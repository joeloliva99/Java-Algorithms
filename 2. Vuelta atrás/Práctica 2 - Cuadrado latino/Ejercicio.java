public class Ejercicio {

    int[][] cuadrado;
    int[] conjuntoColores;
    
    public Ejercicio(int n){
        cuadrado=new int[n][n];
        for (int i=0; i<cuadrado.length; i++){
            for (int j=0; j<cuadrado[i].length; j++){
                cuadrado[i][j]=0;
            }
        }
        conjuntoColores=new int[n];
        for (int i=0; i<conjuntoColores.length; i++){
            conjuntoColores[i]=i+1;
        }
    }
    
    public void ejecutar(){
        resolver(0, 0);
    }
    
    public void resolver(int fila, int col){
        for (int i=0; i<conjuntoColores.length; i++){
            if ((!existeColorEnFila(fila, conjuntoColores[i]))&&(!existeColorEnCol(col, conjuntoColores[i]))){
                cuadrado[fila][col]=conjuntoColores[i];
                if (col<=cuadrado[0].length-1) resolver(fila, col+1);
                else 
                    if (fila<=cuadrado.length-1) resolver(fila+1, 0);
            } else {
                if (esSolucionEncontrada()){
                    System.out.println("Solución encontrada.");
                    imprimirSolucion();
                    break;
                }
            }
        }
    }
    
    public boolean existeColorEnFila(int fila, int color){
        for (int i=0; i<cuadrado[0].length; i++){
            if (cuadrado[fila][i]==color)
                return true;
        }
        return false;
    }
    
    public boolean existeColorEnCol(int col, int color){
        for (int i=0; i<cuadrado.length; i++){
            if (cuadrado[i][col]==color) {
                return true;
            }
        }
        return false;
    }
    
    public boolean esSolucionEncontrada(){
        for (int i=0; i<cuadrado.length; i++) {
            for (int j=0; j < cuadrado[0].length; j++) {
                if (cuadrado[i][j]==0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void imprimirSolucion(){
        for (int i=0; i<cuadrado.length; i++) {
            for (int j = 0; j < cuadrado[0].length; j++) {
                System.out.print(cuadrado[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
