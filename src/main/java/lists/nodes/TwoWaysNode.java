package main.java.lists.nodes;

public class TwoWaysNode {
    public Object data;
    public TwoWaysNode next;
    public TwoWaysNode prev;

    public TwoWaysNode (Object dato){
        this.data=dato;
        this.next=null;
        this.prev=null;
    }

    public Object getData (){
        return this.data;
    }
}
