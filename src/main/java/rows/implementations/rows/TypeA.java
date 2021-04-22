package main.java.rows.implementations.rows;

import main.java.invaders.InvadersFactory;
import main.java.invaders.interfaces.Invader;
import main.java.lists.implementations.list.LinkedList;
import main.java.rows.interfaces.IRow;

public class TypeA implements IRow {

    @Override
    public void creaLista(){
        LinkedList lista = new LinkedList();
        int min = 0;
        int max = 6;
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        this.addInvaders(7, lista, random_int);
        lista.pruebaFuncionamiento();
    }
    public void addInvaders(int cant, LinkedList list, int bossPos){
        InvadersFactory factory1 = new InvadersFactory();
        int pos = 0;
        System.out.println(bossPos);
        while (pos != cant) {
            Invader newInvader;
            if (pos == bossPos) {
                newInvader = factory1.createInvader("BOSS");
                list.append("boss");
            } else {
                newInvader = factory1.createInvader("NORMAL");
                list.append("normal");
            }
            pos += 1;
        }

    }
}
