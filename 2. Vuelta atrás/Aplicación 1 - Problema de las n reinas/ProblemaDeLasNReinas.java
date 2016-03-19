import java.util.Arrays;

public class ProblemaDeLasNReinas{
    
    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    private static boolean esSitioDisponible(int column, int Qi, int[] tablero){
        for (int i=0; i<Qi; i++){ // recorremos todas las posiciones de las reinas ya colocadas
            if (tablero[i]==column) return false; // si en alguna de ellas coincide la columna, no está disponible
            if (Math.abs(tablero[i]-column)==Math.abs(i-Qi)) return false; // ídem con la diagonal
        }
        return true; // si no se cumple en ningún caso la condición del for, la columna está disponible
    }
    
    public static void colocarReinas(int Qi, int[] tablero){
        int n=tablero.length; // colocaremos n reinas, tantas como la longitud del tablero sea
        if (Qi==n){
            System.out.println(Arrays.toString(tablero)); // imprimimos nuestra solución
        } else {
            for (int column=0; column<n; column++){ // nos permite recorrer todo el árbol de búsqueda
                if (esSitioDisponible(column, Qi, tablero)){ // si la nueva reina no está en la misma columna ni diagonal
                    tablero[Qi]=column; // entonces colocamos la reina en la columna deseada
                    colocarReinas(Qi+1, tablero); // realizamos la vuelta atrás para seguir colocando reinas
                }
            }
        }
    }
    
    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args){
        int[] tablero=new int[4]; // la longitud de nuestro array son las reinas que queremos colocar. En este caso, 4
        colocarReinas(0, tablero); // inicializamos nuestro algoritmo con Qi=0 y el array vacío con un tamaño fijo
    }
    
}