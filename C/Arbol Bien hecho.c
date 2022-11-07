#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>



int main (/*int argc, char *argv[]*/) {
    int i;
    int prof, anch, profundidad, anchura;

    //if (argc!= 3) exit(0);
    //profundidad= atoi(argv[1]); /* profundidad */
    //anchura= atoi(argv[2]); /* anchura */
    printf("Ingrese profundidad: ");
    scanf("%d",&profundidad);
    printf("Ingrese anchura: ");
    scanf("%d",&anchura);

    for (prof= 0; prof< profundidad-1; prof++){
        if (fork()!= 0) /* jerarquıa en profundidad */
        {
            break;
        }
    }
    /* if ((prof!= 0) && (prof %2== 0)) */ /*ampliacion */
    for (anch= 0; anch< anchura-1; anch++){
        if (fork()== 0) /* jerarquıa en anchura */
        {
            break;
        }
    }

    printf("Soy el proceso %d y mi padre es %d\n", getpid(), getppid());
    sleep (2);
    return 0;
}
