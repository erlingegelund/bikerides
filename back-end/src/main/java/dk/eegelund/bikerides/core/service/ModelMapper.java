package dk.eegelund.bikerides.core.service;

import dk.eegelund.bikerides.data.CategoryRepository;
import dk.eegelund.bikerides.data.MakeRepository;
import dk.eegelund.bikerides.data.Model;
import dk.eegelund.bikerides.model.ModelDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public abstract class ModelMapper {
    @Autowired
    protected MakeRepository makeRepository;
    @Autowired
    protected CategoryRepository categoryRepository;
    @Mapping(target = "makeId", source = "model.make.id")
    @Mapping(target = "categoryId", source = "model.category.id")
    public abstract ModelDto toDto(Model model);
    @Mapping(target = "make", expression = "java(makeRepository.findById(modelDto.getMakeId()).orElse(null))")
    @Mapping(target = "category", expression = "java(categoryRepository.findById(modelDto.getCategoryId()).orElse(null))")
    public abstract Model toEntity(ModelDto modelDto);
    @Mapping(target = "make", expression = "java(makeRepository.findById(modelDto.getMakeId()).orElse(null))")
    @Mapping(target = "category", expression = "java(categoryRepository.findById(modelDto.getCategoryId()).orElse(null))")
    public abstract void updateEntity(ModelDto modelDto, @MappingTarget Model model);
}
