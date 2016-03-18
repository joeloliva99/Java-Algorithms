import java.util.Arrays;

public class TransposicionDeMatrices{
    
    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public static void transponer(int[][] matriz, int filaInic, int colInic, int filaFin, int colFinal){
        if (filaFin==(filaInic+1)){ // caso base, si tenemos una matriz de 2x2, entonces 
            int aux = matriz[filaInic][colFinal]; // intercambiamos sus diagonales
            matriz[filaInic][colFinal] = matriz[filaFin][colInic];
            matriz[filaFin][colInic] = aux;
        } else { // caso recursivo
            int centroFila=(filaInic+filaFin)/2; // definimos el centro de las filas
            int centroCol=(colInic+colFinal)/2; // definimos el centro de las columnas
            transponer(matriz, filaInic, colInic, centroFila, centroCol); // partimos la matriz 
            transponer(matriz, filaInic, centroCol+1, centroFila, colFinal);
            transponer(matriz, centroFila+1, colInic, filaFin, centroCol);
            transponer(matriz, centroFila+1, centroCol+1, filaFin, colFinal);
            int aux;
            int jAux = centroFila+1;
            for (int i=(filaInic); i<=centroFila; i++){
                int iAux = colInic;
                for (int j=(centroCol+1); j<=colFinal; j++){
                    aux = matriz[i][j];
                    matriz[i][j] = matriz[jAux][iAux];
                    matriz[jAux][iAux] = aux;
                    iAux++;
                }
                jAux++;
            }
        }
    }
    
    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args){
        int [][] numeros = {{10,11,12,13}, {14,15,16,17}, {18,19,20,21}, {22,23,24,25}}; //ha de ser una matriz cuadrada
        for (int i=0; i<numeros.length; i++){
            for (int j=0; j<numeros[0].length; j++){
                System.out.print(numeros[i][j]+" ");
            }
            System.out.println();
        }
        transponer(numeros, 0, 0, 3, 3);
        System.out.println();
        for (int i=0; i<numeros.length; i++){
            for (int j=0; j<numeros[0].length; j++){
                System.out.print(numeros[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}