package main.java.rows.implementations.rows;

import main.java.invaders.InvadersFactory;
import main.java.lists.implementations.list.DoublyLinkedList;
import main.java.lists.interfaces.IList;
import main.java.rows.interfaces.IRow;

public class TypeB implements IRow {

    /**
     * Retorna una nueva lista tipo Lista Doblemente Enlazada
     * Y llama el metodo que añade los invaders
     *
     * @return Una Lista Doblemente Enlazada
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
     * Añade los invaders a la Lista creada
     * Añade tanto invaders normales como un jefe
     *
     * @param cant Numero de invaders que se quieren agregar a la lista
     * @param list La lista a la que se le quiere agregar los invdaders
     * @param bossPos La posicion en la que aleatoriamente aparecerá el jefe
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