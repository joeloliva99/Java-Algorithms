import java.text.DecimalFormat;

public class SaltoDeCaballo {

	int[][] solucion;
	int paso = 0; // inicializamos a 0 el paso para mostrar las posiciones del caballo en la solución

    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
	public SaltoDeCaballo(int n) { // constructor de la clase. Se inicializa la matriz solución de nxn
        solucion = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                solucion[i][j] = 0;
            }
        }
	}
    
	public void resuelve() { // este método desencadena el algoritmo con la primera llamada inicializando todo a 0
        if (encontrarPosicion(0, 0, 0, solucion.length))
            mostrarResultado();
        else {
            System.out.println("NO HAY SOLUCIÓN POSIBLE");
        }
	}

	private boolean encontrarPosicion(int fila, int columna, int index, int n) {
        if (solucion[fila][columna]!=0){
            return false; // si esta posición es distinta de 0, entonces está ocupada
        }
        solucion[fila][columna] = paso++; // si no lo está, entonces la marcamos como ocupada
        if (index==n*n-1){ // si hemos llegado hasta aquí, entonces hemos resuelto el problema
            return true;
        }
        // si no hemos encontrado la solución, entonces la buscamos comenzando a usar la recursividad
        if (esMovimientoPosible(fila + 2, columna + 1, n) && encontrarPosicion(fila + 2, columna + 1, index + 1, n))
            return true; // probamos a ir abajo y a la derecha
        if (esMovimientoPosible(fila + 1, columna + 2, n) && encontrarPosicion(fila + 1, columna + 2, index + 1, n)) 
            return true; // probamos a ir a la derecha y abajo
        if (esMovimientoPosible(fila - 1, columna + 2, n) && encontrarPosicion(fila - 1, columna + 2, index + 1, n))
            return true; // probamos a ir a la derecha y arriba
        if (esMovimientoPosible(fila - 2, columna + 1, n) && encontrarPosicion(fila - 2, columna + 1, index + 1, n))
            return true; // probamos a ir arriba y a la derecha
        if (esMovimientoPosible(fila - 2, columna - 1, n) && encontrarPosicion(fila - 2, columna - 1, index + 1, n))
            return true; // probamos a ir arriba y a la izquierda
        if (esMovimientoPosible(fila - 1, columna - 2, n) && encontrarPosicion(fila - 1, columna - 2, index + 1, n))
            return true; // probamos a ir a la izquierda y arriba
        if (esMovimientoPosible(fila + 1, columna - 2, n) && encontrarPosicion(fila + 1, columna - 2, index + 1, n))
            return true; // probamos a ir a la izquierda y abajo
        if (esMovimientoPosible(fila + 2, columna - 1, n) && encontrarPosicion(fila + 2, columna - 1, index + 1, n))
            return true; // probamos a ir abajo y a la izquierda
        // si el paso anterior tampoco ha funcionado, entonces realizamos la vuelta atrás
        solucion[fila][columna] = 0;
        paso--;
        return false;
	}

	private boolean esMovimientoPosible(int fila, int col, int N){
        if (fila>=0 && col>=0 && fila<N && col<N){ // si la fila y la columna son mayores que cero y además menor que n
            return true; // entonces podemos desplazar el caballo
        }
        return false; // si no, devolvemos false, que indica que está ocupado
	}

	private void mostrarResultado() { // para imprimir el resultado, damos un formato especial de dos cifras
        DecimalFormat dosDigitos = new DecimalFormat("00"); // es útil para los números del 0 al 9, para que no se desvirtúe la matriz
        for (int i=0; i<solucion.length; i++){ // recorremos la matriz imprimiendo la solución, si existe
            for (int j=0; j<solucion.length; j++){
                System.out.print("   " + dosDigitos.format(solucion[i][j]));
            }
            System.out.println();
        }
	}

    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
	public static void main(String[] args) {
        int n = 8; // aquí especificamos la dimensión de nuestro tablero. Por ejemplo, 8x8
        SaltoDeCaballo i = new SaltoDeCaballo(n);
        i.resuelve();
	}

}