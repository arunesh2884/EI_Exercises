import java.util.*;

import Cli.Menu;
import Utils.TimeUtils;

public class Main{
    public static void main(String[] args) {

        // Display system title
        Cli.Decorator.SystemTitle();
        
        Menu menu = new Menu(
            new HashMap<String, Cli.Command>() {{
                put("add", new Cli.AddOccupantCommand());
                put("block", new Cli.BlockRoomCommand());
                put("config", new Cli.ConfigCommand());
            }}
        );
        menu.show();
    }
}