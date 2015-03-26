package vista;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelJuego extends JPanel{
    private int fallos;
        
    public PanelJuego(){
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.setBounds(6, 100, 359, 241);
        fallos = 0;
        setVisible(true);
        this.setBackground(Color.DARK_GRAY);
    }
        
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        
        switch (fallos){            //Determina que partes dibujar de acuertdo al numero de fallos
            case 7: dibujarBoca(g);
            case 6: dibujarOjos(g);
            case 5: dibujarPies(g);
            case 4: dibujarBrazos(g);
            case 3: dibujarTronco(g);
            case 2: dibujarCabeza(g);
            case 1: dibujarBase(g);
        }
    }
        
    public void dibujar(int fallos){
        this.fallos = fallos;
        this.repaint();
    }
        
    private void dibujarBase(Graphics g){
        g.drawRect(290, 230, 20, 5);    //base inferior horizontal
        g.drawLine(300, 230, 300, 20);  //vertical base
        g.drawLine(300, 20, 150, 20);   //superior horizontal
        g.drawLine(150, 20, 150, 50);   //superior vertical
    }
                
    private void dibujarCabeza(Graphics g){
        g.drawOval(130, 50, 40, 40);    //cabeza
    }        
        
    private void dibujarTronco(Graphics g){
        g.drawLine(150, 90, 150, 200);  //tronco
    }
        
    private void dibujarBrazos(Graphics g){
        g.drawLine(150, 105, 120, 120); //brazo izq
        g.drawLine(150, 105, 180, 120); //brazo der        
    }
        
    private void dibujarPies(Graphics g){
        g.drawLine(150, 200, 115, 220); //pie izq
        g.drawLine(150, 200, 185, 220); //pie der
    }
        
    private void dibujarOjos(Graphics g){
        g.fillOval(140, 63, 5, 5);      //ojo izq
        g.fillOval(155, 63, 5, 5);      //ojo der
    }
                
    private void dibujarBoca(Graphics g){
        g.drawArc(143, 78, 15, 10, 10, 180);    //boca
    }
}