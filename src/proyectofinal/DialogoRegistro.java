/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author edgar
 */
public class DialogoRegistro extends JDialog implements ActionListener{
    JTextField nickName;
    JLabel etiquetaN;
    JLabel etiquetaP;
    JLabel imagen;
    JTextField pasword;
    JButton ventanaFile;
    JButton guardar;
    String nombre;
    String clave;
    String foto="Imagenes/persona.png";
    ventanaPrincipal aux;
    public DialogoRegistro(ventanaPrincipal ayu) {
        aux=ayu;
        setSize(300,300);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        guardar= new JButton("GUARDAR");
        guardar.setActionCommand("SAVE");
        guardar.addActionListener(this);
        ventanaFile= new JButton("Cambiar Imagen");
        ventanaFile.setActionCommand("FILE");
        ventanaFile.addActionListener(this);
        etiquetaN= new JLabel("INGRESE SU NICKNAME");
        etiquetaP= new JLabel("INGRESE SU CONTRSEÑA");
        nickName= new JTextField();
        ImageIcon icon= new ImageIcon("Imagenes/persona.png");
        imagen= new JLabel();
        imagen.setIcon(new ImageIcon(icon.getImage().getScaledInstance(200,150,Image.SCALE_SMOOTH)));
        pasword= new JTextField();
        etiquetaN.setBounds(0, 5, 170, 20);
        nickName.setBounds(170, 5, 120, 20);
        etiquetaP.setBounds(0, 30, 170, 20);
        pasword.setBounds(170,30,120,20);
        imagen.setBounds(50, 70, 200, 150);
        ventanaFile.setBounds(65,240, 170, 20);
        guardar.setBounds(0, 280, 100, 20);
        add(etiquetaN);
        add(nickName);
        add(etiquetaP);
        add(pasword);
        add(imagen);
        add(ventanaFile);
        add(guardar);
        setVisible(true);
    }
    protected void actualizarImagen(String imagen){
        ImageIcon icon= new ImageIcon(imagen);
        foto=imagen;
        this.imagen.setIcon(new ImageIcon(icon.getImage().getScaledInstance(200,150,Image.SCALE_SMOOTH)));
        repaint();
    
    } 
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "FILE":
                DialogoArchivo archivo1= new DialogoArchivo(this);
                break;
            case "SAVE":
                if (pasword.getText().equals("")){
                    etiquetaP.setForeground(Color.red);
                } else{
                    etiquetaP.setForeground(Color.black);
                }
                if (nickName.getText().equals("")){
                    etiquetaN.setForeground(Color.red);
                } else{
                    etiquetaN.setForeground(Color.black);
                }
                if((!pasword.getText().equals(""))&&(!nickName.getText().equals(""))){
                String total;
                Jugador pla= new Jugador();
                etiquetaN.setForeground(Color.black);
                etiquetaP.setForeground(Color.black);
                nombre=nickName.getText().toString();
                pla.setNombre(nombre);
                clave= pasword.getText().toString();
                pla.setClave(clave);
                pla.setImagen(foto);
                total=nombre+";"+clave+";"+foto+";"+"1"+";"+"0"+";"+"0"+";"+"0"+";"+"0";
                aux.players.add(pla);
            try {
                Utilidad.Escribir("Fichero/Archivo.txt", true, total);
            } catch (IOException ex) {
                Logger.getLogger(DialogoRegistro.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
                }
                break;
        }
        
    }
    
}
