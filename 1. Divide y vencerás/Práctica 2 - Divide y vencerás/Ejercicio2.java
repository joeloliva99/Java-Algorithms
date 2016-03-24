public class Ejercicio2{
    
    public static int sumaMaxima(int[] generadores, int inicio, int fin){
        if (inicio > fin)
            return 0;
        else if (inicio == fin)
            return generadores[inicio];
        else {
            int centro = (inicio+fin)/2;
            int sumIzda = sumaMaxima(generadores, inicio, centro);
            int sumDcha = sumaMaxima(generadores, centro+1, fin);
            int suma = generadores[centro];
            int maxIzda = suma;
            for (int i = centro-1; i>=inicio; i--){
                suma += generadores[i];
                if(suma>maxIzda)
                    maxIzda = suma;
            }
            suma = generadores[centro+1];
            int maxDcha = suma;
            for (int i=centro+2; i<=fin; i++){
                suma += generadores[i];
                if (suma>maxDcha)
                    maxDcha = suma;
            }
            suma = maxIzda + maxDcha;
            int maximo = Math.max(sumIzda, sumDcha);
            return Math.max(suma, maximo);
        }
    }
    
}