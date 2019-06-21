import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        while (test-- >0){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            boolean[][] adjacencyMatrix=new boolean[n][n];
            boolean[] visited=new boolean[n];
            for (int i=0;i<m;i++){
                int f=scanner.nextInt();
                int s=scanner.nextInt();
                adjacencyMatrix[f-1][s-1]=true;
                adjacencyMatrix[s-1][f-1]=true;
            }
            int[] distance=new int[n];
            Arrays.fill(distance,-1);
            System.out.println(hasPathBfsCount(adjacencyMatrix,n,0,n-1,visited,distance));
        }
    }
    public static int hasPathBfsCount(boolean[][] adjacencyMAtrix,int n,int start,int end,boolean[] visited,int[] distance){
        if (adjacencyMAtrix[start][end]==true){
            return 1;
        }
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(start);
        visited[start]=true;
        while (!queue.isEmpty()) {
            for (int i = 0; i < n; i++) {
                if (adjacencyMAtrix[queue.peek()][i] == true) {
                    if (visited[i]!=true&&distance[i]==-1) {
                        queue.add(i);
                        distance[i]=distance[queue.peek()]+1;
                        visited[i]=true;
                        if (i==end){
                            return distance[end]+1;
                        }
                    }
                }
            }
            queue.remove();
        }
        return 0;
    }
}
