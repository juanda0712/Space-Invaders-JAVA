package main.java.lists.interfaces.implementations.list;

import main.java.lists.interfaces.IList;
import main.java.lists.nodes.TwoWaysNode;

public class DoublyLinkedCircularList implements IList {
    @Override
    public void pruebaFuncionamiento(){
        this.append("Arroba");
        this.append("Hakuna");
        this.append("Matata");
        System.out.println(this.ShowDataInPos(-14));
        System.out.println(this.ShowDataInPos(15));
        System.out.println(this.getLarge());
        System.out.println("La lista circular doblemente enlazada funciona");
    }

    int large;
    int actualpos;
    TwoWaysNode head=null;
    TwoWaysNode tail=null;

    public DoublyLinkedCircularList() {
        new TwoWaysNode(null);
    }

    public void append(Object data) {
        this.large += 1;
        if (this.head == null) {
            this.head = new TwoWaysNode(data);
            this.tail=this.head;
            this.tail.prev=this.head;

        } else {
            var smp = this.tail;
            while (smp.next != this.head) {
                smp = smp.next;
            }
            smp.next = new TwoWaysNode(data);
            this.tail=smp.next;
            this.tail.prev=smp;
        }
        this.head.prev=this.tail;
        this.tail.next=this.head;

    }

    public int getLarge() {
        return this.large;
    }

    public Object ShowDataInPos(int x) {
        var smp = this.head;
        if (x<0){
            while (this.actualpos>x){
                smp=smp.prev;
                this.actualpos -= 1;
            }
            return smp.getData();
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

