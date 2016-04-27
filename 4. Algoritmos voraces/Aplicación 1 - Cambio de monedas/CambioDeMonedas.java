import java.util.Arrays;

public class CambioDeMonedas{

    private static int getPosicionMejorMoneda(double total, double[] monedas){
        double[] resultados=new double[monedas.length];
        for (int i=0; i<resultados.length; i++){ // Almacenamos el resultado de restar la moneda i con el total
            resultados[i]=total-monedas[i];
            if (resultados[i]<0) // Tenemos en cuenta las restas negativas. Si es negativa, forzamos a que sea igual
                resultados[i]=total; // a total, para que la siguiente parte del algoritmo no se centre en ese resultado,
        }                            // porque la moneda no nos sirve
        double mejor=resultados[0];
        int contador=0;
        for (int i=0; i<resultados.length; i++) // Buscamos el mejor resultado (la mejor moneda, que haga que la resta sea mayor)
            if (mejor>resultados[i]&&){
                mejor=resultados[i];
                contador++; // También realizamos un seguimiento sobre su posición
            }
        return contador;
    }
    
    public static int combinarMonedas(double total){
        double[] monedas={0.01, 0.02, 0.05, 0.1, 0.2, 0.5, 1.00, 2.00}; // Definimos las monedas que usaremos
        System.out.println(Arrays.toString(monedas));
        double total1=total;
        int contador=0;
        while (total1>=0.00){
            int posicionMoneda=getPosicionMejorMoneda(total1, monedas); // Buscamos la mejor moneda asociada al total
            total1=total1-monedas[posicionMoneda]; // Restamos la moneda usada al total
            contador+=1; // Contamos las monedas que llevamos
        }
        return contador;
    }
    
    /* --------------------- PRUEBA DEL ALGORITMO --------------------- */
    public static void main(String[] args){
        System.out.println(combinarMonedas(2.24));
    }
    
    /* -------------------------------------------------------------------------------------------------------------
    ----------------------------------------------- AVISO IMPORTANTE -----------------------------------------------
    ------------------------------------------------------------------------------------------------------------- */
    /* COMO LA RESTA ENTRE NÚMEROS DOUBLE NO ES CIEN POR CIEN EXACTA (2.24-2.00=0.24000000002), LOS DECIMALES SE VAN
    ACUMULANDO Y, COMO RESULTADO, DA UNA MONEDA MÁS. PARA LA LLAMADA DE ESTE MÉTODO (COMBINARMONEDAS(2.24)), LA SOLU-
    CIÓN SON 4 MONEDAS, PERO DEBIDO A LOS DECIMALES DE LA RESTA DE DOUBLES, COMO ÚLTIMA MONEDA SE USA UNA DE 1 CÉNTI-
    MO. EL ALGORITMO ESTÁ BIEN IMPLEMENTADO, PERO LAS CARACTERÍSTICAS DE LA API DAN ESE FALLO. */
    
}