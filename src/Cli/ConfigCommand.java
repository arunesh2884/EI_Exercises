package Cli;

public class ConfigCommand implements Command {


    @Override
    public void execute(String args[]) {
        System.out.println("Configuring settings...");
        // business logic here
    }
    @Override
    public void printSyntax() {
        System.out.println("Config:");
        System.out.println("    -> Config Room Count <value>");
        System.out.println("    -> Config Room Max Capacity <id> <value>");
    }
}
