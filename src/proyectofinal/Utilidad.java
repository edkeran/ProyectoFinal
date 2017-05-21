/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author edgar
 */
public class Utilidad {
    public static void Escribir(String dir,boolean caso,String datos) throws IOException{
          FileWriter escribir = null;
          PrintWriter pw=null;
         // File fichero;
          escribir= new FileWriter(dir,caso);
          pw= new PrintWriter(escribir);
          String vector[]= datos.split("\n");
            for (String string : vector) {
                pw.write(string+"\n");
            }
        
        if (escribir!=null){
            try {
                escribir.close();
            } catch (IOException ex) {
                 System.out.printf("ERROR");
            }
            }
    }
    public static String leerFichero(String dir) throws IOException{
            File archivo = null;
            FileReader fr= null;
            BufferedReader br= null;
            archivo = new File (dir);
            try{
                fr= new FileReader(archivo);
                br= new BufferedReader(fr);
                StringBuilder aux= new StringBuilder();
                String linea;
                while ((linea=br.readLine())!=null){
                    aux.append(linea+"\n");
                }    
                return aux.toString();
            }catch(Exception aed){
                return "";
            }
    }
}
