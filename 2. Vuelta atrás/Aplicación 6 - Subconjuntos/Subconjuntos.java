public class Subconjuntos{}

    static int[] subconjunto;
    
    public Subconjuntos(int n){
        subconjunto=new int[n];
        for (int i=0; i<n; i++){
            subconjunto[i]=(int) (Math.random()*10+1);
        }
    }
    
    public void ejecutar(){
        boolean[] c=new boolean[subconjunto.length];
        for (int i=0; i<c.length; i++){
            c[i]=false;
        }
        extraerSubconjuntos(c, 0);
    }
    
    public static void extraerSubconjuntos(boolean[] c, int k){
        imprimirSubconjuntos(c);
        for (int i=k; i<c.length; i++){
            c[i]=true;
            extraerSubconjuntos(c, k+1);
            c[i]=false;
        }
    }
    
    public static void imprimirSubconjuntos(boolean[] c){
        System.out.print("{");
        for (int i=0; i<c.length; i++){
            if (c[i]==true)
                System.out.print(subconjunto[i]+" ");
        }
        System.out.print("}");
        System.out.println();
    }

}