package server.dao;

import server.model.FuelType;
import server.model.Vehicle;

import java.util.List;

public class VehicleDAOImpl implements VehicleDAO {
    @Override
    public String info() {
        return null;
    }

    @Override
    public Vehicle getVehicleById(int id) {
        return null;
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        return null;
    }

    @Override
    public Integer addVehicle(Vehicle vehicle) {
        return null;
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle, int id) {
        return null;
    }

    @Override
    public void removeVehicleById(int id) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void save(String filename) {

    }

    @Override
    public Integer addVehicleIfMax(Vehicle vehicle) {
        return null;
    }

    @Override
    public Integer addVehicleIfMin(Vehicle vehicle) {
        return null;
    }

    @Override
    public void removeGreater(int enginePower) {

    }

    @Override
    public void removeAllByEnginePower(int enginePower) {

    }

    @Override
    public List<Vehicle> filterByFuelType(FuelType fuelType) {
        return null;
    }

    @Override
    public List<Vehicle> filterStartsWithName(String name) {
        return null;
    }
}
