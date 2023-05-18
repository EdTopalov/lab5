package server.commands.list;

import server.commands.Command;
import server.controller.VehicleController;

/**
 * The type Save command.
 */
public class SaveCommand implements Command {
    private final VehicleController controller;
    private final String filename;

    /**
     * Instantiates a new Save command.
     *
     * @param controller the controller
     * @param filename   the filename
     */
    public SaveCommand(VehicleController controller, String filename) {
        this.controller = controller;
        this.filename = filename;
    }

    @Override
    public void execute(String[] args) {
        controller.save(filename);
    }

    @Override
    public String description() {
        return "сохранить коллекцию в файл";
    }
}
