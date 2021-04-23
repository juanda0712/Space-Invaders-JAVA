package main.java.rows.implementations.rows;

import main.java.invaders.InvadersFactory;
import main.java.lists.implementations.list.LinkedList;
import main.java.lists.interfaces.IList;
import main.java.rows.interfaces.IRow;

/**
 * Represents the type class Basic
 */
public class Basic implements IRow {

    /**
     * Returns a new list of Linked List Type
     * And calls the method that add the invaders
     *
     * @return A Linked List
     */
    @Override
    public IList crear(){
        LinkedList lista = new LinkedList();
        this.addInvaders(7, lista);
        return lista;
    }

    /**
     * Adds the invaders to the Linked Lists
     * It only adds normal invaders
     *
     * @param cant Number of invaders wanted to be added
     * @param list The list which is wanted to be added the invaders
     */
    public void addInvaders(int cant, LinkedList list){
        InvadersFactory factory1 = new InvadersFactory();
        while (cant != 0) {

            list.append(factory1.createInvader("NORMAL"));
            cant -= 1;
        }
    }
}

