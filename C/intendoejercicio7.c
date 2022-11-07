#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>

int list[10];

void hilospro (dato){ 
    int a;
    /* Al generarse todos los hilos al mismo timepo estos dan el mismo dato*/
    sleep(dato);/*Se duerme el programa dato segundos(el cual en el primer hilo 0segundos, en el siguiente 1,segundo, y asi sucesivamente)*/
    srand(time(NULL));/*con srand hace que cambie el numero random segun el instante de tiempo en que se ejecute */
    printf("Numero: %d\n",a=rand()%20+1);
    list[dato] = a;
}

void suma(){
int x=0;
    for(int i=0; i<10; i++){
            x=x+list[i];
        }
    printf("Suma total: %d", x);

}

int main (){

pthread_t p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,pf;

pthread_create(&p1,NULL,(void*) hilospro,0);
pthread_create(&p2,NULL,(void*) hilospro,1);
pthread_create(&p3,NULL,(void*) hilospro,2);
pthread_create(&p4,NULL,(void*) hilospro,3);
pthread_create(&p5,NULL,(void*) hilospro,4);
pthread_create(&p6,NULL,(void*) hilospro,5);
pthread_create(&p7,NULL,(void*) hilospro,6);
pthread_create(&p8,NULL,(void*) hilospro,7);
pthread_create(&p9,NULL,(void*) hilospro,8);
pthread_create(&p10,NULL,(void*) hilospro,9);


pthread_join(p1,NULL);
pthread_join(p2,NULL);
pthread_join(p3,NULL);
pthread_join(p4,NULL);
pthread_join(p5,NULL);
pthread_join(p6,NULL);
pthread_join(p7,NULL);
pthread_join(p8,NULL);
pthread_join(p9,NULL);
pthread_join(p10,NULL);



pthread_create(&pf,NULL,(void*) suma,NULL);
pthread_join(pf,NULL);








}

