import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import figures.*;

class PackApp {
    public static void main (String[] args) {
        PackFrame frame = new PackFrame();
        frame.setVisible(true);
    }
}

class PackFrame extends JFrame {
    Rect r1;
    Ellipse e1;
    QuadCurve q1, q2;

    PackFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Java Packages");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30,0,255,255,0,0,204);
        this.e1 = new Ellipse(50,100, 100,30,255,102,102,51,0,0);
	this.q1 = new QuadCurve(50,200,45,110,200,200,255,102,178,51,0,25);
	this.q2 = new QuadCurve(50,200,150,70,200,200,51,255,153,0,153,0);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.e1.paint(g);
	this.q1.paint(g);
	this.q2.paint(g);
    }
}
