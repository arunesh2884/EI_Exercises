import java.util.*;

import Cli.Menu;
import Exceptions.BookingException;
import Models.Office;
import Utils.TimeUtils;

public class Main{
    public static void main(String[] args) {

        // Display system title
        Cli.Decorator.SystemTitle();
        // Office office = new Office();

        System.out.println(TimeUtils.getCurrentTimeHHMM());
        Menu menu = new Menu(
            new HashMap<String, Cli.Command>() {{
                put("add", new Cli.AddOccupantCommand());
                put("block", new Cli.BlockRoomCommand());
                put("config", new Cli.ConfigCommand());
            }}
        );
        try {
            menu.show();

        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (BookingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}