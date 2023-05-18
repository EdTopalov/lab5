package server.builders;

import server.model.FuelType;

import java.util.Scanner;

import static server.utils.Parser.fromStringToFuelType;

/**
 * The type Fuel type builder.
 */
public class FuelTypeBuilder {
    /**
     * Build fuel type.
     *
     * @return the fuel type
     */
    public static FuelType build() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите тип топлива: (1 - gasoline, 2 - alcohol, 3 - antimatter, 4 - plasma, DEFAULT - gasoline)");
        return fromStringToFuelType(sc.nextLine());
    }
}
