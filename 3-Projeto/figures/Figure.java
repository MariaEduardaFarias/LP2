package figures;

import java.awt.Graphics;

public abstract class Figure {
    public int x, y;
    public int r, g, b;
    public int Drawr, Drawg, Drawb;
	
    public Figure (int x, int y, int r, int g, int b, int Drawr, int Drawg, int Drawb){
        this.x = x;
        this.y = y;
        this.r = r;
        this.g = g;
	this.b = b;
	this.Drawr = Drawr;
	this.Drawg = Drawg;
	this.Drawb = Drawb;
    }
	
    public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
	
    public abstract void paint (Graphics g);
}
