package main.java.rows.implementations.rows;

import main.java.invaders.InvadersFactory;
import main.java.invaders.interfaces.Invader;
import main.java.lists.implementations.list.DoublyLinkedCircularList;
import main.java.lists.interfaces.IList;
import main.java.rows.interfaces.IRow;

/**
 * Retorna una nueva lista tipo Lista Doble y Circular
 * Y llama el metodo que añade los invaders
 *
 * @return Una Lista Doble y Circular
 */
public class TypeE implements IRow {
    @Override
    public IList crear(){
        DoublyLinkedCircularList lista = new DoublyLinkedCircularList();
        this.addInvaders(7, lista);
        return lista;

    }

    /**
     * Añade los invaders a la Lista creada
     * Añade tanto invaders normales como un jefe
     *
     * @param cant Numero de invaders que se quieren agregar a la lista
     * @param list La lista a la que se le quiere agregar los invdaders
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
