package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

/**
 *
 * @author Jordan
 */
public class Controlador  implements ActionListener {
    private Vista vista;
    private PanelJuego panelJuego;
    private Ajustes ajustes;
    private Ahorcado ahorcado;
    
    public Controlador(Vista vista){
        this.vista = vista;
        ajustes = new Ajustes(this.vista, true);
        iniciar();
    }
    
    private void iniciar() {
        vista.getOpcNuevoJuego().addActionListener(this);
        vista.getOpcAjustes().addActionListener(this);
        vista.getOpcInstrucciones().addActionListener(this);
        vista.getOpcSalir().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource().equals(vista.getOpcNuevoJuego())) {  //Si selecciono opcion nuevo juego
            if (ajustes.existeArchivo()){           //Si el archivo de palabras existe
                if (panelJuego != null){            //Si hay una instancia de panelJuego
                    vista.remove(panelJuego);       //la quita de la vista
                    panelJuego = null;              //y la marca como null
                }
                if (ahorcado != null)               //Si hay una instancia de ahorcado
                    ahorcado = null;                //La marca como null
                
                System.gc();                        //Llama al rec. de bas.
                vista.revalidate();                 //Revalida el layout
                vista.repaint();                    //Repinta
                panelJuego = new PanelJuego();      //Crea un nuevo panel del juego
                vista.add(panelJuego);              //lo agrega al jframe
                ahorcado = new Ahorcado(vista.getEtiquetaPalabra(), vista.getEntradaLetra(), panelJuego);
            }
            else
                JOptionPane.showMessageDialog(vista, "Debe crear el archivo con las palabras antes de iniciar el juego.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (evento.getSource().equals(vista.getOpcAjustes())) {     //Si selecciono opcion ajustes
            ajustes.ajustar();              //LLama funcion ajustar de la clase Ajustes
            return;
        }
        if (evento.getSource().equals(vista.getOpcInstrucciones())) {   //Si selecciono opcion instrucciones
            JOptionPane.showMessageDialog(panelJuego, vista.getEtiquetaInstrucciones(), "Instrucciones del "
                    + "juego.", JOptionPane.INFORMATION_MESSAGE);       //Despliega instrucciones
            return;
        }
        
        if (evento.getSource().equals(vista.getOpcSalir()))         //Si selecciono opcion salir
            System.exit(0);                                     //Finaliza el programa
        
    }
}
