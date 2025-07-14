package sn.ept.git.seminaire.cicd.mappers;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sn.ept.git.seminaire.cicd.entities.Tag;
import sn.ept.git.seminaire.cicd.entities.Todo;
import sn.ept.git.seminaire.cicd.models.TagDTO;
import sn.ept.git.seminaire.cicd.models.TodoDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-07T20:30:00+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.15 (Ubuntu)"
)
@Component
public class TodoMapperImpl implements TodoMapper {

    @Override
    public Todo toEntity(TodoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Todo.TodoBuilder<?, ?> todo = Todo.builder();

        todo.id( dto.getId() );
        todo.createdDate( dto.getCreatedDate() );
        todo.lastModifiedDate( dto.getLastModifiedDate() );
        todo.version( dto.getVersion() );
        todo.title( dto.getTitle() );
        todo.description( dto.getDescription() );
        todo.completed( dto.isCompleted() );
        todo.dateDebut( dto.getDateDebut() );
        todo.dateFin( dto.getDateFin() );
        todo.tags( tagDTOSetToTagSet( dto.getTags() ) );

        return todo.build();
    }

    @Override
    public TodoDTO toDTO(Todo entity) {
        if ( entity == null ) {
            return null;
        }

        TodoDTO.TodoDTOBuilder<?, ?> todoDTO = TodoDTO.builder();

        todoDTO.id( entity.getId() );
        todoDTO.createdDate( entity.getCreatedDate() );
        todoDTO.lastModifiedDate( entity.getLastModifiedDate() );
        todoDTO.version( entity.getVersion() );
        todoDTO.title( entity.getTitle() );
        todoDTO.description( entity.getDescription() );
        todoDTO.completed( entity.isCompleted() );
        todoDTO.dateDebut( entity.getDateDebut() );
        todoDTO.dateFin( entity.getDateFin() );
        todoDTO.tags( tagSetToTagDTOSet( entity.getTags() ) );

        return todoDTO.build();
    }

    protected Tag tagDTOToTag(TagDTO tagDTO) {
        if ( tagDTO == null ) {
            return null;
        }

        Tag.TagBuilder<?, ?> tag = Tag.builder();

        tag.id( tagDTO.getId() );
        tag.createdDate( tagDTO.getCreatedDate() );
        tag.lastModifiedDate( tagDTO.getLastModifiedDate() );
        tag.version( tagDTO.getVersion() );
        tag.name( tagDTO.getName() );

        return tag.build();
    }

    protected Set<Tag> tagDTOSetToTagSet(Set<TagDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<Tag> set1 = new LinkedHashSet<Tag>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( TagDTO tagDTO : set ) {
            set1.add( tagDTOToTag( tagDTO ) );
        }

        return set1;
    }

    protected TagDTO tagToTagDTO(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagDTO.TagDTOBuilder<?, ?> tagDTO = TagDTO.builder();

        tagDTO.id( tag.getId() );
        tagDTO.createdDate( tag.getCreatedDate() );
        tagDTO.lastModifiedDate( tag.getLastModifiedDate() );
        tagDTO.version( tag.getVersion() );
        tagDTO.name( tag.getName() );

        return tagDTO.build();
    }

    protected Set<TagDTO> tagSetToTagDTOSet(Set<Tag> set) {
        if ( set == null ) {
            return null;
        }

        Set<TagDTO> set1 = new LinkedHashSet<TagDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Tag tag : set ) {
            set1.add( tagToTagDTO( tag ) );
        }

        return set1;
    }
}
