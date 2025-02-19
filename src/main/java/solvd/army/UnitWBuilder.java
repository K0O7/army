package solvd.army;
import java.util.List;

public class UnitWBuilder {

    private int id;
    private String unit_name;
    private List<UnitMission> unitMissions;
    
    private UnitWBuilder(UnitBuilder builder) {
        this.id = builder.id;
        this.unit_name = builder.unit_name;
        this.unitMissions = builder.unitMissions;
    }

	public int getId() {
		return id;
	}

	public String getUnitName() {
		return unit_name;
	}

	public List<UnitMission> getUnitMissions() {
		return unitMissions;
	}
	
    public static class UnitBuilder {
        private int id;
        private String unit_name;
        private List<UnitMission> unitMissions;

        public UnitBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public UnitBuilder setUnitName(String unit_name) {
            this.unit_name = unit_name;
            return this;
        }

        public UnitBuilder setUnitMissions(List<UnitMission> unitMissions) {
            this.unitMissions = unitMissions;
            return this;
        }

        public UnitWBuilder build() {
            return new UnitWBuilder(this);
        }
    }   
}
