package main.java.screens;

import main.java.lists.interfaces.IList;
import main.java.rows.factories.RowsFactory;
import main.java.rows.interfaces.IRow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class gameplayWindow extends JPanel implements ActionListener, MouseListener {

    final int PANEL_WIDTH = 1020;
    final int PANEL_HEIGHT = 720;
    Image ship;
    Image yuca;
    Image background;
    Timer timer;
    int SpeedX = 8;
    double SpeedY = 1.5;
    int x = 200;
    double y = 30;
    double y2 = 550;
    double buff = 0.90;
    double normal = 500;
    private JFrame frame;
    int base = 60;
    int n = 7;
    boolean a=false;
    IRow row;
    int mouseX;
    boolean shoot = false;
    private int cont = 0;

    IList lista;
    boolean kill=false;


    RowsFactory factory = new RowsFactory();

    Image imagenes;




    gameplayWindow(JFrame frame){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT)); // se crea el panel basado en las variables
        this.setBackground(Color.BLACK);// se define el color del fondo
        background = new ImageIcon("Background.png").getImage(); // se pone de fondo una imagen
        ship = new ImageIcon("Player.png").getImage();
        yuca = new ImageIcon("Yuca.png").getImage();
        timer = new Timer(60, this); // los fps del programa
        timer.start();
        this.frame = frame;
        addMouseListener(this);// funcionalidad del mouse



    }

    public void creador(){
        if(a==false){
            row = factory.createaRow("basic");
            a=true;
            lista= creal(row);
        }
    }
    public IList creal(IRow row){
        lista= row.crear();
        return lista;
    }

    void shootAction(Graphics2D g2D){
        g2D.drawImage(yuca, mouseX - 423, (int)y2, null);
    }

    public void paint(Graphics g) {

        super.paint(g);
        creador();
        if(lista.getLarge()==0){
            a=false;
            SpeedY+=0.25;
            y=30;
        }
        lista.BubbleSort();

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(background, 0, 0, null);// pinta en el panel el fondo

        var j = x;

        for (int i = 0; i < lista.getLarge(); i++) {
            while (j < 1020) {
                g2D.drawImage(lista.ShowDataInPos(i).getImg(), j, (int) y, null);
                //System.out.println( lista.ShowDataInPos(i).getLife());
                break;
            }
            j += 90;
        }
        j = 0;
        lista.InterChange();




        int mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
        if (mouseX > 1372) {
            mouseX = 1372;
        } else if (mouseX < 453) {
            mouseX = 453;
        }
        //g2D.drawImage(yuca, mouseX - 423, (int)y2, null);
        g2D.drawImage(ship, mouseX - 445, 550, null); // dibuja al jugador
        if(shoot == true){
            this.shootAction(g2D);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (y > 490) {
            JOptionPane.showMessageDialog(null, "GAME OVER!"); // muestra un mensaje cuando se termina el juego
            y = 490;
            SpeedY = 0;
            mainWindow v1 = new mainWindow();
            frame.dispose();//cierra la ventana

        }
        if(x >= PANEL_WIDTH - 650 || x < 0){
            SpeedX = SpeedX * -1; // evita que los minions colisionen con los bordes
        }
            x = x + SpeedX;// le da el movimiento diagonal a los minions
            y = y + SpeedY;//
            repaint(); // re inserta a los minions dando la persepcion de movimiento

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        shoot = true;
        JOptionPane.showMessageDialog(null, "Troleado");
        lista.ShowDataInPos(0).applyDamage();
        for (int i = 0; i < lista.getLarge(); i++) {
            if (lista.ShowDataInPos(i).getLife() == 0) {
                if (lista.ShowDataInPos(i).getName()=="Boss"){
                    lista.DeleteAll();
                }
                else {
                    lista.Delete(i);
                }
            }
        }
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

