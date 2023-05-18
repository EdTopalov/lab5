import client.ConsoleUI;
import server.commands.Invoker;
import server.exceptions.FileException;

/**
 * The type App.
 */
public class App {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try {
            ConsoleUI session = new ConsoleUI(new Invoker(args[0]));
            session.start();
        } catch (FileException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("При запуске необходимо указать путь до файла с базой данных.");
        }
    }
}
