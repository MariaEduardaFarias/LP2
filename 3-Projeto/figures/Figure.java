package figures;

import ivisible.IVisible;
import java.io.Serializable;

public abstract class Figure implements IVisible, Serializable {
    public int x, y;
    public int w, h;
    public int r, g, b;
    public int Drawr, Drawg, Drawb;
	
    public Figure (int x, int y, int w, int h, int r, int g, int b, int Drawr, int Drawg, int Drawb){
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
	
    public void drag (int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    
    public void resize (int dw, int dh) {
	this.w += dw;
	this.h += dh;
    }
	
    public void fundo (int r, int g, int b) {
	this.r = r;
	this.g = g;
	this.b = b;
    }
	
    public void contorno (int Drawr, int Drawg, int Drawb) {
	this.Drawr = Drawr;
	this.Drawg = Drawg;
	this.Drawb = Drawb;
    }
	
    public boolean clicked (int x, int y) {
        return (this.x<=x && x<=this.x+this.w && this.y<=y && y<=this.y+this.h);
    }
}
