package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import vista.PanelJuego;
/**
 *
 * @author Jordan
 */
public class Ahorcado {
    private JLabel etiquetaPalabra;
    private JTextField entradaLetra;
    private PanelJuego panelJuego;
    private char [] respuesta;
    private Scanner entrada;
    private List <String> lista;
    private ArrayList respuestaEtiqueta;
    private int aciertos;
    private int fallos;
    private Manejador manejador;
    private Set ingresadas;
        
    public Ahorcado(JLabel etiquetaPalabra, JTextField entradaLetra, PanelJuego panelJuego ) {
        if (manejador != null){     //Si hay una instancia de manejador
                manejador = null;   //la marca como null
                System.gc();        //Llama a rec. de bas.
        }
        
        ingresadas = new HashSet();             //Almacena las letras que el usuario ingresa, tanto correctas como incorrectas
        this.etiquetaPalabra = etiquetaPalabra; 
        this.entradaLetra = entradaLetra;       
        this.panelJuego = panelJuego;           
        this.etiquetaPalabra.setVisible(true);  
        this.entradaLetra.setVisible(true);     
        this.entradaLetra.requestFocus();       
        this.panelJuego.setVisible(true);       
        generarPalabra();                       //Genera la palabra
        aciertos = 0;
        fallos = 0;
    }
    
    private void generarPalabra() {
        try {
            lista = new ArrayList <>();         //Almacena palabras que contiene el archivo
            entrada = new Scanner(new File("Palabras.txt"));
            
            while (entrada.hasNext())           //Copia palabras del archivo a la lista
                lista.add(entrada.next());
            
            entrada.close();
            respuesta = (lista.get(new Random().nextInt(lista.size()))).toCharArray();  //Selecciona aleatoriamente una palabra de la lista
            respuestaEtiqueta = new ArrayList(){
            @Override
            public String toString() {                  //Sobreescribe toString para que no muestre comas ni corchetes
                StringBuilder cad = new StringBuilder();
                
                /*this.stream().forEach((caracter) -> { 
                    cad.append(caracter);               
                });*/                                   
                for (int i = 0; i < this.size(); i++)   
                    cad.append(this.get(i));            
                return cad.toString();
            }};
            //ArrayList con el texto que muestra la etiqueta
            respuestaEtiqueta.add("_");                 
    
            for (int i = 1; i < respuesta.length; i++){
                respuestaEtiqueta.add(" ");
                respuestaEtiqueta.add("_");
            }
            
            respuestaEtiqueta.add(".");
            etiquetaPalabra.setText(respuestaEtiqueta.toString());
            
            manejador = new Manejador();                //Evento del cuadro de entrada de texto
            entradaLetra.addActionListener( manejador );    
        }
        
        catch(FileNotFoundException error){
            System.err.println(error.getMessage());
        }
    } 

    private boolean revisarLetra(char letra){
        boolean acierto = false;                        //No hubo aciertos
        ingresadas.add(letra);                          //Agrega letra a lista de ingresadas
        
        for (int i = 0; i < respuesta.length; i++) {
            if (respuesta[i] == letra) {                //la letra se encuentra en la palabra
                respuestaEtiqueta.set(i*2, letra);      //Modifica la letra en el array de la etiqueta
                aciertos++;                             //Incrementa aciertos en 1
                etiquetaPalabra.setText(respuestaEtiqueta.toString());  //Modifica la letra en la etiqueta
                acierto = true;                         //Hubo un acierto
            }
        }
        
        return acierto;
    }
    
    private class Manejador implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!e.getSource().equals(entradaLetra))    //Si el evento no fue presionar enter en la caja de entrada de texto
                return;
            
            if (entradaLetra.getText().matches("^.*\\d.*$") || entradaLetra.getText().contains(" ") 
                    || entradaLetra.getText().length() > 1 || ("".equals(entradaLetra.getText()))) {  //Si ingreso mas de una letra, numeros o espacios
                JOptionPane.showMessageDialog(panelJuego.getParent(), "Sólo se permite una letra en este campo.", "Error", JOptionPane.ERROR_MESSAGE);
                entradaLetra.setText("");
                return;
            }
            
            if (!ingresadas.contains(entradaLetra.getText().charAt(0))) {   //Si no se habia ingresado la letra
                if (!revisarLetra(entradaLetra.getText().charAt(0))) {      //Si la letra no se encuentra en la respuesta
                    
                    fallos++;                                               //Incrementa fallos
                    panelJuego.dibujar(fallos);                             //Actualiza el panel del dibujo
                    
                }
            }
                                    
            if (aciertos == respuesta.length) {                             //Si ya se acetaron todas las letras
                JOptionPane.showMessageDialog(panelJuego.getParent(), "Ha ganado!", "", JOptionPane.INFORMATION_MESSAGE);
                entradaLetra.removeActionListener(manejador);
                entradaLetra.setVisible(false);
            }
            else if (fallos == 7){                                      //Si ya se fallo 7 veces
                entradaLetra.removeActionListener(manejador);    
                entradaLetra.setVisible(false);
                    StringBuilder cad = new StringBuilder();
                    for (char respuesta1: respuesta)
                        cad.append(respuesta1);
                    
                    etiquetaPalabra.setText(cad.toString());
                    JOptionPane.showMessageDialog(panelJuego.getParent(), "Ha perdido!", "", JOptionPane.INFORMATION_MESSAGE);
                    
            }
            entradaLetra.setText("");
        }
    }
}
