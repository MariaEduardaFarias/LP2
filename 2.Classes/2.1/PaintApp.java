import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintApp {
    public static void main (String[] args) {
        PaintFrame frame = new PaintFrame();
        frame.setVisible(true);
    }
}

class PaintFrame extends JFrame {
    Rect r1, r2, r3;
	
    PaintFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
        this.setTitle("Painting Figures");
        this.setSize(350, 350);
        this.r1 = new Rect(50,50, 100,30,0,255,255,0,0,204);
        this.r2 = new Rect(100,100, 30,100,255,102,178,51,0,25);
        this.r3 = new Rect(150,150, 50,80,178,102,255,25,0,51);
		
    }

    public void paint (Graphics g) {
        super.paint(g);
        this.r1.paint(g);
        this.r2.paint(g);
        this.r3.paint(g);
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
