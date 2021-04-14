package main.java.invaders;

import main.java.invaders.implementations.Boss;
import main.java.invaders.implementations.Normal;
import main.java.invaders.interfaces.Invader;

public class InvadersFactory {

    public Invader createInvader(String typeInvader){
        if(typeInvader.equalsIgnoreCase("NORMAL")){
            return new Normal();
        }else{
            return new Boss();
        }

    }
}
