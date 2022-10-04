#include <stdio.h>

int main() {
  int n;
  printf("Introduzca un numero entero: ");
  scanf("%d",&n);
  if (n%2==0){
    printf("PAR");
    }
  else {
      printf("IMPAR");
  }
  return 0;
}
