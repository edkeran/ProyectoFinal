/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author edgar
 */
public class DialogoIngreso extends JDialog implements ActionListener{
    private JLabel clave;
    private JTextField cajaClave;
    private JLabel usuario;
    private JTextField user;
    private JButton aceptar;
    private ventanaPrincipal aux;
    public DialogoIngreso(ventanaPrincipal ayu) {
        aux=ayu;
        setSize(200,150);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        aceptar= new JButton("Aceptar");
        clave= new JLabel("INGRESE SU CLAVE*");
        usuario= new JLabel("INGRESE SU USUARIO*");
        aceptar.addActionListener(this);
        cajaClave= new JTextField();
        user= new JTextField();
        usuario.setBounds(0, 5, 200, 20);
        user.setBounds(0, 25, 150, 20);
        clave.setBounds(0, 50, 150, 20);
        cajaClave.setBounds(0, 70, 150, 20);
        aceptar.setBounds(0, 120, 150, 20);
        add(usuario);
        add(user);
        add(clave);
        add(cajaClave);
        add(aceptar);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((user.getText().equals(""))||(cajaClave.getText().equals(""))){
            if (user.getText().equals("")){
            usuario.setForeground(Color.red);
            }else{
                usuario.setForeground(Color.black);
            }
            if (cajaClave.getText().equals("")){
                clave.setForeground(Color.red);
            }else{
                clave.setForeground(Color.black);
            }
        } else{
            usuario.setForeground(Color.black);
            clave.setForeground(Color.black);
            String key,user1;
            user1=user.getText().toString();
            key= cajaClave.getText().toString();
            System.out.println(user1);
            for (Jugador a : aux.players) {
                if (a.getNombre().equals(user1)){
                    System.out.println("EXISTE");
                    if (a.getClave().equals(key)){
                        System.out.println("ENTRO");
                        aux.cargarJuego(a);
                        dispose();
                    }
                }else{
                    System.out.println("NO EXISTE");
                }
            }
        }
        
    }
    
}
