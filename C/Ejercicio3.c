#include <stdio.h>
#include <math.h>


int main(){
    
    float a,b,c,p;
    printf("Introdusca lado 1: ");
    scanf("%f",&a);
    printf("Introdusca lado 2: ");
    scanf("%f",&b);
    printf("Introdusca lado 3: ");
    scanf("%f",&c);

    if (a==b && a==c){
        printf("Equilatero\n");
        p = (a+b+c)/2;
        printf("%.3f",sqrt(p*(p-a)*(p-b)*(p-c)));
    }
    else if (a != b && a!=c && b!= c){
        printf("Escaleno\n");
        p = (a+b+c)/2;
        printf("%.3f",sqrt(p*(p-a)*(p-b)*(p-c)));
    }
    else{
        printf("Isosceles\n");

        p = (a+b+c)/2;

        printf("%.3f",sqrt(p*(p-a)*(p-b)*(p-c)));

        
    }
}