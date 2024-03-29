package br.com.gubee.interview.infrastructure.controller;

import br.com.gubee.interview.infrastructure.constants.AppConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = AppConstants.URL_SUFFIX + "health")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<String> check() {
        return ResponseEntity.ok("UP");
    }
}
