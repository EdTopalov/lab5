package server.builders;

import java.util.Scanner;

public class IntegerBuilder {
    public static int build(String message) {
        try {
            System.out.println(message);
            Scanner sc = new Scanner(System.in);
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Это поле принимает числовое значение.");
            return build(message);
        }
    }
}
