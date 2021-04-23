package main.java.spacecraft;

import javax.swing.*;
import java.awt.*;

public class PlasmaBeam {
    private int posX;
    private int posY;
    private Image img = new ImageIcon("Yuca.png").getImage();
    private boolean alive;

    PlasmaBeam(int posX,int posY){
        this.posX = posX;
        this.posY = posY;
    }
    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
    }
    public boolean getState(){
        return this.alive;
    }
    public Image getImg(){
        return this.img;
    }
    public void setPosX(int posX){
        this.posX = posX;
    }
    public void setPosY(int posY){
        this.posY = posY;
    }
    public void setState(boolean state){
        this.alive = state;
    }
}
