public class MultiplicacionDeEnteros{
    
    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    private int nDigitos(int n){
        cifras= 0; // esta variable es el contador de cifras
        while(n!=0){ //mientras a n le queden cifras
            n = n/10; //le quitamos el último dígito
            cifras++; //sumamos 1 al contador de cifras
        }
        return cifras;
    }
    
    public static long multiplicacion(long x, long y){
        int n=Math.max(nDigitos(x), nDigitos(y));
        if (n<10){ // esta condición depende del número de bits de la ALU.
            return x*y;
        } else {
            long A=(long) (x/Math.pow(10, n/2)); // Obtenemos el elemento A del producto
            long B=(long) (x%Math.pow(10, n/2)); // Obtenemos el elemento B del producto
            long C=(long) (y/Math.pow(10, n/2)); // Obtenemos el elemento C del producto
            long D=(long) (y%Math.pow(10, n/2)); // Obtenemos el elemento D del producto
            long Z2=multiplicacion(A, C); // calculamos Z2 con los cocentes
            long Z1=multiplicacion(A, D)+multiplicacion(B, C); // sumamos las divisiones
            long Z0=multiplicacion(B, D); // calculamos Z0 con los restos
            return (long) ((Z2*Math.pow(10, n))+(Z1*Math.pow(10, n/2))+Z0); // devolvemos el producto
        }
    }
    
    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args){
        long x=1023234539L;
        long y=2312849399L;
        long resultado;
        resultado=multiplicacion(x, y); // como x e y tienen más de 10 cifras, se resuelve recursivamente
        
        long u=1237273L;
        long v=23493293L;
        resultado=multiplicacion(u, v); // como x e y tienen menos de 10 cifras, se realiza x*y directamente
    }
    
}