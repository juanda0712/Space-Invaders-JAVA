package main.java.rows.implementations.rows;

import main.java.invaders.InvadersFactory;
import main.java.lists.implementations.list.CircularList;
import main.java.lists.interfaces.IList;
import main.java.rows.interfaces.IRow;

/**
 * Represents the type class D
 */
public class TypeD implements IRow {
    /**
     * Returns a new list of Circular List Type
     * And calls the method that add the invaders
     *
     * @return A Circular List
     */
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
     * Adds the invaders to the Linked Lists
     * Adds Bosses with different health
     *
     * @param cant Number of invaders wanted to be added
     * @param list The list which is wanted to be added the invaders
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
