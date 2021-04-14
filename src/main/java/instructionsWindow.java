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
    private JLabel text1;
    private JLabel text2;
    private JLabel text3;
    private ImageIcon ship;
    private JLabel label2;
    private ImageIcon minion;
    private JLabel label3;

    public instructionsWindow(){

        frame = new JFrame("Space Invaders"); // le da el nombre a la ventana
        backIcon = new ImageIcon(this.getClass().getResource("\\Media\\Background.png"));
        myLabel = new JLabel(backIcon);
        back = new JButton("Back");
        tittle = new JLabel("Instructions");
        text1 = new JLabel("Use the mouse to move the ship and click to shoot");
        text2 = new JLabel("Don't get touched or Game Over!");
        text3 = new JLabel("Be careful with the bosses");

        ship = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("\\Media\\Player.png")));
        label2 = new JLabel(backIcon);
        label3 = new JLabel(backIcon);
        minion = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("\\Media\\Minion.png")));

        tittle.setForeground(Color.GREEN);
        tittle.setFont(new Font("Arial", 3, 30));
        tittle.setBounds(410, 100, 1000, 50);

        text1.setForeground(Color.green);
        text1.setFont(new Font("Arial", 1,19));
        text1.setBounds(250, 200, 1000, 100);

        text2.setForeground(Color.green);
        text2.setFont(new Font("Arial", 1,19));
        text2.setBounds(250, 300, 1000, 100);

        text3.setForeground(Color.green);
        text3.setFont(new Font("Arial", 1,19));
        text3.setBounds(250, 400, 1000, 100);

        back.setBounds(20, 600, 120, 35);
        back.addActionListener(this);

        label2.setBounds(100, 400, 130, 130);
        myLabel.setBounds(100, 200, 128, 128);
        label3.setSize(1020, 720);
        myLabel.setIcon(ship);
        label2.setIcon(minion);
        label3.add(back);
        label3.add(tittle);
        label3.add(text1);
        label3.add(text2);
        label3.add(text3);

        frame.setSize(1020, 720);//le da tamaño a la ventana
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);//la ventana aparece en el centro
        frame.setResizable(false);//no cambie de tamaño la ventana
        frame.setVisible(true);//que la ventana se vea
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(myLabel);
        frame.add(label2);
        frame.add(label3);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("\\Media\\Player.png")));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        mainWindow v1 = new mainWindow();
    }
}
