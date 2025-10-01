package Cli;
import Exceptions.BookingException;
import Models.Office;

public interface Command 
{
    void execute(String[] args) throws NumberFormatException, BookingException;
    void printSyntax();

}