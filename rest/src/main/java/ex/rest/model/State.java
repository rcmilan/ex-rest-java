package ex.rest.model;

import java.util.List;

public class State extends BaseModel<Long> {
    public String Name;
    public List<City> Cities;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<City> getCities() {
        return Cities;
    }

    public void setCities(List<City> cities) {
        Cities = cities;
    }
}
