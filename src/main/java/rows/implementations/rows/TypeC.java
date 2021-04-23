package main.java.rows.implementations.rows;

import main.java.invaders.InvadersFactory;
import main.java.invaders.interfaces.Invader;
import main.java.lists.implementations.list.CircularList;
import main.java.lists.interfaces.IList;
import main.java.rows.interfaces.IRow;

public class TypeC implements IRow {
    @Override
    public IList crear(){
        CircularList lista = new CircularList();
        int min = 0;
        int max = 6;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        this.addInvaders(7, lista, random_int);
        return lista;
    }

    public void addInvaders(int cant, CircularList list, int bossPos){
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
