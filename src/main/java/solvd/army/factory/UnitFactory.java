package solvd.army.factory;

public class UnitFactory {
	   public static IUnit createUnit(String type) {
		   if (type.equalsIgnoreCase("infantry")) {
			   return new InfantryUnit();
		   }
		   if (type.equalsIgnoreCase("airforce")) {
			   return new AirforceUnit();
		   }
		   throw new IllegalArgumentException("Unknown unit type: " + type);
	    }
}
