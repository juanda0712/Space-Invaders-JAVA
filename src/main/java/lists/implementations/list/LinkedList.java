package main.java.lists.implementations.list;

import main.java.invaders.interfaces.Invader;
import main.java.lists.interfaces.IList;
import main.java.lists.nodes.OneWayNode;

/**
 * @author Jordy
 * Class that generates a Simple linked List
 *
 */
public class LinkedList implements IList {

    int large;
    int actualpos = 0;
    OneWayNode head = null;
    OneWayNode tail = null;

    public LinkedList() {
        new OneWayNode(null);
    }

    /**
     * Set an Invader as the data of a node and add it to a list
     * @param data is the object to be added
     */
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

    /**
     * Show the large of the list
     * @return an int with the large of the list
     */
    @Override
    public int getLarge() {
        return this.large;
    }

    /**
     * Show the data in an especific node
     * @param x is the position in the list
     * @return the data of the node in position x
     */
    public Invader ShowDataInPos(int x) {
        actualpos = 0;
        var smp = this.head;
        if (smp == null) {

        } else if (x < 0) {
            throw new IllegalArgumentException("No existen las posiciones negativas");
        } else if (x == 0) {
            return (Invader) smp.getData();
        } else if (x == this.large) {
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
        if (smp != null) {
            return (Invader) smp.getData();
        } else {
            return null;
        }
    }

    /**
     * Delete all the nodes in the list
     */
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

    /**
     * Delete a node in an especific position
     * @param pos is the position in the list
     */
    //Esta funcion elimina a un enemigo en una posicion especifica;
    public void Delete(int pos) {
        actualpos=0;
        if (pos == 0) {
            this.head = this.head.next;
            this.large -= 1;
        }
        else {
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
