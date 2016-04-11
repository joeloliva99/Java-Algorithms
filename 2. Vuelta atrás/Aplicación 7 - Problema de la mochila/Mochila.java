public class Mochila{
    
    int[] w;
    int[] v;
    
    public Mochila(int n){
        w=new int[n];
        v=new int[n];
        for (int i=0; i<n; i++){
            w[i]=(int) (Math.random()*5+1);
            v[i]=(int) (Math.random()*10+1);
        }
    }
    
    public int obtenerValorMochila(int k, int r){
        int b=0;
        for (int i=k; i<v.length; i++){
            b=Math.max(b, v[i]+mochila(i, r-w[i]));
        }
        return b;
    }
    
    // La llamada sería: obtenerValorMochila(0, 40);
    
}