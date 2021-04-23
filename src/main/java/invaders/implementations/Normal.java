package main.java.invaders.implementations;

import main.java.invaders.interfaces.Invader;

import javax.swing.*;
import java.awt.*;

/**
 * Create a Normal-type Invader
 *
 *@author Juan Rodriguez
 *@since 1.0

 */
public class Normal implements Invader {

    private int posX;
    private int posY;
    private int life = 1;
    private Image img = new ImageIcon("Minion.png").getImage();
    private String name="minion";

    /**
     * method that returns the image to the invader
     */
    @Override
    public Image getImg(){
        return this.img;
    }

    /**
     * method that returns the life to the invader
     */
    @Override
    public int getLife(){
        return (int)this.life;
    }

    /**
     * method that aplly the damage to the invader
     */
    @Override
    public void applyDamage(){
        this.life -= 1;
    }

    /**
     * method that returns the name to the invader (minion)
     */
    @Override
    public String getName(){return this.name;}
}
