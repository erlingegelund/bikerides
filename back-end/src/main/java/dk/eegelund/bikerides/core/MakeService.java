package dk.eegelund.bikerides.core;

import dk.eegelund.bikerides.model.MakeDto;

import java.util.List;

public interface MakeService {
    MakeDto createMake(MakeDto makeDto);
    void deleteMake(Long id);
    List<MakeDto> getMakes();
    MakeDto getMake(Long id);
    MakeDto updateMake(Long id, MakeDto makeDto);

}
