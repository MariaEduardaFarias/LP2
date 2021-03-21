package figures;

import java.awt.*;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.QuadCurve2D.Double;

public class QuadCurve {
    private int x1, y1;
    private int ctrx, ctry;
	private int x2, y2;

    public QuadCurve (int x1, int y1, int ctrx, int ctry, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.ctrx = ctrx;
        this.ctry = ctry;
		this.x2 = x2;
		this.y2 = y2;
    }

    private void print () {
        System.out.format("Curva quadratica com coordenadas (%d,%d) no inicio e (%d,%d) no final. Ponto de controle (%d,%d).\n",
            this.x1, this.y1, this.x2, this.y2, this.ctrx, this.ctry);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(new QuadCurve2D.Double(this.x1,this.y1, this.ctrx,this.ctry,this.x2,this.y2));
    }
}