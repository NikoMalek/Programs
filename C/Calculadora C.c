#include <stdio.h>
//Calculadora en C
int main()
{
    int a;
    printf("Ingrese numero: ");
    scanf("%d", &a);
    int b;
    printf("Ingrese otro numero: ");
    scanf("%d", &b);
    int c;
    printf("Elija opetacion\n 1.- Suma\n 2.- Resta\n 3.- Multiplicacion\n Elija un numero: ");
    scanf("%d", &c);
    int d;
    if(c==1){
        d = a+b;
        printf("%d", d);
    }
    else if(c==2){
        d = a-b;
        printf("%d", d);}
        
    else{
        d = a*b;
        printf("%d", d);
    }
    return 0;
}