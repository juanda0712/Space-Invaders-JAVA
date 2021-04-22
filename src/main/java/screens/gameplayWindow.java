package main.java.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameplayWindow extends JPanel implements ActionListener{

    final int PANEL_WIDTH = 1020;
    final int PANEL_HEIGHT = 720;
    Image minion1;
    Image minion2;
    Image minion3;
    Image minion4;
    Image minion5;
    Image ship;
    Image background;
    Timer timer;
    int SpeedX;
    double SpeedY = 10;
    int x = 290;
    double y = 30;
    int buff = 0;
    int base = 250;

    gameplayWindow(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        background = new ImageIcon("Background.png").getImage();
        minion1 = new ImageIcon("Minion.png").getImage();
        minion2 = new ImageIcon("Minion.png").getImage();
        minion3 = new ImageIcon("Minion.png").getImage();
        minion4 = new ImageIcon("Minion.png").getImage();
        minion5 = new ImageIcon("Minion.png").getImage();
        ship = new ImageIcon("Player.png").getImage();
        timer = new Timer(base - buff, this);
        timer.start();
    }
    public void paint(Graphics g){

        super.paint(g);

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(background, 0, 0, null);

        g2D.drawImage(minion1, x, (int)y, null);
        g2D.drawImage(minion2, x + 90, (int)y, null);
        g2D.drawImage(minion3, x + 180, (int)y, null);
        g2D.drawImage(minion4, x + 270, (int)y, null);
        g2D.drawImage(minion5, x + 360, (int)y, null);
        g2D.drawImage(ship, 470, 550, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (y > 490) {
            JOptionPane.showMessageDialog(null, "GAME OVER!");
            y = 490;
            SpeedY = 0;
            mainWindow v1 = new mainWindow();

        }
            y = y + SpeedY;
            repaint();


    }
}
