package server.commands;

import server.commands.list.*;
import server.controller.VehicleController;
import server.controller.VehicleControllerImpl;
import server.exceptions.ArgumentException;
import server.exceptions.FileException;
import server.exceptions.ValidationException;
import server.utils.ScriptManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static server.utils.Parser.tildaResolver;

/**
 * Класс инвокер для паттерна команды. Вызывает метод execute от введеной строки, валидирует её, отлавливает ошибки возникающие при выполнении команд.
 * Содержит Map, где ключ -- название, а значение -- класс команды.
 *
 */
public class Invoker {
    private static Map<String, Command> commandMap = new HashMap<>();
    private final VehicleController controller;
    private final String filename;
    private BufferedReader reader;

    /**
     * При создании сущности, создается контроллер, создается скрипт менеджер и обрабатывается путь до файла (filename)
     * Происходит инициализация Map'ы команд.
     *
     * @param filename the filename
     */
    public Invoker(String filename) {
        this.filename = tildaResolver(filename);
        this.reader = reader == null ? new BufferedReader(new InputStreamReader(System.in)) : reader;
        controller = new VehicleControllerImpl(filename);
        init();
    }

    /**
     * Gets command map.
     *
     * @return the command map
     */
    public static Map<String, Command> getCommandMap() {
        return commandMap;
    }

    /**
     * Sets command map.
     *
     * @param commandMap the command map
     */
    public static void setCommandMap(Map<String, Command> commandMap) {
        Invoker.commandMap = commandMap;
    }

    /**
     * Add command to map.
     *
     * @param commandName the command name
     * @param command     the command
     */
    public void addCommandToMap(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    /**
     * Метод инициализации команд, добавленные здесь, будут видны пользователю.
     */
    public void init() {
        addCommandToMap("help", new HelpCommand());
        addCommandToMap("exit", new ExitCommand());
        addCommandToMap("add", new AddCommand(controller));
        addCommandToMap("info", new InfoCommand(controller));
        addCommandToMap("show", new ShowCommand(controller));
        addCommandToMap("clear", new ClearCommand(controller));
        addCommandToMap("update", new UpdateCommand(controller));
        addCommandToMap("remove", new RemoveCommand(controller));
        addCommandToMap("add_if_max", new AddIfMaxCommand(controller));
        addCommandToMap("save", new SaveCommand(controller, filename));
        addCommandToMap("remove_greater", new RemoveGreaterCommand(controller));
        addCommandToMap("filter_by_fuel_type", new FilterByFuelTypeCommand(controller));
        addCommandToMap("filter_starts_with_name", new FilterStartsWithNameCommand(controller));
        addCommandToMap("remove_all_by_engine_power", new RemoveAllByEnginePowerCommand(controller));
        addCommandToMap("execute_script", new ExecuteScriptCommand(this, new ScriptManager(null)));
    }

    /**
     * Метод для обработки введеной строки:
     *  если первый элемент (по разбиению на пробелы) совпадает с названим существующей команды, то вызывается .execute у соответствующей команды
     *  если нет, то "Команда не найдена."
     *
     * Обработка ошибок: при вызове .execute у команды, могут вылетать ошибки ArgumentException etc.
     * Тут они обрабатываются и выводятся пользователю.
     *
     * @param input the input
     */
    public void execute(String input) {
        try {
            String[] commandArray = input.trim().split(" ");
            String command = commandArray[0];
            for (Map.Entry<String, Command> pair : Invoker.getCommandMap().entrySet()) {
                if (pair.getKey().trim().equals(command)) {
                    pair.getValue().execute(commandArray);
                }
            }
            if (!Invoker.getCommandMap().containsKey(command)) {
                System.out.println("Команда не найдена.");
            }
        } catch (ArgumentException | ValidationException | FileException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets reader.
     *
     * @return the reader
     */
    public BufferedReader getReader() {
        return reader;
    }

    /**
     * Sets reader.
     *
     * @param reader the reader
     */
    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }
}