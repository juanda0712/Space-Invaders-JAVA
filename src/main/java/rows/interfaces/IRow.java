package main.java.rows.interfaces;

import main.java.lists.interfaces.IList;


/**
 * The IRow interface defines the method that use all types of rows
 *
 * @author Juan Rodriguez
 * @since 1.0
 */
public interface IRow {

    /**
     * defines a list type and creates it
     * To the list that was created add the number of invaders needed
     */
    IList crear();
}
