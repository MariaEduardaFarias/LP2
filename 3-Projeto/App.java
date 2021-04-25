import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import figures.*;

class App {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    Figure focus = null;
    Random rand = new Random();

    ListFrame () {
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
                    System.exit(0);
                }
            }
        );
	
	this.addMouseListener(
	    new MouseAdapter() {
		public void mousePressed (MouseEvent evt) {  //seleciona a figura
		    focus = null;
		    for (Figure fig: figs) {
		        if ((fig.x <= evt.getX() && (fig.x + fig.w) >= evt.getX()) && (fig.y <= evt.getY() && (fig.y + fig.h) >= evt.getY())) {
			    focus = fig;
			    repaint();
			    break;
                        }
			else {
			    focus = null;
			    repaint();
			}
		    }
		}
	    }
	);
	
	this.addMouseMotionListener(
	    new MouseMotionAdapter() {
	        public void mouseDragged (MouseEvent evt) {  //move a figura selecionada
		    for (Figure fig: figs) {
		        if (focus == fig) {
			    fig.drag(evt.getX()-focus.x, evt.getY()-focus.y);
			    repaint();
			}
		    }
		}
	    }
	);

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
		    int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
		    int ctrx = rand.nextInt(350);
		    int ctry = rand.nextInt(350);
		    int x2 = rand.nextInt(350);
		    int y2 = rand.nextInt(350);
		    int AngleI = rand.nextInt(180);
		    int AngleF = rand.nextInt(280);
		    int r = rand.nextInt(255);
                    int g = rand.nextInt(255);
                    int b = rand.nextInt(255);
                    int Drawr = rand.nextInt(255);
		    int Drawg = rand.nextInt(255);
		    int Drawb = rand.nextInt(255);
		    
                    if (evt.getKeyChar() == 'r') {
                        figs.add(new Rect(x,y, w,h, r,g,b, Drawr,Drawg,Drawb));
                    }
		    else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h, r,g,b, Drawr,Drawg,Drawb));
		    }
		    else if (evt.getKeyChar() == 'q') {
		        figs.add(new QuadCurve(x,y, ctrx,ctry, x2,y2, r,g,b, Drawr,Drawg,Drawb));
		    }
		    else if (evt.getKeyChar() == 'a') {
		        figs.add(new Arc(x,y, w,h, AngleI,AngleF, r,g,b, Drawr,Drawg,Drawb));
		    }
	            for (Figure fig: figs) {
		        if (focus == fig) {
			    if (evt.getKeyCode() == KeyEvent.VK_DELETE) { //deleta a figura selecionada
			        figs.remove(fig);
				focus = null;
				repaint();
			    }
			    else if (evt.getKeyCode() == KeyEvent.VK_LEFT) {  //seta esquerda - arrasta a figura selecionada para esquerda
				fig.drag(-1,0);
			    }
			    else if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {  //seta direita - arrasta a figura selecionada para direita
				fig.drag(1,0);
			    }
			    else if (evt.getKeyCode() == KeyEvent.VK_UP) {  //seta p/ cima - arrasta a figura selecionada para cima
				fig.drag(0,-1);
			    }
			    else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {  //seta p/ baixo - arrasta a figura selecionada para baixo
				fig.drag(0,1);
			    }
			    else if (evt.getKeyChar() == '+') {  //aumenta o tamanho da figura selecionada
				fig.resize(1,1);
			    }
			    else if (evt.getKeyChar() == '-') {  //diminui o tamanho da figura selecionada
				fig.resize(-1,-1);
			    }
			    else if (evt.getKeyChar() == 'f') {  //muda cor de fundo da figura selecionada
				fig.fundo(r,g,b);
			    }
			    else if (evt.getKeyChar() == 'c') {  //muda cor de contorno da figura selecionada
				fig.contorno(Drawr,Drawg,Drawb);
			    }
			}
		    }
		    repaint();
                }
            }
        );

        this.setTitle("Projeto - Editor Grafico");
        this.setSize(350, 350);
    }

    public void paint (Graphics g) {
        super.paint(g);
	Graphics2D g2d = (Graphics2D) g;
        for (Figure fig: this.figs) {
            fig.paint(g);
        }
	
	if (focus != null) {  //foca as figuras
	    g2d.setColor(Color.RED);
	    g2d.drawRect(focus.x-3, focus.y-3, focus.w+6, focus.h+6);
	    focus.paint(g);  //Z-order
	}
    }
}
