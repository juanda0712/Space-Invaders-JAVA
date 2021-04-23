package main.java.rows.implementations.rows;

import main.java.invaders.InvadersFactory;
import main.java.invaders.interfaces.Invader;
import main.java.lists.implementations.list.LinkedList;
import main.java.lists.interfaces.IList;
import main.java.rows.interfaces.IRow;

public class Basic implements IRow {
    @Override
    public IList crear(){
        LinkedList lista = new LinkedList();
        this.addInvaders(7, lista);
        return lista;
    }

    public void addInvaders(int cant, LinkedList list){
        InvadersFactory factory1 = new InvadersFactory();
        while (cant != 0) {

            list.append(factory1.createInvader("NORMAL"));
            cant -= 1;
        }
    }
}

