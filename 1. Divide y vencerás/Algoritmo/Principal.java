package Algoritmo;

public class Principal{
    
    public static void main(String[] args){ /* Emplearemos esta clase para probar lo trabajado */
        public static void main(String[] args){
        OrdenacionPorFusion objeto = new OrdenacionPorFusion();
        objeto.v = new int[5];
        objeto.v[0] = 5;
        objeto.v[1] = 506;              /* ---------------------- RESULTADO ---------------------- */
        objeto.v[2] = 20;               /* Antes de la llamada a mergeSort:     [ 5 506 20 1 11 ]  */
        objeto.v[3] = 1;                /* Tras la llamada a mergeSort:         [ 1 5 11 20 506 ]  */     
        objeto.v[4] = 11;
        System.out.println(objeto.toString());
        System.out.println("");
        objeto.mergeSort(objeto.v, 0, 4);
        System.out.println(objeto.toString());
    }
}