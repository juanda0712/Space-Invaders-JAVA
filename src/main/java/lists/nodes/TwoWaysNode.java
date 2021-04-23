package main.java.lists.nodes;

import main.java.invaders.interfaces.Invader;

public class TwoWaysNode {
    public Invader data;
    public TwoWaysNode next;
    public TwoWaysNode prev;

    public TwoWaysNode (Invader dato){
        this.data=dato;
        this.next=null;
        this.prev=null;
    }

    public Invader getData (){
        return this.data;
    }
}
