import java.util.Scanner;
import java.util.Arrays;

public class SumaDeSubconjuntos{
    
    int[] w;
    int[] x;
    int suma;

    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public void iniciarSumaSubconjuntos() { // en este caso recogeremos los datos por teclado, para variar
        Scanner sc = new Scanner(System.in); // declaramos un objeto de la clase Scanner
        System.out.print("Introduzca el número de elementos: "); 
        int n = sc.nextInt(); // Lo que hacemos es inicializar n por teclado, que es el número de elementos del array
        w = new int[n + 1]; // declaramos w, que será el array que contenga los números a combinar (el subconjunto)
        x = new int[n + 1]; // declaramos x, que será el array que contenga los 1 y 0 de la solución (si el elemento está o no)
        int total = 0; // declaramos e incializamos total, que sumará todos los elementos de w
        System.out.print("Introduzca " + n + " elementos: "); // introducimos los números para darle valor al array
        for (int i = 1; i < n + 1; i++) { // como tenemos n elementos, para cada uno se le asigna un valor
            w[i] = sc.nextInt(); // se introduce en el array según el orden en el que se introduzca
            total += w[i]; // se suman además los números para la comprobación final
        }
        System.out.print("¿Qué suma quiere encontrar? "); // solicitamos la suma que debemos encontrar combinando los elementos de w
        suma = sc.nextInt(); // leemos la suma por teclado
        if (total < suma) { // si el total es inferior a la suma, no nos molestamos en seguir con el procedimiento
            System.out.print("¡No es posible con estos datos!");
            System.exit(1); // finalizamos la ejecución
        }
        sumaSubconjuntos(0, 1, total); // si no, entonces llamamos a nuestro algoritmo para buscar todas las soluciones
    }

    private void sumaSubconjuntos(int s, int k, int r) { // esta implementación imprime todas las soluciones posibles
        x[k] = 1; // Como es un arbol binario, de 1 y 0, entonces probamos con el primer elemento si vale 1
        if (s + w[k] == suma) { // Si hemos llegado a la suma (caso base)
            System.out.println(Arrays.toString(x)); // Imprimimos la solución
        } else if ((s + w[k] + w[k + 1]) <= suma) { // si no estamos en la solución, pero la suma es inferior a la deseada
            sumaSubconjuntos(s + w[k], k + 1, r - w[k]); // entonces seguimos con x[k]=1, pero accedemos al siguiente nodo del árbol
        }
        if ((s + r - w[k]) >= suma && (s + w[k + 1]) <= suma) { // si no estamos en la solución, pero la suma es superior
            x[k] = 0; // entonces no contamos el elemento del nodo en el que estamos 
            sumaSubconjuntos(s, k + 1, r - w[k]); // procedemos al siguiente nodo del árbol
        }
    }
    
    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args){ 
        new prueba().iniciarSumaSubconjuntos(); // realizamos esta llamada para inicializar correctamente nuestro procedimiento
    }
    
}
