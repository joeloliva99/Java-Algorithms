public class OrdenacionPorFusion{
    
    int[] v;

    public void fusionar(int[] v, int inf, int medio, int sup){
        int[] vAux = new int[v.length];
        int i1 = inf;
        int i2 = medio+1;
        int j = inf;
        while((i1 <= medio) && (i2 <= sup)){
            if (v[i1] < v[i2]){
                vAux[j] = v[i1];
                i1++;
            } else {
                vAux[j] = v[i2];
                i2++;
            }
            j++;
        }
        for (int i=i1; i <= medio; i++){
            vAux[j] = v[i];
            j++;
        }
        for (int i=i2; i <= sup; i++){
            vAux[j] = v[i];
            j++;
        }
        for(int i = inf; i <= sup; i++){
            v[i] = vAux[i];
        }
        this.v = new int[v.length];
        for (int i = 0; i < v.length; i++){
            this.v[i] = v[i];
        }
    }

    public void mergeSort(int[] v, int inf, int sup){
        if (inf < sup){
            int medio = (inf+sup)/2;
            mergeSort(v, inf, medio);
            mergeSort(v, medio+1, sup);
            fusionar(v, inf, medio, sup);
        }
    }
    
    @Override
    public String toString(){
        String cadena = "[ ";
        for (int i = 0; i < v.length; i++){
            cadena+=v[i]+" ";
        }
        cadena+=" ]";
        return cadena;
    }
    
}