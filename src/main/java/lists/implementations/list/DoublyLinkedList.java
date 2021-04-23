package main.java.lists.implementations.list;

import main.java.lists.interfaces.IList;
import main.java.lists.nodes.TwoWaysNode;

public class DoublyLinkedList implements IList {
    @Override
    public void pruebaFuncionamiento(){
        this.append(15);
        this.append(14);
        this.append(13);
        this.append(30);
        this.append(25);
        System.out.println(ShowDataInPos(2));
        this.Delete(2);
        System.out.println(ShowDataInPos(2));
        System.out.println("La lista doblemente enlazada funciona");
    }

    int large;
    int actualpos;
    TwoWaysNode head=null;
    TwoWaysNode tail=null;

    public DoublyLinkedList() {
        new TwoWaysNode(null);
    }

    public void append(Object data) {
        this.large += 1;
        if (this.head == null) {
            this.head = new TwoWaysNode(data);
            this.tail=this.head;
        } else {
            var smp = this.tail;
            smp.next = new TwoWaysNode(data);
            this.tail=smp.next;
            this.tail.prev=smp;
        }
    }

    public int getLarge() {
        return this.large;
    }

    public Object ShowDataInPos(int x) {
        actualpos=0;
        var smp = this.head;
        if (x<0){
            throw new IllegalArgumentException("No existen las posiciones negativas");
        }
        if (x == 0) {
            return smp.getData();
        }
        if (x<=this.large/2) {
            while (this.actualpos < x) {
                if (this.actualpos <= this.large) {
                    if (smp.next != null) {
                        smp = smp.next;
                        this.actualpos += 1;
                    }
                }
            }
        }
        else{
            smp=this.tail;
            this.actualpos=this.large-1;
            while (this.actualpos>x){
                smp=smp.prev;
                this.actualpos-=1;
            }
        }
        return smp.getData();
    }

    public void Delete (int pos){
        actualpos=0;
        if (pos==0){
            this.head=this.head.next;
            this.head.prev=null;
            this.large-=1;
        }
        var smp=this.head;
        while(actualpos<=pos){
            if (actualpos+1==pos){
                smp.next=smp.next.next;
                smp=smp.next;
                smp.prev=smp.prev.prev;
                this.large-=1;
            }
            smp=smp.next;
            actualpos+=1;
        }
    }
}
