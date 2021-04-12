package figures;

import java.awt.*;

public class Rect extends Figure {
    private int w, h;

    public Rect (int x, int y, int w, int h, int r, int g, int b, int Drawr, int Drawg, int Drawb) {
        super(x,y, r,g,b, Drawr,Drawg,Drawb);
        this.w = w;
        this.h = h;
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