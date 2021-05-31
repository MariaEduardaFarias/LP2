import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

import figures.*;

class App {
    public static void main (String[] args) {
        ListFrame frame = new ListFrame();
        frame.setVisible(true);
    }
}

class ListFrame extends JFrame {
    ArrayList<Figure> figs = new ArrayList<Figure>();
    ArrayList<Button> buts = new ArrayList<Button>();
    Figure focus = null;
    Button focus_but = null;
    Random rand = new Random();
    int idx;

    ListFrame () {
	try {
	    FileInputStream f = new FileInputStream("proj.bin");
	    ObjectInputStream o = new ObjectInputStream(f);
	    this.figs = (ArrayList<Figure>) o.readObject();
	    o.close();
	} catch (Exception x) {
	    System.out.println("ERRO!");
	}
	    
        this.addWindowListener (
            new WindowAdapter() {
                public void windowClosing (WindowEvent e) {
		    try {
		        FileOutputStream f = new FileOutputStream("proj.bin");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(figs);
			o.flush();
			o.close();
		    } catch (Exception x) {
		    }
                    System.exit(0);
                }
            }
        );
	
	setFocusTraversalKeysEnabled(false);
	    
	buts.add(new Button(1, new Rect(0,0,0,0,0,0,0,0,0,0)));
	buts.add(new Button(2, new Ellipse(0,0,0,0,0,0,0,0,0,0)));
	buts.add(new Button(3, new Arc(0,0,0,0,180,250,0,0,0,0,0,0)));
	buts.add(new Button(4, new RoundRect(0,0,0,0,20,15,0,0,0,0,0,0)));
	
	this.addMouseListener(
	    new MouseAdapter() {
		public void mousePressed (MouseEvent evt) {  //seleciona a figura
		    focus = null;
		    focus_but = null;
		    int x = evt.getX();
		    int y = evt.getY();
		    for (Figure fig: figs) {
		        if (fig.clicked(x,y)) {
			    focus = fig;
			    repaint();
			    break;
                        }
			else {
			    focus = null;
			    repaint();
			}
		    }
		    for (Button but: buts) {
		        if (but.clicked(x,y)) {
			    focus_but = but;
			    repaint();
			    break;
			}
		    }
			
		    if (focus_but != null) {
		        if (focus_but.idx == 1) {
			    idx = 1;
			}
			else if (focus_but.idx == 2) {
			    idx = 2;
			}
			else if (focus_but.idx == 3) {
			    idx = 3;
			}
			else if (focus_but.idx == 4) {
			    idx = 4;
			}
		    }
		    repaint();
			
		    if ((focus_but == null) && (focus == null)) {
		        if (idx == 1) {
			    figs.add(new Rect(x,y, rand.nextInt(50),rand.nextInt(50),0,0,0,0,0,0));
			    focus = figs.get(figs.size()-1); //figura surge em foco
			}
			else if (idx == 2) {
			    figs.add(new Ellipse(x,y, rand.nextInt(50),rand.nextInt(50),0,0,0,0,0,0));
			    focus = figs.get(figs.size()-1);
			}
			else if (idx == 3) {
			    figs.add(new Arc(x,y, rand.nextInt(50),rand.nextInt(50), rand.nextInt(180),rand.nextInt(280),0,0,0,0,0,0));
			    focus = figs.get(figs.size()-1);
			}
			else if (idx == 4) {
			    figs.add(new RoundRect(x,y, rand.nextInt(50),rand.nextInt(50),20,15,0,0,0,0,0,0));
			    focus = figs.get(figs.size()-1);
			}
			idx = 0;
		    }
		    repaint();
		}
	    }
	);
	
	this.addMouseMotionListener(
	    new MouseMotionAdapter() {
	        public void mouseDragged (MouseEvent evt) {  //move a figura selecionada
		    for (Figure fig: figs) {
		        if (focus == fig) {
			    focus.x = evt.getX()-focus.w/2;
			    focus.y = evt.getY()-focus.h/2;
			    repaint();
			}
		    }
		}
	    }
	);

        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
		    Point pos = getMousePosition();
		    int x = pos.x;
                    int y = pos.y;
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
		    int arcW = 20;
		    int arcH = 15;
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
                    	focus = figs.get(figs.size()-1);
		    }
		    else if (evt.getKeyChar() == 'e') {
                        figs.add(new Ellipse(x,y, w,h, r,g,b, Drawr,Drawg,Drawb));
		    	focus = figs.get(figs.size()-1);
		    }
		    else if (evt.getKeyChar() == 'a') {
		        figs.add(new Arc(x,y, w,h, AngleI,AngleF, r,g,b, Drawr,Drawg,Drawb));
		    	focus = figs.get(figs.size()-1);
		    }
		    else if (evt.getKeyChar() == 'o') {
		        figs.add(new RoundRect(x,y, w,h, arcW,arcH, r,g,b, Drawr,Drawg,Drawb));
		    	focus = figs.get(figs.size()-1);
		    }
	            for (Figure fig: figs) {
		        if (focus == fig) {
			    if (evt.getKeyCode() == KeyEvent.VK_DELETE) { //deleta a figura selecionada
			        figs.remove(fig);
				focus = null;
				repaint();
				break;
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
			else if (evt.getKeyCode() == KeyEvent.VK_TAB) { //muda o foco
			    focus = fig;
			    figs.remove(fig);
			    figs.add(fig);
			    break;
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
            fig.paint(g, false);
        }
	
	if (focus != null) {  //foca as figuras
	    focus.paint(g, true);  //Z-order
	}
	for (Button but: this.buts) {
	    but.paint(g, but == focus_but);
	}
    }
}
