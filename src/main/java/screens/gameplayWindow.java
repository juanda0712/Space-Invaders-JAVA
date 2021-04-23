package main.java.screens;

import main.java.lists.interfaces.IList;
import main.java.rows.factories.RowsFactory;
import main.java.rows.interfaces.IRow;
import main.java.spacecraft.PlasmaBeam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

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
    double y2 = 600;
    double buff = 0.90;
    double normal = 500;
    private JFrame frame;
    int base = 60;
    int n = 7;
    boolean a=false;
    IRow row;
    int mouseX;
    private int cont = 0;
    int posx;
    PlasmaBeam plasma;
    IList lista;
    boolean kill=false;
    RowsFactory factory = new RowsFactory();
    Image imagenes;
    PlasmaBeam disparo = new PlasmaBeam(400,400);
    List<PlasmaBeam> listaDisparos = new ArrayList<PlasmaBeam>();


    gameplayWindow(JFrame frame){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT)); // se crea el panel basado en las variables
        this.setBackground(Color.BLACK);// se define el color del fondo
        background = new ImageIcon("Background.png").getImage(); // se pone de fondo una imagen
        ship = new ImageIcon("Player.png").getImage();
        yuca = new ImageIcon("Yuca.png").getImage();
        timer = new Timer(60, this); // los fps del programa
        timer.start();;
        this.frame = frame;
        addMouseListener(this);// funcionalidad del mouse



    }

    public void creador(int rowGenerador){
        if(a==false){
            if(rowGenerador==1){
                row = factory.createaRow("basic");
                a=true;
                lista= creal(row);
            }else if(rowGenerador==2){
                row = factory.createaRow("d");
                a=true;
                lista= creal(row);
            }else{
                row = factory.createaRow("a");
                a=true;
                lista= creal(row);
            }
        }

    }
    public IList creal(IRow row){
        lista= row.crear();
        return lista;
    }


    public void paint(Graphics g) {

        super.paint(g);
        creador((int)(Math.random()*3+1));
        if(lista.getLarge()==0){
            a=false;
            SpeedY+=0.25;
            y=30;
        }
        lista.BubbleSort();

        String strp = String.valueOf(cont);

        Graphics2D g2D = (Graphics2D) g;
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Arial", 1, 25));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g2D.drawImage(background, 0, 0, null);// pinta en el panel el fondo
        g.drawString("Puntaje", PANEL_WIDTH - metrics.stringWidth("Puntaje")-50, 50);
        g.drawString(strp, PANEL_WIDTH - metrics.stringWidth(strp)-90, 90);



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




        mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();

        mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();

        if (mouseX > 1372) {
            mouseX = 1372;
        } else if (mouseX < 453) {
            mouseX = 453;
        }
        g2D.drawImage(ship, mouseX - 445, 550, null); // dibuja al jugador

        if (!listaDisparos.isEmpty()){
            for (int i = 0; i < listaDisparos.size(); i++) {
                g2D.drawImage(listaDisparos.get(i).getImg(), listaDisparos.get(i).getPosX(), listaDisparos.get(i).getPosY(), null);
                listaDisparos.get(i).setPosY();
            }
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

            y2=y2-2;

            y2+=2;
            repaint(); // re inserta a los minions dando la persepcion de movimiento

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        listaDisparos.add(new PlasmaBeam(mouseX-445,550));

        lista.ShowDataInPos(0).applyDamage();
        for (int i = 0; i < lista.getLarge(); i++) {
            if (lista.ShowDataInPos(i).getLife() == 0) {
                if (lista.ShowDataInPos(i).getName()=="Boss"){
                    lista.DeleteAll();
                    cont += 5;
                }
                else {
                    lista.Delete(i);
                    cont += 1;
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

