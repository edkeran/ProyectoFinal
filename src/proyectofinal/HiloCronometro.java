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
        try {
            while (end){
                sleep(1000);
                if (seg==59){
                    min++;
                    seg=0;
                }else seg++;
                if (min==59){
                    hor++;
                    min=0;
                    seg=0;
                }
                a.cronometro.setText(hor+":"+min+":"+seg);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloCronometro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void terminar(){
        end=false;
    }
    
}
