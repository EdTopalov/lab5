package server.commands.list;

import server.commands.Command;

public class ExitCommand implements Command {

    @Override
    public void execute(String[] args) {

    }

    @Override
    public String description() {
        return "завершить программу.";
    }
}
