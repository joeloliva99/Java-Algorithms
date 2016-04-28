import java.util.*;
import java.lang.*;
import java.io.*;

public class Dijkstra{
   
    static final int V=9; // Número de vértices del problema
    
    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    private int minimaDistancia(int distancias[], Boolean sptSet[]){
        int min = Integer.MAX_VALUE, min_index=-1; // Inicializamos el valor mínimo
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && distancias[v] <= min)
            {
                min = distancias[v];
                min_index = v;
            }
 
        return min_index;
    }
    
    // Imprime la solución obtenida
    private void imprimirSolucion(int distancias[], int n){
        System.out.println("Vértice   Distancia desde el inicio");
        for (int i = 0; i < V; i++)
            System.out.println(i+" \t\t "+distancias[i]);
    }
 
    // Funtion that implements Dijkstra's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    private void dijkstra(int graph[][], int src){
        int distancias[] = new int[V]; // The output array. distancias[i] will hold
                                 // the shortest distance from src to i
 
        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[V];
 
        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++)
        {
            distancias[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
 
        // Distance of source vertex from itself is always 0
        distancias[src] = 0;
 
        // Find shortest path for all vertices
        for (int count = 0; count < V-1; count++)
        {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minimaDistancia(distancias, sptSet);
 
            // Mark the picked vertex as processed
            sptSet[u] = true;
 
            // Update distancias value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)
 
                // Update distancias[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of distancias[v]
                if (!sptSet[v] && graph[u][v]!=0 &&
                        distancias[u] != Integer.MAX_VALUE &&
                        distancias[u]+graph[u][v] < distancias[v])
                    distancias[v] = distancias[u] + graph[u][v];
        }
 
        // Imprime el array de distancias
        imprimirSolucion(distancias, V);
    }

    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main (String[] args){
        int grafo[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, // Este es mi ejemplo de grafo
                                    {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                    {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                    {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                    {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                    {0, 0, 4, 0, 10, 0, 2, 0, 0},
                                    {0, 0, 0, 14, 0, 2, 0, 1, 6},
                                    {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                    {0, 0, 2, 0, 0, 0, 6, 7, 0}};
        Dijkstra d = new Dijkstra();
        d.dijkstra(grafo, 0);
    }
    
}