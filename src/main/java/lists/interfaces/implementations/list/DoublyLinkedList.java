package main.java.lists.interfaces.implementations.list;

import main.java.lists.interfaces.IList;
import main.java.lists.interfaces.implementations.list.nodes.TwoWaysNode;

public class DoublyLinkedList implements IList {
    @Override
    public void pruebaFuncionamiento(){
        this.append(15);
        this.append(14);
        this.append(13);
        this.append(30);
        this.append(25);
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
        // El while esta acomodado de manera que aunque exceda el largo de la lista trate de continuar
        //con el fin de que realize el throw
        var smp = this.head;
        if (x<0){
            throw new IllegalArgumentException("No existen las posiciones negativas");
        }
        if (x == 0) {
            return smp.getData();
        }
        if (x<=this.large/2) {
            System.out.println("I'm Head");
            while (this.actualpos < x) {
                if (this.actualpos <= this.large) {
                    if (smp.next != null) {
                        smp = smp.next;
                        this.actualpos += 1;
                    } else {
                        throw new IllegalArgumentException("Posicion no existente en la lista");
                    }
                }
            }
        }
        else{
            System.out.println("I'm Tail");
            smp=this.tail;
            this.actualpos=this.large-1;
            while (this.actualpos>x){
                smp=smp.prev;
                this.actualpos-=1;
            }
        }
        return smp.getData();
    }
}
