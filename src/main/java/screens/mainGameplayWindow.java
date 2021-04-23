package main.java.screens;

import javax.swing.*;
import java.awt.*;


public class mainGameplayWindow extends JFrame {

    private JFrame frame;
    gameplayWindow window;

    public mainGameplayWindow() {

        frame =  new JFrame("Space Invaders");
        window = new gameplayWindow(frame);

        frame.setSize(1020, 720);//le da tamaño a la ventana
        frame.setLocationRelativeTo(null);//la ventana aparece en el centro
        frame.setResizable(false);//no cambie de tamaño la ventana
        frame.setVisible(true);//que la ventana se vea
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("\\Media\\Player.png")));
        frame.add(window);
    }
}

