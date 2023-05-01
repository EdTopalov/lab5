package server.database;

import server.model.Vehicle;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

public class DataBaseProvider {
    private final Set<Vehicle> dataBase;
    private final LocalDateTime dateTime;

    public DataBaseProvider(Set<Vehicle> dataBase, LocalDateTime dateTime) {
        this.dataBase = loadDataBase("");
        this.dateTime = dateTime;
    }

    private static Set<Vehicle> loadDataBase(String fileName) {
        Set<Vehicle> resultSet = new TreeSet<>();
        return resultSet;
    }

}
