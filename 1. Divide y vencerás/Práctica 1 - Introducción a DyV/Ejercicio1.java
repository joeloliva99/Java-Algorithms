public class Ejercicio1{
    
    public static int invertirNumero(int n){
        if (n<10)
            return n;
        else
            return (n%10)*nCifras(n)+invertirNumero(n/10); 
    }
    
    public int nCifras(){
        int numCifras=0;
        while (n>10){
            numCifras++;
            n=n/10;
        }
        return Math.pow(10, numCifras);
    }
    
}
