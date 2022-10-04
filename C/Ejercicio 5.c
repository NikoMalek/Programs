#include <stdio.h>

struct product{
    int code;
    char descripcion [20];
    int price;
};


int main(){

    struct product producto1, producto2;

printf("Ingrece datos producto 1:\n");

    printf("Ingrece codigo: ");
    scanf("%d",&producto1.code);

    printf("Ingrece descripcion: ");
    scanf("%s",&producto1.descripcion);

    printf("Ingrece precio: ");
    scanf("%d",&producto1.price);

printf("\nIngrece datos producto 2:\n");

    printf("Ingrece codigo: ");
    scanf("%d",&producto2.code);

    printf("Ingrece descripcion: ");
    scanf("%s",&producto2.descripcion);

    printf("Ingrece precio: ");
    scanf("%d",&producto2.price);

    if (producto1.price>producto2.price){
        printf("Producto %s es de mayor precio",producto1.descripcion);
    }
    else{
        printf("Producto %s es de mayor precio",producto2.descripcion);
    }

}