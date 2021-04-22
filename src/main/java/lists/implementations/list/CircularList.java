package main.java.lists.implementations.list;

import main.java.lists.interfaces.IList;
import main.java.lists.nodes.OneWayNode;

import java.util.Random;

public class CircularList implements IList {
    @Override
    public void pruebaFuncionamiento(){
        var i=0;
        var h=7;
        //while (i<h) {
          //  Random a = new Random();
            //this.append(a.nextInt(7));
            //i++;
        //}
        this.append(2);
        this.append(1);
        this.append(1);
        this.append(3);
        this.append(6);
        this.append(5);
        this.append(4);
        for (i=0;i<this.large;i++) {
            System.out.println(this.ShowDataInPos(i));
        }
        this.BubbleSort();
        System.out.println("------");
        for (i=0;i<this.large;i++) {
            System.out.println(this.ShowDataInPos(i));
        }
        System.out.println("---");
        System.out.println(this.getLarge());
        System.out.println("La lista circular funciona");
        this.Delete(6);
        for (i=0;i<this.large;i++) {
            System.out.println(this.ShowDataInPos(i));
        }
        System.out.println("--");
        System.out.println(this.getLarge());


    }

    int large=0;
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
        actualpos=0;
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
    public void BubbleSort(){
        for (int i = 0; i < this.large-1; i++ ) {
            var currentNode = this.head;
            var prev=this.tail;
            var next = this.head.next;
            for (int j = 0; j < this.large - 1; j++) {
                if ((int)currentNode.getData() >(int) next.getData()) {
                    var temp = currentNode;
                    if (currentNode==this.head){
                        prev.next=next;
                        this.head=next;
                        temp.next=next.next;
                        next.next=temp;
                    }
                    else if (next==this.tail){
                        prev.next=next;
                        this.tail=temp;
                        temp.next=next.next;
                        next.next=temp;
                    }
                    else {
                        prev.next = next;
                        temp.next = next.next;
                        next.next = temp;
                    }
                }
                prev=prev.next;
                currentNode = prev.next;
                next = currentNode.next;
            }
        }
    }

    //Esta funcion elimina a un enemigo en una posicion especifica;
    //Esta funcion elimina a un enemigo en una posicion especifica;
    public void Delete (int pos) {
        actualpos = 0;
        if (pos == 0) {
            this.tail.next = this.head.next;
            this.head = this.head.next;
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
                    this.large -= 1;
                }
                smp = smp.next;
                actualpos += 1;
            }
        }
    }
}
