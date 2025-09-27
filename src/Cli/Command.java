package Cli;
import Exceptions.BookingException;
import Models.Office;

public abstract class Command {
    protected Office office;
    
    Command(Office office) {
        this.office = office;
    }

    
    abstract void execute(String[] args) throws NumberFormatException, BookingException;
    abstract void printSyntax();
    
}