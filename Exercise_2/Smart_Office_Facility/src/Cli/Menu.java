package Cli;
import java.util.*;

import Exceptions.BookingException;
// import Models.Office;
import Exceptions.ConfigException;

public class Menu {
    // private Office office;
    private Map<String, Command> commands;

    public Menu( Map<String, Command> commands) {
        this.commands = commands;
    }

    private void showOptions() {
        System.out.println("Available commands:");
        Decorator.separator();
        for(Command cmd : commands.values()) {
            cmd.printSyntax();
        }
    }

    public void show() throws NumberFormatException, BookingException, ArrayIndexOutOfBoundsException {
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
        try {
            Command command = commands.get(input[0].toLowerCase());
            if (command != null) {
                command.execute(input);
            } else {
                System.out.println("Invalid command.");
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid Command");
            show(); // Recursive call—shows menu again unless exit chosen
        } catch (BookingException e) {
            System.out.println("Booking error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            //separator
            Decorator.separator();
            show(); // Recursive call—shows menu again unless exit chosen
        }
    }
}
