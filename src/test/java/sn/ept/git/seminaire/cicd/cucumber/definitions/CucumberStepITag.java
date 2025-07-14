package sn.ept.git.seminaire.cicd.cucumber.definitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import sn.ept.git.seminaire.cicd.repositories.TagRepository;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import sn.ept.git.seminaire.cicd.data.TestData;
import sn.ept.git.seminaire.cicd.entities.Tag;
import sn.ept.git.seminaire.cicd.models.TagDTO;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

@Slf4j
public class CucumberStepITag {

    private final static String BASE_URI = "http://localhost";
    public static final String API_PATH = "/cicd/api/tags";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_SYSTEM_ID = "system_id";
    public static final String KEY_SYSTEM_NAME = "system_name";
    public static final String KEY_TYPE = "type";
    public static final String KEY_STATUS = "status";
    public static final String KEY_MESSAGE = "message";
    
    
    private String name;
    private Response response;
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @LocalServerPort
    private int port;

    @Autowired
    private TagRepository tagRepository;

    @BeforeAll
    public static void beforeAll() {
        objectMapper.findAndRegisterModules();
    }

    @Before
    public void init() {
        tagRepository.deleteAll();
    }


    
    protected RequestSpecification request() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
        return given()
                .contentType(ContentType.JSON)
                .log()
                .all();
    }

    @Given("table tag contains data:")
    public void tableTagContainsData(DataTable dataTable) {
        List<Tag> tags = dataTable
                .asMaps(String.class, String.class)
                .stream()
                .map(line -> Tag.builder()
                        .id(line.get(KEY_ID))
                        .name(line.get(KEY_NAME))
                        .version(0)
                        .build())
                .collect(Collectors.toList());
        tagRepository.saveAllAndFlush(tags);
    }

    @When("call find tag by id with id={string}")
    public void callFindTagById(String id) {
        response = request()
                .when()
                .get(API_PATH + "/" + id);
    }

    @When("call delete tag with id={string}")
    public void callDeleteTagById(String id) {
        response = request()
                .when()
                .delete(API_PATH + "/" + id);
    }

    @When("call add tag")
    public void callAddTag() {
        TagDTO tagDTO = TagDTO.builder()
                .name(this.name)
                .build();

        response = request()
                .body(tagDTO)
                .when()
                .post(API_PATH);
    }

    @When("call update tag with id={string}")
    public void callUpdateTag(String id) {
        TagDTO tagDTO = TagDTO.builder()
                .name(this.name)
                .build();

        response = request()
                .body(tagDTO)
                .when()
                .put(API_PATH + "/" + id);
    }

    @When("call find all tags with page={int} and size={int}")
    public void callFindAllTags(int page, int size) {
        response = request()
                .when()
                .get(API_PATH + "?page=" + page + "&size=" + size);
    }

    @Then("the tag http status is {int}")
    public void assertTagHttpStatus(int status) {
        response.then().assertThat().statusCode(status);
    }

    @And("the returned tag has name {string}")
    public void assertReturnedTagHasName(String expectedName) {
        response.then()
                .assertThat()
                .body(KEY_NAME, Matchers.equalTo(expectedName));
    }

    @And("the tag error body looks like:")
    public void assertTagErrorBody(DataTable dataTable) {
        Optional<Map<String, String>> opt = dataTable.asMaps(String.class, String.class).stream().findFirst();
        Assertions.assertThat(opt).isPresent();
        Map<String, String> error = opt.get();

        response.then().assertThat()
                .body(KEY_SYSTEM_ID, Matchers.equalTo(error.get(KEY_SYSTEM_ID)))
                .body(KEY_SYSTEM_NAME, Matchers.equalTo(error.get(KEY_SYSTEM_NAME)))
                .body(KEY_TYPE, Matchers.equalTo(error.get(KEY_TYPE)))
                .body(KEY_STATUS, Matchers.equalTo(Integer.parseInt(error.get(KEY_STATUS))))
                .body(KEY_MESSAGE, Matchers.equalTo(error.get(KEY_MESSAGE)));
    }

    @And("the following tag to add:")
    public void theFollowingTagToAdd(DataTable dataTable) {
        Optional<Map<String, String>> opt = dataTable.asMaps(String.class, String.class).stream().findFirst();
        Assertions.assertThat(opt).isPresent();
        this.name = opt.get().get(KEY_NAME);
    }
    
    // Ajoutez ces méthodes à votre classe CucumberStepITag

    @Then("Add tag should return {int}")
    public void addTagShouldReturn(int expectedStatus) {
        response.then().assertThat().statusCode(expectedStatus);
    }

    @Then("Add tag with null name should return {int}")
    public void addTagWithNullNameShouldReturn(int expectedStatus) {
        TagDTO tagDTO = TagDTO.builder()
                .name(null)
                .build();

        response = request()
                .body(tagDTO)
                .when()
                .post(API_PATH);

        response.then().assertThat().statusCode(expectedStatus);
    }

    @Then("Add tag with null color should return {int}")
    public void addTagWithNullColorShouldReturn(int expectedStatus) {
        TagDTO tagDTO = TagDTO.builder()
                .name(this.name)
//                .color(null)
                .build();

        response = request()
                .body(tagDTO)
                .when()
                .post(API_PATH);

        response.then().assertThat().statusCode(expectedStatus);
    }

    @Then("Delete tag should return {int}")
    public void deleteTagShouldReturn(int expectedStatus) {
        response.then().assertThat().statusCode(expectedStatus);
    }

    @When("call find all tags with page={int}, size={int} and sort={string}")
    public void callFindAllTagsWithPaginationAndSorting(int page, int size, String sort) {
        response = request()
                .when()
                .get(API_PATH + "?page=" + page + "&size=" + size + "&sort=" + sort);
    }

    @Then("Find all tags with pagination and sorting should return {int}")
    public void findAllTagsWithPaginationAndSortingShouldReturn(int expectedStatus) {
        response.then().assertThat().statusCode(expectedStatus);
    }

    @Then("Find all tags with no match should return empty list")
    public void findAllTagsWithNoMatchShouldReturnEmptyList() {
        response.then()
                .assertThat()
                .statusCode(200)
                .body("content", Matchers.empty());
    }

    @Then("Find by id should return {int}")
    public void findByIdShouldReturn(int expectedStatus) {
        response.then().assertThat().statusCode(expectedStatus);
    }

    @When("call find by id with bad id should return {int}")
    public void callFindByIdWithBadIdShouldReturn(int expectedStatus) {
        response = request()
                .when()
                .get(API_PATH + "/invalid-id");

        response.then().assertThat().statusCode(expectedStatus);
    }

    @Then("Update tag should return {int}")
    public void updateTagShouldReturn(int expectedStatus) {
        response.then().assertThat().statusCode(expectedStatus);
    }

    @Then("Update tag with invalid id should return {int}")
    public void updateTagWithInvalidIdShouldReturn(int expectedStatus) {
        TagDTO tagDTO = TagDTO.builder()
                .name(this.name)
                .build();

        response = request()
                .body(tagDTO)
                .when()
                .put(API_PATH + "/invalid-id");

        response.then().assertThat().statusCode(expectedStatus);
    }

    @Then("Update tag with null name should return {int}")
    public void updateTagWithNullNameShouldReturn(int expectedStatus) {
        TagDTO tagDTO = TagDTO.builder()
                .name(null)
                .build();

        response = request()
                .body(tagDTO)
                .when()
                .put(API_PATH + "/some-id");

        response.then().assertThat().statusCode(expectedStatus);
    }

    // Méthode pour gérer les cas où l'ID est mal formaté
    @When("call delete with id={string}")
    public void callDeleteWithId(String id) {
        response = request()
                .when()
                .delete(API_PATH + "/" + id);
    }

    // Méthode pour gérer les cas de mise à jour avec des IDs spécifiques
    @When("call update with id={string}")
    public void callUpdateWithId(String id) {
        TagDTO tagDTO = TagDTO.builder()
                .name(this.name)
                .build();

        response = request()
                .body(tagDTO)
                .when()
                .put(API_PATH + "/" + id);
    }

    // Méthode pour vérifier que la réponse contient des données paginées
    @And("the response contains paginated data")
    public void theResponseContainsPaginatedData() {
        response.then()
                .assertThat()
                .body("content", Matchers.notNullValue())
                .body("page", Matchers.notNullValue())
                .body("size", Matchers.notNullValue())
                .body("totalElements", Matchers.notNullValue());
    }

}