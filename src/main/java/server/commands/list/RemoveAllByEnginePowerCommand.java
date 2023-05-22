package server.commands.list;

import server.commands.Command;
import server.controller.VehicleController;
import server.exceptions.ArgumentException;

/**
 * The type Remove all by engine power command.
 */
public class RemoveAllByEnginePowerCommand implements Command {
    private final VehicleController controller;

    /**
     * Instantiates a new Remove all by engine power command.
     *
     * @param controller the controller
     */
    public RemoveAllByEnginePowerCommand(VehicleController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            throw new ArgumentException("Команда содержит 1 аргумент - engine power.");
        }
        try {
            controller.removeAllByEnginePower(Integer.parseInt(args[1]));
            System.out.println("Vehicle удален.");
        } catch (NumberFormatException e) {
            System.out.println("Значение engine power -- числовое.");
        }
    }

    @Override
    public String description() {
        return "удаляет элементы с заданным engine power";
    }
}
