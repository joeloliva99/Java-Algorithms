import java.util.Arrays;

public class OrdenacionRapida{
    
    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public static void quicksort(int[] A, int izq, int der) {
    int pivote=A[izq]; // tomamos primer elemento como pivote
    int i=izq; // i realiza la búsqueda de izquierda a derecha
    int j=der; // j realiza la búsqueda de derecha a izquierda
    int aux;
    while (i<j){            // mientras no se crucen las búsquedas
       while (A[i]<=pivote && i<j) i++; // busca elemento mayor que pivote
       while (A[j]>pivote) j--;         // busca elemento menor que pivote
       if (i<j) {                      // si no se han cruzado                      
           aux=A[i];                  // los intercambia
           A[i]=A[j];
           A[j]=aux;
       }
     }
     A[izq]=A[j]; // se coloca el pivote en su lugar de forma que tendremos
     A[j]=pivote; // los menores a su izquierda y los mayores a su derecha
     if (izq<j-1)
        quicksort(A,izq,j-1); // ordenamos subarray izquierdo
     if (j+1 <der)
        quicksort(A,j+1,der); // ordenamos subarray derecho
    }
    
    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args){
        int[] v={40, 21, 1, 3, 14, 4};
        System.out.println(Arrays.toString(v)); // imprimimos el antiguo vector
        quicksort(v, 0, v.length-1);
        System.out.println(Arrays.toString(v)); // imprimimos el vector ordenado
    }
    
}