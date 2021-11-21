package ex.rest.model;

import java.util.List;
import java.util.UUID;

public class Country extends BaseModel<UUID>{
    public String Name;
    public List<State> States;
}
