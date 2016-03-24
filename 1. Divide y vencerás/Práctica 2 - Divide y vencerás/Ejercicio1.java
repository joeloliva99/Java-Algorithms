public class Ejercicio1{
    
    int[] vectorEnteros1;
    int[] vectorEnteros2;
    int[] vectorEnteros3;
    
    public Ejercicio1(int n){
        vectorEnteros1=new int[n];
        for (int i=0; i<n; i++){
            vectorEnteros1[i]=(int) (Math.random()*100+1);
        }
        vectorEnteros2=vectorEnteros1;
        vectorEnteros3=vectorEnteros1;
    }
    
    public int maximo(){
        int valor=-1;
        for (int i=0; i<vectorEnteros1.length; i++){
            if (vectorEnteros1[i]>valor)
                valor=vectorEnteros1[i];
        }
        return valor;
    }
    
    public int maximoDyV2(int izq, int der){
        if (izq>der)
            return -1;
        else {
            if (izq==der)
                return vectorEnteros2[izq];
            else {
                int mitad=(izq+der)/2;
                int valor1=maximoDyV2(izq, mitad);
                int valor2=maximoDyV2(mitad+1, der);
                if (valor1>valor2)
                    return valor1;
                else 
                    return valor2;
            }
        }
    }
    
    public int maximoDyV3(int izq, int der){
        if (izq>der)
            return -1;
        else {
            if (izq==der)
                return vectorEnteros3[izq];
            else {
                int cuarto=(izq+der)/3;
                int valor1=maximoDyV3(izq, cuarto);
                int valor2=maximoDyV3(cuarto+1, cuarto+cuarto);
                int valor3=maximoDyV3(cuarto+cuarto+1, der);
                if (valor1>valor2 && valor1>valor3) 
                    return valor1;
                else if (valor1>valor2 && valor1<valor3)
                    return valor3;
                else
                    return valor2;
            }
        }
    }
    
}