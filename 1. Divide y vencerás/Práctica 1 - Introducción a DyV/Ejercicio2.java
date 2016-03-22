public class Ejercicio2{
    
    public int numeroCombinatorio(int n, int k){
        if (k<=0 || n<=k)
            return 1;
        else 
            return numeroCombinatorio(n-1, k-1)+numeroCombinatorio(n-1, k);
    }
    
}