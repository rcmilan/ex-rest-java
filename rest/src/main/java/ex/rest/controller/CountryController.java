package ex.rest.controller;

import ex.rest.model.City;
import ex.rest.model.Country;
import ex.rest.service.ICountryService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    private ICountryService _countryService;

    public CountryController(ICountryService countryService){
        _countryService = countryService;
    }

    @RequestMapping(value = "api/city/{id}", method = RequestMethod.GET)
    public City Get(@PathVariable("id") Integer id) {

        return _countryService.Get(id);
    }

    @RequestMapping(value = "api/country", method = RequestMethod.GET)
    public List<Country> GetAll(){
        return _countryService.GetAll();
    }
}
