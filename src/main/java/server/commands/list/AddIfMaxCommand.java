package server.commands.list;

import server.builders.VehicleBuilder;
import server.commands.Command;
import server.controller.VehicleController;
import server.exceptions.ArgumentException;

public class AddIfMaxCommand implements Command {
    private final VehicleController controller;

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
