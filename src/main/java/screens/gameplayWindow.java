package main.java.screens;

import main.java.lists.interfaces.IList;
import main.java.rows.factories.RowsFactory;
import main.java.rows.interfaces.IRow;

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
    Image imagenes;
    Timer timer;
    int SpeedX;
    double SpeedY = 2;
    int x = 200;
    double y = 30;
    int buff = 0;
    int base = 60;
    int n = 7;


    RowsFactory factory = new RowsFactory();


    gameplayWindow(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        background = new ImageIcon("Background.png").getImage();
        ship = new ImageIcon("Player.png").getImage();
        timer = new Timer(base - buff, this);
        timer.start();

        imagenes = lista.ShowDataInPos(0).getImg();

    }
    public void paint(Graphics g){

        super.paint(g);

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(background, 0, 0, null);
        var j = x;

        int ramdom = (int) ((Math.random() * 4) + 2);

        if(ramdom == 1){
            IRow row = factory.createaRow("basic");
            IList lista = row.crear();
        }



        for (int i = 0; i < lista.getLarge() ; i++) {
            while (j < 1020){
                g2D.drawImage(lista.ShowDataInPos(i).getImg(), j, (int)y, null);
                break;
            }
            j+=90;
        }
        j=0;

        int mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
        g2D.drawImage(ship, mouseX - 445, 550, null);
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
