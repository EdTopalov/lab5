package server.dao;

import server.model.FuelType;
import server.model.Vehicle;

import java.util.List;

public interface VehicleDAO {
    String info();

    Vehicle getVehicleById(int id);

    List<Vehicle> getAllVehicle();

    Integer addVehicle(Vehicle vehicle);

    Vehicle updateVehicle(Vehicle vehicle, int id);

    void removeVehicleById(int id);

    void clear();

    void save(String filename);

    Integer addVehicleIfMax(Vehicle vehicle);

    Integer addVehicleIfMin(Vehicle vehicle);

    void removeGreater(int enginePower);

    void removeAllByEnginePower(int enginePower);

    List<Vehicle> filterByFuelType(FuelType fuelType);

    List<Vehicle> filterStartsWithName(String name);
}
