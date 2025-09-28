package Cli;
import Exceptions.BookingException;
import Models.Office;
import Utils.TimeUtils;

public class BlockRoomCommand implements Command {

    Office office;

    public BlockRoomCommand() {
        this.office = Office.getInstance();
    }

    @Override
    public void execute(String args[]) {
        System.out.println("Blocking room...");
        if(args.length != 5){
            System.out.println("Invalid Command");
            printSyntax();
            return;
        }
        if (!"room".equalsIgnoreCase(args[1]) || !TimeUtils.isValidTimeFormat(args[3]) || Integer.parseInt(args[4]) <= 0 || Integer.parseInt(args[2]) < 1) {
            System.out.println("Invalid Command "+!"room".equalsIgnoreCase(args[1])+" "+args[2]+" "+args[3]);
            printSyntax();
            return;
        }
        // business logic here
        try {
            office.blockRoom(Integer.parseInt(args[2]), args[3], Integer.parseInt(args[4]));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (BookingException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void printSyntax() {
        System.out.println("Block:");
        System.out.println("    ->Block Room <id> <StartTime> <Duration>");
    }

}

