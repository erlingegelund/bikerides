package dk.eegelund.bikerides.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RequiredArgsConstructor
abstract class ApiController {
    private final NativeWebRequest request;

    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }
}
