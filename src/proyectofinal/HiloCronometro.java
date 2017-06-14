/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edgar
 */
public class HiloCronometro extends Thread {
    NivelUno a;
    NivelDos b;
    NivelTres c;
    boolean end=true;
    
    public HiloCronometro(NivelUno ayu) {
        a=ayu;
    }

    public HiloCronometro(NivelDos ayu) {
        b=ayu;
    }

    public HiloCronometro(NivelTres ayu) {
        c=ayu;
    }

    @Override
    public void run() {
        super.run();
        int seg=0;
        int min=0;
        int hor=0;
        int seg1=0,min1=0,hor1=0;
        if (a!=null){
            seg=a.jugador.getSeg();
            min=a.jugador.getMin();
            hor=a.jugador.getHor();
        }
        if (b!=null){
            seg=b.jugador.getSeg();
            min=b.jugador.getMin();
            hor=b.jugador.getHor();
        }
        if (c!=null){
            seg=c.jugador.getSeg();
            min=c.jugador.getMin();
            hor=c.jugador.getHor();
        }
        try {
            while (end){
                sleep(1000);
                if (seg==59){
                    min++;
                    min1++;
                    seg1=0;
                    seg=0;
                }else {
                    seg++;
                    seg1++;
                }
                if (min==59){
                    hor++;
                    hor1++;
                    min=0;
                    min1=0;
                    seg1=0;
                    seg=0;
                }
                if (a!=null){
                    
                    if (seg<10){
                        if (min<10){
                             a.cronometro.setText(hor+":"+"0"+min+":"+"0"+seg);   
                        }
                        else{
                            a.cronometro.setText(hor+":"+min+":"+"0"+seg);
                        }
                    }else{
                        if (min<10){
                            a.cronometro.setText(hor+":"+"0"+min+":"+seg);  
                        }
                        else a.cronometro.setText(hor+":"+min+":"+seg);  
                    }
                    a.jugador.setHor(hor);
                    a.jugador.setSeg(seg);
                    a.jugador.setMin(min);
                    a.seg=seg1;
                    a.min=min1;
                    a.hor=hor1;
                }else if (b!=null){
                    if (seg<10){
                        if (min<10){
                             b.cronometroDos.setText(hor+":"+"0"+min+":"+"0"+seg);   
                        }
                        else{
                            b.cronometroDos.setText(hor+":"+min+":"+"0"+seg);
                        }
                    }else{
                        if (min<10){
                            b.cronometroDos.setText(hor+":"+"0"+min+":"+seg);  
                        }
                        else b.cronometroDos.setText(hor+":"+min+":"+seg);  
                    }
                    b.jugador.setHor(hor);
                    b.jugador.setSeg(seg);
                    b.jugador.setMin(min);
                    b.seg=seg1;
                    b.min=min1;
                    b.hor=hor1;
                }else if (c!=null){
                    if (seg<10){
                        if (min<10){
                             c.cronometroTres.setText(hor+":"+"0"+min+":"+"0"+seg);   
                        }
                        else{
                            c.cronometroTres.setText(hor+":"+min+":"+"0"+seg);
                        }
                    }else{
                        if (min<10){
                            c.cronometroTres.setText(hor+":"+"0"+min+":"+seg);  
                        }
                        else c.cronometroTres.setText(hor+":"+min+":"+seg);  
                    }
                    c.jugador.setHor(hor);
                    c.jugador.setSeg(seg);
                    c.jugador.setMin(min);
                    c.seg=seg1;
                    c.min=min1;
                    c.hor=hor1;
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloCronometro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void terminar(){
        end=false;
    }
    
}
