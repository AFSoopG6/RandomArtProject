import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.EventQueue;
import java.util.Stack;
import java.util.Stack;

class RandomPanel extends JPanel{

    private static final int NUM_SHADES = 256;
    private Color[] grayscales;
    private boolean color;
    private RandomExpression exp;
    private RandomExpression[] colorExp;
    
    // indices into colorExp array
    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;

    // create 256 gray scale colors to avoid lots
    // of garbage color objects
    public RandomPanel(){
        grayscales = new Color[NUM_SHADES];
        for(int i = 0; i < NUM_SHADES; i++){
            grayscales[i] = new Color(i,i,i);
        }
        color = false;   
        setPreferredSize(new Dimension(400,400));
        exp = new RandomExpression("xCySM");
        // exp = new RandomExpression("xxACSSxCAyCyxASASCAyCCAyyyAAxMSxCxCAxSySMMCMCSMSCS");
        
        // if using 3 different functions for color
        colorExp = new RandomExpression[3];
    }

    //public void setToGray(){
        //exp = new RandomExpression();
        //color = false;
    //}

    public void setToColor(){
        for(int i = 0; i < colorExp.length; i++)
            colorExp[i] = new RandomExpression();
        color = true;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        final int MAX_X = getWidth();
        final int MAX_Y = getHeight();
        double xInc = 2.0 / MAX_X;
        double yInc = 2.0 / MAX_Y;
        double xVal = -1.0;
        double yVal = -1.0;     
        for(int x = 0; x < MAX_X; x++){
            yVal = -1.0;
            for(int y = 0; y < MAX_Y; y++){
                //if(!color){
                    //int shade = getShade(xVal, yVal, exp);
                    //g2.setColor(grayscales[shade]);
                //}
                //else {
                    
                    // the following block is an alternative way of 
                    // doing color. Use the same expression, but 
                    // swap around x, y
                    /*
                    int r = getShade(xVal, yVal, colorExp[RED]);
                    int gr = getShade(yVal, xVal, colorExp[RED]);
                    int b = getShade(-yVal, -xVal, colorExp[RED]);
                    */
                    int r = getShade(xVal, yVal, colorExp[RED]);
                    int gr = getShade(xVal, yVal, colorExp[GREEN]);
                    int b = getShade(xVal, yVal, colorExp[BLUE]);
                    g2.setColor(new Color(r, gr, b));
                //}
                Rectangle2D pixel = new Rectangle2D.Double(x, y, 1, 1);
                g2.fill(pixel);
                yVal += yInc;
            }
            xVal += xInc;
        }
        // need to add this to the GUI!!!!
        //if(!color)
            //System.out.println(exp);
        //else{
            System.out.println("red: " + colorExp[RED]);
            System.out.println("green: " + colorExp[GREEN]);
            System.out.println("blue: " + colorExp[BLUE]);
        //}
    }

    private int getShade(double x, double y, RandomExpression exp){
        double val = exp.getResult(x, y);
        int result = (int)((val + 1.0) / 2.0 * NUM_SHADES);
        result = (result == 256) ? 255 : result;
        assert 0 <= result && result < NUM_SHADES : result + " " + val;
        return result;
    }


}