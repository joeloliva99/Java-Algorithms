public class Hortelano{
    
    public static int n;
    public static int k;
    
    public static int[] asignaTierras(int[][] h){
        int[] s=new int[n];
        for (int i=0; i<n; i++)
            s[i]=-1; // Este valor indica los hortelanos no asignados
        int c;
        int j=0;
        for (int i=0; i<n; i++){
            c=seleccionarCandidato(h);
            // Introducimos al mejor candidato en la solucion
            s[j]=c;
            // Eliminamos el candidato
            quitarCandidato(h, c);
            j++;
        }
    }

    // Buscamos el candidato cuyo beneficio (fila 1 de la matriz) sea mayor
    private void seleccionarCandidato(int[][] h){
        int posicion=0;
        int valor=0;
        for (int i=0; i<n; i++)
            if(valor<h[1][i]){
                valor=h[1][i];
                posicion=i
            }
        return i;
    }
    
    // Trunca el valor para que no vuelva a ser un máximo
    private void quitarCandidato(int[][] h, int c)
        h[1][c]=-1;
    
}