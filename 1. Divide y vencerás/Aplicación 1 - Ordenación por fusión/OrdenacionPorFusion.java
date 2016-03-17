package Algoritmo;

public class OrdenacionPorFusion{

    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public void fusionar(int[] v, int inf, int medio, int sup){
        int[] vAux=new int[v.length]; // creamos un array auxiliar para poder cambiar los valores 
        int i1=inf; // i1 recorre el array de izquierda al medio
        int i2=medio+1; // i2 recorre el array del medio al final
        int j=inf; 
        while((i1<=medio) && (i2<=sup)){ // mientras no superemos los límites
            if (v[i1]<v[i2]){ // si el elemento de la izquierda es menor que el de la derecha
                vAux[j]=v[i1]; // lo metemos en el array auxiliar en la posición j
                i1++;
            } else { // si es mayor que el de la derecha 
                vAux[j] = v[i2]; // lo metemos en el array auxiliar en la posición j
                i2++;
            }
            j++; // incrementamos j para rellenar el array
        }
        for (int i=i1; i<=medio; i++){ // desde inicio hasta medio recorremos v
            vAux[j]=v[i]; // copiamos los valores de v en auxiliar
            j++;
        }
        for (int i=i2; i<=sup; i++){ // desde medio hasta la última posición
            vAux[j]=v[i]; // copiamos los valores de v en auxiliar
            j++;
        }
        for(int i=inf; i<=sup; i++){ // desde inferior hasta la última posición
            v[i]=vAux[i]; // devolvemos los valores al vector v ya ordenado
        }
    }
    
    public void mergeSort(int[] v, int inf, int sup){
        if (inf<sup){
            int medio=(inf+sup)/2;
            mergeSort(v, inf, medio); // Primera mitad del array
            mergeSort(v, medio+1, sup); // Segunda mitad del array
            fusionar(v, inf, medio, sup); // Llamada al método de fusión
        }
    }
    
    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args){
        int[] v={40, 21, 1, 3, 14, 4};
        System.out.println(Arrays.toString(v)); // imprimimos el antiguo vector
        mergeSort(v, 0, v.length-1);
        System.out.println(Arrays.toString(v)); // imprimimos el vector ordenado
    }
    
}
