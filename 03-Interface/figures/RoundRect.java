package figures;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.RoundRectangle2D.Double;

public class RoundRect extends Figure {
	private int arcW, arcH;

    public RoundRect (int x, int y, int w, int h, int arcW, int arcH, int r, int g, int b, int Drawr, int Drawg, int Drawb) {
        super(x,y, w,h, r,g,b, Drawr,Drawg,Drawb);
		this.arcW = arcW;
		this.arcH = arcH;
    }

    private void print () {
        System.out.format("Retangulo redondo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(this.r,this.g,this.b));
		g2d.fill(new RoundRectangle2D.Double(this.x,this.y, this.w,this.h, this.arcW,this.arcH));
        g2d.setColor(new Color(this.Drawr,this.Drawg,this.Drawb));
        g2d.draw(new RoundRectangle2D.Double(this.x,this.y, this.w,this.h, this.arcW,this.arcH));
    }
}