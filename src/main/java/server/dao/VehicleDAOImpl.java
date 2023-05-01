package server.dao;

import server.database.DataBaseProvider;
import server.model.FuelType;
import server.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleDAOImpl implements VehicleDAO {
    private final DataBaseProvider source;

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
        //не трогать
        return null;
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
        //попробовать
        return null;
    }

    @Override
    public void removeVehicleById(int id) {
        //вызвать метод соурса
    }

    @Override
    public void clear() {
        source.getDataBase().clear();
    }

    @Override
    public void save(String filename) {
        //не трогать
    }

    @Override
    public Integer addVehicleIfMax(Vehicle vehicle) {
        //взять все Vehicle, взять их Int значения(по полю enginePower) и сравнить максильное из их с vehicle.getEnginePower()
        return null;
    }

    @Override
    public Integer addVehicleIfMin(Vehicle vehicle) {
        //анал. см выше
        return null;
    }

    @Override
    public void removeGreater(int enginePower) {
        //getAllVehicle, if (enginePower < vehicle.getEnginePower) { source.remove(vehicle.getId) }
    }

    @Override
    public void removeAllByEnginePower(int enginePower) {
        // анал. см. выше ( == )
    }

    @Override
    public List<Vehicle> filterByFuelType(FuelType fuelType) {
        //1. создать список, getAllVEhicle if fuelType == vehicle.getFuelType list.add(vehicle)
        //return list;
        return null;
    }

    @Override
    public List<Vehicle> filterStartsWithName(String name) {
        // анал. см. выше + if (vehicle.getName().contains(name)) { list.add(vehicle)}
        return null;
    }
}
