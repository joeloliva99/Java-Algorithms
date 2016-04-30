import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EscogerKElementos{

    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public static Integer[] escogerKElementos(int k, Integer[] numeros){
        Integer[] solucion=new Integer[k];
        ArrayList<Integer> vectorNumeros=new ArrayList<Integer>(Arrays.asList(numeros));
        for (int i=0; i<k; i++){
            int posicion=getPosicionMayorElemento(vectorNumeros);
            solucion[i]=vectorNumeros.get(posicion);
            vectorNumeros.remove(posicion);
        }
        return solucion;
    }
    
    public static int getPosicionMayorElemento(ArrayList<Integer> numeros){
        int valor=numeros.get(0);
        int posicion=0;
        for (int i=1; i<numeros.size(); i++){
            if (valor<numeros.get(i)){
                valor=numeros.get(i);
                posicion=i;
            }
        }
        return posicion;
    }
    
    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args){
        int k=10;
        Integer[] numeros=new Integer[k];
        for (int i=0; i<k; i++){
            numeros[i]=(int) (Math.random()*20+1);
        }
        System.out.println(Arrays.toString(numeros));
        System.out.println(Arrays.toString(escogerKElementos(3, numeros)));
    }
    
}
