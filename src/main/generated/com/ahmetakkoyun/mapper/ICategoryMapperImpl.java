package com.ahmetakkoyun.mapper;

import com.ahmetakkoyun.dto.request.CategorySaveRequestDto;
import com.ahmetakkoyun.repository.entity.Category;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-20T20:53:27+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Amazon.com Inc.)"
)
@Component
public class ICategoryMapperImpl implements ICategoryMapper {

    @Override
    public Category toCategory(CategorySaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Category.CategoryBuilder category = Category.builder();

        category.name( dto.getName() );
        category.description( dto.getDescription() );

        return category.build();
    }
}
