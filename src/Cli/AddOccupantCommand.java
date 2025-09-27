package Cli;
import Models.Office;

public class AddOccupantCommand extends Command {

    public AddOccupantCommand(Office office) {
        super(office);
    }


    @Override
    public void execute(String[] args) {
        System.out.println("Adding occupant...");
        // business logic here
    }

    @Override
    public void printSyntax() {
        System.out.println("Add:");
        System.out.println("    -> Add Occupant <roomId> <value>");
    }
}
