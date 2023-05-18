package server.controller;

import server.model.FuelType;
import server.model.Vehicle;

import java.util.List;

/**
 * The interface Vehicle controller.
 */
public interface VehicleController {
    /**
     * Info string.
     *
     * @return the string
     */
    String info();

    /**
     * Gets vehicle by id.
     *
     * @param id the id
     * @return the vehicle by id
     */
    Vehicle getVehicleById(int id);

    /**
     * Gets all vehicle.
     *
     * @return the all vehicle
     */
    List<Vehicle> getAllVehicle();

    /**
     * Add vehicle integer.
     *
     * @param vehicle the vehicle
     * @return the integer
     */
    Integer addVehicle(Vehicle vehicle);

    /**
     * Update vehicle vehicle.
     *
     * @param vehicle the vehicle
     * @param id      the id
     * @return the vehicle
     */
    Vehicle updateVehicle(Vehicle vehicle, int id);

    /**
     * Remove vehicle by id.
     *
     * @param id the id
     */
    void removeVehicleById(int id);

    /**
     * Clear.
     */
    void clear();

    /**
     * Save.
     *
     * @param filename the filename
     */
    void save(String filename);

    /**
     * Add vehicle if max integer.
     *
     * @param vehicle the vehicle
     * @return the integer
     */
    Integer addVehicleIfMax(Vehicle vehicle);

    /**
     * Add vehicle if min integer.
     *
     * @param vehicle the vehicle
     * @return the integer
     */
    Integer addVehicleIfMin(Vehicle vehicle);

    /**
     * Remove greater.
     *
     * @param enginePower the engine power
     */
    void removeGreater(int enginePower);

    /**
     * Remove all by engine power.
     *
     * @param enginePower the engine power
     */
    void removeAllByEnginePower(int enginePower);

    /**
     * Filter by fuel type list.
     *
     * @param fuelType the fuel type
     * @return the list
     */
    List<Vehicle> filterByFuelType(FuelType fuelType);

    /**
     * Filter starts with name list.
     *
     * @param name the name
     * @return the list
     */
    List<Vehicle> filterStartsWithName(String name);
}
