package server.commands.list;

import server.commands.Command;
import server.controller.VehicleController;
import server.exceptions.ArgumentException;

/**
 * The type Filter starts with name command.
 */
public class FilterStartsWithNameCommand implements Command {
    private final VehicleController controller;

    /**
     * Instantiates a new Filter starts with name command.
     *
     * @param controller the controller
     */
    public FilterStartsWithNameCommand(VehicleController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            throw new ArgumentException("Команда содержит 1 аргумент - часть имени.");
        }
        System.out.println(controller.filterStartsWithName(args[1]));
    }

    @Override
    public String description() {
        return "вывести элементы, значение поля name которых начинается с заданной подстроки.";
    }
}
