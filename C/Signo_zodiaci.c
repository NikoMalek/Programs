#include <stdio.h>
#include <string.h>
int main() {
  int a;
  char c[7];
  printf("Listado de signos del zodiaco:\n\n 1. Aries\n 2. Tauro\n 3. Geminis\n 4. Cancer\n 5. Leo\n 6. Virgo\n 7. Libra\n 8. Escorpio\n 9. Sagitario\n 10. Capricornio\n 11. Acuario\n 12. Piscis\n  Introduzca numero de signo: ");
  scanf("%d", &a);
  if (a>0 && a<=12){
  switch(a%4){
    case 0 : strcpy(c, "Agua");
    break;
    case 1 : strcpy(c, "Fuego");
    break;
    case 2 : strcpy(c, "Tierra");
    break;
    case 3 : strcpy(c, "Aire");
    break;
  }
    printf("Es un signo %s", c);
  }
  else{
    printf("ERROR: %d no esta asociado a ningun signo.");
  }
  return 0;
}