import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Polygon;

public class Hello2DApp {
    public static void main (String[] args) {
        Hello2DFrame frame = new Hello2DFrame();
		    frame.getContentPane().setBackground(Color.blue);
        frame.setVisible(true);
    }
}

class Hello2DFrame extends JFrame {
    public Hello2DFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java2D - Hello World!");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.black);	
        int w = getWidth();
        int h = getHeight();
        g2d.drawLine(0,0, w,h);
        g2d.drawLine(0,h, w,0);
		    g2d.setPaint(Color.yellow);
		    g2d.fillRect(getWidth()/2, getHeight()/2, 100, 150);
		    g2d.setPaint(Color.red);
		    int[] x = { 80, 160, 200, 120, 80, 60 };
        int[] y = { 200, 200, 240, 320, 320, 240 };
        Polygon poligono = new Polygon( x, y, 6);
        g2d.fillPolygon( poligono );
    }
}
