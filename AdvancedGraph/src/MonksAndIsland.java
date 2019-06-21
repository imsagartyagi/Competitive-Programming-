/*
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MonksAndIsland {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int test=scanner.nextInt();
        while (test-- >0){
            int n=scanner.nextInt();
            int e=scanner.nextInt();
            boolean[][] adjacencyMatrix=new boolean[n+1][n+1];
            for (int i=0;i<e;i++){
                int a=scanner.nextInt();
                int b=scanner.nextInt();
                adjacencyMatrix[a][b]=true;
                adjacencyMatrix[b][a]=true;
            }
            boolean[] visited=new boolean[n+1];
            System.out.println(shortestPath(adjacencyMatrix,visited,1,n));
        }
    }

    private static int shortestPath(boolean[][] adjacencyMatrix, boolean[] visited,int sv,int n) {
        int[] distance=new int[n+1];
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(sv);
        visited[sv]=true;
        while (!queue.isEmpty()){
            int currentElement=queue.poll();
            for (int i=1;i<=n;i++){
                if (adjacencyMatrix[currentElement][i]&&!visited[i]){
                    queue.add(i);
                    visited[i]=true;
                    distance[i]=distance[currentElement]+1;
                    if (distance[n]!=0){
                        return distance[n];
                    }
                }
            }
        }
        return distance[n];
    }
}
*/
