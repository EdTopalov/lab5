package server.controller;

import server.dao.VehicleDAO;
import server.dao.VehicleDAOImpl;
import server.model.FuelType;
import server.model.Vehicle;

import java.util.List;

public class VehicleControllerImpl implements VehicleController {
    private VehicleDAO vehicleDAO;

    public VehicleControllerImpl(String fileName) {
        this.vehicleDAO = new VehicleDAOImpl(fileName);
    }

    @Override
    public String info() {
        return vehicleDAO.info();
    }

    @Override
    public Vehicle getVehicleById(int id) {
        return vehicleDAO.getVehicleById(id);
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        return vehicleDAO.getAllVehicle();
    }

    @Override
    public Integer addVehicle(Vehicle vehicle) {
        return vehicleDAO.addVehicle(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle, int id) {
        return vehicleDAO.updateVehicle(vehicle, id);
    }

    @Override
    public void removeVehicleById(int id) {
        vehicleDAO.removeVehicleById(id);
    }

    @Override
    public void clear() {
        vehicleDAO.clear();
    }

    @Override
    public void save(String filename) {
        vehicleDAO.save(filename);
    }

    @Override
    public Integer addVehicleIfMax(Vehicle vehicle) {
        return vehicleDAO.addVehicleIfMax(vehicle);
    }

    @Override
    public Integer addVehicleIfMin(Vehicle vehicle) {
        return vehicleDAO.addVehicleIfMin(vehicle);
    }

    @Override
    public void removeGreater(int enginePower) {
        vehicleDAO.removeGreater(enginePower);
    }

    @Override
    public void removeAllByEnginePower(int enginePower) {
        vehicleDAO.removeAllByEnginePower(enginePower);
    }

    @Override
    public List<Vehicle> filterByFuelType(FuelType fuelType) {
        return vehicleDAO.filterByFuelType(fuelType);
    }

    @Override
    public List<Vehicle> filterStartsWithName(String name) {
        return vehicleDAO.filterStartsWithName(name);
    }

    public VehicleDAO getVehicleDAO() {
        return vehicleDAO;
    }

    public void setVehicleDAO(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }
}
