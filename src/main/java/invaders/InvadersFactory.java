package main.java.invaders;

import main.java.invaders.implementations.Boss;
import main.java.invaders.implementations.Normal;
import main.java.invaders.interfaces.Invader;


/**
 * create a factory to create Invaders
 *
 *@author Juan Rodriguez
 *@since 1.0

 */
public class InvadersFactory {

    /**
     * create an Invader type
     *
     * @param typeInvader the type of the invader
     * @return an object of type Invader
     * @since 1.0
     */
    public Invader createInvader(String typeInvader){
        if(typeInvader.equalsIgnoreCase("NORMAL")){
            return new Normal();
        }else{
            return new Boss();
        }
    }
}
