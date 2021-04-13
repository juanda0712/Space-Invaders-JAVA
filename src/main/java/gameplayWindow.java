package main.java;

import javax.swing.*;
import java.awt.*;

public class gameplayWindow  {
    private JFrame frame;
    private ImageIcon backIcon;
    private JLabel myLabel;

    public gameplayWindow(){
        frame = new JFrame("Space Invaders"); // le da el nombre a la ventana
        backIcon = new ImageIcon(this.getClass().getResource("\\Media\\Background.png"));
        myLabel = new JLabel(backIcon);

        myLabel.setSize(1020, 720);//

        frame.setSize(1020, 720);//le da tamaño a la ventana
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);//la ventana aparece en el centro
        frame.setResizable(false);//no cambie de tamaño la ventana
        frame.setVisible(true);//que la ventana se vea
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(myLabel);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("\\Media\\Player.png")));


    }

}

