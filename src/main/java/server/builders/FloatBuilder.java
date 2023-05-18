package server.builders;

import java.util.Scanner;

/**
 * The type Float builder.
 */
public class FloatBuilder {
    /**
     * Build float.
     *
     * @param message the message
     * @return the float
     */
    public static float build(String message) {
        try {
            System.out.println(message);
            Scanner sc = new Scanner(System.in);
            float value = Float.parseFloat(sc.nextLine());
            if (value < 0) {
                System.out.println("Значение должно быть больше нуля.");
                return build(message);
            }
            return value;
        } catch (NumberFormatException e) {
            System.out.println("Это поле принимает числовое значение.");
            return build(message);
        }
    }
}
