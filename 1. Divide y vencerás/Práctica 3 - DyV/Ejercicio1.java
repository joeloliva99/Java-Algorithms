public class Ejercicio1{
    
    public int[] cajaAburrida(int[] bombones, int inicio, int fin){
        int[] solucion=new int[2];
        //Por defecto la caja será aburrida, entonces devuelve 0
        solucion[0]=0;
        solucion[1]=0;
        if (inicio>fin){
            return solucion;
        } else if (inicio==fin){
            solucion[0]=bombones[inicio];
            solucion[1]++;
            return solucion;
        } else if (fin-inicio==1){
            if (bombones[inicio]==bombones[fin]){
                solucion[0]=bombones[inicio];
                solucion[1]=2;
        }
            return solucion;
        } else {
            int centro =(inicio+fin)/2;
            int [] solucionIzda = cajaAburrida(bombones,inicio,centro);
            int [] solucionDcha = cajaAburrida(bombones,centro+1,fin);
            if (solucionIzda[0]!=0){
                for (int i=centro+1;i<=fin;i++){
                    if(bombones[i]==solucionIzda[0]){
                        solucionIzda[1]++;
                    }
                }
            }
            int numeroBombones=fin-inicio+1;
            if(solucionIzda[1]>(numeroBombones/2))
                return solucionIzda;
            else {
                if(solucionDcha[0]!=0){
                    for (int i = inicio;i<=centro;i++){
                        if(bombones[i] == solucionDcha[0])
                            solucionDcha[1]++;
                    }
                }
                if(solucionDcha[1]>(bombones.length/2))
                    return solucionDcha;            
            }
            return solucion;
        }        
    }
    
}