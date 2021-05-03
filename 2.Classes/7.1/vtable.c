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
typedef int (* Figure_Area) (struct Figure*);
typedef int (* Figure_Perimetro) (struct Figure*);

typedef struct {
	void (* print) (struct Figure*);
	int (* area) (struct Figure*);
	int (* perimetro) (struct Figure*);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    Color fg, bg;
    Figure_vtable* vtable;
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int w, h;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("Retangulo de tamanho (%d,%d) na posicao (%d,%d), area %d e perimetro %d. ",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->perimetro(sup));
    printf("Cor de fundo: "); color_paint(sup->fg);
    printf("; Cor de borda:  "); color_paint(sup->bg);
}

int rect_area (Rect* this) {
	Figure* sup = (Figure*) this;
	return this->w * this->h;
}

int rect_perimetro (Rect* this) {
	Figure* sup = (Figure*) this;
	return 2*this->w + 2*this->h;
}

Figure_vtable rect_vtable = {
	(Figure_Print) rect_print,
    (Figure_Area)  rect_area,
    (Figure_Perimetro) rect_perimetro,
};

Rect* rect_new (int x, int y, int w, int h, int fgr, int fgg, int fgb, int bgr, int bgg, int bgb) {
    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->vtable = &rect_vtable;
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
    printf("\nElipse de tamanho (%d,%d) na posicao (%d,%d), area %d e perimetro %d. ",
           this->w, this->h, sup->x, sup->y, sup->vtable->area(sup), sup->vtable->perimetro(sup));
    printf("Cor de fundo: "); color_paint(sup->fg);
    printf("; Cor de borda:  "); color_paint(sup->bg);
}

int ellipse_area (Ellipse* this) {
	Figure* sup = (Figure*) this;
	return this->w * this->h;
}

int ellipse_perimetro (Ellipse* this) {
	Figure* sup = (Figure*) this;
	return 2*this->w + 2*this->h;
}

Figure_vtable ellipse_vtable = {
	(Figure_Print) ellipse_print,
    (Figure_Area)  ellipse_area,
    (Figure_Perimetro) ellipse_perimetro
};

Ellipse* ellipse_new (int x, int y, int w, int h, int fgr, int fgg, int fgb, int bgr, int bgg, int bgb) {
    Ellipse* this = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->vtable = &ellipse_vtable;
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
    printf("\nArco de tamanho (%d,%d) na posicao (%d,%d), com angulo de (%d,%d) graus, area %d e perimetro %d. ",
           this->w, this->h, sup->x, sup->y, this->AngleI, this->AngleF, sup->vtable->area(sup), sup->vtable->perimetro(sup));
	printf("Cor de fundo: "); color_paint(sup->fg);
    printf("; Cor de borda:  "); color_paint(sup->bg);
}

int arc_area (Arc* this) {
	Figure* sup = (Figure*) this;
	return this->w * this->h;
}

int arc_perimetro (Arc* this) {
	Figure* sup = (Figure*) this;
	return 2*this->w + 2*this->h;
}

Figure_vtable arc_vtable = {
	(Figure_Print) arc_print,
    (Figure_Area)  arc_area,
    (Figure_Perimetro) arc_perimetro
};

Arc* arc_new (int x, int y, int w, int h, int AngleI, int AngleF, int fgr, int fgg, int fgb, int bgr, int bgg, int bgb) {
    Arc* this = malloc(sizeof(Arc));
    Figure* sup = (Figure*) this;
    sup->vtable = &arc_vtable;
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
    printf("\nCurva quadratica com coordenadas (%d,%d) no inicio e (%d,%d) no final. Ponto de controle (%d,%d). Area %d e perimetro %d. ",
           sup->x, sup->y, this->x2, this->y2, this->ctrx, this->ctry, sup->vtable->area(sup), sup->vtable->perimetro(sup));
    printf("Cor de fundo: "); color_paint(sup->fg);
    printf("; Cor de borda:  "); color_paint(sup->bg);
}

int quadCurve_area (QuadCurve* this) {
	Figure* sup = (Figure*) this;
	return (sup->x + this-> x2) * (sup->y + this->y2);
}

int quadCurve_perimetro (QuadCurve* this) {
	Figure* sup = (Figure*) this;
	return 2*sup->x + 2*this->x2 + 2*sup->y + 2*this->y2;
}

Figure_vtable quadCurve_vtable = {
	(Figure_Print) quadCurve_print,
    (Figure_Area)  quadCurve_area,
    (Figure_Perimetro) quadCurve_perimetro
};

QuadCurve* quadcurve_new (int x, int y, int ctrx, int ctry, int x2, int y2, int fgr, int fgg, int fgb, int bgr, int bgg, int bgb) {
    QuadCurve* this = malloc(sizeof(QuadCurve));
    Figure* sup = (Figure*) this;
    sup->vtable = &quadCurve_vtable;
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
        figs[i]->vtable->print(figs[i]);
    }

    ///

    for (i=0; i<4; i++) {
        free(figs[i]);
    }
}
