package dk.eegelund.bikerides.rest;

import dk.eegelund.bikerides.api.ModelsApi;
import dk.eegelund.bikerides.model.ModelDto;
import dk.eegelund.bikerides.core.ModelService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;

@RestController
public class ModelsController extends ApiController implements ModelsApi {
    private final ModelService modelService;
    public ModelsController(NativeWebRequest request, ModelService modelService) {
        super(request);
        this.modelService = modelService;
    }

    @Override
    public ModelDto createModel(ModelDto modelDto) {
        return modelService.createModel(modelDto);
    }

    @Override
    public void deleteModel(Long id) {
        modelService.deleteModel(id);
    }

    @Override
    public ModelDto getModel(Long id) {
        return modelService.getModel(id);
    }

    @Override
    public List<ModelDto> getModels() {
        return modelService.getModels();
    }

    @Override
    public ModelDto updateModel(Long id, ModelDto modelDto) {
        return modelService.updateModel(id, modelDto);
    }
}
