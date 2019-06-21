import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class CAM5 {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        StringBuilder builder=new StringBuilder();
        while (test-- >0){
            int n=scanner.nextInt();
            int[][] graph=new int[n][n];
            boolean[] visited=new boolean[n];
            int e=scanner.nextInt();
            for (int i=0;i<e;i++){
                int a=scanner.nextInt();
                int b=scanner.nextInt();
                graph[a][b]=1;
                graph[b][a]=1;
            }
            int count=0;
            for (int i=0;i<n;i++){
                if (!visited[i]){
                    dfs(graph,i,visited);
                    count++;
                }
            }
            builder.append(count).append("\n");
        }
        System.out.println(builder);
    }

    private static void dfs(int[][] graph, int start, boolean[] visited) {
        visited[start]=true;
        for (int i=0;i<visited.length;i++){
            if (graph[start][i]==1&&!visited[i]){
                visited[i]=true;
                dfs(graph,i,visited);
            }
        }
    }
}




