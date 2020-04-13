package assignment;

import assignment.view.ConsoleView;
import java.sql.SQLException;


public class MainThread {
    public static void main(String[] args) throws SQLException {
        ConsoleView consoleView = new ConsoleView();
        consoleView.generateMenu();
    }

}

