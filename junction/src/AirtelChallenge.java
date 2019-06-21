import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AirtelChallenge {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StringBuilder builder=new StringBuilder();
        int test=scanner.nextInt();
        while (test-- >0) {
            String str=scanner.next();
            boolean[] arr=new boolean[26];
            int startingvertes=-1;
            for (int i=0;i<str.length();i++){
                arr[str.charAt(i)-97]=true;
                if (arr[str.charAt(i)-97]==true){
                    startingvertes=str.charAt(i)-97;
                }
            }
            int e=scanner.nextInt();
            boolean[][] adjacencyMatrix=new boolean[26][26];
            for (int i=0;i<e;i++){
                char first=scanner.next().charAt(0);
                char second=scanner.next().charAt(0);
                int f=(int)first-97;
                int s=(int)second-97;
                adjacencyMatrix[f][s]=true;
                adjacencyMatrix[s][f]=true;
            }
            boolean[] visited=new boolean[26];
            BFS(visited,adjacencyMatrix,startingvertes);
            int i=0;
            for ( i=0;i<26;i++){
                if (arr[i]){
                    if (visited[i]){
                        continue;
                    }
                    else break;
                }
            }
            if (i==26){
                builder.append("YES").append("\n");
            }
            else builder.append("NO").append("\n");
        }
        System.out.println(builder);

    }

    private static void BFS(boolean[] visited, boolean[][] adjacencyMatrix, int startingvertes) {
        Queue<Integer> q=new LinkedList<>();
        q.add(startingvertes);
        visited[startingvertes]=true;
        while (!q.isEmpty()) {
            for (int i = 0; i < 26; i++) {
                if (adjacencyMatrix[startingvertes][i] == true) {
                    if (visited[i]==true) continue;
                    q.add(i);
                    visited[i] = true;
                }
            }
            q.remove();
            if (!q.isEmpty())
            startingvertes=q.peek();
        }

    }
}
