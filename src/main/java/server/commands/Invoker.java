package server.commands;

import server.commands.list.ExitCommand;
import server.commands.list.HelpCommand;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Invoker {
    private BufferedReader reader;
    private static Map<String, Command> commandMap = new HashMap<>();

    public Invoker() {
        this.reader = reader == null ? new BufferedReader(new InputStreamReader(System.in)) : reader;
        init();
    }

    public void addCommandToMap(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void init() {
        addCommandToMap("help", new HelpCommand());
        addCommandToMap("exit", new ExitCommand());
    }

    public void execute(String input) {
        try {
            String[] commandArray = input.split(" ");
            String command = commandArray[0];
            for (Map.Entry<String, Command> pair : Invoker.getCommandMap().entrySet()) {
                if (pair.getKey().equals(command)) {
                    pair.getValue().execute(commandArray);
                }
            }
            if (!Invoker.getCommandMap().containsKey(command)) {
                System.out.println("Command not found.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedReader getReader() {
        return reader;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public static Map<String, Command> getCommandMap() {
        return commandMap;
    }

    public static void setCommandMap(Map<String, Command> commandMap) {
        Invoker.commandMap = commandMap;
    }
}