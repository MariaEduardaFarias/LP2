package figures;

import java.awt.*;

public class Rect extends Figure {
    private int x, y;
    private int w, h;
    private int r, g, b;
    private int Drawr, Drawg, Drawb;

    public Rect (int x, int y, int w, int h, int r, int g, int b, int Drawr, int Drawg, int Drawb) {
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

    private void print () {
        System.out.format("Retangulo de tamanho (%d,%d) na posicao (%d,%d).\n",
            this.w, this.h, this.x, this.y);
    }

    public void paint (Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
	g2d.setColor(new Color(this.r,this.g,this.b));
	g2d.fillRect(this.x,this.y, this.w,this.h);
        g2d.setColor(new Color(this.Drawr,this.Drawg,this.Drawb));
        g2d.drawRect(this.x,this.y, this.w,this.h);
    }
}
