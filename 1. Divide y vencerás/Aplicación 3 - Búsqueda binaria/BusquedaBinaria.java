public class BusquedaBinaria{
    
    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public int busquedaBinaria(inr[] v, int ini, int fin, int valor){
        int sol=-1; // devolverá -1 si no encuentra el elemento
        if (ini>fin){ // también si los índices están mal indicados
            return sol;
        } else {
            int medio=(ini+fin)/2; // declaramos la posición mitad del array
            if (valor==v[medio]) sol=medio; // caso base, devuelve la posición
            else if (valor<v[medio]) //casos recursivos. Este parte el vector a la izquierda
                sol=busquedaBinaria(v, ini, medio, valor); // llamada recursiva de inicio a mitad
            else
                sol=busquedaBinaria(v, medio+1, fin, valor); // llamada recursiva de mitad+1 a final
            return sol;
        }
    }
    
    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args){
        int[] v={1, 3, 14, 21, 40}; //podemos ordenarlo con alguna de las técnicas vistas
        System.out.println(busquedaBinaria(v, 0, v.length-1, 10)); // devuelve -1, porque 10 no está en el vector
        System.out.println(busquedaBinaria(v, 0, v.length-1, 14)); // devuelve 2, porque 14 está en la posición 2
    }
    
}