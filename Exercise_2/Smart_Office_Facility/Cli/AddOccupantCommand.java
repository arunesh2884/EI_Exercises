package Cli;
import Exceptions.BookingException;
import Models.Office;

public class AddOccupantCommand implements Command {
    Office office;
    public AddOccupantCommand() {
        this.office = Office.getInstance();
    }


    @Override
    public void execute(String[] args) {
        System.out.println("Adding occupant...");

        if(args.length != 4){
            System.out.println("Invalid Command");
            printSyntax();
            return;
        }
        try {
            int roomId = Integer.parseInt(args[2]);
            int numberOfOccupants = Integer.parseInt(args[3]);
            if (roomId < 1 || numberOfOccupants < 0) {
                System.out.println("Invalid Command");
                printSyntax();
                throw new NumberFormatException("Room ID must be a positive integer and number of occupants must be a non-negative integer.");
            }
            office.getRoomManager().addOccupant(roomId, numberOfOccupants);
        } catch (NumberFormatException e) {
            System.out.println("Invalid room ID.");
        } catch (BookingException e) {
            System.out.println("Error adding occupant: " + e.getMessage());
        }
    }

    @Override
    public void printSyntax() {
        System.out.println("Add:");
        System.out.println("    -> Add Occupant <roomId> <value>");
    }
}
