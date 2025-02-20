package comt.est_server.testserver.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/health")
public class HealthCheckContoller {
    @GetMapping
    public String healthcheck(){
        return  "Server is health is Green";
    }
}
