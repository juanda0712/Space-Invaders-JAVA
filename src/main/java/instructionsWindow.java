package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class instructionsWindow implements ActionListener {
    private JFrame frame;
    private ImageIcon backIcon;
    private JLabel myLabel;
    private JButton back;
    private JLabel tittle;

    public instructionsWindow(){

        frame = new JFrame("Space Invaders"); // le da el nombre a la ventana
        backIcon = new ImageIcon(this.getClass().getResource("\\Media\\Background.png"));
        myLabel = new JLabel(backIcon);
        back = new JButton("Back");
        tittle = new JLabel("Instrucciones");

        tittle.setForeground(Color.GREEN);
        tittle.setFont(new Font("Arial", 3, 25));
        tittle.setBounds(410, 100, 200, 50);


        back.setBounds(20, 600, 120, 35);
        back.addActionListener(this);

        myLabel.setSize(1020, 720);//
        myLabel.add(back);
        myLabel.add(tittle);

        frame.setSize(1020, 720);//le da tamaño a la ventana
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);//la ventana aparece en el centro
        frame.setResizable(false);//no cambie de tamaño la ventana
        frame.setVisible(true);//que la ventana se vea
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(myLabel);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("\\Media\\Player.png")));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        mainWindow v1 = new mainWindow();
    }
}
