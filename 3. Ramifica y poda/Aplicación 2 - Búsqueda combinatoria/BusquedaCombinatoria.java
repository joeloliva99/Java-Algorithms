import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BusquedaCombinatoria{
    
    static int[][] matrizCostes; // Almacena los costes de las aristas
    static String[] city; // Vector del nombre de las ciudades
    static int n; // Dimensión de matrizCostes y de las ciudades
    static ArrayList<Tour> soln=new ArrayList<Tour>();
    static int bestTour; // Se inicializa en init()
    static int blocked;
    static boolean DEBUG=true; // Muestra las decisiones aceptadas/rechazadas
    static boolean VERBOSE=true; // Muestra todos los tours descubiertos
 
    @SuppressWarnings("rawtypes")
    private static class Tour implements Comparable{
        int[] soln;
        int index;
        int dist;
        static int nTours=0;
        static boolean DFS=true;
        static boolean DBG=true;
            
        private Tour(int[] vect, int index, int[][] matrizCostes){
            dist = 0;
            for (int k = 1; k < index; k++)
                dist += matrizCostes[vect[k - 1]][vect[k]];
            if (index == n)
                dist += matrizCostes[vect[n - 1]][vect[0]];
            soln = new int[n];
            System.arraycopy(vect, 0, soln, 0, n);
            this.index = index;
            nTours++;
            if (DBG)
                System.out.printf("Idx %d: %s\n", index, toString());
        }
 
        public int compareTo(Object o){
            Tour rt = (Tour) o;
            int c1 = rt.index - this.index, c2 = this.dist - rt.dist;
            if (DFS)
                return c1 == 0 ? c2 : c1;
            else
                return c2;
        }
 
        public String toString(){
            StringBuilder val = new StringBuilder(city[soln[0]]);
            for (int k = 1; k < n; k++)
                val.append(", " + city[soln[k]]);
            val.append(", " + city[soln[0]]);
            val.append(String.format(" for %d", dist));
            return val.toString();
        }
    }
 
    private static void init(Scanner inp){
        int sub1, sub2;
        String line;
        n = inp.nextInt();
        matrizCostes = new int[n][n];
        city = new String[n];
        for (sub1 = 0; sub1 < n; sub1++)
            Arrays.fill(matrizCostes[sub1], -1);
        inp.nextLine();
        for (sub1 = 0; sub1 < n; sub1++)
            city[sub1] = inp.nextLine();
        Arrays.sort(city);
        inp.nextLine();
        blocked = 0;
        while (inp.hasNext()){
            int head, tail;
            int dist;
            String src, dst;
            line = inp.nextLine();
            head = line.indexOf('"') + 1;
            tail = line.indexOf('"', head);
            src = line.substring(head, tail);
            head = line.indexOf('"', tail + 1) + 1;
            tail = line.indexOf('"', head);
            dst = line.substring(head, tail);
            dist = Integer.parseInt(line.substring(tail + 1).trim());
            sub1 = Arrays.binarySearch(city, src);
            sub2 = Arrays.binarySearch(city, dst);
            matrizCostes[sub1][sub2] = matrizCostes[sub2][sub1] = dist;
            blocked += dist;
        }
        blocked += blocked;
        bestTour = blocked;
    }
 
    private static void swap(int[] x, int p, int q){
        int tmp = x[p];
        x[p] = x[q];
        x[q] = tmp;
    }
 
    
    public static void tour(){
        int[] vect = new int[n];
        int start;
        Queue<Tour> work = new PriorityQueue<Tour>();
        for (int k = 0; k < n; k++)
            vect[k] = k;
        start = Arrays.binarySearch(city, "Spokane");
        if (start >= 0){
            vect[start] = 0;
            vect[0] = start;
        }
        work.add(new Tour(vect, 1, matrizCostes));
        while (!work.isEmpty()){
            Tour current = work.poll();
            int index = current.index;
            vect = current.soln;
            if (index == n){
                if (matrizCostes[vect[n - 1]][vect[0]] > 0){
                    if (current.dist < bestTour){
                        bestTour = current.dist;
                        soln.add(current);
                        if (DEBUG)
                            System.out.println("Accept " + current);
                    }
                    else if (DEBUG)
                        System.out.println("Too long:  " + current);
                }
                else if (DEBUG)
                    System.out.println("Invalid:   " + current);
            }
            else{
                int k;
                int hold; 
                for (k = index; k < n; k++){
                    swap(vect, index, k);
                    if (matrizCostes[vect[index - 1]][vect[index]] < 0)
                        continue;
                    work.add(new Tour(vect, index + 1, matrizCostes));
                }
                hold = vect[index];
                for (k = index + 1; k < n; k++)
                    vect[k - 1] = vect[k];
                vect[n - 1] = hold;
            }
        }
    }
 
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception{
        String filename = args.length == 0 ? "RoadSet.txt" : args[0];
        Scanner inp = new Scanner(new java.io.File(filename));
        System.out.println("Datos leídos de " + filename);
        init(inp);
        tour();
        if (VERBOSE){
            System.out.println("Tours descubiertos:");
            for (Tour opt : soln)
                System.out.println(opt);
        }
        if (soln.size() == 0){
            System.out.println("No se han encontrado tours.  Saliendo.");
            System.exit(0);
        }
        System.out.println(Tour.nTours + " Objetos tour generados.");
        Collections.sort(soln);
        System.out.println("Mejor tour:  ");
        System.out.println(soln.get(0));
    }
}