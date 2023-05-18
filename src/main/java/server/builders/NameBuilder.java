package server.builders;

import server.exceptions.ValidationException;
import server.validation.Validation;

import java.util.Scanner;


/**
 * The type Name builder.
 */
public class NameBuilder {
    /**
     * Build string.
     *
     * @return the string
     */
    public static String build() {
        String name;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите название Vehicle: ");
            name = sc.nextLine();
            if (!Validation.validateUserName(name)) {
                throw new ValidationException("Неверное имя. Оно не должно быть пустым.");
            }
            return name;
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return build();
        }
    }
}
