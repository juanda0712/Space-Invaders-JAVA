package main.java.lists.implementations.list;

import main.java.invaders.interfaces.Invader;
import main.java.lists.interfaces.IList;
import main.java.lists.nodes.TwoWaysNode;

public class DoublyLinkedCircularList implements IList {
    @Override
    public void pruebaFuncionamiento(){
        for (int i = 0; i < this.large; i++) {
            System.out.println(this.ShowDataInPos(i));
        }
        //this.Delete(3);
        System.out.println("----");
        this.ascention();
        for (int i = 0; i < this.large; i++) {
            System.out.println(this.ShowDataInPos(i));
        }
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
        actualpos=0;
        var smp = this.head;
        if (x<0){
            while (this.actualpos>x){
                smp=smp.prev;
                this.actualpos -= 1;
            }
            return (Invader) smp.getData();
        }
        if (x == 0) {
            return (Invader) smp.getData();
        }
        while (this.actualpos < x) {
            smp = smp.next;
            this.actualpos += 1;
        }
        return (Invader) smp.getData();
    }

    public void Delete (int pos) {
        actualpos = 0;
        if (pos == 0) {
            this.tail.next = this.head.next;
            this.head = this.head.next;
            this.head.prev=this.tail;
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

    @Override
    public void DeleteAll() {
    }

    @Override
    public void BubbleSort() {
    }

    @Override
    public void InterChange() {}

    @Override
    public void ascention(){
        var i=1;
        var smp=this.head;
        while (i!=0){
            if (smp.getData().getName()=="boss"){
                var smp2=smp.next;
                var h=Math.floor(Math.random()*10);
                while (h!=0){
                    smp2=smp2.next;
                    h--;
                }
                if (smp2==smp){
                    smp2=smp2.next;
                }
                var smp3=smp.prev;
                var smp4=smp.next;
                var smp5=smp2.prev;
                var smp6=smp2.next;
                if (smp.next==smp2){
                    smp3.next = smp2;
                    smp2.prev = smp3;
                    smp.next=smp6;
                    smp6.prev=smp;
                    smp.prev=smp2;
                    smp2.next=smp;
                }
                else if (smp.prev==smp2){
                    smp4.prev = smp2;
                    smp2.next = smp4;
                    smp.next=smp2;
                    smp5.next=smp;
                    smp.prev=smp5;
                    smp2.prev=smp;
                }
                else {
                    smp3.next = smp2;
                    smp2.prev = smp3;
                    smp4.prev = smp2;
                    smp2.next = smp4;
                    smp5.next = smp;
                    smp.prev = smp5;
                    smp6.prev = smp;
                    smp.next = smp6;
                }
                if (smp2==head){
                    this.head=smp;
                }
                else if(smp==head){
                    this.head=smp2;
                }
                else if (smp==tail){
                    this.tail=smp2;
                }
                else if (smp2==tail){
                    this.tail=smp;
                }
                i--;
            }
            smp=smp.next;
        }
    }
}

