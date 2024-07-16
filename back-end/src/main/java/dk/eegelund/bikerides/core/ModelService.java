package dk.eegelund.bikerides.core;

import dk.eegelund.bikerides.model.ModelDto;

import java.util.List;

public interface ModelService {
    ModelDto createModel(ModelDto modelDto);
    void deleteModel(Long id);
    List<ModelDto> getModels();
    ModelDto getModel(Long id);
    ModelDto updateModel(Long id, ModelDto modelDto);

}
