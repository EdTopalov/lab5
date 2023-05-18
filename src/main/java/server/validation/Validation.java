package server.validation;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import server.exceptions.FileException;
import server.model.Coordinates;
import server.model.Vehicle;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static server.utils.Parser.tildaResolver;

/**
 * The type Validation.
 */
public class Validation {
    /**
     * Validate vehicle boolean.
     *
     * @param vehicle the vehicle
     * @param idList  the id list
     * @return the boolean
     */
    public static boolean validateVehicle(Vehicle vehicle, ArrayList<Integer> idList) {
        if (vehicle.getId() == null || vehicle.getId() <= 0 || idList.contains(vehicle.getId())) return false;
        if (vehicle.getName() == null || vehicle.getName().trim().equals("")) return false;
        if (vehicle.getEnginePower() < 0) return false;
        if (vehicle.getCoordinates() == null || vehicle.getCoordinates().getX() == null ||
                vehicle.getCoordinates().getY() == null || vehicle.getCoordinates().getY() <= -775)
            return false;
        if (vehicle.getCreationDate() == null) return false;
        if (vehicle.getFuelConsumption() == null) return false;
        return vehicle.getFuelType() != null;
    }

    /**
     * Validate file exist.
     *
     * @param file the file
     */
    public static void validateFileExist(File file) {
        if (!Files.exists(file.toPath())) {
            throw new FileException("Файл с базой данных не найден.");
        }
    }

    /**
     * Validate file read.
     *
     * @param file the file
     */
    public static void validateFileRead(File file) {
        if (!Files.isReadable(file.toPath())) {
            throw new FileException("Файл с базой данных не доступен к чтению.");
        }
    }

    /**
     * Validate file write.
     *
     * @param file the file
     */
    public static void validateFileWrite(File file) {
        if (!Files.isWritable(file.toPath())) {
            throw new FileException("file_not_writable");
        }
    }

    /**
     * Validate file name.
     *
     * @param fileName the file name
     */
    public static void validateFileName(String fileName) {
        try {
            (new File(fileName.replace("~", ""))).toPath();
        } catch (InvalidPathException e) {
            throw new FileException("invalid_file_name");
        }
    }

    /**
     * Validate file directory.
     *
     * @param fileName the file name
     */
    public static void validateFileDirectory(String fileName) {
        if (Files.isDirectory(Paths.get(fileName))) {
            throw new FileException("file_is_directory");
        }
    }

    /**
     * Validate file.
     *
     * @param fileName the file name
     */
    public static void validateFile(String fileName) {
        fileName = tildaResolver(fileName);
        validateFileName(fileName);
        File file = new File(fileName);
        validateFileDirectory(fileName);
        validateFileExist(file);
        validateFileRead(file);
        validateFileWrite(file);
    }

    private static boolean isValidJson(String json) {
        try {
            new Gson().fromJson(json, Object.class);
            return true;
        } catch (JsonSyntaxException ex) {
            return false;
        }
    }

    /**
     * Is valid json file boolean.
     *
     * @param filePath the file path
     * @return the boolean
     */
    public static boolean isValidJsonFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                stringBuilder.append(line);
            }
            scanner.close();
            String jsonString = stringBuilder.toString();
            return isValidJson(jsonString);
        } catch (FileNotFoundException ex) {
            return false;
        }
    }


    /**
     * Validate coordinate boolean.
     *
     * @param coordinates the coordinates
     * @return the boolean
     */
    public static boolean validateCoordinate(Coordinates coordinates) {
        return !(coordinates.getX() != null && coordinates.getY() != null && coordinates.getY() > -775);
    }

    /**
     * Validate user name boolean.
     *
     * @param userName the user name
     * @return the boolean
     */
    public static boolean validateUserName(String userName) {
        return (userName != null && !userName.trim().equals("") && userName.length() > 0);
    }

    /**
     * Validate id boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean validateId(Long id) {
        return (id != null && id > 0);
    }
}
