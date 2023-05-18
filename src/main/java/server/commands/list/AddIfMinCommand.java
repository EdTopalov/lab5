package server.commands.list;

import server.builders.VehicleBuilder;
import server.commands.Command;
import server.controller.VehicleController;
import server.exceptions.ArgumentException;

/**
 * The type Add if min command.
 */
public class AddIfMinCommand implements Command {
    private final VehicleController controller;

    /**
     * Instantiates a new Add if min command.
     *
     * @param controller the controller
     */
    public AddIfMinCommand(VehicleController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            throw new ArgumentException("Команда не должна содержать аргументов.");
        }
        controller.addVehicleIfMin(VehicleBuilder.build());
    }

    @Override
    public String description() {
        return "Добавляет элемент, если его значение меньше значения наименьшего элемента";
    }
}
