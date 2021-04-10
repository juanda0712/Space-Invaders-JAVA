package main.java.lists.interfaces.implementations.list;

import main.java.lists.interfaces.IList;
import main.java.lists.nodes.OneWayNode;

public class CircularList implements IList {
    @Override
    public void pruebaFuncionamiento(){
        this.append("Arroba");
        this.append("Hakuna");
        this.append("Matata");
        System.out.println(this.ShowDataInPos(17));
        System.out.println(this.getLarge());
        System.out.println("La lista circular funciona");
    }

    int large;
    int actualpos;
    OneWayNode head=null;
    OneWayNode tail=null;

    public CircularList() {
        new OneWayNode(null);
    }

    public void append(Object data) {
        this.large += 1;
        if (this.head == null) {
            this.head = new OneWayNode(data);
            this.tail=this.head;
            this.tail.next=this.head;
        } else {
            var smp = this.tail;
            while (smp.next != this.head) {
                smp = smp.next;
            }
            smp.next = new OneWayNode(data);
            this.tail=smp.next;
            this.tail.next=this.head;
        }
    }

    public int getLarge() {
        return this.large;
    }

    public Object ShowDataInPos(int x) {
        var smp = this.head;
        if (x<0){
            throw new IllegalArgumentException("No existen las posiciones negativas");
        }
        if (x == 0) {
            return smp.getData();
        }
        while (this.actualpos < x) {
            smp = smp.next;
            this.actualpos += 1;
            }
        return smp.getData();
    }
}
