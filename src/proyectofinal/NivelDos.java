/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author edgar
 */
public class NivelDos extends JFrame implements MouseListener,ActionListener  {
    
    JButton boton1;
    JButton boton2;
    JButton boton3;
    JButton guardar;
    Jugador jugador;
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
    List <Jugador> players = new ArrayList <Jugador>();
    
    public NivelDos(Jugador a){
        cronometroDos = new JLabel("00:00:00");
        labelCronDos = new JLabel("CRONOMETRO");
        labelCronDos.setForeground(Color.DARK_GRAY);
        labelCronDos.setBounds(450, 80, 100, 20);
        jugador=a;
        cronometroDos.setBounds(450, 100, 100, 20);
        setSize(600,600);
         auxDos= new JButton("....");
        boton1=new JButton("....");
        boton1.setBackground(Color.white);
        boton1.setBounds(180, 80, 220, 20);
        boton1.addMouseListener(this);
        boton2= new JButton("....");
        boton2.setBackground(Color.white);
        boton2.setBounds(180, 300, 220, 20);
        boton2.addMouseListener(this);
        boton3= new JButton("....");
        boton3.setBackground(Color.white);
        boton3.setBounds(400, 80, 20, 240);
        boton3.addMouseListener(this);
        auxDos.setBackground(Color.white);
        auxDos.addMouseListener(this);
        auxDos.setBounds(180, 100, 20, 200);
        add(auxDos);
        add(boton1);
        add(boton2);
        add(boton3);
        add(cronometroDos);
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
                
                if(contador == 4){
                boton.setBackground(Color.blue);
                cabeza1="Boton " + contador;
                }
                if(contador == 5){
                    boton.setBackground(Color.cyan);
                    cabeza2 ="Boton " + contador;
                }
                
                 if(contador == 7){
                   boton.setBackground(Color.red);
                   cabeza3 ="Boton " + contador;
                }
                 
                 if(contador == 8){
                      boton.setBackground(Color.pink);
                      cabeza4 ="Boton " + contador;
                 }
                 
                 if(contador == 9){
                      boton.setBackground(Color.cyan);
                      cabeza5 ="Boton " + contador;
                 }
                 
                 if(contador == 12){
                      boton.setBackground(Color.blue);
                      cabeza6 ="Boton " + contador;
                 }
                 
                 if(contador == 15){
                      boton.setBackground(Color.yellow);
                      cabeza7 ="Boton " + contador;
                 }
                 
                 if(contador == 22){
                      boton.setBackground(Color.pink);
                      cabeza8 ="Boton " + contador;
                 }
                 
                 if(contador == 25){
                      boton.setBackground(Color.green);
                      cabeza9 ="Boton " + contador;
                 }
                 
                 if(contador == 27){
                      boton.setBackground(Color.yellow);
                     cabeza10 ="Boton " + contador;
                 } 
                 
                  if(contador == 31){
                      boton.setBackground(Color.red);
                     cabeza11 ="Boton " + contador;
                 } 
                  
                   if(contador == 35){
                      boton.setBackground(Color.green);
                     cabeza12 ="Boton " + contador;
                 }
                 boton.addMouseListener(this);
                boton.addActionListener(this);
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
       if((aux2==mapaBotonDos.get(cabeza1))||(aux2==mapaBotonDos.get(cabeza2))
               ||(aux2==mapaBotonDos.get(cabeza3))||(aux2==mapaBotonDos.get(cabeza4))||
               (aux2==mapaBotonDos.get(cabeza5)||(auxDos==mapaBotonDos.get(cabeza6))||(aux2==mapaBotonDos.get(cabeza7))
               ||(aux2==mapaBotonDos.get(cabeza8))||(aux2==mapaBotonDos.get(cabeza9))||
               (aux2==mapaBotonDos.get(cabeza10)) || (aux2==mapaBotonDos.get(cabeza11)) || (aux2==mapaBotonDos.get(cabeza12)))){
           
               switch(colorDos){
                   
                   case 1:
                       if (aux2.getBackground()!=Color.blue){
                       repintar(colorDos);
                   }
                       break;
                   case 2:
                       if (aux2.getBackground()!=Color.cyan){
                       repintar(colorDos);
                   }
                       break;
                   case 3:
                       if (aux2.getBackground()!=Color.red){
                       repintar(colorDos);
                   }
                       break;
                   case 4:
                       if (aux2.getBackground()!=Color.pink){
                       repintar(colorDos);
                   }
                       break;
                   case 5:
                       if (aux2.getBackground()!=Color.yellow){
                       repintar(colorDos);
                   }
                       break;
                   case 6:
                       if (aux2.getBackground()!=Color.green){
                       repintar(colorDos);
                   }
                          
               }
               
               colorDos =0;
       }
       
           if (((JButton) e.getSource()).getBackground()== Color.white){
                repintar(colorDos);
                colorDos=0;
                System.out.println("SALIO");  
    }
           else{
                if (colorDos==1){
                ((JButton) e.getSource()).setBackground(Color.blue);
            }
            if (colorDos==2){
                ((JButton) e.getSource()).setBackground(Color.cyan);
            }
            if (colorDos==3){
                ((JButton) e.getSource()).setBackground(Color.red);
            }
            if (colorDos==4){
                ((JButton) e.getSource()).setBackground(Color.PINK);
            }
            if (colorDos==5){
                ((JButton) e.getSource()).setBackground(Color.yellow);
            }
            
             if (colorDos==6){
                ((JButton) e.getSource()).setBackground(Color.green);
            }
        }
  }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    private void repintar(int b){
        contador=1;
         for (int i=1;i<=36;i++){
             if(b==6){
                   if (mapaBotonDos.get("Boton " + contador).getBackground()==Color.green){
                            mapaBotonDos.get("Boton " + contador).setBackground(Color.BLACK);
                            mapaBotonDos.get(cabeza9).setBackground(Color.green);
                            mapaBotonDos.get(cabeza10).setBackground(Color.green);
                    }
             }
             if(b==5){
                             if (mapaBotonDos.get("Boton " + contador).getBackground()==Color.yellow){
                                mapaBotonDos.get("Boton " + contador).setBackground(Color.BLACK);
                                mapaBotonDos.get(cabeza9).setBackground(Color.yellow);
                                mapaBotonDos.get(cabeza10).setBackground(Color.yellow);
             }
         }
             if(b==4){
                            if (mapaBotonDos.get("Boton " + contador).getBackground()==Color.pink){
                                mapaBotonDos.get("Boton " + contador).setBackground(Color.BLACK);
                                mapaBotonDos.get(cabeza9).setBackground(Color.pink);
                                mapaBotonDos.get(cabeza10).setBackground(Color.pink);
             }
    }
             if(b==3){
                 if (mapaBotonDos.get("Boton " + contador).getBackground()==Color.red){
                                mapaBotonDos.get("Boton " + contador).setBackground(Color.BLACK);
                                mapaBotonDos.get(cabeza9).setBackground(Color.red);
                                mapaBotonDos.get(cabeza10).setBackground(Color.red);
             }
    
   }
             if(b==2){
                 if (mapaBotonDos.get("Boton " + contador).getBackground()==Color.cyan){
                                mapaBotonDos.get("Boton " + contador).setBackground(Color.BLACK);
                                mapaBotonDos.get(cabeza9).setBackground(Color.cyan);
                                mapaBotonDos.get(cabeza10).setBackground(Color.cyan);
             }               
   }
             if(b==1){
                 if (mapaBotonDos.get("Boton " + contador).getBackground()==Color.blue){
                                mapaBotonDos.get("Boton " + contador).setBackground(Color.BLACK);
                                mapaBotonDos.get(cabeza9).setBackground(Color.blue);
                                mapaBotonDos.get(cabeza10).setBackground(Color.blue);
             }
    }
             contador++;
   }
  }
}
