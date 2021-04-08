package main.java;

import main.java.lists.ProducerFactory;
import main.java.lists.interfaces.AbstractFactory;
import main.java.lists.interfaces.IList;

public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = ProducerFactory.createFactory("LISTS");

        IList linked = factory.createList("SIMPLE");
        linked.pruebaFuncionamiento();

    }
}
