import java.util.*;

import Cli.Menu;
import Exceptions.BookingException;
import Models.Office;
import Utils.TimeUtils;

public class Main{
    public static void main(String[] args) {

        // Display system title
        Cli.Decorator.SystemTitle();
        // Display current time
        System.out.println("Current time: " + TimeUtils.getCurrentTimeHHMM());
        Menu menu = new Menu(
            new HashMap<String, Cli.Command>() {{
                put("add", new Cli.AddOccupantCommand());
                put("block", new Cli.BlockRoomCommand());
                put("config", new Cli.ConfigCommand());
            }}
        );
        try {
            menu.show();

        } catch (BookingException e) {
            System.out.println("Booking error: " + e.getMessage());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Command");
        }catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}