import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.awt.Component;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.EventQueue;
import java.util.Stack;


public class RandomFrame extends JFrame{
    private JFrame theFrame;
    private RandomPanel thePanel;
    
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run(){
                
            }
        });
    }

    public RandomFrame(){
        theFrame = new JFrame();
        theFrame.setTitle("Random Art");
        theFrame.setLocation(100,100);
        theFrame.setVisible(true);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        thePanel = new RandomPanel();
        theFrame.add(thePanel);

        // create panel with buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(getButton("Random Gray", false));
        buttonPanel.add(getButton("Random Color", true));
        buttonPanel.add(getButton("Submit"));
        // add components to frame
        theFrame.add(thePanel, BorderLayout.CENTER);
        theFrame.add(buttonPanel, BorderLayout.SOUTH);
        theFrame.pack();
    }

    public JButton getButton(String label, final boolean makeColor){
        JButton result = new JButton(label);
        result.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(makeColor)
                    thePanel.setToColor();
                else
                    thePanel.setToGray();
                thePanel.repaint();
            }
        });
        return result;
    }
    
     public JButton getButton(String label){
        JButton btnsubmit = new JButton(label);
        btnsubmit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JTextField name = new JTextField();
                   
                   final JComponent[] inputs = new JComponent[] {
                       new JLabel("Pic Name: "),
                       name
                    };

                    JOptionPane.showMessageDialog(null, inputs, "Save", JOptionPane.PLAIN_MESSAGE);
                    System.out.println("Your picture: " + name.getText());
                
            }
        });
        return btnsubmit;
    }

    public void start(){
        theFrame.setVisible(true);
        
        RandomPanel r = new RandomPanel();
        r.setVisible(true);
        
        RandomExpression ex = new RandomExpression();
        ex.setVisible(true);
    }
}