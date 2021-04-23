package main.java.lists.implementations.list;

import main.java.invaders.interfaces.Invader;
import main.java.lists.interfaces.IList;
import main.java.lists.nodes.TwoWaysNode;

public class DoublyLinkedCircularList implements IList {
    @Override
    public void pruebaFuncionamiento(){

        System.out.println(this.ShowDataInPos(2));
        this.Delete(2);
        System.out.println(this.ShowDataInPos(2));
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

    public void append(Invader data) {
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

    public Invader ShowDataInPos(int x) {
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

    public void Delete (int pos) {
        actualpos = 0;
        if (pos == 0) {
            this.tail.next = this.head.next;
            this.head = this.head.next;
            this.head.prev=this.head.prev.prev;
            this.large -= 1;
        }
        else {
            var smp = this.head;
            while (actualpos <= pos) {
                if (actualpos+1 == pos) {
                    if (smp.next==this.tail){
                        this.tail=smp;
                    }
                    smp.next = smp.next.next;
                    smp=smp.next;
                    smp.prev=smp.prev.prev;
                    this.large -= 1;
                }
                smp = smp.next;
                actualpos += 1;
            }
        }
    }
}

