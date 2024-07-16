package dk.eegelund.bikerides.rest;

import dk.eegelund.bikerides.api.RidesApi;
import dk.eegelund.bikerides.core.RideService;
import dk.eegelund.bikerides.model.RideDto;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;

@RestController
public class RidesController extends ApiController implements RidesApi {
    private final RideService rideService;
    public RidesController(NativeWebRequest request, RideService rideService) {
        super(request);
        this.rideService = rideService;
    }

    @Override
    public RideDto createRide(RideDto rideDto) {
        return rideService.createRide(rideDto);
    }

    @Override
    public void deleteRide(Long id) {
        rideService.deleteRide(id);
    }

    @Override
    public RideDto getRide(Long id) {
        return rideService.getRide(id);
    }

    @Override
    public List<RideDto> getRides() {
        return rideService.getRides();
    }

    @Override
    public RideDto updateRide(Long id, RideDto rideDto) {
        return rideService.updateRide(id, rideDto);
    }
}
