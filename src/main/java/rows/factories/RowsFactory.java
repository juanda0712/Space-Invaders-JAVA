package main.java.rows.factories;

import main.java.rows.implementations.rows.*;
import main.java.rows.interfaces.IRow;

/**
 * create a factory to create Rows
 *
 *@author Juan Rodriguez
 *@since 1.0

 */
public class RowsFactory {

    /**
     * create an row type
     *
     * @param typeRow the type of the invader
     * @return an object of type Invader
     * @since 1.0
     */
    public IRow createaRow(String typeRow){
        if (typeRow.equalsIgnoreCase("BASIC")){
            return new Basic();
        }else if(typeRow.equalsIgnoreCase("A")){
            return new TypeA();
        }else if(typeRow.equalsIgnoreCase("B")){
            return new TypeB();
        }else if(typeRow.equalsIgnoreCase("C")){
            return new TypeC();
        }else if(typeRow.equalsIgnoreCase("D")){
            return new TypeD();
        }else{
            return new TypeE();
        }
    }
}
