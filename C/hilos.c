#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void *procesojunto(void *data){
    while (1){
        printf("%s\n",data);
    }
}

int main(){

    pthread_t hola;
    pthread_t mundo;

    pthread_create (&hola, NULL, &procesojunto, "hola");
    pthread_create (&mundo, NULL, &procesojunto, "mundo");
    pthread_join(hola, NULL);
    pthread_join(mundo, NULL);



}