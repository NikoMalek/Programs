#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <pthread.h>
#include <semaphore.h>

#define MAX 6

sem_t A,B,C;

void *escribirA (void *nada)
{
  
  int num;
  for (num=0;num<MAX;num++)
  {
    sem_wait(&A); /* Semaforo que bloquea que se siga ejecutando hasta que se ejecute sem_post(&A);*/
    printf("A");
    fflush(NULL);
    sleep(random()%3);
    sem_post(&B); /* Semaforo que desbloquea sem_wait(&B);*/
    
    }
    
    //pthread exit(NULL);
}
void *escribirB (void *nada)
{

  int num;
  for (num=0;num<MAX;num++)
  {
    sem_wait(&B); /* Semaforo que bloquea que se siga ejecutando hasta que se ejecute sem_post(&B);*/
    printf("B");
    fflush(NULL);
    sleep(random()%2);
    sem_post(&C); /* Semaforo que desbloquea sem_wait(&C);*/
    }
    //pthread exit(NULL);
}
void *escribirC (void *nada)
{
  
  int num;
  for (num=0;num<MAX;num++)
  {
    sem_wait(&C); /* Semaforo que bloquea que se siga ejecutando hasta que se ejecute sem_post(&C);*/
    printf("C");
    fflush(NULL);
    sleep(random()%1);
    sem_post(&A); /* Semaforo que desbloquea sem_wait(&A);*/
    }
    
    //pthread exit(NULL);
}
int main(void) {
  pthread_t th1, th2, th3;
  
  srandom(time(NULL));

    sem_init (&A, 0, 1); /* habilitado */ /*Habilita que al iniciar el programa sem_wait(&A); este desbloqueado en una primera instancia (Este se vuelve a bloquear al volverse a ejecutar sem_wait(&A); al repetirse el ciclo for)*/
    sem_init (&B, 0, 0); /* no habilitado */ /*Solo indica que no esta habilitado en un inicio*/
    sem_init (&C, 0, 0); /* no habilitado */ /*Solo indica que no esta habilitado en un inicio*/
  
  pthread_create(&th1, NULL, escribirA, NULL);
  pthread_create(&th2, NULL, escribirB, NULL);
  pthread_create(&th3, NULL, escribirC, NULL);
  pthread_join(th1,NULL);
  pthread_join(th2,NULL);
  pthread_join(th3,NULL);

  sem_destroy(&A); /*Finaliza los semaforos*/
  sem_destroy(&B);
  sem_destroy(&C);

  return 0;
}
