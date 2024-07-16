package dk.eegelund.bikerides.core.service;

import dk.eegelund.bikerides.core.ModelService;
import dk.eegelund.bikerides.data.Model;
import dk.eegelund.bikerides.data.ModelRepository;
import dk.eegelund.bikerides.exception.NotFoundException;
import dk.eegelund.bikerides.model.ModelDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ModelServiceImpl implements ModelService {
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;

    @Override
    @Transactional
    public ModelDto createModel(ModelDto modelDto) {
        final Model detached = modelMapper.toEntity(modelDto);
        return modelMapper.toDto(modelRepository.save(detached));
    }

    @Override
    @Transactional
    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }

    @Override
    public List<ModelDto> getModels() {
        return modelRepository.findAll().stream().map(modelMapper::toDto).toList();
    }

    @Override
    public ModelDto getModel(Long id) {
        return modelRepository.findById(id).map(modelMapper::toDto).orElseThrow(() -> new NotFoundException("Model not found"));
    }

    @Override
    @Transactional
    public ModelDto updateModel(Long id, ModelDto modelDto) {
        final var existingModel = modelRepository.findById(id).orElseThrow(() -> new NotFoundException("Model not found"));
        modelMapper.updateEntity(modelDto, existingModel);
        return modelDto;
    }
}
