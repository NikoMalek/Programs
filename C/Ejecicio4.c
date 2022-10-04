#include <stdio.h>
int main(){
    int list[5];
    int i,a,x;
    for (i=0; i<5; i++){
	    printf("Para la posicion %d, ingrese su valor: ",i);
        scanf("%d",&list[i]);
    
	}

    for (i=0; i<5; i++){
        for (a=0; a<5; a++){
            if (list[i]<list[a]){
                x = list[a];
                list[a] = list[i];
                list[i] = x;
            }

        }
    }
    for(i=0; i<5; i++){
        printf("\nPosicion %d es: %d\n",i,list[i]);
   }


}
