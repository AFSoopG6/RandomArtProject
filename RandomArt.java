import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.Stack;
import javax.imageio.ImageIO;                    
import java.awt.image.BufferedImage;     
import java.io.IOException; 
import java.awt.EventQueue;

public class RandomArt extends JFrame {
    
      public static void main(String[] args){
         EventQueue.invokeLater(new Runnable() {
            public void run(){
                RandomArt f = new RandomArt();
                f.setVisible(true);
            }
        });
    } 
    
        public RandomArt() {
            // Create a Frame
            super("Random Art");
            setSize(925, 612);
            setLocation(250, 280);
            setContentPane(new JLabel(new ImageIcon("Randomart.png")));
            
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            getContentPane().setLayout(null);
      
            // Create Button Start
            ImageIcon start = new ImageIcon("start.png");
            JButton btnStart = new JButton(start);
            btnStart.setBounds(370, 300, 200, 100);
            
            btnStart.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    //Start random
                    RandomFrame p = new RandomFrame();
                    p.setVisible(true);
                    p.start();
                    
                    //Hide this class
                    setVisible(false);
                }
            });
            
            getContentPane().add(btnStart);     
            
            // Create Button Exit
            ImageIcon exit = new ImageIcon("exit.png");
            JButton btnExit = new JButton(exit);
            btnExit.setBounds(370, 400, 200, 100);
            
            btnExit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   System.exit(0);
                }
            });
            
            getContentPane().add(btnExit);   
            
        }
    }


