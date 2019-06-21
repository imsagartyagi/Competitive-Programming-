import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class kruskals_Algo {
    public static class Edge implements Comparator<Edge>{
         int source,destiation,weight;
        @Override
        public int compare(Edge o1, Edge o2) {
            return (o1.weight-o2.weight);
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int e=scanner.nextInt();
        Edge[] input=new Edge[e];
        for (int i=0;i<e;i++){
            input[i]=new Edge();
            input[i].source=scanner.nextInt();
            input[i].destiation=scanner.nextInt();
            input[i].weight=scanner.nextInt();
        }
        Arrays.sort(input,new Edge());
        Edge[] output=new Edge[n-1];
        int[] parent=new int[n];
        for (int i=0;i<n;i++){
            parent[i]=i;
        }
        int count =0;
        while(count!=n-1){
            
        }
    }
}
