import client.ConsoleUI;
import server.commands.Invoker;

public class App {
    public static void main(String[] args) {
        ConsoleUI session = new ConsoleUI(new Invoker(""));
        session.start();
    }
}
