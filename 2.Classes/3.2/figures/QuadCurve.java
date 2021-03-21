package figures;

import java.awt.*;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.QuadCurve2D.Double;

public class QuadCurve {
    private int x1, y1;
    private int ctrx, ctry;
	private int x2, y2;
	private int r, g, b;
	private int Drawr, Drawg, Drawb;

    public QuadCurve (int x1, int y1, int ctrx, int ctry, int x2, int y2,int r, int g, int b, int Drawr, int Drawg, int Drawb) {
        this.x1 = x1;
        this.y1 = y1;
        this.ctrx = ctrx;
        this.ctry = ctry;
		this.x2 = x2;
		this.y2 = y2;
		this.r = r;
		this.g = g;
		this.b = b;
		this.Drawr = Drawr;
		this.Drawg = Drawg;
		this.Drawb = Drawb;
    }

    private void print () {
        System.out.format("Curva quadratica com coordenadas (%d,%d) no inicio e (%d,%d) no final. Ponto de controle (%d,%d).\n",
            this.x1, this.y1, this.x2, this.y2, this.ctrx, this.ctry);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(this.r,this.g,this.b));
		g2d.fill(new QuadCurve2D.Double(this.x1,this.y1, this.ctrx,this.ctry,this.x2,this.y2));
        g2d.draw(new QuadCurve2D.Double(this.x1,this.y1, this.ctrx,this.ctry,this.x2,this.y2));
		g2d.setColor(new Color(this.Drawr,this.Drawg,this.Drawb));
        g2d.draw(new QuadCurve2D.Double(this.x1,this.y1, this.ctrx,this.ctry,this.x2,this.y2));
    }
}