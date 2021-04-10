package main.java.rows.factories;

import main.java.rows.implementations.rows.*;
import main.java.rows.interfaces.IRow;

public class RowsFactory {

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
