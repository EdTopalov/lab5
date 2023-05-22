package server.dao;

import server.database.DataBaseProvider;
import server.model.FuelType;
import server.model.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Класс для взаимодействия с базой данных.
 */
public class VehicleDAOImpl implements VehicleDAO {
    private final DataBaseProvider source;

    /**
     * Instantiates a new Vehicle dao.
     *
     * @param fileName the file name
     */
    public VehicleDAOImpl(String fileName) {
        this.source = new DataBaseProvider(fileName);
    }

    @Override
    public String info() {
        String answer = ("Данные о базе данных: \n");
        answer += "Тип: " + source.getDataBase().getClass().getTypeName().split("\\.")[2] + "\n";
        answer += "Время создания: " + source.getDateTime().toString() + "\n";
        answer += "Элементов внутри: " + (source.getDataBase().size()) + "\n";
        return answer;
    }

    @Override
    public Vehicle getVehicleById(int id) {
        return source.getDataBase().stream().filter(p -> p.getId().equals(id)).toList().get(0);
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        return new ArrayList<Vehicle>(source.getDataBase());
    }

    @Override
    public Integer addVehicle(Vehicle vehicle) {
        return source.addVehicleToDatabase(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle, int id) {
        return source.getDataBase().stream().filter(v -> v.getId().equals(id)).findFirst().get().update(vehicle);
    }

    @Override
    public void removeVehicleById(int id) {
        source.removeVehicleFromDataBase(id);
    }

    @Override
    public void clear() {
        source.getDataBase().clear();
    }

    @Override
    public void save(String filename) {
        source.save(filename);
    }

    @Override
    public Integer addVehicleIfMax(Vehicle vehicle) {
        int id = -1;
        int maxPower = source.getDataBase().stream().map(Vehicle::getEnginePower).max(Comparator.naturalOrder()).orElse(0);
        if (maxPower < vehicle.getEnginePower()) {
            id = source.addVehicleToDatabase(vehicle);
            System.out.println("Успешно");
        } else {
            System.out.println("Не добавлен так как ePower не максимальный");
        }
        return id;
    }

    @Override
    public Integer addVehicleIfMin(Vehicle vehicle) {
        int id = -1;
        int minPower = source.getDataBase().stream().map(Vehicle::getEnginePower).min(Comparator.naturalOrder()).orElse(0);
        if (minPower > vehicle.getEnginePower()) {
            id = source.addVehicleToDatabase(vehicle);
            System.out.println("Успешно");
        }
        return id;
    }

    @Override
    public void removeGreater(int enginePower) {
        source.getDataBase().removeIf(p -> p.getEnginePower() > enginePower);
        source.reorderId();
    }

    @Override
    public void removeAllByEnginePower(int enginePower) {
        source.getDataBase().removeIf(p -> p.getEnginePower() == enginePower);
        source.reorderId();
    }

    @Override
    public List<Vehicle> filterByFuelType(FuelType fuelType) {
        return source.getDataBase().stream().filter(p -> p.getFuelType().equals(fuelType)).toList();
    }

    @Override
    public List<Vehicle> filterStartsWithName(String name) {
        return source.getDataBase().stream().filter(p -> p.getName().contains(name)).toList();
    }
}
