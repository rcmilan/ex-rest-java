package ex.rest.model;

public class City extends BaseModel<Integer> {
    private String _name;

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }
}
