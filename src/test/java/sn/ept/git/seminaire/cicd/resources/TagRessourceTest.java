package sn.ept.git.seminaire.cicd.resources.TagResourceTest

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import sn.ept.git.seminaire.cicd.models.TagDTO;
import sn.ept.git.seminaire.cicd.services.TagService;
import sn.ept.git.seminaire.cicd.utils.UrlMapping;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TagResource.class)
class TagResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TagService tagService;

    @Autowired
    private ObjectMapper objectMapper;

    private TagDTO tag;

    @BeforeEach
    void setUp() {
        tag = new TagDTO();
        tag.setId(UUID.randomUUID().toString());
        tag.setName("Test Tag");
    }

    @Test
    void shouldFindAllTags() throws Exception {
        Mockito.when(tagService.findAll(any()))
                .thenReturn(new PageImpl<>(List.of(tag)));

        mockMvc.perform(get(UrlMapping.Tag.ALL)
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(1)))
                .andExpect(jsonPath("$.content[0].name").value(tag.getName()));
    }

    @Test
    void shouldFindTagById() throws Exception {
        Mockito.when(tagService.findById(tag.getId()))
                .thenReturn(tag);

        mockMvc.perform(get(UrlMapping.Tag.FIND_BY_ID, tag.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(tag.getName()));
    }

    @Test
    void shouldCreateTag() throws Exception {
        Mockito.when(tagService.save(any(TagDTO.class)))
                .thenReturn(tag);

        mockMvc.perform(post(UrlMapping.Tag.ADD)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tag)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(jsonPath("$.name").value(tag.getName()));
    }

    @Test
    void shouldUpdateTag() throws Exception {
        Mockito.when(tagService.update(eq(tag.getId()), any(TagDTO.class)))
                .thenReturn(tag);

        mockMvc.perform(put(UrlMapping.Tag.UPDATE, tag.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tag)))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.name").value(tag.getName()));
    }

    @Test
    void shouldDeleteTag() throws Exception {
        mockMvc.perform(delete(UrlMapping.Tag.DELETE, tag.getId()))
                .andExpect(status().isNoContent());
    }
}
