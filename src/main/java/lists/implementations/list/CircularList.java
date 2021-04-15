package main.java.lists.implementations.list;

import main.java.lists.interfaces.IList;
import main.java.lists.nodes.OneWayNode;

import java.util.Random;

public class CircularList implements IList {
    @Override
    public void pruebaFuncionamiento(){
        var i=0;
        var h=15;
        while (i<=h) {
            Random a = new Random();
            this.append(a.nextInt(35));
            i++;
        }
        System.out.println(this.ShowDataInPos(0));
        this.BubbleSort();
        System.out.println(this.ShowDataInPos(0));
        System.out.println(this.getLarge());
        System.out.println("La lista circular funciona");
        this.Delete(2);
        System.out.println(this.ShowDataInPos(1));
        System.out.println(this.getLarge());


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
    public void BubbleSort(){
        var smp=this.head;
        var smp2=smp;
        while(smp.next!=this.head){
            if ((int) smp.getData()> (int)smp.next.getData()){
                if (smp==this.head){
                    smp2=smp.next;
                    this.head=smp2;
                    smp.next=smp2.next;
                    smp2.next=smp;
                }
                smp2=smp.next;
                smp.next=smp2.next;
                smp2.next=smp;
            }

            smp=smp.next;
        }
    }

    //Esta funcion elimina a un enemigo en una posicion especifica;
    public void Delete (int pos){
        var smp=this.head;
        while(actualpos!=pos){
            if (actualpos+1==pos){
                smp.next=smp.next.next;
                this.large-=1;
                break;
            }
            smp=smp.next;
            actualpos+=1;
        }
    }
}
