package server.commands.list;

import server.commands.Command;
import server.controller.VehicleController;
import server.exceptions.ArgumentException;
import server.model.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The type Show command.
 */
public class ShowCommand implements Command {
    private final VehicleController controller;

    /**
     * Instantiates a new Show command.
     *
     * @param controller the controller
     */
    public ShowCommand(VehicleController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            throw new ArgumentException("Команда не должна содержать аргументов.");
        }
        List<Vehicle> vehicles = controller.getAllVehicle();
        vehicles.sort(Comparator.comparingInt(Vehicle::getId));
        vehicles.forEach(System.out::println);
        System.out.println("Выведено " + controller.getAllVehicle().size() + " объектов.");
    }

    @Override
    public String description() {
        return "выводит все объекты.";
    }
}
