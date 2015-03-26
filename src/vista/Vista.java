package vista;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

/**
 *
 * @author Jordan
 * Prueba cambio 1
 */
public class Vista extends javax.swing.JFrame {

    /**
     * Creates new form Vista
     */
    private final JLabel etiquetaInstrucciones;
    
    public Vista() {
        initComponents();
        etiquetaInstrucciones = new JLabel("<html><body><p align=\"justify\">El juego consiste en descifrar la palabra<br>"
                + "oculta que se genera aleatoriamente.<br>Debe ingresar una letra por intento.<br>"
                + "Dispone de 7 fallos como máximo.</p></body></html>");
        this.setTitle("Juego: ahorcado");
        setVisible(true);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaPalabra = new javax.swing.JLabel();
        etiquetaPalabra.setVisible(false);
        entradaLetra = new javax.swing.JTextField();
        entradaLetra.setVisible(false);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        opcNuevoJuego = new javax.swing.JMenuItem();
        opcAjustes = new javax.swing.JMenuItem();
        opcInstrucciones = new javax.swing.JMenuItem();
        opcSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(380, 400));
        setPreferredSize(new java.awt.Dimension(380, 400));
        setResizable(false);

        etiquetaPalabra.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        etiquetaPalabra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaPalabra.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMenu1.setText("Menú principal");

        opcNuevoJuego.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK));
        opcNuevoJuego.setText("Nuevo juego");
        opcNuevoJuego.setToolTipText("Inicia una nueva partida");
        jMenu1.add(opcNuevoJuego);

        opcAjustes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        opcAjustes.setText("Ajustes...");
        opcAjustes.setToolTipText("Ajusta las palabras del juego.");
        jMenu1.add(opcAjustes);

        opcInstrucciones.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.ALT_MASK));
        opcInstrucciones.setText("Instrucciones del juego");
        opcInstrucciones.setToolTipText("Muestra las instrucciones del juego");
        jMenu1.add(opcInstrucciones);

        opcSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        opcSalir.setText("Salir");
        opcSalir.setToolTipText("Finaliza el programa");
        jMenu1.add(opcSalir);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(entradaLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(etiquetaPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(etiquetaPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entradaLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(285, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JMenuItem getOpcAjustes(){
        return opcAjustes;
    }
   
    public JMenuItem getOpcInstrucciones(){
        return opcInstrucciones;
    }
    
    public JMenuItem getOpcNuevoJuego(){
        return opcNuevoJuego;
    }
    
    public JMenuItem getOpcSalir(){
        return opcSalir;
    }
            
    public JLabel getEtiquetaPalabra() {
        return etiquetaPalabra;
    }
    
    public JTextField getEntradaLetra() {
        return entradaLetra;
    }
    
    public JLabel getEtiquetaInstrucciones(){
        return etiquetaInstrucciones;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField entradaLetra;
    private javax.swing.JLabel etiquetaPalabra;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem opcAjustes;
    private javax.swing.JMenuItem opcInstrucciones;
    private javax.swing.JMenuItem opcNuevoJuego;
    private javax.swing.JMenuItem opcSalir;
    // End of variables declaration//GEN-END:variables
}
