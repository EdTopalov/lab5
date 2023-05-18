package server.commands.list;

import server.builders.VehicleBuilder;
import server.commands.Command;
import server.controller.VehicleController;
import server.exceptions.ArgumentException;

/**
 * The type Add if max command.
 */
public class AddIfMaxCommand implements Command {
    private final VehicleController controller;

    /**
     * Instantiates a new Add if max command.
     *
     * @param controller the controller
     */
    public AddIfMaxCommand(VehicleController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            throw new ArgumentException("Команда не должна содержать аргументов.");
        }
        controller.addVehicleIfMax(VehicleBuilder.build());
    }

    @Override
    public String description() {
        return "Добавляет элемент, если его значение превышает значение наибольшего элемента";
    }
}
