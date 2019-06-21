import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int v=scanner.nextInt();
        int e=scanner.nextInt();
        int[][] graph=new int[e][3];
        for (int i=0;i<e;i++){
            graph[i][0]=scanner.nextInt();
            graph[i][1]=scanner.nextInt();
        }
        numberofCycles(v,e,graph);
        System.out.println(cyclecount);

    }
    public static int cyclecount=0;
    public static void numberofCycles(int vertices,int edges,int[][] graph){
        boolean[][] adjacencyMatrix=new boolean[vertices+1][vertices+1];
        for (int i=0;i<edges;i++){
            adjacencyMatrix[graph[i][0]][graph[i][1]]=true;
        }
        boolean[] visited=new boolean[vertices+1];
        graphDFS(adjacencyMatrix,visited,1);
    }

    public static void graphDFS(boolean[][] adjacencyMatrix, boolean[] visited, int start) {
        visited[start]=true;
        for (int i=1;i<=visited.length-1;i++){
            if (adjacencyMatrix[start][i]==true&&!visited[i]){
                graphDFS(adjacencyMatrix, visited, i);
            }
            else if (adjacencyMatrix[start][i]==true&&visited[i]){
                cyclecount++;
            }
        }
    }
}
