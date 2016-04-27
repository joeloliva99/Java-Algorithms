import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EscogerKElementos{

    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public static int[] escogerkElementos(int k, Integer[] vectorNumeros){
        ArrayList<Integer> numeros=new ArrayList<Integer>(Arrays.asList(vectorNumeros));
        int[] solucion=new int[k];
        int i=0;
        int j=0;
        while (i<k && j<numeros.size())
            if (numeros.get(j)==getElementoMayor(numeros)){
                solucion[i]=numeros.get(j);
                numeros.remove(j);
                j=0;
                i++;
            } else
                j++;
        return solucion;
    }
    
    private static int getElementoMayor(ArrayList<Integer> numeros){
        int elemento=0;
        for (int i=0; i<numeros.size(); i++){
            if (elemento<numeros.get(i))
                elemento=numeros.get(i);
        }
        return elemento;
    }
    
    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args){
        Integer[] vector={10, 2, 5, 7, 3, 4};
        System.out.println(Arrays.toString(escogerkElementos(4, vector)));
    }
    
}