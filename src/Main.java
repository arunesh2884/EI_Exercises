import java.util.*;

import Cli.Menu;
import Exceptions.BookingException;
import Models.Office;
import Utils.TimeUtils;

public class Main{
    public static void main(String[] args) {

        // Display system title
        Cli.Decorator.SystemTitle();
        Office office = new Office();

        System.out.println(TimeUtils.getCurrentTimeHHMM());
        Menu menu = new Menu(office,
            new HashMap<String, Cli.Command>() {{
                put("add", new Cli.AddOccupantCommand(office));
                put("block", new Cli.BlockRoomCommand(office));
                put("config", new Cli.ConfigCommand(office));
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