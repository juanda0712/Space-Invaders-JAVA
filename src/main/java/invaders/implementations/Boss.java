package main.java.invaders.implementations;

import main.java.invaders.interfaces.Invader;
import javax.swing.*;
import java.awt.*;


/**
 * Create a Boss-type Invader
 *
 *@author Juan Rodriguez
 *@since 1.0

 */
public class Boss implements Invader {
    private int posX;
    private int posY;
    private double life = (Math.random()*5+2);
    private Image img = new ImageIcon("Boss.png").getImage();
    private String name = "boss";

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
     * method that returns the name to the invader (boss)
     */
    @Override
    public String getName(){return this.name;}
}
