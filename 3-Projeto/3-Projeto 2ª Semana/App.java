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
                        }
					}
				}
			}
		);	

		/*this.addMouseMotionListener(
			new MouseMotionAdapter() {
				public void mouseDragged (MouseEvent evt) {
					
				}
			}
		);*/	


        this.addKeyListener (
            new KeyAdapter() {
                public void keyPressed (KeyEvent evt) {
					int x = rand.nextInt(350);
                    int y = rand.nextInt(350);
                    int w = rand.nextInt(50);
                    int h = rand.nextInt(50);
					int ctrx = rand.nextInt(100);
					int ctry = rand.nextInt(100);
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
						figs.add(new QuadCurve(x,y, ctrx,ctry, w,h, r,g,b, Drawr,Drawg,Drawb));
					}
					else if (evt.getKeyChar() == 'a') {
						figs.add(new Arc(x,y, w,h, AngleI,AngleF, r,g,b, Drawr,Drawg,Drawb));
					}
					else if (evt.getKeyCode() == KeyEvent.VK_DELETE) { 
						for (Figure fig: figs) {
							if (focus == fig) {
								figs.remove(fig);
								focus = null;
								repaint();
							}
						}
					}	
					repaint();
                }
            }
        );

        this.setTitle("Projeto");
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
			g2d.drawRect(focus.x-4, focus.y-4, focus.w+8, focus.h+8);
			focus.paint(g);	//Z-order
		}	
    }
}