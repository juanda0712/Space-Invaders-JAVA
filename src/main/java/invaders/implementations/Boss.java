package main.java.invaders.implementations;

import main.java.invaders.interfaces.Invader;

public class Boss implements Invader {
    private int posX;
    private int posY;
    private double life = ((Math.random() * 4) + 2);

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
//    @Override
//    public Object getImg(){
//
//    }
    @Override
    public int getLife(){
        return (int)this.life;
    }
    @Override
    public void applyDamage(){
        this.life -= 1;
    }
}
