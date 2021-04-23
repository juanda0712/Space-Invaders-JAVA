package main.java.rows.implementations.rows;

import main.java.invaders.InvadersFactory;
import main.java.lists.implementations.list.CircularList;
import main.java.lists.interfaces.IList;
import main.java.rows.interfaces.IRow;

/**
 * Retorna una nueva lista tipo Lista Circular
 * Y llama el metodo que añade los invaders
 *
 * @return Una Lista Circular
 */
public class TypeD implements IRow {
    @Override
    public IList crear(){
        CircularList lista = new CircularList();
        int min = 0;
        int max = 6;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        this.addInvaders(7, lista);
        return lista;
    }

    /**
     * Añade los invaders a la Lista creada
     * Añade jefes con diferentes resistencias
     *
     * @param cant Numero de invaders que se quieren agregar a la lista
     * @param list La lista a la que se le quiere agregar los invdaders
     */
    public void addInvaders(int cant, CircularList list){
        InvadersFactory factory1 = new InvadersFactory();
        int pos = 0;
        var i=0;
        while (pos != cant) {
                list.append(factory1.createInvader("BOSS"));
                System.out.println(list.ShowDataInPos(i).getLife());
                i++;
                pos += 1;
        }

    }
}
