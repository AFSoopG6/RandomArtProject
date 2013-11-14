import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.Stack;

public class A2MainSolution extends JFrame {

    public static void main(String[] args) {
         EventQueue.invokeLater(new Runnable() {
            public void run(){
                A2MainSolution f = new A2MainSolution();
                f.setVisible(true);
            }
        });
    } 
    
    public A2MainSolution() {
            // Create Form Frame
            super("Random Art");
            setSize(450, 300);
            setLocation(250, 280);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            getContentPane().setLayout(null);

            // Create Label Welcome
            JLabel lbwelcome = new JLabel("Welcome To Random Art");
            lbwelcome.setBounds(140, 20, 150, 100);
            getContentPane().add(lbwelcome);

            // Create Button Start
            JButton btnStart = new JButton("Start");
            btnStart.setBounds(90, 90, 90, 30);
            btnStart.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    //Start random
                    RandomFrame f = new RandomFrame();
                    f.setVisible(true);
                    f.start();
                    
                    //Hide this class
                    setVisible(false);
                }
            });
            getContentPane().add(btnStart);   
            
            // Create Button Exit
            JButton btnExit = new JButton("Exit");
            btnExit.setBounds(250, 90, 90, 30);
            btnExit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   System.exit(0);
                }
            });
            getContentPane().add(btnExit);  
        }
}

