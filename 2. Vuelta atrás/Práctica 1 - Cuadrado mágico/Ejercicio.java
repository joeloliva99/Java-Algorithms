public class Ejercicio{
    
    private int[][] cuadrado;
    private boolean[] disponible;

    public Ejercicio() {
        cuadrado=new int[3][3];
        disponible = new boolean[9];
        for (int i = 0; i < disponible.length; i++) {
            disponible[i] = true;
        }
    }

    public void ejecutar() {
        resolver(0, 0);
    }

    public void resolver(int fila, int col){
    for (int i = 1; i <= 9; i++){
        if (existenNumerosDisponibles(i)){
            cuadrado[fila][col]=i;
            disponible[i-1]=false;
            if (noExistenNumerosDisponibles()) {
                if (solucionValida()) {
                    System.out.println("¡Solución correcta encontrada!");
                    imprimirSolucion();
                }
            } else {
                if (col!=2) {
                    resolver(fila, col+1);
                } else if (fila!=2) {
                    resolver(fila+1,0);   
                }
            }
            cuadrado[fila][col]=0;
            disponible[i-1]=true;
        }
    }
}

    public boolean existenNumerosDisponibles(int valor){
        if (disponible[valor-1]==true)
            return true;
        else
            return false;
    }

    public boolean filaValida(int fila){
        if (cuadrado[fila][0]+cuadrado[fila][1]+cuadrado[fila][2]==15)
            return true;
        else
            return false;
    }

    public boolean columnaValida(int col){
        if (cuadrado[0][col]+cuadrado[1][col]+cuadrado[2][col]==15)
            return true;
        else
            return false;
    }

    public boolean diagonalValida(){
        if ((cuadrado[0][0]+cuadrado[1][1]+cuadrado[2][2]==15)&&(cuadrado[2][0]+cuadrado[1][1]+cuadrado[0][2]==15))
            return true;
        else
            return false;
    }

    public boolean solucionValida(){
        for (int i=0; i<cuadrado.length; i++){
            if (!filaValida(i)||!columnaValida(i))
                return false;
        }
        return diagonalValida();
    }

    public boolean noExistenNumerosDisponibles(){
        for (int i=0; i<disponible.length; i++){
            if (disponible[i])
                return false;
        }
        return true;
    }

    public void imprimirSolucion(){
        for (int i=0; i<cuadrado.length; i++){
            for (int j=0; j<cuadrado[i].length; j++){
                System.out.print(cuadrado[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}