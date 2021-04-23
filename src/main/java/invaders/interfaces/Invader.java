package main.java.invaders.interfaces;

import java.awt.*;
/**
 * The Invader interface provide three methods to return the image, invader life and name.
 *
 * The Invader interface provide an method to apply the damage to the invader.
 *
 * @author Juan Rodriguez
 * @since 1.0
 */
public interface Invader {
    /**
     * return the image to the invader
     */
    Image getImg();

    /**
     * return the life to the invader
     */
    int getLife();

    /**
     * Apply damange to the invader
     */
    void applyDamage();

    /**
     * return the name to the invader
     */
    String getName();
}