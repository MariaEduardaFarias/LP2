import ivisible.IVisible;
import figures.Figure;
import java.awt.*;

public class Button implements IVisible {
    public int idx;
    private Figure fig;
	
    public Button (int idx, Figure fig) {
        this.idx = idx;
	this.fig = fig;
	this.fig.x = 24;
	this.fig.y = 24+idx*40;
	this.fig.w = 40-4*2;
	this.fig.h = 40-4*2;
    }

    public boolean clicked (int x, int y) {
	return (20<=x && x<=20+40 && 20+this.idx*40<=y && y<=20+this.idx*40+40);
    }

    public void paint (Graphics g, boolean focused) {
	Graphics2D g2d = (Graphics2D) g;

	if (focused) {
	    g2d.setColor(Color.GRAY);
	}
	else {
	    g2d.setColor(Color.LIGHT_GRAY);
	}
	g2d.fillRect(20, 20+this.idx*40, 40, 40);

	g2d.setColor(Color.BLACK);
	g2d.drawRect(20, 20+this.idx*40, 40, 40);

	this.fig.paint(g, false);
    }
}
