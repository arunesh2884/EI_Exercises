package Cli;

public class AddOccupantCommand implements Command {

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
