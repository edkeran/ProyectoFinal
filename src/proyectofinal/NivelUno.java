/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;
import java.awt.BorderLayout;
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
public class NivelUno extends JFrame implements MouseListener,ActionListener {
    JButton boton1;
    int seg,min,hor;
    JLabel imagen;
    JButton boton2;
    JButton boton3;
    JButton guardar;
    Jugador jugador;
    JLabel etiquPunt;
    String cabeza1,cabeza2,cabeza3,cabeza4,cabeza5,cabeza6,cabeza7,cabeza8,cabeza9,cabeza10;
    JButton aux;
    JLabel cronometro;
    JLabel puntaje;
    JLabel labelCron;
    HiloCronometro hiloC;
    HiloPuntaje punt;
    int filas = 5;
    boolean c1=false,c2=false,c3=false,c4=false,c5=false;
    int columnas = 5;
    int contador = 1;
    int auxX = 200;
    int auxY = 100;
    int color=0;
    private Map<String, JButton> mapaBoton;
    List <Jugador> players = new ArrayList <Jugador>();
    
    public NivelUno(Jugador a,List <Jugador> ayu) {
        players=ayu;
        punt = new HiloPuntaje(a,this);
        imagen= new JLabel();
        etiquPunt= new JLabel("PUNTAJE");
        puntaje= new JLabel(""+a.getPuntaje());
        ImageIcon icon= new ImageIcon(a.getImagen());
        imagen.setIcon(new ImageIcon(icon.getImage().getScaledInstance(200,150,Image.SCALE_SMOOTH)));
        cronometro = new JLabel("00:00:00");
        labelCron= new JLabel("CRONOMETRO");
        labelCron.setForeground(Color.DARK_GRAY);
        labelCron.setBounds(450, 80, 100, 20);
        jugador=a;
        cronometro.setBounds(450, 100, 100, 20);
        setSize(600,600);
        guardar=new JButton("Guardar");
        guardar.addActionListener(this);
        guardar.setBounds(400, 370, 100, 20);
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
        imagen.setBounds(0, 400, 200, 150);
        etiquPunt.setBounds(0, 50, 100, 20);
        puntaje.setBounds(0, 70, 100, 20);
        add(imagen);
        add(puntaje);
        add(etiquPunt);
        add(aux);
        add(boton1);
        add(guardar);
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
         if ((validarNivel()==true)&&(c1==true)&&(c2==true)&&(c3==true)&&(c4==true)&&(c5==true)){
            System.out.println("Termino el nivel");
            hiloC.terminar();
            jugador.setPuntaje(punt.tiempo());
            punt.terminar();
            jugador.setNivel(2);
            guardar();
            dispose();
            NivelDos nuevo= new NivelDos(jugador,players); 
        }
       if((aux==mapaBoton.get(cabeza1))||(aux==mapaBoton.get(cabeza2))||(aux==mapaBoton.get(cabeza3))||(aux==mapaBoton.get(cabeza4))||(aux==mapaBoton.get(cabeza5)||(aux==mapaBoton.get(cabeza6))||(aux==mapaBoton.get(cabeza7))||(aux==mapaBoton.get(cabeza8))||(aux==mapaBoton.get(cabeza9))||(aux==mapaBoton.get(cabeza10)))){
           switch(color){
               case 1:
                   if (aux.getBackground()!=Color.red){
                       repintar(color);
                       c1=false;
                   }else{
                       c1=true;
                   }
                   break;
               case 2:
                   if (aux.getBackground()!=Color.BLUE){
                       repintar(color);
                       c2=false;
                   }else{
                    c2=true;
                   }
                   break;
               case 3:
                   if (aux.getBackground()!=Color.yellow){
                       repintar(color);
                       c3=false;
                   }else{
                       c3=true;
                   }
                   break;
               case 4:
                   if (aux.getBackground()!=Color.PINK){
                       repintar(color);
                       c4=false;
                   }else{
                       c4=true;
                   }
                   break;
               case 5:
                   if (aux.getBackground()!=Color.GREEN){
                       repintar(color);
                       c5=false;
                   }else{
                       c5=true;
                   }
                   break;
           }
           color=0;
          
       }
       
       if (((JButton) e.getSource()).getBackground()== Color.white){
           repintar(color);
           if (color==1){
               c1=false;
           }
           if (color==2){
               c2=false;
           }
           if (color==3){
               c3=false;
           }
           if (color==4){
               c4=false;
           }
           if (color==5){
               c5=false;
           }
           color=0;
           System.out.println("SALIO");
           
       }else{
            if (color==1){
                if (((JButton) e.getSource()).getBackground()==Color.BLACK){
                    ((JButton) e.getSource()).setBackground(Color.red);
                }else{
                     quitarColor(((JButton) e.getSource()).getBackground());
                     ((JButton) e.getSource()).setBackground(Color.red);
                }
            }
            if (color==2){
                 if (((JButton) e.getSource()).getBackground()==Color.BLACK){
                    ((JButton) e.getSource()).setBackground(Color.BLUE);
                }else{
                     quitarColor(((JButton) e.getSource()).getBackground());
                     ((JButton) e.getSource()).setBackground(Color.BLUE);
                }
            }
            if (color==3){
                if (((JButton) e.getSource()).getBackground()==Color.BLACK){
                    ((JButton) e.getSource()).setBackground(Color.yellow);
                }else{
                     quitarColor(((JButton) e.getSource()).getBackground());
                     ((JButton) e.getSource()).setBackground(Color.yellow);
                }
            }
            if (color==4){
                if (((JButton) e.getSource()).getBackground()==Color.BLACK){
                    ((JButton) e.getSource()).setBackground(Color.PINK);
                }else{
                     quitarColor(((JButton) e.getSource()).getBackground());
                     ((JButton) e.getSource()).setBackground(Color.PINK);
                }
            }
            if (color==5){
                if (((JButton) e.getSource()).getBackground()==Color.BLACK){
                    ((JButton) e.getSource()).setBackground(Color.GREEN);
                }else{
                     quitarColor(((JButton) e.getSource()).getBackground());
                     ((JButton) e.getSource()).setBackground(Color.GREEN);
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

        public void quitarColor(Color a){
            int ayu=1;
            String clave;
            for (int i=0;i<25;i++){
                clave="Boton "+ayu;
                if ((ayu!=1)&&(ayu!=12)&&(ayu!=6)&&(ayu!=18)&&(ayu!=14)&&(ayu!=21)&&(ayu!=13)&&(ayu!=5)&&(ayu!=9)&&(ayu!=25)){
                    if (mapaBoton.get(clave).getBackground()==a){
                        mapaBoton.get(clave).setBackground(Color.BLACK);
                    }
                }
                ayu++;
            }
    }
    public boolean validarNivel(){
        int ayu=1;
        for (int i=0;i<25;i++){
            if (mapaBoton.get("Boton "+ayu).getBackground()==Color.BLACK){
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

