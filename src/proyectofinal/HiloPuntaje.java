/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

/**
 *
 * @author edgar
 */
public class HiloPuntaje extends Thread {
    boolean fin=true;
    int puntaje;
    Jugador player;
    NivelUno a=null;
    NivelDos b=null;
    NivelTres c=null;
    
    public HiloPuntaje(Jugador aux,NivelUno ayu) {
        player=aux;
        puntaje=player.getPuntaje();
        a=ayu;
    }
    public HiloPuntaje(Jugador aux,NivelDos ayu) {
        b=ayu;
        player=aux;
        puntaje=player.getPuntaje();
    }

    public HiloPuntaje(Jugador aux,NivelTres ayu) {
        c=ayu;
        player=aux;
        puntaje=player.getPuntaje();
    }
    
    @Override
    public void run() {
        while (fin){
           
        }
    }
    
    public int tiempo(){
         if (a!=null){
             if (a.min==0){
                 if (a.seg<45){
                     puntaje+=100;
                 }else puntaje+=50;
             }else puntaje+=25;
         }
         if (b!=null){
             if (b.min==0){
                 if (b.seg<59){
                     puntaje+=100;
                 }
             }else if (b.seg<30){
                 puntaje+=50;
            }else puntaje+=25;
         }
         if (c!=null){
             if (c.min<=1){
                 if (c.seg<=30){
                     puntaje+=100;
                 }else puntaje+=50;
             }else{
                 puntaje+=25;
             }
         }
         return puntaje;
    }
    
    public void terminar(){
        fin=false;
    }
    
    
}


