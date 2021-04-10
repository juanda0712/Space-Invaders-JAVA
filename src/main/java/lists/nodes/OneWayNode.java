package main.java.lists.nodes;

public class OneWayNode {
    public Object data;
    public OneWayNode next;

    public OneWayNode (Object dato){
        this.data=dato;
        this.next=null;
    }

    public Object getData () {
        return this.data;
    }
}
