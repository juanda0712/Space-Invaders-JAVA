package main.java.invaders.interfaces;

import java.awt.*;

public interface Invader {
    int getPosX();
    int getPosY();
    void setPosX(int num);
    void setPosY();
    Image getImg();
    int getLife();
    void applyDamage();
    void prueba();

    String getName();
}
