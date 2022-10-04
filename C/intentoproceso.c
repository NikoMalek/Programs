#include <stdio.h>
#include <time.h>
#include <pthread.h>
 

float list[50];
int i;

void algoxd(dato){

    clock_t start = clock();

    pid_t pid1;
    if ( (pid1=fork()) == 0 )
    { /* hijo */
        printf("Soy hijo %d (%d, hijo de %d)\n", dato ,getpid(), getppid());
        
    }
    else if(dato==1)
    { /*  padre */
        printf("Soy el padre de todos: %d\n", getpid());
    
    }
    else{
    }


    list[dato-1] = ((double)clock() - start) / CLOCKS_PER_SEC;
}

void mediatiempo(){
    float suma=0;
    for (i=0;i<5;i++){
        suma+=list[i];        
    }
    float media = suma / 50;
	printf("La media es %f\n", media);
}

int main(){
    int Nhijo=1;
    pthread_t padre;
    for (i=0;i<50;i++){
        pthread_create(&padre,NULL,(void*) algoxd,Nhijo);
        pthread_join(padre,NULL);
        Nhijo++;
    }
    mediatiempo();



}