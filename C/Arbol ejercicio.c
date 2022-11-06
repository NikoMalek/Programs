#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>

void procesos(s){
int j;
for(j=0;j<s;j++)
  if (fork()==0){
    printf("Soy hijo(%d, hijo de %d)\n",getpid(),getppid());
    
    }
  }

int main() {
  int i,a,b,dato=1,c,n;
  printf("Profundidad cantidad de papus: ");
  scanf("%d",&a);
  printf("Anchura cantidad de Hijos (se cuenta al papu): ");
  scanf("%d",&b);
for (c=0;c<a;c++){
  if (fork()==0){
    printf("Soy hijo(%d, hijo de %d)\n",getpid(),getppid());
    if (c==0){
      for(n=0;n<b;n++){
      procesos(b);
        break;
        }
    }
    break;
  }
    
  
  }
  while(1);
}