package server.commands.list;

import server.commands.Command;
import server.controller.VehicleController;
import server.exceptions.ArgumentException;

import static server.utils.Parser.fromStringToFuelType;

/**
 * The type Filter by fuel type command.
 */
public class FilterByFuelTypeCommand implements Command {
    private final VehicleController controller;

    /**
     * Instantiates a new Filter by fuel type command.
     *
     * @param controller the controller
     */
    public FilterByFuelTypeCommand(VehicleController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            throw new ArgumentException("Команда содержит 1 аргумент - FuelType.");
        }
        System.out.println(controller.filterByFuelType(fromStringToFuelType(args[1])));
    }

    @Override
    public String description() {
        return "вывести элементы, значение поля fuelType которых равно заданному.";
    }
}
