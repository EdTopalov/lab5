package server.utils;

import server.model.FuelType;

public class Parser {
    public static String tildaResolver(String file) {
        if (file.startsWith("~")) {
            file = file.replaceFirst("^~", System.getProperty("user.home"));
        }
        return file;
    }

    public static FuelType fromStringToFuelType(String line) {
        switch (line.toLowerCase()) {
            case "1", "gasoline" -> {
                return FuelType.GASOLINE;
            }
            case "2", "alcohol" -> {
                return FuelType.ALCOHOL;
            }
            case "3", "antimatter" -> {
                return FuelType.ANTIMATTER;
            }
            case "4", "plasma" -> {
                return FuelType.PLASMA;
            }
            default -> {
                return FuelType.GASOLINE;
            }
        }
    }
}
