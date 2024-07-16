package dk.eegelund.bikerides.core.service;

import dk.eegelund.bikerides.data.Category;
import dk.eegelund.bikerides.model.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface CategoryMapper {
    Category toEntity(CategoryDto categoryDto);
    void updateEntity(CategoryDto categoryDto, @MappingTarget Category category);
    CategoryDto toDto(Category category);
}
