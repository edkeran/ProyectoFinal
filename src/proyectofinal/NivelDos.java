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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author edgar
 */
public class NivelDos extends JFrame implements MouseListener,ActionListener  {
    
    int seg,min,hor;
    HiloPuntaje punt;
    boolean c1=false,c2=false,c3=false,c4=false,c5=false,c6=false;
    JButton boton1;
    JButton boton2;
    JButton boton3;
    JButton guardar;
    Jugador jugador;
    JLabel imagen; 
    JLabel etquPun;
    JLabel puntaje;
    String cabeza1,cabeza2,cabeza3,cabeza4,cabeza5,cabeza6,cabeza7,
           cabeza8,cabeza9,cabeza10,cabeza11,cabeza12;
    JButton auxDos;
    JLabel cronometroDos;
    JLabel labelCronDos;
    HiloCronometro hiloCDos;
    int filasDos = 6;
    int columnasDos = 6;
    int contador = 1;
    int auxXDos = 200;
    int auxYDos = 100;
    int colorDos = 0;
    private Map<String, JButton> mapaBotonDos;
    List <Jugador> players;
    
    public NivelDos(Jugador a,List <Jugador> ayu){
        punt= new HiloPuntaje(a,this);
        players=ayu;
        cronometroDos = new JLabel("00:00:00");
        imagen= new JLabel();
        puntaje= new JLabel(""+a.getPuntaje());
        etquPun= new JLabel("PUNTAJE");
        guardar=new JButton("Guardar");
        guardar.addActionListener(this);
        guardar.setBounds(400, 370, 100, 20);
        ImageIcon icon= new ImageIcon(a.getImagen());
        imagen.setIcon(new ImageIcon(icon.getImage().getScaledInstance(200,150,Image.SCALE_SMOOTH)));
        labelCronDos = new JLabel("CRONOMETRO");
        labelCronDos.setForeground(Color.DARK_GRAY);
        labelCronDos.setBounds(470, 80, 100, 20);
        jugador=a;
        cronometroDos.setBounds(470, 100, 100, 20);
        setSize(600,600);
         auxDos= new JButton("....");
        boton1=new JButton("....");
        boton1.setBackground(Color.white);
        boton1.setBounds(200, 80, 240, 20);
        boton1.addMouseListener(this);
        boton2= new JButton("....");
        boton2.setBackground(Color.white);
        boton2.setBounds(200, 340, 240, 20);
        boton2.addMouseListener(this);
        boton3= new JButton("....");
        boton3.setBackground(Color.white);
        boton3.setBounds(440, 80, 20, 280);
        boton3.addMouseListener(this);
        auxDos.setBackground(Color.white);
        auxDos.addMouseListener(this);
        auxDos.setBounds(180, 80, 20, 280);
        imagen.setBounds(0, 400, 200, 150);
        etquPun.setBounds(0, 50, 100, 20);
        puntaje.setBounds(0, 70, 100, 20);
        add(etquPun);
        add(puntaje);
        add(imagen);
        add(auxDos);
        add(boton1);
        add(boton2);
        add(boton3);
        add(cronometroDos);
        add(guardar);
        add(labelCronDos);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        mapaBotonDos = new HashMap<String, JButton>();
        for(int i = 0; i < filasDos; i++) {
            auxXDos = 200;    
            for(int j = 0; j < columnasDos; j++) {
                JButton boton = new JButton("Boton " + contador);
                boton.setBounds(auxXDos, auxYDos, 40, 40);
                boton.setActionCommand("Boton " + contador);
                boton.setBackground(Color.BLACK);
                
                if(contador == 6){
                boton.setBackground(Color.blue);
                cabeza1="Boton " + contador;
                }
                if(contador == 24){
                    boton.setBackground(Color.cyan);
                    cabeza2 ="Boton " + contador;
                }
                
                 if(contador == 16){
                   boton.setBackground(Color.red);
                   cabeza3 ="Boton " + contador;
                }
                
                 if(contador == 2){
                      boton.setBackground(Color.pink);
                      cabeza4 ="Boton " + contador;
                 }
                 
                 if(contador == 29){
                      boton.setBackground(Color.cyan);
                      cabeza5 ="Boton " + contador;
                 }
                 
                 if(contador == 8){
                      boton.setBackground(Color.blue);
                      cabeza6 ="Boton " +contador;
                 }
                 
                 if(contador == 14){
                      boton.setBackground(Color.yellow);
                      cabeza7 ="Boton " + contador;
                 }
                 
                 if(contador == 33){
                      boton.setBackground(Color.pink);
                      cabeza8 ="Boton " + contador;
                 }
                 
                 if(contador == 15){
                      boton.setBackground(Color.green);
                      cabeza9 ="Boton " + contador;
                 }
                 
                 if(contador == 36){
                      boton.setBackground(Color.yellow);
                     cabeza10 ="Boton " + contador;
                 } 
                 
                  if(contador == 18){
                      boton.setBackground(Color.red);
                     cabeza11 ="Boton " + contador;
                 } 
                  
                   if(contador == 17){
                      boton.setBackground(Color.green);
                     cabeza12 ="Boton " + contador;
                 }
                boton.addMouseListener(this);
                mapaBotonDos.put("Boton " + contador, boton);
                add(boton);         
                auxXDos += 40;
                contador++;
            }
            auxYDos += 40;
    }
        hiloCDos= new HiloCronometro(this);
        hiloCDos.start();
        setVisible(true);
  }
    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (((JButton) e.getSource()).getBackground()==Color.blue){
            colorDos=1;
        }
        if (((JButton) e.getSource()).getBackground()==Color.cyan){
            colorDos=2;
        }
        if (((JButton) e.getSource()).getBackground()==Color.red){
            colorDos=3;
        }
        if (((JButton) e.getSource()).getBackground()==Color.pink){
            colorDos=4;
        }
         if (((JButton) e.getSource()).getBackground()==Color.yellow){
            colorDos=5;
        }
          if (((JButton) e.getSource()).getBackground()==Color.green){
            colorDos=6;
        }
          
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       JButton aux2=(JButton) e.getSource();
       if ((validarNivel()==true)&&(c1==true)&&(c2==true)&&(c3==true)&&(c4==true)&&(c5==true)&&(c6==true)){
            System.out.println("Termino el nivel");
            hiloCDos.terminar();
            jugador.setPuntaje(punt.tiempo());
            punt.terminar();
            dispose();
            jugador.setNivel(3);
            guardar();
            NivelTres nuevo= new NivelTres(jugador,players); 
        }
       if((aux2==mapaBotonDos.get(cabeza1))||(aux2==mapaBotonDos.get(cabeza2))
               ||(aux2==mapaBotonDos.get(cabeza3))||(aux2==mapaBotonDos.get(cabeza4))||
               (aux2==mapaBotonDos.get(cabeza5)||(aux2==mapaBotonDos.get(cabeza6))||(aux2==mapaBotonDos.get(cabeza7))
               ||(aux2==mapaBotonDos.get(cabeza8))||(aux2==mapaBotonDos.get(cabeza9))||
               (aux2==mapaBotonDos.get(cabeza10)) || (aux2==mapaBotonDos.get(cabeza11))||(aux2==mapaBotonDos.get(cabeza12)))){
           
               switch(colorDos){
                   
                   case 1:
                       if (aux2.getBackground()!=Color.blue){
                       repintar(colorDos);
                       c1=false;
                   }else{
                       c1=true;
                       }
                       break;
                   case 2:
                       if (aux2.getBackground()!=Color.cyan){
                       repintar(colorDos);
                       c2=false;
                   }else{
                       c2=true;
                       }
                       break;
                   case 3:
                       if (aux2.getBackground()!=Color.red){
                       repintar(colorDos);
                       c3=false;
                   }else{
                       c3=true;
                       }
                       break;
                   case 4:
                       if (aux2.getBackground()!=Color.pink){
                       repintar(colorDos);
                       c4=false;
                   }else{
                       c4=true;
                       }
                       break;
                   case 5:
                       if (aux2.getBackground()!=Color.yellow){
                       repintar(colorDos);
                       c5=false;
                   }else{
                       c5=true;
                       }
                       break;
                   case 6:
                       if (aux2.getBackground()!=Color.green){
                       repintar(colorDos);
                       c6=false;
                   }else{
                       c6=true;
                       }
                          
               }
               
               colorDos =0;
       }
       
           if (((JButton) e.getSource()).getBackground()== Color.white){
                repintar(colorDos);
                if (colorDos==1){
                    c1=false;
                }
                if (colorDos==2){
                    c2=false;
                }
                if (colorDos==3){
                    c3=false;
                }
                if (colorDos==4){
                    c4=false;
                }
                if (colorDos==5){
                    c5=false;
                }
                if (colorDos==6){
                    c6=false;
                }
                colorDos=0;
                System.out.println("SALIO");  
    }
           else{
                if (colorDos==1){
                    if (((JButton) e.getSource()).getBackground()==Color.BLACK){
                    ((JButton) e.getSource()).setBackground(Color.blue);
                }else{
                     quitarColor(((JButton) e.getSource()).getBackground());
                     ((JButton) e.getSource()).setBackground(Color.blue);
                }
            }
            if (colorDos==2){
                if (((JButton) e.getSource()).getBackground()==Color.BLACK){
                    ((JButton) e.getSource()).setBackground(Color.cyan);
                }else{
                     quitarColor(((JButton) e.getSource()).getBackground());
                     ((JButton) e.getSource()).setBackground(Color.cyan);
                }
            }
            if (colorDos==3){
                if (((JButton) e.getSource()).getBackground()==Color.BLACK){
                    ((JButton) e.getSource()).setBackground(Color.red);
                }else{
                     quitarColor(((JButton) e.getSource()).getBackground());
                     ((JButton) e.getSource()).setBackground(Color.red);
                }
            }
            if (colorDos==4){
                if (((JButton) e.getSource()).getBackground()==Color.BLACK){
                    ((JButton) e.getSource()).setBackground(Color.PINK);
                }else{
                     quitarColor(((JButton) e.getSource()).getBackground());
                     ((JButton) e.getSource()).setBackground(Color.PINK);
                }
            }
            if (colorDos==5){
                if (((JButton) e.getSource()).getBackground()==Color.BLACK){
                    ((JButton) e.getSource()).setBackground(Color.yellow);
                }else{
                     quitarColor(((JButton) e.getSource()).getBackground());
                     ((JButton) e.getSource()).setBackground(Color.yellow);
                }
            }
             if (colorDos==6){
                 if (((JButton) e.getSource()).getBackground()==Color.BLACK){
                    ((JButton) e.getSource()).setBackground(Color.green);
                }else{
                     quitarColor(((JButton) e.getSource()).getBackground());
                     ((JButton) e.getSource()).setBackground(Color.green);
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
    
    private void repintar(int b){
        contador=1;
         for (int i=1;i<=36;i++){
             if(b==6){
                   if (mapaBotonDos.get("Boton " + contador).getBackground()==Color.green){
                            mapaBotonDos.get("Boton " + contador).setBackground(Color.BLACK);
                            mapaBotonDos.get(cabeza9).setBackground(Color.green);
                            mapaBotonDos.get(cabeza12).setBackground(Color.green);
                    }
             }
             if(b==5){
                             if (mapaBotonDos.get("Boton " + contador).getBackground()==Color.yellow){
                                mapaBotonDos.get("Boton " + contador).setBackground(Color.BLACK);
                                mapaBotonDos.get(cabeza7).setBackground(Color.yellow);
                                mapaBotonDos.get(cabeza10).setBackground(Color.yellow);
             }
         }
             if(b==4){
                            if (mapaBotonDos.get("Boton " + contador).getBackground()==Color.pink){
                                mapaBotonDos.get("Boton " + contador).setBackground(Color.BLACK);
                                mapaBotonDos.get(cabeza4).setBackground(Color.pink);
                                mapaBotonDos.get(cabeza8).setBackground(Color.pink);
             }
    }
             if(b==3){
                 if (mapaBotonDos.get("Boton " + contador).getBackground()==Color.red){
                                mapaBotonDos.get("Boton " + contador).setBackground(Color.BLACK);
                                mapaBotonDos.get(cabeza3).setBackground(Color.red);
                                mapaBotonDos.get(cabeza11).setBackground(Color.red);
             }
    
   }
             if(b==2){
                 if (mapaBotonDos.get("Boton " + contador).getBackground()==Color.cyan){
                                mapaBotonDos.get("Boton " + contador).setBackground(Color.BLACK);
                                mapaBotonDos.get(cabeza2).setBackground(Color.cyan);
                                mapaBotonDos.get(cabeza5).setBackground(Color.cyan);
             }               
   }
             if(b==1){
                 if (mapaBotonDos.get("Boton " + contador).getBackground()==Color.blue){
                                mapaBotonDos.get("Boton " + contador).setBackground(Color.BLACK);
                                mapaBotonDos.get(cabeza1).setBackground(Color.blue);
                                mapaBotonDos.get(cabeza6).setBackground(Color.blue);
             }
    }
             contador++;
   }
  }
  public void quitarColor(Color a){
            int ayu=1;
            String clave;
            for (int i=0;i<36;i++){
                clave="Boton "+ayu;
                if ((ayu!=6)&&(ayu!=24)&&(ayu!=16)&&(ayu!=2)&&(ayu!=29)&&(ayu!=8)&&(ayu!=14)&&(ayu!=33)&&(ayu!=15)&&(ayu!=36)&&(ayu!=18)&&(ayu!=17)){
                    if (mapaBotonDos.get(clave).getBackground()==a){
                        mapaBotonDos.get(clave).setBackground(Color.BLACK);
                    }
                }
                ayu++;
            }
    }
  
  public boolean validarNivel(){
        int ayu=1;
        for (int i=0;i<36;i++){
            if (mapaBotonDos.get("Boton "+ayu).getBackground()==Color.BLACK){
                return false;
            }
            ayu++;
        }
        return true;
    }
  
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
