/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author edgar
 */
public class DialogoIngreso extends JDialog{
    private JLabel clave;
    private JTextField cajaClave;
    private JLabel usuario;
    private JTextField user;

    public DialogoIngreso() {
        setSize(200,150);
        clave= new JLabel("INGRESE SU CLAVE");
        usuario= new JLabel("INGRESE SU USUARIO");
        cajaClave= new JTextField();
        user= new JTextField();
        usuario.setBounds(0, 5, 100, 20);
        add(usuario);
        setVisible(true);
    }
    
}
