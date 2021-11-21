package ex.rest.service;

import ex.rest.model.City;
import ex.rest.model.Country;
import ex.rest.model.State;

import java.util.UUID;

public interface ICountryService {
    City Get(Integer ID);
    State Get(Long ID);
    Country Get(UUID ID);

    Country GetCountryByStateID(Long ID);
    State GetStateByCityID(Integer ID, Country country);
    Country GetCountryByCityID(Integer ID);
}
