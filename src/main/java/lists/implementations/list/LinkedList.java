package main.java.lists.implementations.list;

import main.java.lists.interfaces.IList;
import main.java.lists.nodes.OneWayNode;

public class LinkedList implements IList {
    @Override
    public void pruebaFuncionamiento(){
        this.append("Arroba");
        System.out.println(this.ShowDataInPos(0));
        System.out.println("La lista simple funciona");
    }
    int large;
    int actualpos;
    OneWayNode head=null;
    OneWayNode tail=null;

    public LinkedList() {
        new OneWayNode(null);
    }

    public void append(Object data) {
        this.large += 1;
        if (this.head == null) {
            this.head = new OneWayNode(data);
            this.tail=this.head;
        } else {
            var smp = this.tail;
            smp.next = new OneWayNode(data);
            this.tail=smp;
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
        if (x==this.large){
            return this.tail;
        }
        while (this.actualpos < x) {
            if (this.actualpos <= this.large) {
                if (smp.next != null) {
                    smp = smp.next;
                    this.actualpos += 1;
                }
                else {
                    throw new IllegalArgumentException("Posicion no existente en la lista");
                }
            }
        }
        return smp.getData();
    }
}
