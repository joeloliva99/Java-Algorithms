import java.util.*;
import java.lang.*;
import java.io.*;

public class Dijkstra{
   
    static final int V=9; // Número de vértices del problema
    
    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    private int minimaDistancia(int distancias[], Boolean procesados[]){
        int min=Integer.MAX_VALUE, min_index=-1; // Inicializamos el valor mínimo
        for (int v=0; v<V; v++)
            if (procesados[v] == false && distancias[v] <= min){
                min=distancias[v];
                min_index=v;
            }
        return min_index;
    }
    
    // Imprime la solución obtenida
    private void imprimirSolucion(int distancias[], int n){
        System.out.println("Vértice   Distancia desde el inicio");
        for (int i=0; i<V; i++)
            System.out.println(i+" \t\t "+distancias[i]);
    }
    
    // Implementa el algoritmo de Dijkstra dado un grafo con adyacencias
    private void dijkstra(int grafo[][], int nodoRaiz){
        int distancias[]=new int[V]; // Vector de distancias solución del algoritmo, distancias[i] es la ruta más corta desde nodoRaiz hasta i
        Boolean procesados[]=new Boolean[V]; // procesados[i] será true si el vértice i está incluido en el camino más corto
        for (int i=0; i<V; i++){ // Inicializamos todas las distancias como infinito y stpSet[] a false
            distancias[i]=Integer.MAX_VALUE; // Función de Interger
            procesados[i]=false;
        }
        distancias[nodoRaiz]=0; // La distancia del nodo raíz a si mismo es siempre 0
        for (int count=0; count<V-1; count++){ // Encuentra el camino más corto en todos los vértices
            int u=minimaDistancia(distancias, procesados);
            procesados[u]=true; // Marca el vértice seleccionado como procesado
            for (int v=0; v<V; v++) // Actualiza el valor de las distancias del grafo adyacente para el vértice seleccionado
                if (!procesados[v] && grafo[u][v]!=0 &&
                    distancias[u]!=Integer.MAX_VALUE &&
                    distancias[u]+grafo[u][v]<distancias[v])
                    distancias[v]=distancias[u]+grafo[u][v];
        }
        imprimirSolucion(distancias, V); // Imprime el array de distancias
    }

    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main (String[] args){
        int grafo[][]=new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, // Este es mi ejemplo de grafo
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                  {0, 0, 4, 0, 10, 0, 2, 0, 0},
                                  {0, 0, 0, 14, 0, 2, 0, 1, 6},
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        Dijkstra d=new Dijkstra();
        d.dijkstra(grafo, 0);
    }
    
}