package server.commands.list;

import server.commands.Command;
import server.controller.VehicleController;
import server.exceptions.ArgumentException;
import server.exceptions.ValidationException;
import server.model.Vehicle;

public class RemoveCommand implements Command {
    private final VehicleController controller;

    public RemoveCommand(VehicleController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            throw new ArgumentException("Команда содержит 1 аргумент - id.");
        }
        try {
            int id = Integer.parseInt(args[1]);
            if (id <= 0) {
                throw new ValidationException("id больше нуля");
            }
            if (controller.getAllVehicle().stream().map(Vehicle::getId).toList().contains(id)) {
                controller.removeVehicleById(id);
                System.out.println("Vehicle удален.");
            } else {
                System.out.println("Vehicle с таким id не найден.");
            }
        } catch (NumberFormatException e) {
            System.out.println("id принимает целочисленное значение.");
        }

    }

    @Override
    public String description() {
        return "удаляет элемент по id";
    }
}
