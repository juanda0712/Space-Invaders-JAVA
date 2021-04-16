package main.java.spacecraft;

public class PlasmaBeam {
    private int posX;
    private int posY;
    private Object img;
    private boolean alive;

    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
    }
    public boolean getState(){
        return this.alive;
    }
    public Object getImg(){
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
