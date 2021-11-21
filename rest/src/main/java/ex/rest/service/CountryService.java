package ex.rest.service;

import ex.rest.model.City;
import ex.rest.model.Country;
import ex.rest.model.State;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CountryService implements ICountryService {

    private static List<Country> _countries;

    public CountryService () {
        var city = new City();
        city.ID = 1;
        city.set_name("Cidade 1");

        var state = new State();
        state.ID = 999L;
        state.setName("State A");
        state.setCities(new ArrayList<City>(){{ add(city); }});

        var country = new Country();
        country.ID = UUID.randomUUID();
        country.setName("Country ABC");
        country.setStates(new ArrayList<State>(){{ add(state); }});

        _countries = new ArrayList<Country>(){{
            add(country);
        }};
    }

    @Override
    public City Get(Integer ID) {
        var country = GetCountryByCityID(ID);
        var state = GetStateByCityID(ID, country);

        return state.getCities()
            .stream()
            .filter(c -> c.ID == ID)
            .findFirst()
            .get();
    }

    @Override
    public State GetStateByCityID(Integer ID, Country country) {
        var state = country.States.stream()
            .filter(s -> s.getCities().stream().anyMatch(c -> c.ID == ID))
            .findFirst()
            .get();
        return state;
    }

    @Override
    public Country GetCountryByCityID(Integer ID) {
        var country = _countries.stream()
            .filter(c -> c.getStates().stream()
                .anyMatch(s -> s.getCities().stream()
                    .anyMatch(ct -> ct.ID == ID)
                )
            ).findFirst().get();
        return country;
    }

    @Override
    public List<Country> GetAll() {
        return _countries;
    }

    @Override
    public State Get(Long ID) {
        var country = GetCountryByStateID(ID);

        return country.getStates().stream()
            .filter(s -> s.ID == ID)
            .findFirst()
            .get();
    }

    @Override
    public Country GetCountryByStateID(Long ID) {
        return _countries.stream()
            .filter(c -> c.States.stream()
                .anyMatch(s -> s.ID == ID)
            )
            .findFirst()
            .get();
    }

    @Override
    public Country Get(UUID ID) {
        return _countries.stream()
            .filter(c -> c.ID == ID)
            .findFirst()
            .get();
    }
}