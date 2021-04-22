package main.java.screens;

import javax.swing.*;
import java.awt.*;


public class mainGameplayWindow extends JFrame {


    gameplayWindow window;

    public mainGameplayWindow() {

        window = new gameplayWindow();

        setSize(1020, 720);//le da tamaño a la ventana
        setLocationRelativeTo(null);//la ventana aparece en el centro
        setResizable(false);//no cambie de tamaño la ventana
        setVisible(true);//que la ventana se vea
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("\\Media\\Player.png")));
        add(window);
        setTitle("Space Invaders");
    }
}

