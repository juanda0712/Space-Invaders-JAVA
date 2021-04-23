package main.java.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class gameplayWindow extends JPanel implements ActionListener, MouseListener {

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
    double buff = 0.90;
    double normal = 500;
    private JFrame frame;
    int base = 60;
    int n = 7;


    RowsFactory factory = new RowsFactory();
    IRow row = factory.createaRow("basic");
    IList lista = row.crear();

    gameplayWindow(JFrame frame){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        background = new ImageIcon("Background.png").getImage();
        minion1 = new ImageIcon("Minion.png").getImage();
        minion2 = new ImageIcon("Minion.png").getImage();
        minion3 = new ImageIcon("Minion.png").getImage();
        minion4 = new ImageIcon("Minion.png").getImage();
        minion5 = new ImageIcon("Minion.png").getImage();
        ship = new ImageIcon("Player.png").getImage();
        timer = new Timer((int)normal, this);
        timer.start();
        this.frame = frame;
        addMouseListener(this);

        imagenes = lista.ShowDataInPos(0).getImg();


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

        var j = x;

        int ramdom = (int) ((Math.random() * 4) + 2);


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
            frame.dispose();

        }
            y = y + SpeedY;
            repaint();


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JOptionPane.showMessageDialog(null, "Troleado");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
