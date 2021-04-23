package main.java.lists.implementations.list;

import main.java.invaders.interfaces.Invader;
import main.java.lists.interfaces.IList;
import main.java.lists.nodes.OneWayNode;

import java.util.Random;

/**
 * Clase que genera listas circulares
 *
 */
public class CircularList implements IList {
    int large=0;
    int actualpos;
    OneWayNode head=null;
    OneWayNode tail=null;

    public CircularList() {
        new OneWayNode(null);
    }

    @Override
    public void append(Invader data) {
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

    @Override
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
            return  (Invader) smp.getData();
        }
        while (this.actualpos < x) {
            smp = smp.next;
            this.actualpos += 1;
            }
        return (Invader) smp.getData();
    }
    @Override
    public void BubbleSort(){
        for (int i = 0; i < this.large-1; i++ ) {
            var currentNode = this.head;
            var prev=this.tail;
            var next = this.head.next;
            for (int j = 0; j < this.large - 1; j++) {
                if (currentNode.getData().getLife() > next.getData().getLife()) {
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

    @Override
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

    @Override
    public void DeleteAll() {
    }

    @Override
    public void InterChange() {
    }
    @Override
    public void ascention(){
        var i=1;
        var smp=this.head;
        var prev=this.tail;
        while (i!=0){
            if (smp.getData().getName()=="boss"){
                var smp2=smp.next;
                var prev2=smp;
                var h=Math.floor(Math.random()*10);
                while (h!=0){
                    prev2=prev2.next;
                    smp2=smp2.next;
                    h--;
                }
                if (smp2==smp){
                    prev2=prev2.next;
                    smp2=smp2.next;
                }
                var smp3=smp.next;
                var smp4=smp2.next;
                if (smp.next==smp2){
                    prev.next=smp2;
                    smp.next=smp4;
                    smp2.next=smp;
                }
                else if(smp2.next==smp){
                    prev2.next=smp;
                    smp.next=smp2;
                    smp2.next=smp3;
                }
                else if(this.large==3){
                    if (smp.next==smp2){
                        prev.next=smp2;
                        smp.next=smp2.next;
                        smp2.next=smp;
                    }
                    else if(smp2.next==smp){
                        prev2.next=smp;
                        smp2.next=prev2;
                        smp.next=smp2;
                    }
                }
                else {
                    prev.next=smp2;
                    smp2.next = smp3;
                    prev2.next = smp;
                    smp.next = smp4;
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
            prev=prev.next;
            smp=smp.next;
        }
    }
}
