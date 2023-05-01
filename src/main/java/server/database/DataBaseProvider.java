package server.database;

import server.model.Vehicle;
import server.model.VehicleComparatorForTreeSet;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeSet;

public class DataBaseProvider {
    private final Set<Vehicle> dataBase;
    private final LocalDateTime dateTime;

    public DataBaseProvider(String filename) {
        this.dataBase = loadDataBase("");
        this.dateTime = LocalDateTime.now();
    }

    private static Set<Vehicle> loadDataBase(String fileName) {
        Set<Vehicle> resultSet = new TreeSet<>(new VehicleComparatorForTreeSet());
        return resultSet;
    }

    private synchronized Long generateNextId() {
        return dataBase.stream().mapToLong(Vehicle::getId).max().isPresent()
                ? dataBase.stream().mapToLong(Vehicle::getId).max().getAsLong() + 1
                : 1;
    }

    public int addVehicleToDatabase(Vehicle model) {
        int id = generateNextId().intValue();
        model.setId(id);
        dataBase.add(model);
        return id;
    }

    public int updateVehicle(Vehicle model, int id) {
        //берет элемент из dataBase с номером id и подставляет значения из model
        return id;
    }

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


    public Set<Vehicle> getDataBase() {
        return dataBase;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
