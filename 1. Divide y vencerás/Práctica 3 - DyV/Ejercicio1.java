public class Ejercicio1{
    
    public static int cajaAburrida(int[] caja, int izq, int der){
        int sol=-1;
        if (izq>der)
            return sol;
        else {
            if (izq==der)
                sol=caja[izq];
            else {
                int mitad=(izq+der)/2;
                int mitad1=cajaAburrida(caja, izq, mitad);
                int mitad2=cajaAburrida(caja, mitad+1, der);
                if (esBombonMasRepetido(caja, mitad1))
                   sol=mitad1;
                else if (esBombonMasRepetido(caja, mitad2))
                   sol=mitad2;
            }
            return sol;
        }
    }
   
    private static boolean esBombonMasRepetido(int[] caja, int x){
        int contador=0;
        for (int i=0; i<caja.length; i++)
            if (x==caja[i])
                contador++;
        if (contador>=(caja.length/2+1))
            return true;
        return false;
    }
    
}