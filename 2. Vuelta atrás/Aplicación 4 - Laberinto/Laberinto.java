public class Laberinto{
    
    public int contador = 0;
    public char[][] laberinto={ // dibujamos nuestro laberinto. En este caso, este es el diseño que hemos elegido
        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
	    {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', '#'},
	    {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#'},
	    {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
	    {'#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
	    {'#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
	    {'#', ' ', ' ', ' ', ' ', '#', '#', '#', '#', '#'},
	    {'#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', '#'},
	    {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
	    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
    };
    
    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public void resuelve(int x, int y){ // permite introducir unas coordenadas (x, y) 
        if (paso(x, y)) { // intentará resolver el laberinto en estas coordenadas
            laberinto[x][y] = 'S'; // introduce en las coordenadas (x, y) la entrada
	    }
    }
    
    private boolean paso(int x, int y) {
        contador++; // en cada llamada incrementaremos el contador
        if (laberinto[x][y]=='X'){ // si hemos llegado a X quiere decir que hemos encontrado solución
            return true; // luego, el algoritmo termina
	    }
	    if (laberinto[x][y]=='#'||laberinto[x][y]=='*') { // si llegamos a una pared o al mismo punto,
            return false; // entonces el laberinto no puede resolverse y termina.
	    }
	    // si no se cumple ninguna de estas dos situaciones, quiere decir que nos encontramos en un
        // caso intermedio, por lo tanto, que empezamos a recorrer o todavía no hemos llegado a nada
        laberinto[x][y]='*'; // marcamos la posición como visitada (si es la primera, en las coordenadas x e y
        boolean result;	     // se coloca S de START)
	    result=paso(x, y+1); // intentamos ir hacia la izquierda. Primera llamada recursiva
	    if (result) return true; // si el resultado es el final, entonces el algoritmo termina
	    result=paso(x-1, y); // intentamos ir hacia arriba. Segunda llamada recursiva
	    if (result) return true; // si el resultado es el final, entonces el algoritmo termina
	    result=paso(x, y-1); // intentamos ir hacia la izquierda. Tercera llamada recursiva
	    if (result) return true; // si el resultado es el final, entonces el algoritmo termina
	    result=paso(x+1, y); // intentamos ir hacia abajo. Cuarta llamada recursiva
	    if (result) return true; // si el resultado es el final, entonces el algoritmo termina
	    // si no hemos encontrado la solución en estos cuatros movimientos, volvemos atrás, aunque hay que
        // considerar que en este punto, todas las llamadas recursivas han finalizado. Si en ninguna de ellas
        // se ha conseguido el éxito, entonces el algoritmo termina y devuelve false.
	    laberinto[x][y]=' '; // en el caso de no ser el resultado, desmarcamos el camino
	    return false; // vuelta atrás si la solución no se encuentra aquí
    }
	
    private String toString() { // imprimiremos nuestra solución. Debido a que la clase Arrays no tiene implementado
        String salida = "";    // un método toString para arrays bidimensionales, lo programamos a mano
        for (int x=0; x<laberinto.length; x++) { // recorremos filas
            for (int y=0; y<laberinto[x].length; y++) { // recorremos columnas
                salida += laberinto[x][y] + " "; // output es nuestra variable que va almacenando los valores a imprimir
            }
            salida += "\n"; // devolvemos esta variable con un salto de línea
        }
        return salida;
    }
	
    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
	public static void main(String[] args) {
		Laberinto m = new Laberinto(); // construimos un objeto de la clase Laberinto por defecto
		m.laberinto[1][1] = 'X'; // introducimos en este caso, la salida (X) en las coordenadas (1,1)
		m.resuelve(8, 1); // ahora, introducimos la entrada (S) en las coordenadas (8,1) y llamamos al algoritmo
		System.out.println(m); // imprimimos el laberinto ya resuelto (si tiene solución)
		System.out.println("Total de casos recursivos examinados: " + m.contador); // también imprimimos las llamadas recursivas necesarias
	}
    
}
