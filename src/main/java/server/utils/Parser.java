package server.utils;

import server.model.FuelType;

/**
 * The type Parser.
 */
public class Parser {
    /**
     * Tilda resolver string.
     *
     * @param file the file
     * @return the string
     */
    public static String tildaResolver(String file) {
        if (file.startsWith("~")) {
            file = file.replaceFirst("^~", System.getProperty("user.home"));
        }
        return file;
    }

    /**
     * From string to fuel type fuel type.
     *
     * @param line the line
     * @return the fuel type
     */
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
