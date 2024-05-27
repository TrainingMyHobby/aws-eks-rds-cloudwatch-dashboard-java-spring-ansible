package com.tmh.aws.solutions.controllers;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.LinkedHashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/trade-management")
public class HealthCheckController {

    @RequestMapping(value = "/healh-check-current-status", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Map<String, String> >getCurrentStatus() {
        Map<String, String> response = new LinkedHashMap<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        response.put("Status_DateTime", formattedDateTime);

        return ResponseEntity.ok(response);
    }
}
