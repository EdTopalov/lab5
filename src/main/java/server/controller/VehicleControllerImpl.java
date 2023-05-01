package server.controller;

import server.dao.VehicleDAO;
import server.dao.VehicleDAOImpl;
import server.model.FuelType;
import server.model.Vehicle;

import java.util.List;

public class VehicleControllerImpl implements VehicleController {
    private VehicleDAO vehicleDAO;

    public VehicleControllerImpl() {
        this.vehicleDAO = new VehicleDAOImpl();
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

    public VehicleDAO getVehicleDAO() {
        return vehicleDAO;
    }

    public void setVehicleDAO(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }
}
