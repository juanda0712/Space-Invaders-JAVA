package main.java.rows.implementations.rows;

import main.java.invaders.InvadersFactory;
import main.java.invaders.interfaces.Invader;
import main.java.lists.implementations.list.DoublyLinkedCircularList;
import main.java.lists.interfaces.IList;
import main.java.rows.interfaces.IRow;

/**
 * Representsthe type class E
 */
public class TypeE implements IRow {
    /**
     * Returns a new list of Doubly Linked List Type
     * And calls the method that add the invaders
     *
     * @return A Doubly Linked List
     */
    @Override
    public IList crear(){
        DoublyLinkedCircularList lista = new DoublyLinkedCircularList();
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
    public void addInvaders(int cant, DoublyLinkedCircularList list){
        InvadersFactory factory1 = new InvadersFactory();
        int pos = 0;
        while (pos != cant) {
            Invader newInvader;
            if (pos == 4) {
                list.append(factory1.createInvader("BOSS"));
            } else {
                list.append(factory1.createInvader("NORMAL"));
            }
            pos += 1;
        }

    }
}
