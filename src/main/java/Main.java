package main.java;
import main.java.rows.factories.RowsFactory;
import main.java.rows.interfaces.IRow;
import main.java.screens.mainGameplayWindow;
import main.java.screens.mainWindow;

public class Main {
    public static void main(String[] args) {
        mainWindow v1 = new mainWindow();
        //mainGameplayWindow g1 = new mainGameplayWindow();



        RowsFactory factory = new RowsFactory();
        IRow row = factory.createaRow("b");
        row.crear();


    }
}
