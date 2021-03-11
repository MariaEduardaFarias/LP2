public class PoligonoApp {
    public static void main (String[] args) {
        Poligono p1 = new Poligono(9,11, 4,3, 6, "tracejado");
        p1.print();
    }
}
class Poligono {
	int x, y;
    int w, h;
	int lados;
	String traco;
    Poligono (int x, int y, int w, int h, int lados, String traco) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
		this.lados = lados;
		this.traco = traco;
	}
	void print () {
		System.out.format("O poligono de %d lados com contorno %s possui tamanho (%d,%d) e esta na posicao (%d,%d).\n",
		    this.lados, this.traco, this.w, this.h, this.x, this.y);
	}
}