package main.java.lists.factories;

import main.java.lists.interfaces.AbstractFactory;
import main.java.lists.interfaces.IList;
import main.java.lists.interfaces.implementations.list.CircularList;
import main.java.lists.interfaces.implementations.list.DoublyLinkedCircularList;
import main.java.lists.interfaces.implementations.list.DoublyLinkedList;
import main.java.lists.interfaces.implementations.list.LinkedList;


public class ListsFactory implements AbstractFactory {

    @Override
    public IList createList(String typeList){
        if (typeList.equalsIgnoreCase("SIMPLE")){
            return new LinkedList();
        }else if (typeList.equalsIgnoreCase("CIRCULAR")){
            return new CircularList();
        }else if (typeList.equalsIgnoreCase("DOUBLE")){
            return new DoublyLinkedList();
        }else if(typeList.equalsIgnoreCase("DOUBLECIRUCLAR")){
            return new DoublyLinkedCircularList();
        }
        return null;
    }
}
