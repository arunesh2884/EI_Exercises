package Cli;
import java.util.*;

import Exceptions.BookingException;
import Models.Office;

public class Menu {
    private Office office;
    private Map<String, Command> commands;

    public Menu(Office office, Map<String, Command> commands) {
        this.office = office;
        this.commands = commands;
    }

    private void showOptions() {
        System.out.println("Available commands:");
        Decorator.separator();
        for(Command cmd : commands.values()) {
            cmd.printSyntax();
        }
    }

    public void show() throws NumberFormatException, BookingException {
        // ... show options
        showOptions();


        //... get user input
        System.out.println("\nEnter command:");
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        if ("exit".equalsIgnoreCase(input[0])) {
            System.out.println("Exiting...");
            return;
             // End recursion
        }

        Command command = commands.get(input[0].toLowerCase());
        if (command != null) {
            command.execute(input);
        } else {
            System.out.println("Invalid command.");
        }

        //separator
        Decorator.separator();
        

        show(); // Recursive call—shows menu again unless exit chosen
    }
}
