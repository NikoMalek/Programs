#include <stdio.h>
#include <stdlib.h>
#include <math.h>


int main(){
	
	//Crear un arreglo
	float grupo[10];
	int i;
 
	//Asignar valores directamente a cada ubicación
	grupo[0] = 0;
	grupo[1] = 0;
	grupo[2] = 0;
 
 
	// Poner todas las ubicaciones en cero
	for (i=0; i<10; i++){
		grupo[i] = 0;
 
	}
	
	//float personas[] = {70,80,100};7
 
	// Mostrar el contenido de cada ubicación
	for (i=0; i<10; i++){
	  printf("En posicion %d el valor es %f\n", i, grupo[i]);
	}
 
	grupo[0] = 70;
	grupo[1] = 90;
	grupo[2] = 100;
 
	for (i=0; i<10; i++){
	  printf("En posicion %d el valor es %f\n", i, grupo[i]);
	}
 
 
	//Leer datos y guardarlos en el arreglo
	for(i=0; i<10; i++){
		printf("\nEscriba el valor %d: ", i);
		scanf("%f", &grupo[i]);
 
	}
 
	system("clear"); // reemplace clear por cls si usas windows
 
	for (i=0; i<10; i++){
	  printf("En posicion %d el valor es %f\n", i, grupo[i]);
	}
 
	// Sumar todos los datos de un arreglo
	float suma =0;
	for(i=0; i<10; i++){
		suma+=grupo[i];
	}
	float media = suma / 10;
	printf("La media es %.2f", media);
 
	//Obtener el valor máximo y mínimo de un arreglo	
	float max=grupo[0];
	for(i=0; i<10; i++){
		if (grupo[i] > max){
			max=grupo[i];
		}
	}
	printf("El valor máximo es %.2f", max);
 
 
 
	float min=grupo[0];
	for(i=0; i<10; i++){
		if (grupo[i] < min){
			min=grupo[i];
		}
	}
	printf("El valor minimo es %.2f", min);
 
 
	/*
	
	A cada numero se le resta la media
	El resultado se eleva al cuadrado
	Se suman todos los cuadrados
	Se dividen entre n
	Se saca la raiz cuadrada
	*/
 
	// Ejemplo: obtener la desviación estándar
	float diferencia, cuadrado, total, varianza, devest;
 
	for (i=0; i<10; i++){
		diferencia = grupo[i]-media;
		cuadrado = diferencia * diferencia;
		total+=cuadrado;
	}
	varianza = total/10;
	devest = sqrt(varianza);
	printf("La desviacion estándar es: %.4f", devest);
 
 
}