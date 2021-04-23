package main.java.rows.implementations.rows;

import main.java.invaders.InvadersFactory;
import main.java.invaders.interfaces.Invader;
import main.java.lists.implementations.list.DoublyLinkedCircularList;
import main.java.lists.interfaces.IList;
import main.java.rows.interfaces.IRow;

public class TypeE implements IRow {
    @Override
    public IList crear(){
        DoublyLinkedCircularList lista = new DoublyLinkedCircularList();
        this.addInvaders(7, lista);
        return lista;

    }
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
