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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author edgar
 */
public class NivelTres extends JFrame implements MouseListener,ActionListener {
    
    int seg,min,hor;
    boolean c1=false,c2=false,c3=false,c4=false,c5=false,c6=false,c7=false;
    JButton boton1;
    JButton boton2;
    JButton boton3;
    JButton guardar;
    Jugador jugador;
    String cabeza1,cabeza2,cabeza3,cabeza4,cabeza5,cabeza6,cabeza7,
           cabeza8,cabeza9,cabeza10,cabeza11,cabeza12,cabeza13,cabeza14;
    JButton auxTres;
    JLabel cronometroTres;
    JLabel labelCronTres;
    JLabel puntaje;
    JLabel etiquPunt;
    JLabel imagen;
    HiloCronometro hiloCTres;
    int filasTres = 7;
    int columnasDos = 7;
    int contador = 0;
    int auxXTres = 200;
    int auxYTres = 100;
    int colorTres = 0;
    HiloPuntaje punt;
    private Map<String, JButton> mapaBotonTres;
    List <Jugador> players = new ArrayList <Jugador>();

    public NivelTres(Jugador a,List <Jugador> ayu) {
        etiquPunt= new JLabel("PUNTAJE");
        puntaje= new JLabel(""+a.getPuntaje());
        players=ayu;
        punt=new HiloPuntaje(a,this);
        guardar= new JButton("Guardar");
        guardar.addActionListener(this);
        guardar.setBounds(500, 370, 100, 20);
        imagen= new JLabel();
        ImageIcon icon= new ImageIcon(a.getImagen());
        imagen.setIcon(new ImageIcon(icon.getImage().getScaledInstance(200,150,Image.SCALE_SMOOTH)));
        cronometroTres = new JLabel("00:00:00");
        labelCronTres = new JLabel("CRONOMETRO");
        labelCronTres.setForeground(Color.DARK_GRAY);
        labelCronTres.setBounds(500, 80, 100, 20);
        jugador=a;
        cronometroTres.setBounds(500, 100, 100, 20);
        setSize(600,600);
        auxTres = new JButton("....");
        boton1=new JButton("....");
        boton1.setBackground(Color.white);
        boton1.setBounds(200, 80, 280, 20);
        boton1.addMouseListener(this);
        boton2= new JButton("....");
        boton2.setBackground(Color.white);
        boton2.setBounds(200, 380, 280, 20);
        boton2.addMouseListener(this);
        boton3= new JButton("....");
        boton3.setBackground(Color.white);
        boton3.setBounds(180, 80, 20, 320);
        boton3.addMouseListener(this);
        auxTres.setBackground(Color.white);
        auxTres.addMouseListener(this);
        auxTres.setBounds(480, 80, 20, 320);
        imagen.setBounds(0, 400, 200, 150);
        etiquPunt.setBounds(0, 50, 100, 20);
        puntaje.setBounds(0, 70, 100, 20);
        add(etiquPunt);
        add(puntaje);
        add(guardar);
        add(imagen);
        add(auxTres);
        add(boton1);
        add(boton2);
        add(boton3);
        add(cronometroTres);
        add(labelCronTres);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        mapaBotonTres = new HashMap<String, JButton>();
        for(int i = 0; i < filasTres; i++) {
            auxXTres = 200;    
            for(int j = 0; j < columnasDos; j++) {
                 JButton boton = new JButton("Boton " + contador);
                boton.setBounds(auxXTres, auxYTres, 40, 40);
                boton.setActionCommand("Boton " + contador);
                boton.setBackground(Color.BLACK);
                
                if(contador == 0){
                boton.setBackground(Color.red);
                cabeza1="Boton " + contador;
                }
                if(contador == 5){
                    boton.setBackground(Color.green);
                    cabeza2 ="Boton " + contador;
                }
                
                 if(contador == 6){
                   boton.setBackground(Color.pink);
                   cabeza3 ="Boton " + contador;
                }
                 
                 if(contador == 10){
                      boton.setBackground(Color.yellow);
                      cabeza4 ="Boton " + contador;
                 }
                 
                 if(contador == 11){
                      boton.setBackground(Color.pink);
                      cabeza5 ="Boton " + contador;
                 }
                 
                 if(contador == 17){
                      boton.setBackground(Color.cyan);
                      cabeza6 ="Boton " + contador;
                 }
                 
                 if(contador == 24){
                      boton.setBackground(Color.magenta);
                      cabeza7 ="Boton " + contador;
                 }
                 
                 if(contador == 32){
                      boton.setBackground(Color.yellow);
                      cabeza8 ="Boton " + contador;
                 }
                 
                 if(contador == 34){
                      boton.setBackground(Color.cyan);
                      cabeza9 ="Boton " + contador;
                 }
                 
                 if(contador == 37){
                      boton.setBackground(Color.green);
                     cabeza10 ="Boton " + contador;
                 } 
                 
                  if(contador == 38){
                      boton.setBackground(Color.blue);
                     cabeza11 ="Boton " + contador;
                 } 
                  
                   if(contador == 41){
                      boton.setBackground(Color.magenta);
                     cabeza12 ="Boton " + contador;
                 }
                   
                  if(contador == 45){
                      boton.setBackground(Color.red);
                     cabeza13 ="Boton " + contador;
                  }
                  
                  if(contador== 48){
                      boton.setBackground(Color.blue);
                     cabeza14 ="Boton " + contador;
                  }
                  
                 boton.addMouseListener(this);
                boton.addActionListener(this);
                mapaBotonTres.put("Boton " + contador, boton);
                add(boton);         
                auxXTres += 40;
                contador++;
            }
            auxYTres += 40;
    }
        hiloCTres = new HiloCronometro(this);
        hiloCTres.start();
        setVisible(true);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
         if (((JButton) e.getSource()).getBackground()==Color.red){
            colorTres=1;
        }
        if (((JButton) e.getSource()).getBackground()==Color.green){
            colorTres=2;
        }
        if (((JButton) e.getSource()).getBackground()==Color.pink){
            colorTres=3;
        }
        if (((JButton) e.getSource()).getBackground()==Color.yellow){
            colorTres=4;
        }
         if (((JButton) e.getSource()).getBackground()==Color.cyan){
            colorTres=5;
        }
          if (((JButton) e.getSource()).getBackground()==Color.magenta){
            colorTres = 6;
        }
          
          if (((JButton) e.getSource()).getBackground()==Color.blue){
            colorTres = 7;
        }
          
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
        JButton aux2=(JButton) e.getSource();
        if (validarNivel()==true){
            System.out.println("Termino el nivel");
            hiloCTres.terminar();
            jugador.setPuntaje(punt.tiempo());
            punt.terminar();
            jugador.setNivel(3);
            guardar();
            dispose();
            JOptionPane.showMessageDialog(null,"Haz Completado el Juego Felicitaciones ;)"+"\n Su puntaje final es de:"+jugador.getPuntaje());
        }
        
       if((aux2==mapaBotonTres.get(cabeza1))||(aux2==mapaBotonTres.get(cabeza2))
               ||(aux2==mapaBotonTres.get(cabeza3))||(aux2==mapaBotonTres.get(cabeza4))||
               (aux2==mapaBotonTres.get(cabeza5)||(aux2==mapaBotonTres.get(cabeza6))||(aux2==mapaBotonTres.get(cabeza7))
               ||(aux2==mapaBotonTres.get(cabeza8))||(aux2==mapaBotonTres.get(cabeza9))||
               (aux2==mapaBotonTres.get(cabeza10)) || (aux2==mapaBotonTres.get(cabeza11)) || 
               (aux2==mapaBotonTres.get(cabeza12)) || (aux2 == mapaBotonTres.get(cabeza13)) || (aux2 == mapaBotonTres.get(cabeza14)))){
           
               switch(colorTres){
                   
                   case 1:
                       if (aux2.getBackground()!=Color.red){
                       repintar(colorTres);
                       c1=false;
                   }else{
                       c1=true;
                   }
                       break;
                   case 2:
                       if (aux2.getBackground()!=Color.green){
                       repintar(colorTres);
                       c2=false;
                   }else{
                       c2=true;
                   }
                       break;
                   case 3:
                       if (aux2.getBackground()!=Color.pink){
                       repintar(colorTres);
                       c3=false;
                   }else{
                       c3=true;
                   }
                       break;
                   case 4:
                       if (aux2.getBackground()!=Color.yellow){
                       repintar(colorTres);
                       c4=false;
                   }else{
                       c4=true;
                   }
                       break;
                   case 5:
                       if (aux2.getBackground()!=Color.cyan){
                       repintar(colorTres);
                       c5=false;
                   }else{
                       c5=true;
                   }
                       break;
                   case 6:
                       if (aux2.getBackground()!=Color.magenta){
                       repintar(colorTres);
                       c6=false;
                        }else{
                       c6=true;
                   }
                       break;
                   case 7:
                       if (aux2.getBackground()!=Color.blue){
                       repintar(colorTres);
                       c7=false;
                       }else{
                       c7=true;
                   }
                       break;
        }
        colorTres =0;
       }
       
       if (((JButton) e.getSource()).getBackground()== Color.white){
                repintar(colorTres);
                if (colorTres==1){
                    c1=false;
                }
                if (colorTres==2){
                    c2=false;
                }
                if (colorTres==3){
                    c3=false;
                }
                if (colorTres==4){
                    c4=false;
                }
                if (colorTres==5){
                    c5=false;
                }
                if (colorTres==6){
                    c6=false;
                }
                if (colorTres==7){
                    c7=false;
                }
                colorTres=0;
                System.out.println("SALIO");  
    }
           else{
                if (colorTres==1){
                    if (((JButton) e.getSource()).getBackground()==Color.BLACK){
                    ((JButton) e.getSource()).setBackground(Color.red);
                }else{
                     quitarColor(((JButton) e.getSource()).getBackground());
                     ((JButton) e.getSource()).setBackground(Color.red);
                }
            }
            if (colorTres==2){
                if (((JButton) e.getSource()).getBackground()==Color.BLACK){
                    ((JButton) e.getSource()).setBackground(Color.green);
                }else{
                     quitarColor(((JButton) e.getSource()).getBackground());
                     ((JButton) e.getSource()).setBackground(Color.green);
                }
            }
            if (colorTres==3){
                if (((JButton) e.getSource()).getBackground()==Color.BLACK){
                    ((JButton) e.getSource()).setBackground(Color.pink);
                }else{
                     quitarColor(((JButton) e.getSource()).getBackground());
                     ((JButton) e.getSource()).setBackground(Color.pink);
                }
                ((JButton) e.getSource()).setBackground(Color.pink);
            }
            if (colorTres==4){
                if (((JButton) e.getSource()).getBackground()==Color.BLACK){
                    ((JButton) e.getSource()).setBackground(Color.yellow);
                }else{
                     quitarColor(((JButton) e.getSource()).getBackground());
                     ((JButton) e.getSource()).setBackground(Color.yellow);
                }
            }
            if (colorTres==5){
                if (((JButton) e.getSource()).getBackground()==Color.BLACK){
                    ((JButton) e.getSource()).setBackground(Color.cyan);
                }else{
                     quitarColor(((JButton) e.getSource()).getBackground());
                     ((JButton) e.getSource()).setBackground(Color.cyan);
                }
            }
            
             if (colorTres==6){
                 if (((JButton) e.getSource()).getBackground()==Color.BLACK){
                    ((JButton) e.getSource()).setBackground(Color.magenta);
                }else{
                     quitarColor(((JButton) e.getSource()).getBackground());
                     ((JButton) e.getSource()).setBackground(Color.magenta);
                }
            }
            if(colorTres == 7){
                if (((JButton) e.getSource()).getBackground()==Color.BLACK){
                    ((JButton) e.getSource()).setBackground(Color.blue);
                }else{
                     quitarColor(((JButton) e.getSource()).getBackground());
                     ((JButton) e.getSource()).setBackground(Color.blue);
                }
            }
        }
}

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.print("ENTRO EL SAVE");
        guardar();
    }
    
    private void repintar(int c){
        
        contador= 0;
         for (int i=1;i<=49;i++){
             
             if(c == 7){
                 if(mapaBotonTres.get("Boton " + contador).getBackground() == Color.BLUE){
                            mapaBotonTres.get("Boton " + contador).setBackground(Color.BLACK);
                            mapaBotonTres.get(cabeza11).setBackground(Color.blue);
                            mapaBotonTres.get(cabeza14).setBackground(Color.blue);
                 }
             }
             if(c==6){
                   if (mapaBotonTres.get("Boton " + contador).getBackground()==Color.magenta){
                            mapaBotonTres.get("Boton " + contador).setBackground(Color.BLACK);
                            mapaBotonTres.get(cabeza7).setBackground(Color.magenta);
                            mapaBotonTres.get(cabeza12).setBackground(Color.magenta);
                    }
             }
             if(c==5){
                             if (mapaBotonTres.get("Boton " + contador).getBackground()==Color.cyan){
                                mapaBotonTres.get("Boton " + contador).setBackground(Color.BLACK);
                                mapaBotonTres.get(cabeza9).setBackground(Color.cyan);
                                mapaBotonTres.get(cabeza6).setBackground(Color.cyan);
             }
         }
             if(c==4){
                            if (mapaBotonTres.get("Boton " + contador).getBackground()==Color.yellow){
                                mapaBotonTres.get("Boton " + contador).setBackground(Color.BLACK);
                                mapaBotonTres.get(cabeza4).setBackground(Color.yellow);
                                mapaBotonTres.get(cabeza8).setBackground(Color.yellow);
             }
    }
             if(c==3){
                 if (mapaBotonTres.get("Boton " + contador).getBackground()==Color.pink){
                                mapaBotonTres.get("Boton " + contador).setBackground(Color.BLACK);
                                mapaBotonTres.get(cabeza5).setBackground(Color.pink);
                                mapaBotonTres.get(cabeza3).setBackground(Color.pink);
             }
    
   }
             if(c==2){
                 if (mapaBotonTres.get("Boton " + contador).getBackground()==Color.green){
                                mapaBotonTres.get("Boton " + contador).setBackground(Color.BLACK);
                               mapaBotonTres.get(cabeza2).setBackground(Color.green);
                                mapaBotonTres.get(cabeza10).setBackground(Color.green);
             }               
   }
             if(c==1){
                 if (mapaBotonTres.get("Boton " + contador).getBackground()==Color.red){
                                mapaBotonTres.get("Boton " + contador).setBackground(Color.BLACK);
                                mapaBotonTres.get(cabeza1).setBackground(Color.red);
                                mapaBotonTres.get(cabeza13).setBackground(Color.red);
             }
    }
             contador++;
   }
  }
    
public void quitarColor(Color a){
            int ayu=0;
            String clave;
            for (int i=0;i<49;i++){
            clave="Boton "+ayu;
            if ((ayu!=0)&&(ayu!=5)&&(ayu!=6)&&(ayu!=10)&&(ayu!=11)&&(ayu!=17)&&(ayu!=24)&&(ayu!=32)&&(ayu!=34)&&(ayu!=37)&&(ayu!=38)&&(ayu!=41)&&(ayu!=45)&&(ayu!=48)){
                if (mapaBotonTres.get(clave).getBackground()==a){
                    mapaBotonTres.get(clave).setBackground(Color.BLACK);
                }
            }
            ayu++;
        }
    }
//Funcion que valida que el nivel este completo
public boolean validarNivel(){
        int ayu=0;
        for (int i=0;i<49;i++){
            if (mapaBotonTres.get("Boton "+ayu).getBackground()==Color.BLACK){
                return false;
            }
            ayu++;
        }
        return true;
    }
//Funcion para Guardar la partida
public void guardar(){
    int cont=0;
        for (Jugador player : players) {
            if (player.getNombre()==jugador.getNombre()){
                player.setHor(jugador.getHor());
                player.setMin(jugador.getMin());
                player.setSeg(jugador.getSeg());
                player.setImagen(jugador.getImagen());
                player.setNivel(jugador.getNivel());
                player.setPuntaje(jugador.getPuntaje());
            }
        }
        
        for (Jugador player : players) {
            if (cont==0){
                try {
                    String datos=player.getNombre()+";"+player.getClave()+";"+player.getImagen()+";"+player.getNivel()+";"+player.getPuntaje()+";"+player.getHor()+";"+player.getMin()+";"+player.getSeg();
                    Utilidad.Escribir("Fichero/Archivo.txt", false, datos);
                } catch (IOException ex) {
                    Logger.getLogger(NivelUno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                try {
                    String datos=player.getNombre()+";"+player.getClave()+";"+player.getImagen()+";"+player.getNivel()+";"+player.getPuntaje()+";"+player.getHor()+";"+player.getMin()+";"+player.getSeg();
                    Utilidad.Escribir("Fichero/Archivo.txt", true, datos);
                } catch (IOException ex) {
                    Logger.getLogger(NivelUno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            cont++;
        }
    }
}    


