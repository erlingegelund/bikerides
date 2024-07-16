package dk.eegelund.bikerides.rest;

import dk.eegelund.bikerides.api.MakesApi;
import dk.eegelund.bikerides.core.MakeService;
import dk.eegelund.bikerides.model.MakeDto;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;

@RestController
public class MakesController extends ApiController implements MakesApi {
    private final MakeService makeService;
    public MakesController(NativeWebRequest request, MakeService makeService) {
        super(request);
        this.makeService = makeService;
    }

    @Override
    public MakeDto createMake(MakeDto makeDto) {
        return makeService.createMake(makeDto);
    }

    @Override
    public void deleteMake(Long id) {
        makeService.deleteMake(id);
    }

    @Override
    public MakeDto getMake(Long id) {
        return makeService.getMake(id);
    }

    @Override
    public List<MakeDto> getMakes() {
        return makeService.getMakes();
    }

    @Override
    public MakeDto updateMake(Long id, MakeDto makeDto) {
        return makeService.updateMake(id, makeDto);
    }
}
