package main.java.invaders.interfaces;

public interface Invader {
    int getPosX();
    int getPosY();
    void setPosX(int num);
    void setPosY();
    Object getImg();
    int getLife();
    void applyDamage();
    void prueba();

    String getName();
}
