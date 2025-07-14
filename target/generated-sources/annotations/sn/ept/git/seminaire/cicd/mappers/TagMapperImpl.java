package sn.ept.git.seminaire.cicd.mappers;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import sn.ept.git.seminaire.cicd.entities.Tag;
import sn.ept.git.seminaire.cicd.models.TagDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-07T20:30:01+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.15 (Ubuntu)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public Tag toEntity(TagDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Tag.TagBuilder<?, ?> tag = Tag.builder();

        tag.id( dto.getId() );
        tag.createdDate( dto.getCreatedDate() );
        tag.lastModifiedDate( dto.getLastModifiedDate() );
        tag.version( dto.getVersion() );
        tag.name( dto.getName() );

        return tag.build();
    }

    @Override
    public TagDTO toDTO(Tag entity) {
        if ( entity == null ) {
            return null;
        }

        TagDTO.TagDTOBuilder<?, ?> tagDTO = TagDTO.builder();

        tagDTO.id( entity.getId() );
        tagDTO.createdDate( entity.getCreatedDate() );
        tagDTO.lastModifiedDate( entity.getLastModifiedDate() );
        tagDTO.version( entity.getVersion() );
        tagDTO.name( entity.getName() );

        return tagDTO.build();
    }
}
