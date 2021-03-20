import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

class RectEllipseApp {
    public static void main (String[] args) {
        RectEllipseFrame frame = new RectEllipseFrame();
        frame.setVisible(true);
    }
}

class RectEllipseFrame extends JFrame {
    Rect r1, r2, r3;
    Ellipse e1, e2, e3;

    RectEllipseFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Rect + Ellipse");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30,0,255,255,0,0,204);
        this.r2 = new Rect(100,100, 30,100,255,102,178,51,0,25);
        this.r3 = new Rect(150,150, 50,80,178,102,255,25,0,51);
        this.e1 = new Ellipse(200,50, 100,30,255,102,102,51,0,0);
        this.e2 = new Ellipse(250,100, 30,100,255,255,102,102,204,0);
        this.e3 = new Ellipse(300,150, 100,50,51,255,153,0,153,0);
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
        this.e1.paint(g);
        this.e2.paint(g);
        this.e3.paint(g);
    }
}

class Rect {
    int x, y;
    int w, h;
    int r, g, b;
    int Drawr, Drawg, Drawb;

    Rect (int x, int y, int w, int h, int r, int g, int b, int Drawr, int Drawg, int Drawb) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r = r;
        this.g = g;
        this.b = b;
        this.Drawr = Drawr;
        this.Drawg = Drawg;
        this.Drawb = Drawb;
    }

    void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r,this.g,this.b));
        g2d.fillRect(this.x,this.y, this.w,this.h);
        g2d.setColor(new Color(this.Drawr,this.Drawg,this.Drawb));
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}

class Ellipse {
    int x, y;
    int w, h;
    int r, g, b;
    int Drawr, Drawg, Drawb;

    Ellipse (int x, int y, int w, int h, int r, int g, int b, int Drawr, int Drawg, int Drawb) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.r = r;
        this.g = g;
        this.b = b;
        this.Drawr = Drawr;
        this.Drawg = Drawg;
        this.Drawb = Drawb;
    }

    void print () {
        System.out.format("Elipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(this.r,this.g,this.b));
        g2d.fillOval(this.x,this.y, this.w,this.h);
        g2d.drawOval(this.x,this.y, this.w,this.h);
        g2d.setColor(new Color(this.Drawr,this.Drawg,this.Drawb));
        g2d.drawOval(this.x,this.y, this.w,this.h);
    }
}
