package main.java.lists.nodes;

import main.java.invaders.interfaces.Invader;

/**
 * Clase que genera nodos
 * 
 */
public class OneWayNode {
    public Invader data;
    public OneWayNode next;

    public OneWayNode (Invader dato){
        this.data=dato;
        this.next=null;
    }

    public Invader getData () {
        return this.data;
    }

    public void setNull(){
        this.data=null;
    }
}
