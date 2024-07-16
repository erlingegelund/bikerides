package dk.eegelund.bikerides.core.service;

import dk.eegelund.bikerides.core.MakeService;
import dk.eegelund.bikerides.data.Make;
import dk.eegelund.bikerides.data.MakeRepository;
import dk.eegelund.bikerides.exception.NotFoundException;
import dk.eegelund.bikerides.model.MakeDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MakeServiceImpl implements MakeService {
    private final MakeRepository makeRepository;
    private final MakeMapper makeMapper;

    @Override
    @Transactional
    public MakeDto createMake(MakeDto makeDto) {
        final Make detached = makeMapper.toEntity(makeDto);
        return makeMapper.toDto(makeRepository.save(detached));
    }

    @Override
    @Transactional
    public void deleteMake(Long id) {
        makeRepository.deleteById(id);
    }

    @Override
    public List<MakeDto> getMakes() {
        return makeRepository.findAll().stream().map(makeMapper::toDto).toList();
    }

    @Override
    public MakeDto getMake(Long id) {
        return makeRepository.findById(id).map(makeMapper::toDto).orElseThrow(() -> new NotFoundException("Make not found"));
    }

    @Override
    @Transactional
    public MakeDto updateMake(Long id, MakeDto makeDto) {
        final var existingMake = makeRepository.findById(id).orElseThrow(() -> new NotFoundException("Make not found"));
        makeMapper.updateEntity(makeDto, existingMake);
        return makeDto;
    }
}
