package figures;

import java.awt.*;
import java.awt.geom.*;

public class Ellipse extends Figure {
	
    public Ellipse (int x, int y, int w, int h, int r, int g, int b, int Drawr, int Drawg, int Drawb) {
        super(x,y, w,h, r,g,b, Drawr,Drawg,Drawb);
    }

    private void print () {
        System.out.format("Ellipse de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
	
	if (focused) {
	    g2d.setPaint(Color.RED);
	    g2d.drawOval(this.x-3, this.y-3, this.w+6, this.h+6);
	}
	
	g2d.setColor(new Color(this.r,this.g,this.b));
	g2d.fillOval(this.x,this.y, this.w,this.h);
        g2d.drawOval(this.x,this.y, this.w,this.h);
	g2d.setColor(new Color(this.Drawr,this.Drawg,this.Drawb));
	g2d.drawOval(this.x,this.y, this.w,this.h);
    }
}
