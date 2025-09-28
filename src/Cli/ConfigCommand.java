package Cli;


import Exceptions.BookingException;
import Models.Office;

public class ConfigCommand implements Command {
    Office office;

    public ConfigCommand() {
        this.office = Office.getInstance();
    }

    @Override
    public void execute(String args[]) throws NumberFormatException, BookingException {
        System.out.println("Configuring settings...");

        if("room".equalsIgnoreCase(args[1])){
            if(args.length == 4 && "count".equalsIgnoreCase(args[2])){
                office.configureOffice(Integer.parseInt(args[3]));
                return;
            }else if(args.length == 6 && "max".equalsIgnoreCase(args[2]) && "capacity".equalsIgnoreCase(args[3])){
                office.configureRoom(Integer.parseInt(args[4]), Integer.parseInt(args[5]));
                return;
            }else{
                throw new BookingException("Invalid Command");
            }
        }else{
            throw new BookingException("Invalid Command");
        }
    }



    @Override
    public void printSyntax() {
        System.out.println("Config:");
        System.out.println("    -> Config Room Count <value>");
        System.out.println("    -> Config Room Max Capacity <id> <value>");
    }
}
