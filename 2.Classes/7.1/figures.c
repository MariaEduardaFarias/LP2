#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int r,g,b;
} Color;

Color color_new(int r, int g, int b) {
	Color cor;
	cor.r = r;
	cor.g = g;
	cor.b = b;
	return cor;
}

void color_paint(Color cor) {
	int r = cor.r;
	int g = cor.g;
	int b = cor.b;
	if(r == 0 && g == 0 && b == 0){
        printf("preto");
	}
	else if(r == 0 && g == 0 && b == 255){
        printf("azul ");
	}
}

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    Color fg, bg;
    void (* print) (struct Figure*);
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d). ",
           this->w, this->h, sup->x, sup->y);
    printf("Cor de fundo: "); color_paint(sup->fg);
    printf("; Cor de borda: "); color_paint(sup->bg);
}

Rect* rect_new (int x, int y, int w, int h, int fgr, int fgg, int fgb, int bgr, int bgg, int bgb) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_print;
    sup->x = x;
    sup->y = y;
    sup->fg = color_new(fgr,fgg,fgb);
    sup->bg = color_new(bgr,bgg,bgb);
    this->w = w;
    this->h = h;
    return this;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Ellipse;

void ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("\nElipse de tamanho (%d,%d) na posicao (%d,%d). ",
           this->w, this->h, sup->x, sup->y);
    printf("Cor de fundo: "); color_paint(sup->fg);
    printf("; Cor de borda: "); color_paint(sup->bg);
}

Ellipse* ellipse_new (int x, int y, int w, int h, int fgr, int fgg, int fgb, int bgr, int bgg, int bgb) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) ellipse_print;
    sup->x = x;
    sup->y = y;
    sup->fg = color_new(fgr,fgg,fgb);
    sup->bg = color_new(bgr,bgg,bgb);
    this->w = w;
    this->h = h;
    return this;
}

///////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
    int AngleI, AngleF;
} Arc;

void arc_print (Arc* this) {
    Figure* sup = (Figure*) this;
    printf("\nArco de tamanho (%d,%d) na posicao (%d,%d) e com angulo de (%d,%d) graus. ",
           this->w, this->h, sup->x, sup->y, this->AngleI, this->AngleF);
    printf("Cor de fundo: "); color_paint(sup->fg);
    printf("; Cor de borda: "); color_paint(sup->bg);
}

Arc* arc_new (int x, int y, int w, int h, int AngleI, int AngleF, int fgr, int fgg, int fgb, int bgr, int bgg, int bgb) {
    Arc* this = malloc(sizeof(Arc));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) arc_print;
    sup->x = x;
    sup->y = y;
    sup->fg = color_new(fgr,fgg,fgb);
    sup->bg = color_new(bgr,bgg,bgb);
    this->w = w;
    this->h = h;
    this->AngleI = AngleI;
    this->AngleF = AngleF;
    return this;
}

///////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int ctrx, ctry;
    int x2, y2;
} QuadCurve;

void quadCurve_print (QuadCurve* this) {
    Figure* sup = (Figure*) this;
    printf("\nCurva quadratica com coordenadas (%d,%d) no inicio e (%d,%d) no final. Ponto de controle (%d,%d). ",
           sup->x, sup->y, this->x2, this->y2, this->ctrx, this->ctry);
    printf("Cor de fundo: "); color_paint(sup->fg);
    printf("; Cor de borda: "); color_paint(sup->bg);
}

QuadCurve* quadcurve_new (int x, int y, int ctrx, int ctry, int x2, int y2, int fgr, int fgg, int fgb, int bgr, int bgg, int bgb) {
    QuadCurve* this = malloc(sizeof(QuadCurve));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) quadCurve_print;
    sup->x = x;
    sup->y = y;
    sup->fg = color_new(fgr,fgg,fgb);
    sup->bg = color_new(bgr,bgg,bgb);
    this->ctrx = ctrx;
    this->ctry = ctry;
    this->x2 = x2;
    this->y2 = y2;
    return this;
}

///////////////////////////////////////////////////////////////////////////////

void main (void) {
    Figure* figs[4] = {
        (Figure*) rect_new(10,10,100,100,0,0,255,0,0,0),
        (Figure*) ellipse_new(40,10,140,300,0,0,255,0,0,0),
        (Figure*) arc_new(30,30,100,100,0,150,0,0,255,0,0,0),
        (Figure*) quadcurve_new(20,20,100,50,80,20,0,0,255,0,0,0)
    };

    ///
	int i;
    for (i=0; i<4; i++) {
        figs[i]->print(figs[i]);
    }

    ///

    for (i=0; i<4; i++) {
        free(figs[i]);
    }
}
