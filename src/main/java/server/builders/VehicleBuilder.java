package server.builders;

import server.model.Vehicle;

/**
 * Класс строитель объекта класса Vehicle.
 */
public class VehicleBuilder {
    /**
     * Build vehicle.
     *
     * @return the vehicle
     */
    public static Vehicle build() {
        Vehicle response = new Vehicle();
        response.setName(NameBuilder.build());
        response.setCoordinates(CoordinatesBuilder.build());
        response.setEnginePower(IntegerBuilder.build("Введите значение Engine Power:"));
        response.setCapacity(FloatBuilder.build("Введите значение capacity:"));
        response.setFuelConsumption(FloatBuilder.build("Введите значение fuel consumption:"));
        response.setFuelType(FuelTypeBuilder.build());
        return response;
    }
}
