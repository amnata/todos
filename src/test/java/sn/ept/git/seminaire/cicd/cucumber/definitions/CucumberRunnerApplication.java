<<<<<<< HEAD
=======
//package sn.ept.git.seminaire.cicd.cucumber.definitions;
//
//import io.cucumber.spring.CucumberContextConfiguration;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.TestPropertySource;
//import sn.ept.git.seminaire.cicd.TodoApplication;
//
//@AutoConfigureMockMvc
//@SpringBootTest(
//        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
//        classes = TodoApplication.class
//)
//@CucumberContextConfiguration()
//@TestPropertySource(locations = {"classpath:application.properties", "classpath:cucumber.properties"})
//public class CucumberRunnerApplication {
//}


>>>>>>> test-ci-pr
package sn.ept.git.seminaire.cicd.cucumber.definitions;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
<<<<<<< HEAD
=======
import org.springframework.test.context.ActiveProfiles;
>>>>>>> test-ci-pr
import sn.ept.git.seminaire.cicd.TodoApplication;

@AutoConfigureMockMvc
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = TodoApplication.class
)
<<<<<<< HEAD
@CucumberContextConfiguration()
@TestPropertySource(locations = {"classpath:application.properties", "classpath:cucumber.properties"})
=======
@CucumberContextConfiguration
@TestPropertySource(locations = {"classpath:application.properties", "classpath:cucumber.properties"})
@ActiveProfiles("test")
>>>>>>> test-ci-pr
public class CucumberRunnerApplication {
}