package main.java.lists.implementations.list;

import main.java.lists.interfaces.IList;
import main.java.lists.nodes.OneWayNode;

public class LinkedList implements IList {
    @Override
    public void pruebaFuncionamiento(){
        this.append(15);
        this.append(15);
        this.append(5);
        this.append(8);
        System.out.println(this.ShowDataInPos(0));
        System.out.println(getLarge());
        System.out.println("La lista simple funciona");
        System.out.println(ShowDataInPos(2));
        this.Delete(2);
        System.out.println(ShowDataInPos(2));
        System.out.println(this.getLarge());
        this.DeleteAll();
        System.out.println(getLarge());
        System.out.println(ShowDataInPos(9));
    }
    int large;
    int actualpos;
    OneWayNode head=null;
    OneWayNode tail=null;

    public LinkedList() {
        new OneWayNode(null);
    }

    public void append(Object data) {
        this.large += 1;
        if (this.head == null) {
            this.head = new OneWayNode(data);
            this.tail=this.head;
        } else {
            var smp = this.tail;
            smp.next = new OneWayNode(data);
            this.tail=smp.next;
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
        if (x==this.large){
            return this.tail;
        }
        while (this.actualpos < x & this.actualpos<this.large) {
            if (this.actualpos <= this.large) {
                if (smp.next != null) {
                    smp = smp.next;
                    this.actualpos += 1;
                }
            }
        }
        return smp.getData();
    }

    public void DeleteAll(){
        var smp=this.head;
        var smp2=smp;
        while (this.tail!=null){
            if(smp==this.tail){
                smp.next=null;
                smp.setNull();
                this.large-=1;
                break;
            }
            smp2=smp.next;
            smp.next=null;
            smp.setNull();
            smp=smp2;
            this.large-=1;
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
