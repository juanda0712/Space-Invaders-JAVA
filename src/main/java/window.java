package main.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class window implements ActionListener{

    private JFrame frame;
    private ImageIcon backIcon;
    private JLabel myLabel;
    private JButton startButton;
    private JButton instructionsButton;
    private JButton exitButton;
    private JLabel tittle;

    public window(){

        startButton = new JButton("Start");
        instructionsButton = new JButton("Instructions");
        exitButton = new JButton("Exit");
        backIcon = new ImageIcon(this.getClass().getResource("\\Media\\Background.png"));
        myLabel =new JLabel(backIcon);
        tittle = new JLabel("Space Invaders");

        tittle.setForeground(Color.YELLOW);
        tittle.setFont(new Font("Arial",3, 25));

        myLabel.setSize(1020, 720);//
        myLabel.add(startButton);              //Agrega los botones
        myLabel.add(instructionsButton);       //
        myLabel.add(exitButton);               //
        myLabel.add(tittle);

        startButton.setBounds(400, 240, 200, 50);
        instructionsButton.setBounds(400, 310, 200, 50);// Le da tamaño y posicion a los botones

        exitButton.setBounds(400, 380, 200, 50);
        exitButton.addActionListener(this);

        tittle.setBounds(410, 100, 200, 50);

        frame = new JFrame("Space Invaders"); // le da el nombre a la ventana
        frame.setSize(1020, 720);//le da tamaño a la ventana
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);//la ventana aparece en el centro
        frame.setResizable(false);//no cambie de tamaño la ventana
        frame.setVisible(true);//que la ventana se vea
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.add(myLabel);
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("\\Media\\Icon.png")));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit the game", "Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }
}
