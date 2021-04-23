package main.java.invaders.implementations;

import main.java.invaders.interfaces.Invader;

import javax.swing.*;

public class Boss implements Invader {
    private int posX;
    private int posY;
    private double life = ((Math.random() * 4) + 2);
    private Object img = new ImageIcon(this.getClass().getResource("Media\\Minion.png"));
    private String name = "boss";

    @Override
    public int getPosX(){
        return this.posX;
    }
    @Override
    public int getPosY(){
        return this.posY;
    }
    @Override
    public void setPosX(int num){
        if (num == 0){
            this.posX -= 1;
        }else{
            this.posX += 1;
        }
    }
    @Override
    public void setPosY(){
        this.posY += 1 ;
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
