/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;
import java.awt.BorderLayout;
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
public class NivelUno extends JFrame implements MouseListener,ActionListener {
    JButton boton1;
    JButton boton2;
    JButton boton3;
    JButton guardar;
    Jugador jugador;
    String cabeza1,cabeza2,cabeza3,cabeza4,cabeza5,cabeza6,cabeza7,cabeza8,cabeza9,cabeza10;
    JButton aux;
    JLabel cronometro;
    JLabel labelCron;
    HiloCronometro hiloC;
    int filas = 5;
    int columnas = 5;
    int contador = 1;
    int auxX = 200;
    int auxY = 100;
    int color=0;
    private Map<String, JButton> mapaBoton;
    List <Jugador> players = new ArrayList <Jugador>();
    public NivelUno(Jugador a) {
        cronometro = new JLabel("00:00:00");
        labelCron= new JLabel("CRONOMETRO");
        labelCron.setForeground(Color.DARK_GRAY);
        labelCron.setBounds(450, 80, 100, 20);
        jugador=a;
        cronometro.setBounds(450, 100, 100, 20);
        setSize(600,600);
        aux= new JButton("....");
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
        aux.setBackground(Color.white);
        aux.addMouseListener(this);
        aux.setBounds(180, 100, 20, 200);
        add(aux);
        add(boton1);
        add(boton2);
        add(boton3);
        add(cronometro);
        add(labelCron);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        mapaBoton = new HashMap<String, JButton>();
        for(int i = 0; i < filas; i++) {
            auxX = 200;
            for(int j = 0; j < columnas; j++) {
                JButton boton = new JButton("Boton " + contador);
                boton.setBounds(auxX, auxY, 40, 40);
                boton.setActionCommand("Boton " + contador);
                boton.setBackground(Color.BLACK);
                if (contador==1){
                boton.setBackground(Color.red);
                cabeza1="Boton " + contador;
                }
                if (contador==12){
                boton.setBackground(Color.red);
                cabeza2="Boton " + contador;
                }
                if (contador==6){
                boton.setBackground(Color.BLUE);
                cabeza3="Boton " + contador;
                }
                if(contador==18){
                boton.setBackground(Color.BLUE);
                cabeza4="Boton " + contador;
                }
                if (contador==14){
                boton.setBackground(Color.yellow);
                cabeza5="Boton " + contador;
                }
                if (contador==21){
                boton.setBackground(Color.yellow);
                cabeza6="Boton " + contador;
                }
                if (contador==13){
                boton.setBackground(Color.PINK);
                cabeza7="Boton " + contador;
                }
                if (contador==5){
                boton.setBackground(Color.PINK);
                cabeza8="Boton " + contador;
                }
                if (contador==9){
                boton.setBackground(Color.GREEN);
                cabeza9="Boton " + contador;
                }
                if (contador==25){
                boton.setBackground(Color.GREEN);
                cabeza10="Boton " + contador;
                }
                boton.addMouseListener(this);
                boton.addActionListener(this);
                mapaBoton.put("Boton " + contador, boton);
                add(boton);         
                auxX += 40;
                contador++;
            }
            auxY += 40;
        }
        hiloC= new HiloCronometro(this);
        hiloC.start();
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (((JButton) e.getSource()).getBackground()==Color.red){
            color=1;
            }
        if (((JButton) e.getSource()).getBackground()==Color.BLUE){
                color=2;
            }
        if(((JButton) e.getSource()).getBackground()==Color.yellow){
                color=3;
            }
        if (((JButton) e.getSource()).getBackground()==Color.PINK){
                color=4;
            }
        if (((JButton) e.getSource()).getBackground()==Color.GREEN){
                color=5;
            }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e){
        JButton aux=(JButton) e.getSource();
       if((aux==mapaBoton.get(cabeza1))||(aux==mapaBoton.get(cabeza2))||(aux==mapaBoton.get(cabeza3))||(aux==mapaBoton.get(cabeza4))||(aux==mapaBoton.get(cabeza5)||(aux==mapaBoton.get(cabeza6))||(aux==mapaBoton.get(cabeza7))||(aux==mapaBoton.get(cabeza8))||(aux==mapaBoton.get(cabeza9))||(aux==mapaBoton.get(cabeza10)))){
           switch(color){
               case 1:
                   if (aux.getBackground()!=Color.red){
                       repintar(color);
                   }
                   break;
               case 2:
                   if (aux.getBackground()!=Color.BLUE){
                       repintar(color);
                   }
                   break;
               case 3:
                   if (aux.getBackground()!=Color.yellow){
                       repintar(color);
                   }
                   break;
               case 4:
                   if (aux.getBackground()!=Color.PINK){
                       repintar(color);
                   }
                   break;
               case 5:
                   if (aux.getBackground()!=Color.GREEN){
                       repintar(color);
                   }
                   break;
           }
           color=0;
          
       }
       if (((JButton) e.getSource()).getBackground()== Color.white){
           repintar(color);
           color=0;
           System.out.println("SALIO");
           
       }else{
            if (color==1){
                ((JButton) e.getSource()).setBackground(Color.red);
            }
            if (color==2){
                ((JButton) e.getSource()).setBackground(Color.BLUE);
            }
            if (color==3){
                ((JButton) e.getSource()).setBackground(Color.yellow);
            }
            if (color==4){
                ((JButton) e.getSource()).setBackground(Color.PINK);
            }
            if (color==5){
                ((JButton) e.getSource()).setBackground(Color.GREEN);
            }
       }
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    private void repintar(int a){
        contador=1;
        for (int i=1;i<=25;i++){
            if (a==5){
                if (mapaBoton.get("Boton " + contador).getBackground()==Color.GREEN){
                            mapaBoton.get("Boton " + contador).setBackground(Color.BLACK);
                            mapaBoton.get(cabeza9).setBackground(Color.GREEN);
                            mapaBoton.get(cabeza10).setBackground(Color.GREEN);
                    }
            }
            if (a==4){
                if (mapaBoton.get("Boton " + contador).getBackground()==Color.PINK){
                            mapaBoton.get("Boton " + contador).setBackground(Color.BLACK);
                            mapaBoton.get(cabeza7).setBackground(Color.PINK);
                            mapaBoton.get(cabeza8).setBackground(Color.PINK);
                    }
            }
            if (a==3){
                if (mapaBoton.get("Boton " + contador).getBackground()==Color.yellow){
                        mapaBoton.get("Boton " + contador).setBackground(Color.BLACK);
                        mapaBoton.get(cabeza5).setBackground(Color.yellow);
                        mapaBoton.get(cabeza6).setBackground(Color.yellow);
                }
            }
            if (a==2){
                if (mapaBoton.get("Boton " + contador).getBackground()==Color.BLUE){
                            mapaBoton.get("Boton " + contador).setBackground(Color.BLACK);
                            mapaBoton.get(cabeza3).setBackground(Color.BLUE);
                            mapaBoton.get(cabeza4).setBackground(Color.BLUE);
                    }
            }
            if(a==1){
                if (mapaBoton.get("Boton " + contador).getBackground()==Color.red){
                            mapaBoton.get("Boton " + contador).setBackground(Color.BLACK);
                            mapaBoton.get(cabeza1).setBackground(Color.red);
                            mapaBoton.get(cabeza2).setBackground(Color.red);
                    }
            }                     
            contador++;
        }
    }
    
}
