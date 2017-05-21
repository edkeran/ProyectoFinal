/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
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
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "NEW":
                DialogoRegistro registro1 = new DialogoRegistro();
                break;
            case "OLD":
                DialogoIngreso ingreso1= new DialogoIngreso();
                break;
        }
    }
}
