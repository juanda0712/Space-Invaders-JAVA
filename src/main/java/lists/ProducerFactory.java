package main.java.lists;


import main.java.lists.factories.ListsFactory;
import main.java.lists.interfaces.AbstractFactory;

public class ProducerFactory {

    public static AbstractFactory createFactory(String factoryType){
        if(factoryType.equalsIgnoreCase("LISTS")){
            return new ListsFactory();
        }
        return null;
    }
}
