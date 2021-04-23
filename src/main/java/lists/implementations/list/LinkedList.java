package main.java.lists.implementations.list;

import main.java.invaders.interfaces.Invader;
import main.java.lists.interfaces.IList;
import main.java.lists.nodes.OneWayNode;

public class LinkedList implements IList {
    @Override
    public void pruebaFuncionamiento() {
        System.out.println(this.ShowDataInPos(0));
        System.out.println(getLarge());
        System.out.println("La lista simple funciona");
        System.out.println(ShowDataInPos(1));
        this.Delete(0);
        System.out.println(ShowDataInPos(1));
        System.out.println(this.getLarge());
        this.DeleteAll();
        System.out.println(getLarge());
        System.out.println(ShowDataInPos(9));
    }

    int large;
    int actualpos = 0;
    OneWayNode head = null;
    OneWayNode tail = null;

    public LinkedList() {
        new OneWayNode(null);
    }

    @Override
    public void append(Invader data) {
        this.large += 1;
        if (this.head == null) {
            this.head = new OneWayNode(data);
            this.tail = this.head;
        } else {
            var smp = this.tail;
            smp.next = new OneWayNode(data);
            this.tail = smp.next;
        }
    }

    @Override
    public int getLarge() {
        return this.large;
    }

    public Invader ShowDataInPos(int x) {
        actualpos = 0;
        var smp = this.head;
        if (x < 0) {
            throw new IllegalArgumentException("No existen las posiciones negativas");
        }
        if (x == 0) {
            return (Invader) smp.getData();
        }
        if (x == this.large) {
            return (Invader) this.tail;
        }
        while (this.actualpos < x & this.actualpos < this.large) {
            if (this.actualpos <= this.large) {
                if (smp.next != null) {
                    smp = smp.next;
                    this.actualpos += 1;
                }
            }
        }
        return (Invader) smp.getData();
    }

    public void DeleteAll() {
        var smp = this.head;
        var smp2 = smp;
        while (this.tail != null) {
            if (smp == this.tail) {
                smp.next = null;
                smp.setNull();
                this.large -= 1;
                break;
            }
            smp2 = smp.next;
            smp.next = null;
            smp.setNull();
            smp = smp2;
            this.large -= 1;
        }
    }

    //Esta funcion elimina a un enemigo en una posicion especifica;
    public void Delete(int pos) {
        if (pos == 0) {
            this.head = this.head.next;
            this.large -= 1;
        }
        var smp = this.head;
        while (actualpos <= pos) {
            if (actualpos == pos) {
                smp.next = smp.next.next;
                this.large -= 1;
            }
            smp = smp.next;
            actualpos += 1;
        }
    }

    @Override
    public void BubbleSort() {
    }

    @Override
    public void InterChange() {

    }

    @Override
    public void ascention() {
    }
}
