package solvd.army.mvc;

public class UnitMVC {
    private int id;
    private String unitName;

    public UnitMVC(int id, String unitName) {
        this.id = id;
        this.unitName = unitName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
