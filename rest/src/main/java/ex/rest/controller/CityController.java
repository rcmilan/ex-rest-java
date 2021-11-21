package ex.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @GetMapping(path="/api/status")
    public String Get() {
        return "teste";
    }
}
