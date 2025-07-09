package sn.ept.git.seminaire.cicd.resources;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sn.ept.git.seminaire.cicd.models.TagDTO;
import sn.ept.git.seminaire.cicd.services.TagService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

public class TagResourceTest {

    @Mock
    private TagService tagService;

    @InjectMocks
    private TagResource tagResource;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreate() {
        TagDTO tag = new TagDTO();
        tag.setId("1");
        tag.setName("Important");

        when(tagService.save(any(TagDTO.class))).thenReturn(tag);

        ResponseEntity<TagDTO> response = tagResource.create(tag);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(tag, response.getBody());
    }

    @Test
    public void testFindAll() {
        TagDTO tag1 = new TagDTO();
        tag1.setId("1");
        tag1.setName("Important");

        TagDTO tag2 = new TagDTO();
        tag2.setId("2");
        tag2.setName("Urgent");

        List<TagDTO> tags = Arrays.asList(tag1, tag2);
        Pageable pageable = PageRequest.of(0, 10);
        Page<TagDTO> page = new PageImpl<>(tags, pageable, tags.size());

        when(tagService.findAll(pageable)).thenReturn(page);

        ResponseEntity<Page<TagDTO>> response = tagResource.findAll(pageable);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().getContent().size());
        assertEquals("Important", response.getBody().getContent().get(0).getName());
        assertEquals("Urgent", response.getBody().getContent().get(1).getName());
    }

    @Test
    public void testFindById_found() {
        TagDTO tag = new TagDTO();
        tag.setId("1");
        tag.setName("Important");

        when(tagService.findById("1")).thenReturn(tag);

        ResponseEntity<TagDTO> response = tagResource.findById("1");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tag, response.getBody());
    }

    @Test
    public void testFindById_notFound() {
        when(tagService.findById("1")).thenReturn(null);

        ResponseEntity<TagDTO> response = tagResource.findById("1");

        // Ton code TagResource ne gère pas explicitement le cas null, il retourne OK
        // avec null
        // Si tu veux un NOT_FOUND, il faudrait modifier TagResource.findById
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testUpdate() {
        TagDTO tag = new TagDTO();
        tag.setId("1");
        tag.setName("Updated");

        when(tagService.update(eq("1"), any(TagDTO.class))).thenReturn(tag);

        ResponseEntity<TagDTO> response = tagResource.update("1", tag);

        // Dans TagResource update() retourne ACCEPTED (202)
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(tag, response.getBody());
    }

    @Test
    public void testDelete() {
        // delete() ne retourne rien dans TagResource, mais on vérifie le code HTTP

        // On simule simplement le comportement du service sans exception
        doNothing().when(tagService).delete("1");

        ResponseEntity<TagDTO> response = tagResource.delete("1");

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
