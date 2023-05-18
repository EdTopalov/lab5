package server.commands.list;

import server.commands.Command;
import server.controller.VehicleController;
import server.exceptions.ArgumentException;

/**
 * The type Remove greater command.
 */
public class RemoveGreaterCommand implements Command {
    private final VehicleController controller;

    /**
     * Instantiates a new Remove greater command.
     *
     * @param controller the controller
     */
    public RemoveGreaterCommand(VehicleController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            throw new ArgumentException("Команда содержит 1 аргумент - engine power.");
        }
        try {
            controller.removeGreater(Integer.parseInt(args[1]));
        } catch (NumberFormatException e) {
            System.out.println("Значение engine power -- числовое.");
        }
    }

    @Override
    public String description() {
        return "удалить из коллекции все элементы, превышающие заданное значение engine power";
    }
}
