package server.builders;

import java.util.Scanner;

/**
 * The type Integer builder.
 */
public class IntegerBuilder {
    /**
     * Build int.
     *
     * @param message the message
     * @return the int
     */
    public static int build(String message) {
        try {
            System.out.println(message);
            Scanner sc = new Scanner(System.in);
            int value = Integer.parseInt(sc.nextLine());
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