#include <stdio.h>

typedef struct {
    int x, y;
    int w, h;
    int voltas;
} Espiral;

void print(Espiral* e) {
    printf("O espiral de tamanho (%d,%d) de %d voltas esta na posicao (%d,%d).\n",
        e->w, e->h, e->voltas, e->x, e->y);
}

int main() {
    Espiral e1 = {16,18,12,12,3};
    print(&e1);
}
