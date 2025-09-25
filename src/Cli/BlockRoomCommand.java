package Cli;
public class BlockRoomCommand implements Command {
    @Override
    public void execute(String args[]) {
        System.out.println("Blocking room...");
        // business logic here
    }
    @Override
    public void printSyntax() {
        System.out.println("Block:");
        System.out.println("    ->Block Room <id> <StartTime> <Duration>");
    }

}

