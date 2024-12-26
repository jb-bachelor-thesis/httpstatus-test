package net.joshuabrandes.httpstatus_test.boundary;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/v1")
class EndpointController {

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        return RestClient.create().get()
                .uri("https://httpstat.us/200?sleep=5000")
                .retrieve()
                .toEntity(String.class);
    }
}
