package figures;

import java.awt.*;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.QuadCurve2D.Double;

public class QuadCurve extends Figure {
    private int ctrx, ctry;
    private int x2, y2;

    public QuadCurve (int x, int y, int ctrx, int ctry, int x2, int y2, int w, int h, int r, int g, int b, int Drawr, int Drawg, int Drawb) {
        super(x,y, w,h, r,g,b, Drawr,Drawg,Drawb);
        this.ctrx = ctrx;
        this.ctry = ctry;
	this.x2 = x2;
	this.y2 = y2;
    }

    private void print () {
        System.out.format("Curva quadratica com coordenadas (%d,%d) no inicio e (%d,%d) no final. Ponto de controle (%d,%d).\n",
            this.x, this.y, this.x2, this.y2, this.ctrx, this.ctry);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(new Color(this.r,this.g,this.b));
	g2d.fill(new QuadCurve2D.Double(this.x,this.y, this.ctrx,this.ctry,this.x2,this.y2));
        g2d.draw(new QuadCurve2D.Double(this.x,this.y, this.ctrx,this.ctry,this.x2,this.y2));
	g2d.setColor(new Color(this.Drawr,this.Drawg,this.Drawb));
        g2d.draw(new QuadCurve2D.Double(this.x,this.y, this.ctrx,this.ctry,this.x2,this.y2));
    }
}
