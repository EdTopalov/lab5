package server.database;

import com.fatboyindustrial.gsonjavatime.Converters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import server.model.Vehicle;
import server.model.VehicleComparatorForTreeSet;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static server.validation.Validation.*;

/**
 * Класс имитирующий поведение базы данных.
 */
public class DataBaseProvider {
    private final Set<Vehicle> dataBase;
    private final LocalDateTime dateTime;

    /**
     * Валидируется файл. Загружает базу данных. Время создание устанавливается с созданим класса.
     *
     * @param filename the filename
     */
    public DataBaseProvider(String filename) {
        this.dataBase = loadDataBase(filename);
        this.dateTime = LocalDateTime.now();
    }

    private static Set<Vehicle> loadDataBase(String fileName) {
        validateFile(fileName);
        Set<Vehicle> resultSet = new TreeSet<>(new VehicleComparatorForTreeSet());
        List<Vehicle> resultList;
        try {
            isValidJsonFile(fileName);
            Gson gson = Converters.registerOffsetDateTime(new GsonBuilder()).create();
            Type type = new TypeToken<ArrayList<Vehicle>>() {
            }.getType();
            JsonReader reader = new JsonReader(new FileReader(fileName));
            resultList = gson.fromJson(reader, type);

            validatedList(resultList);

            for (Vehicle vehicle : resultList) {
                resultSet.add(vehicle);
            }

            return resultSet;
        } catch (NullPointerException e) {
            System.out.println("База данных пуста.");
        } catch (Exception e) {
            System.out.println("Ошибка при чтение json файла.");
        }
        return resultSet;
    }

    /**
     * Метод для валидации списка городов из json файла.
     *
     * @param data
     * @return
     */
    private static List<Vehicle> validatedList(List<Vehicle> data) {
        try {
            List<Vehicle> copy = new ArrayList<>(data);
            ArrayList<Integer> idList = new ArrayList<>();
            for (Vehicle vehicle : copy) {
                if (!validateVehicle(vehicle, idList)) {
                    data.remove(vehicle);
                }
                idList.add(vehicle.getId());
            }
            return data;
        } catch (NullPointerException e) {
            return new ArrayList<>();
        }
    }

    private synchronized Long generateNextId() {
        return dataBase.stream().mapToLong(Vehicle::getId).max().isPresent()
                ? dataBase.stream().mapToLong(Vehicle::getId).max().getAsLong() + 1
                : 1;
    }

    /**
     * Save.
     *
     * @param fileName the file name
     */
    public void save(String fileName) {
        validateFile(fileName);
        try (Writer writer = new FileWriter(fileName)) {
            Gson gson = Converters.registerOffsetDateTime(new GsonBuilder()).create();
            gson.toJson(dataBase.stream().toList(), writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Add vehicle to database int.
     *
     * @param model the model
     * @return the int
     */
    public int addVehicleToDatabase(Vehicle model) {
        int id = generateNextId().intValue();
        model.setId(id);
        dataBase.add(model);
        reorderId();
        return id;
    }

    /**
     * Reorder id.
     */
    public void reorderId() {
        for (int i = 0; i < dataBase.size(); i++) {
            if (dataBase.stream().toList().get(i).getId() != i + 1) {
                dataBase.stream().toList().get(i).setId(i + 1);
            }
        }
    }

    /**
     * Remove vehicle from data base boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean removeVehicleFromDataBase(int id) {
        Set<Vehicle> copy = new TreeSet<>(dataBase);
        for (Vehicle model : copy) {
            if (model.getId().equals(id)) {
                dataBase.remove(model);
                return true;
            }
        }
        return false;
    }


    /**
     * Gets data base.
     *
     * @return the data base
     */
    public Set<Vehicle> getDataBase() {
        return dataBase;
    }

    /**
     * Gets date time.
     *
     * @return the date time
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
