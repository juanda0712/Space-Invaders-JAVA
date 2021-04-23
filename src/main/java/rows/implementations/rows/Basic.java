package main.java.rows.implementations.rows;

import main.java.invaders.InvadersFactory;
import main.java.lists.implementations.list.LinkedList;
import main.java.lists.interfaces.IList;
import main.java.rows.interfaces.IRow;

/**
 * Representa el tipo de clase Basic.
 */
public class Basic implements IRow {

    /**
     * Retorna una nueva lista tipo Lista Enlazada
     * Y llama el metodo que añade los invaders
     *
     * @return Una Lista Enlazada
     */
    @Override
    public IList crear(){
        LinkedList lista = new LinkedList();
        this.addInvaders(7, lista);
        return lista;
    }

    /**
     * Añade los invaders a la Lista creada
     * Solamente añade invaders normales
     *
     * @param cant Numero de invaders que se quieren agregar a la lista
     * @param list La lista a la que se le quiere agregar los invdaders
     */
    public void addInvaders(int cant, LinkedList list){
        InvadersFactory factory1 = new InvadersFactory();
        while (cant != 0) {

            list.append(factory1.createInvader("NORMAL"));
            cant -= 1;
        }
    }
}

