package main.java.rows.implementations.rows;

import main.java.invaders.InvadersFactory;
import main.java.lists.implementations.list.DoublyLinkedList;
import main.java.lists.interfaces.IList;
import main.java.rows.interfaces.IRow;

/**
 * Represents the type class B
 */
public class TypeB implements IRow {

    /**
     * Returns a new list of Doubly Linked List Type
     * And calls the method that add the invaders
     *
     * @return A Doubly Linked List
     */
    @Override
    public IList crear(){
        DoublyLinkedList lista = new DoublyLinkedList();
        int min = 0;
        int max = 6;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        this.addInvaders(7, lista, random_int);
        return lista;
    }

    /**
     * Adds the invaders to the Linked Lists
     * It only adds normal invaders
     *
     * @param cant Number of invaders wanted to be added
     * @param list The list which is wanted to be added the invaders
     * @param bossPos Random position where the Boss will spawn
     */
    public void addInvaders(int cant, DoublyLinkedList list, int bossPos) {
        InvadersFactory factory1 = new InvadersFactory();
        int pos = 0;
        System.out.println(bossPos);
        while (pos != cant) {
            if (pos == bossPos) {
                list.append(factory1.createInvader("BOSS"));
            } else {
                list.append(factory1.createInvader("NORMAL"));
            }
            pos += 1;
        }
    }
}