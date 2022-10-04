#include <stdio.h>

int main (){
    int a, b;
    printf("Introduzca un numero entero: ");
    scanf("%d",&a);
    printf("Introduzca otro numero entero: ");
    scanf("%d",&b);
    
    if(a<b){
        printf("%d es menor que %d",a,b);
    }
    else 
        printf("%d es menor que %d",b,a);

}