package main.java;
import main.java.rows.factories.RowsFactory;
import main.java.rows.interfaces.IRow;

public class Main {
    public static void main(String[] args) {
        //instructionsWindow v1 = new instructionsWindow();
        mainWindow v1 = new mainWindow();
        RowsFactory factory = new RowsFactory();
        IRow lista = factory.createaRow("E");
        lista.creaLista();

    }
}
