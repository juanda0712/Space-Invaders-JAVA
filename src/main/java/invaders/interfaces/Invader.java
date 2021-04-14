package main.java.invaders.interfaces;

public interface Invader {
    int getPosX();
    int getPosY();
    void setPosX(int posx);
    void setPosY(int posy);
//    Object getImg();
    int getLife();
    void applyDamage();

}
