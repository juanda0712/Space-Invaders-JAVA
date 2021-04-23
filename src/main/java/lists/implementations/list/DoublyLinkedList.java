package main.java.lists.implementations.list;

import main.java.invaders.interfaces.Invader;
import main.java.lists.interfaces.IList;
import main.java.lists.nodes.TwoWaysNode;

public class DoublyLinkedList implements IList {
    @Override
    public void pruebaFuncionamiento(){
        System.out.println(ShowDataInPos(2));

        this.Delete(2);
        System.out.println(ShowDataInPos(2));
        this.InterChange();
        System.out.println("La lista doblemente enlazada funciona");
    }

    int large;
    int actualpos;
    TwoWaysNode head=null;
    TwoWaysNode tail=null;

    public DoublyLinkedList() {
        new TwoWaysNode(null);
    }

    public void append(Invader data) {
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

    @Override
    public Invader ShowDataInPos(int x) {
        actualpos=0;
        var smp = this.head;
        if (x<0){
            throw new IllegalArgumentException("No existen las posiciones negativas");
        }
        if (x == 0) {
            return (Invader) smp.getData();
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
        return (Invader) smp.getData();
    }

    @Override
    public void InterChange(){
        var i=0;
        var smp= this.head;
        while(i==0){
            if (smp.getData().getName()=="boss"){
                while(smp.getData().getLife()!=0){

                    while (smp.next!=null){
                        var smp2=smp.prev;
                        var smp3=smp.next;
                        if (smp.prev==null){
                            smp3.prev=smp2;
                            smp.next=smp.next.next;
                            smp.prev=smp3;
                            smp.next.prev=smp;
                            smp3.next=smp;
                        }
                        else {
                            smp2.next = smp3;
                            smp3.prev = smp2;
                            smp.next = smp.next.next;
                            smp.prev = smp3;
                            if (smp.next!=null) {
                                smp.next.prev = smp;
                                smp3.next = smp;
                            }
                        }
                        }
                    while (smp.prev!=null){
                        var smp2=smp.prev;
                        var smp3=smp.next;
                        if (smp.next==null){
                            smp2.next=smp3;
                            smp.prev=smp2.prev;
                            smp.next=smp2;
                            smp2.prev=smp;
                            smp.prev.next=smp;
                        }
                        else {
                            smp2.next = smp3;
                            smp3.prev = smp2;
                            smp.prev = smp.prev.prev;
                            smp.next = smp2;
                            if(smp.prev!=null) {
                                smp.prev.next = smp;
                                smp.prev.next = smp;
                            }
                        }
                    }

                }
            }
            i++;
            smp=smp.next;

        }
        while (this.large!=0){
            Delete(0);
        }
    }
    @Override
    public void Delete (int pos){
        actualpos=0;
        if(this.large==1){
            this.head=null;
            this.large--;
        }
        else if (pos==0){
            this.head=this.head.next;
            this.head.prev=null;
            this.large-=1;
        }
        else {
        var smp=this.head;
        while(actualpos<=pos) {
            if (actualpos + 1 == pos) {
                smp.next = smp.next.next;
                smp = smp.next;
                smp.prev = smp.prev.prev;
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
    public void ascention(){}

}
