package server.builders;

import java.util.Scanner;

public class FloatBuilder {
    public static float build(String message) {
        try {
            System.out.println(message);
            Scanner sc = new Scanner(System.in);
            return Float.parseFloat(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Это поле принимает числовое значение.");
            return build(message);
        }
    }
}
