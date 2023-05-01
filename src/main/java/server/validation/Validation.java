package server.validation;

import client.ConsoleColors;
import server.exceptions.FileException;
import server.exceptions.ValidationException;
import server.model.Coordinates;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.function.Function;

import static server.utils.Parser.tildaResolver;

public class Validation {
    public static void validateFileExist(File file) {
        if (!Files.exists(file.toPath())) {
            throw new FileException("db_file_not_found");
        }
    }

    public static void validateFileRead(File file) {
        if (!Files.isReadable(file.toPath())) {
            throw new FileException("db_file_not_readable");
        }
    }

    public static void validateFileWrite(File file) {
        if (!Files.isWritable(file.toPath())) {
            throw new FileException("file_not_writable");
        }
    }

    public static void validateFileName(String fileName) {
        try {
            (new File(fileName.replace("~", ""))).toPath();
        } catch (InvalidPathException e) {
            throw new FileException("invalid_file_name");
        }
    }

    public static void validateFileDirectory(String fileName) {
        if (Files.isDirectory(Paths.get(fileName))) {
            throw new FileException("file_is_directory");
        }
    }

    public static void validateFile(String fileName) {
        fileName = tildaResolver(fileName);
        validateFileName(fileName);
        File file = new File(fileName);
        validateFileDirectory(fileName);
        validateFileExist(file);
        validateFileRead(file);
        validateFileWrite(file);
    }


    public static boolean validateCoordinate(Coordinates coordinates) {
        return !(coordinates.getX() != null && coordinates.getY() != null && coordinates.getY() > -775);
    }

    public static boolean validateUserName(String userName) {
        return (userName != null && !userName.trim().equals("") && userName.length() > 0);
    }

    public boolean validateId(Long id) {
        return (id != null && id > 0);
    }

    public static <T> void validate(T object, Function<T, Boolean> validator, String errorMessage) {
        if (!validator.apply(object)) {
            throw new ValidationException(ConsoleColors.RED + errorMessage + ConsoleColors.RESET);
        }
    }
}
