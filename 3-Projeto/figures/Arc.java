package figures;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Arc2D.Double;

public class Arc extends Figure {
    private int AngleI, AngleF;

    public Arc (int x, int y, int w, int h, int AngleI, int AngleF, int r, int g, int b, int Drawr, int Drawg, int Drawb) {
        super(x,y, w,h, r,g,b, Drawr,Drawg,Drawb);
        this.AngleI = AngleI;
        this.AngleF = AngleF;
    }

    private void print () {
        System.out.format("Arco de tamanho (%d,%d) na posição (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g, boolean focused) {
        Graphics2D g2d = (Graphics2D) g;
	
	if (focused) {
	    g2d.setPaint(Color.RED);
	    g2d.draw(new Arc2D.Double(this.x-3,this.y-3, this.w+6,this.h+6, this.AngleI,this.AngleF, Arc2D.PIE));
        }
	
	g2d.setColor(new Color(this.r,this.g,this.b));
	g2d.fill(new Arc2D.Double(this.x,this.y, this.w,this.h, this.AngleI,this.AngleF, Arc2D.PIE));
        g2d.draw(new Arc2D.Double(this.x,this.y, this.w,this.h, this.AngleI,this.AngleF, Arc2D.PIE));
	g2d.setColor(new Color(this.Drawr,this.Drawg,this.Drawb));
        g2d.draw(new Arc2D.Double(this.x,this.y, this.w,this.h, this.AngleI,this.AngleF, Arc2D.PIE));
    }
}
