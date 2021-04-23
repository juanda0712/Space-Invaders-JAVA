package main.java.spacecraft;

public class Spacecraft {
    private int posX;
    private int posY;
    private Object img;

    public int getPosX(){
        return this.posX;
    }
    public int getPosY(){
        return this.posY;
    }
    public Object getImg(){
        return this.img;
    }
    public void setPosX(int posX){
        this.posX = posX;
    }
    public PlasmaBeam shoot(){
        return new PlasmaBeam();
    }
}
