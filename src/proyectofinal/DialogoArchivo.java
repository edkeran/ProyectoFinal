/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Edgar Andres Krejci Bautista
 */
public class DialogoArchivo extends JDialog{
    JFileChooser escoger;
    File imagen;
    String direccion;
    FileNameExtensionFilter filtro= new FileNameExtensionFilter("JPG y PNG","jpg","png");
    public DialogoArchivo(DialogoRegistro aux) {
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        escoger= new JFileChooser();
        escoger.setAcceptAllFileFilterUsed(false);
        escoger.setFileFilter(filtro);
        escoger.showOpenDialog(null);
        add(escoger);
        setVisible(true);
        imagen=escoger.getSelectedFile();
        if (imagen!=null){
            direccion=imagen.toString();
            dispose();
            aux.actualizarImagen(direccion);
            
        }
        else{
        dispose();
        }
    }
    
    
}
