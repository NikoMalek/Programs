#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>
#include <pthread.h>

#define MAX 6
pthread_mutex_t lock;

void *escribirA (void *nada)
{
  
  int num;
  for (num=0;num<MAX;num++)
  {
    pthread_mutex_lock(&lock);
    printf("A");
    
    pthread_mutex_unlock(&lock);
    fflush(NULL);
    sleep(random()%3);
    
    }
    
    //pthread exit(NULL);
}
void *escribirB (void *nada)
{

  int num;
  for (num=0;num<MAX;num++)
  {
    pthread_mutex_lock(&lock);
    printf("B");
    pthread_mutex_unlock(&lock);
    
    fflush(NULL);
    sleep(random()%2);
    
    }
    //pthread exit(NULL);
}
void *escribirC (void *nada)
{
  
  int num;
  for (num=0;num<MAX;num++)
  {

    pthread_mutex_lock(&lock);
    printf("C");
    
    
    fflush(NULL);
    sleep(random()%1);
    pthread_mutex_unlock(&lock);
    }
    
    //pthread exit(NULL);
}
int main(void) {
  pthread_t th1, th2, th3;
  
  srandom(time(NULL));
  
  pthread_create(&th1, NULL, escribirA, NULL);
  pthread_create(&th2, NULL, escribirB, NULL);
  pthread_create(&th3, NULL, escribirC, NULL);
  pthread_join(th1,NULL);
  pthread_join(th2,NULL);
  pthread_join(th3,NULL);
  return 0;
}