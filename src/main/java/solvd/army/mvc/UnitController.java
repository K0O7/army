package solvd.army.mvc;

public class UnitController {
    private UnitMVC model;
    private UnitView view;

    public UnitController(UnitMVC model, UnitView view) {
        this.model = model;
        this.view = view;
    }

    public void setUnitName(String unitName) {
        model.setUnitName(unitName);
    }

    public String getUnitName() {
        return model.getUnitName();
    }

    public void updateView() {
        view.displayUnitDetails(model.getId(), model.getUnitName());
    }
}
