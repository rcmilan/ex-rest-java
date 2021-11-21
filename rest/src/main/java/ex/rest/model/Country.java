package ex.rest.model;

import java.util.List;
import java.util.UUID;

public class Country extends BaseModel<UUID>{
    public String Name;
    public List<State> States;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<State> getStates() {
        return States;
    }

    public void setStates(List<State> states) {
        States = states;
    }
}
