package Cli;

public interface Command {
    void execute(String[] args);

    void printSyntax() ;
    
}