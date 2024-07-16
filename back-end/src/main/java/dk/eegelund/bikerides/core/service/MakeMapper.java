package dk.eegelund.bikerides.core.service;

import dk.eegelund.bikerides.data.Make;
import dk.eegelund.bikerides.model.MakeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface MakeMapper {
    @Mapping(target = "models", ignore = true)
    Make toEntity(MakeDto makeDto);
    MakeDto toDto(Make make);
    void updateEntity(MakeDto makeDto, @MappingTarget Make make);
}
