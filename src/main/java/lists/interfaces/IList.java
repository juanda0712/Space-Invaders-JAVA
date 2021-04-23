package main.java.lists.interfaces;

import main.java.invaders.interfaces.Invader;


/**
 * The Ilist interface defines all methods that use all types of lists
 *
 * @author Juan Rodriguez
 * @since 1.0
 */
public interface IList {
    /**
     * Set an Invader as the data of a node and add it to a list
     * @param data is the object to be added
     */
    void append(Invader data);

    /**
     * return the large of the list
     */
    int getLarge();

    /**
     * returns the data that a node has in the list
     * @param x is the position in the list
     */
    Invader ShowDataInPos(int x);

    /**
     * Delete all the nodes in the list
     */
    void DeleteAll();

    /**
     * remove a specific node from the list
     * @param pos is the position in the list
     */
    void Delete (int pos);

    /**
     * Sort the nodes on the list so
     * it goes from the smallest to
     * the bigger number found
     */
    void BubbleSort();

    /**
     * swap the positions of nodes in the list
     */
    void InterChange();

    /**
     * change the Data that has a node (the object it points to)
     */
    void ascention();
}
