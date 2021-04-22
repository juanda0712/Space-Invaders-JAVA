package main.java.rows.implementations.rows;

import main.java.invaders.InvadersFactory;
import main.java.invaders.interfaces.Invader;
import main.java.lists.implementations.list.DoublyLinkedCircularList;
import main.java.rows.interfaces.IRow;

public class TypeE implements IRow {
    @Override
    public void creaLista(){
        DoublyLinkedCircularList lista = new DoublyLinkedCircularList();
        this.addInvaders(7, lista);
        lista.pruebaFuncionamiento();
    }
    public void addInvaders(int cant, DoublyLinkedCircularList list){
        InvadersFactory factory1 = new InvadersFactory();
        int pos = 0;
        while (pos != cant) {
            Invader newInvader;
            if (pos == 4) {
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
