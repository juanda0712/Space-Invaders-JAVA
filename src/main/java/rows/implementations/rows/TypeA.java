package main.java.rows.implementations.rows;

import main.java.lists.implementations.list.LinkedList;
import main.java.lists.interfaces.IList;
import main.java.rows.interfaces.IRow;

public class TypeA implements IRow {

    @Override
    public void creaLista(){
        IList lista = new LinkedList();
        lista.pruebaFuncionamiento();
    }
}
