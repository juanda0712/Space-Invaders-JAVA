package main.java.rows.implementations.rows;

import main.java.invaders.InvadersFactory;
import main.java.invaders.interfaces.Invader;
import main.java.lists.implementations.list.LinkedList;
import main.java.rows.interfaces.IRow;

public class Basic implements IRow {
    @Override
    public void creaLista(){
        LinkedList lista = new LinkedList();
        this.addInvaders(6, lista);
    }

    public void addInvaders(int cant, LinkedList list){
        InvadersFactory factory1 = new InvadersFactory();
        while (cant != 0) {

            list.append(factory1.createInvader("NORMAL"));
            cant -= 1;
        }
    }
}

