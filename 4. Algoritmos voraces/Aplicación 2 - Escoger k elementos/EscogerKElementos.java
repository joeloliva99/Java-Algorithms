import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EscogerKElementos{

    public static int[] escogerkElementos(int k, Integer[] vectorNumeros){
        ArrayList<Integer> numeros=new ArrayList<Integer>(Arrays.asList(vectorNumeros)); // Necesitamos una estructura de datos
        int[] solucion=new int[k]; // Definimos el vector solución
        int i=0;
        int j=0;
        while (i<k || j<numeros.size()) // Mientras no nos pasemos de los k elementos y de la estructura de datos
            if (numeros.get(j)==getElementoMayor(vectorNumeros)){ // Si estamos sobre el elemento mayor
                solucion[i]=numeros.get(j); // Lo incluimos en el vector
                numeros.remove(j); // Y lo eliminamos de la estructura de datos
                j=0; // Reseteamos el contador sobre el ArrayList
                i++; // E incrementamos el número de elemento recorrido
            } else
                j++;
        return solucion;
    }
    
    private static int getElementoMayor(Integer[] numeros){ // Devuelve el elemento mayor
        int elemento=0;
        for (int i=0; i<numeros.length; i++){
            if (elemento<numeros[i])
                elemento=numeros[i];
        }
        return elemento;
    }
    
    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args){
        Integer[] vector={10, 2, 5, 7, 3, 4};
        System.out.println(Arrays.toString(escogerkElementos(4, vector)));
    }
    
}