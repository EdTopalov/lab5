package server.model;

import com.google.gson.annotations.JsonAdapter;
import server.utils.GsonLocalDateTime;

import java.time.LocalDateTime;

/**
 * The type Vehicle.
 */
public class Vehicle {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    @JsonAdapter(GsonLocalDateTime.class)
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private int enginePower; //Значение поля должно быть больше 0
    private Float capacity; //Поле может быть null, Значение поля должно быть больше 0
    private Float fuelConsumption; //Поле не может быть null, Значение поля должно быть больше 0
    private FuelType fuelType; //Поле может быть null

    /**
     * Instantiates a new Vehicle.
     *
     * @param id              the id
     * @param name            the name
     * @param coordinates     the coordinates
     * @param creationDate    the creation date
     * @param enginePower     the engine power
     * @param capacity        the capacity
     * @param fuelConsumption the fuel consumption
     * @param fuelType        the fuel type
     */
    public Vehicle(Integer id, String name, Coordinates coordinates, LocalDateTime creationDate, int enginePower, Float capacity, Float fuelConsumption, FuelType fuelType) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.enginePower = enginePower;
        this.capacity = capacity;
        this.fuelConsumption = fuelConsumption;
        this.fuelType = fuelType;
    }

    /**
     * Instantiates a new Vehicle.
     *
     * @param name            the name
     * @param coordinates     the coordinates
     * @param enginePower     the engine power
     * @param capacity        the capacity
     * @param fuelConsumption the fuel consumption
     * @param fuelType        the fuel type
     */
    public Vehicle(String name, Coordinates coordinates, int enginePower, Float capacity, Float fuelConsumption, FuelType fuelType) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.enginePower = enginePower;
        this.capacity = capacity;
        this.fuelConsumption = fuelConsumption;
        this.fuelType = fuelType;
    }

    /**
     * Instantiates a new Vehicle.
     */
    public Vehicle() {
        creationDate = LocalDateTime.now();
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets coordinates.
     *
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Sets coordinates.
     *
     * @param coordinates the coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Sets creation date.
     *
     * @param creationDate the creation date
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets engine power.
     *
     * @return the engine power
     */
    public int getEnginePower() {
        return enginePower;
    }

    /**
     * Sets engine power.
     *
     * @param enginePower the engine power
     */
    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    /**
     * Gets capacity.
     *
     * @return the capacity
     */
    public Float getCapacity() {
        return capacity;
    }

    /**
     * Sets capacity.
     *
     * @param capacity the capacity
     */
    public void setCapacity(Float capacity) {
        this.capacity = capacity;
    }

    /**
     * Gets fuel consumption.
     *
     * @return the fuel consumption
     */
    public Float getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Sets fuel consumption.
     *
     * @param fuelConsumption the fuel consumption
     */
    public void setFuelConsumption(Float fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    /**
     * Gets fuel type.
     *
     * @return the fuel type
     */
    public FuelType getFuelType() {
        return fuelType;
    }

    /**
     * Sets fuel type.
     *
     * @param fuelType the fuel type
     */
    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", enginePower=" + enginePower +
                ", capacity=" + capacity +
                ", fuelConsumption=" + fuelConsumption +
                ", fuelType=" + fuelType +
                '}';
    }

    /**
     * Update vehicle.
     *
     * @param vehicle the vehicle
     * @return the vehicle
     */
    public Vehicle update(Vehicle vehicle) {
        name = vehicle.getName();
        coordinates = vehicle.getCoordinates();
        enginePower = vehicle.getEnginePower();
        fuelConsumption = vehicle.getFuelConsumption();
        capacity = vehicle.getCapacity();
        fuelType = vehicle.getFuelType();
        return this;
    }
}