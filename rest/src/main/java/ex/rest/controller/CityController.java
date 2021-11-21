package ex.rest.controller;

import ex.rest.model.City;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {

    @GetMapping(path="/api/status")
    public City Get(Integer id) {
        var city = new City();
        city.set_name("Name");

        return city;
    }
}
