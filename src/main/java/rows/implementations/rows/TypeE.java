package main.java.rows.implementations.rows;

import main.java.lists.implementations.list.DoublyLinkedCircularList;
import main.java.lists.implementations.list.LinkedList;
import main.java.lists.interfaces.IList;
import main.java.rows.interfaces.IRow;

public class TypeE implements IRow {
    @Override
    public void creaLista(){
        IList lista = new DoublyLinkedCircularList();
        lista.pruebaFuncionamiento();
    }
}
