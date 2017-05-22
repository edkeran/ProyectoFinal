/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author edgar
 */
public class ventanaPrincipal extends JFrame implements ActionListener{
    JButton botonIngreso;
    JButton botonRegistro;
    JLabel etiqueta;
    List <Jugador> players = new ArrayList <Jugador>();
    public ventanaPrincipal() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("VENTANA DE INICIO");
        setSize(600,600);
        etiqueta= new JLabel("BIENVENIDO ESCOGE UNA OPCION");
        setLayout(null);
        botonIngreso= new JButton("INGRESAR");
        botonIngreso.setActionCommand("OLD");
        botonIngreso.addActionListener(this);
        botonRegistro= new JButton("REGISTRARSE");
        botonRegistro.setActionCommand("NEW");
        botonRegistro.addActionListener(this);
        botonIngreso.setBounds(150, 400, 300, 40);
        botonRegistro.setBounds(150, 500, 300, 40);
        setLocationRelativeTo(null);
        add(botonIngreso);
        add(botonRegistro);
        cargarJugadores();
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "NEW":
                DialogoRegistro registro1 = new DialogoRegistro(this);
                break;
            case "OLD":
                DialogoIngreso ingreso1= new DialogoIngreso(this);
                break;
        }
    }
    //Metodo que añade a los jugadores a la lista
    public void cargarJugadores(){
        String datos,vector[];
        try {
            datos=Utilidad.leerFichero("Fichero/Archivo.txt");
            vector=datos.split("\n");
            for (int i=0;i<vector.length;i++){
                Jugador cargar= new Jugador();
                String ayu[];
                ayu= vector[i].split(";");
                cargar.setNombre(ayu[0]);
                cargar.setClave(ayu[1]);
                cargar.setImagen(ayu[2]);
                cargar.setNivel(Integer.parseInt(ayu[3]));
                cargar.setPuntaje(Integer.parseInt(ayu[4]));
                cargar.setHor(Integer.parseInt(ayu[5]));
                cargar.setMin(Integer.parseInt(ayu[6]));
                cargar.setSeg(Integer.parseInt(ayu[7]));
                players.add(cargar);
            }
        } catch (IOException ex) {
            System.err.println("Ha ocurrido un error inesperado");
        }
    }
    //Metodo que carga el juego de Acuerdo a el Nivel
    public void cargarJuego(Jugador a){
        NivelUno partida= new NivelUno();
        dispose();
    }
}
