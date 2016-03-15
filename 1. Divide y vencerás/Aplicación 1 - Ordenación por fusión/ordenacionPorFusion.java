package Algoritmo;

public class OrdenacionPorFusion{
    
    int[] v; /* Declaramos el array que vamos a ordenar. Es un atributo de la clase OrdenacionPorFusion*/

    public void fusionar(int[] v, int inf, int medio, int sup){ /* Este método nos va a permitir fusionar ambos lados del array */
        int[] vAux = new int[v.length]; /* Creamos un array auxiliar para poder cambiar los valores */ 
        int i1 = inf;
        int i2 = medio+1;
        int j = inf;
        
        /* Mientras que i1 no sobrepase la mitad e i2 no sobrepase el límite del array, entonces lo que hacemos es comparar los  
        * valores del vector. i1 recorre el vector desde la posición 0 hasta la mitad e i2 recorre el vector desde la mitad + 1
        * hasta la última. Si hay algún valor de la primera mitad que es menor, entonces, como queremos ordenar el array de maenor
        * a mayor, mantiene la posición. Si es mayor, entonces el valor de la posición i2 se aloja en la primera mitad. */
        while((i1 <= medio) && (i2 <= sup)){
            if (v[i1] < v[i2]){
                vAux[j] = v[i1];
                i1++;
            } else {
                vAux[j] = v[i2];
                i2++;
            }
            j++;
        }
        
        /* A lo largo de este bucle for, que comienza en inf y acaba en la posición mitad del vector, se recorre la primera mitad
        * del array copiando los valores del vector v en el auxiliar. */
        for (int i=i1; i <= medio; i++){
            vAux[j] = v[i];
            j++;
        }
        
        /* A lo largo de este bucle for, que comienza en mitad + 1 y acaba en la posición final del vector, se recorre la segunda
        * mitad del array copiando los valores del vector v en el auxiliar. */
        for (int i=i2; i <= sup; i++){
            vAux[j] = v[i];
            j++;
        }
        
        /* A lo largo de este bucle for, que comienza en la posición 0 y acaba en la posición final del vector, se recorre todo el
        * vector auxiliar, modificando la variable de clase v, para posteriormente imprimirla. Ya no nos interesa el vector que ha
        * entrado como parámetro, v, porque en esta ocasión queremos modificar el atributo de clase, this.v */
        for(int i = inf; i <= sup; i++){
            this.v[i] = vAux[i];
        }
    }
    
    /* Este es nuestro primer algoritmo de Divide y Vencerás. Trata básicamente en dividir el problema en dos subproblemas. En este
    * caso, al tratarse de un vector (array), es fácil modularizarlo en varios subproblemas, ambos con la misma esencia.*/
    public void mergeSort(int[] v, int inf, int sup){
        if (inf < sup){
            int medio = (inf+sup)/2;
            mergeSort(v, inf, medio); /* Primera mitad del array */
            mergeSort(v, medio+1, sup); /* Segunda mitad del array */
            fusionar(v, inf, medio, sup); /* Llamada al método de fusión */
        }
    }
    
    @Override
    public String toString(){
        String cadena = "[ ";
        for (int i = 0; i < v.length; i++){
            cadena+=v[i]+" ";
        }
        cadena+="]";
        return cadena;
    }
    
}