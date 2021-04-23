package main.java.invaders.implementations;

import main.java.invaders.interfaces.Invader;

import javax.swing.*;

public class Normal implements Invader {

    private int posX;
    private int posY;
    private int life = 1;
    private Object img = new ImageIcon(this.getClass().getResource("Media\\Minion.png"));

    @Override
    public int getPosX(){
        return this.posX;
    }
    @Override
    public int getPosY(){
        return this.posY;
    }
    @Override
    public void setPosX(int posX){
        this.posX = posX;
    }
    @Override
    public void setPosY(int posY){
        this.posY = posY;
    }
    @Override
    public Object getImg(){
        return this.img;
    }
    @Override
    public int getLife(){
        return (int)this.life;
    }
    @Override
    public void applyDamage(){
        this.life -= 1;
    }
    @Override
    public void prueba(){
        System.out.println("El invader esta dentro de la lista");
    }
}
