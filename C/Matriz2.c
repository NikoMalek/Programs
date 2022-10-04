#include <stdio.h>

void cargarm (int mat[2][2]){
    int n,c,x,y;
    printf("Ingrese Filas: ");
    scanf("%d",&x);
    printf("Ingrese Columnas: ");
    scanf("%d",&y);
    for (n=0; n < x; n++)
    {
        for (c=0;  c < y; c++)
        {
            printf("Ingrese algo: ");
            scanf("%i",&mat[n][c]);
        }
    }
}
void mostrar(int mat[2][2]){
    int n,c,x,y;
    for (n = 0; n < x; n++)
    {
        for (c=0;c < y; c++)
        {
            printf("%i ",mat[n][c]);
        } 
        printf("\n");
    }
        
}

int main(){
    int mat[2][2];
    cargarm(mat);
    mostrar(mat);
    
    return 0;
}
    
