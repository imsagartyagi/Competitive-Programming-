import java.util.*;

public class ValidBFS {
    public static void main(String[] args) {
        class node {
            int val;
            int indx;
        }
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        ArrayList<Integer>[] graph=new ArrayList[n+1];
        for (int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a=in.nextInt();
            int b=in.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        node[] givenbfs=new node[n+1];
        for (int i=1;i<n;i++){
            givenbfs[i].val=in.nextInt();
            givenbfs[i].indx=i;
        }
       /* for (int i=1;i<=n;i++){
            Collections.sort(graph[i], new Comparator<node>() {
                @Override
                public int compare(node o1, node o2) {
                    return o1.indx-o2.indx;
                }
            });
        }*/
        int[] distance=new int[n+1];
        int flag=0;
        ArrayList<Integer> bfs= bfs(graph,distance,1);
        for (int i=1;i<=n;i++){
            int x=in.nextInt();
            int y=bfs.get(i);
            if (distance[x]!=distance[y]){
                flag=1;
                break;
            }
        }
        if (flag==0){
            System.out.println("Yes");
        }
        else System.out.println("No");
    }
    private static ArrayList<Integer> bfs(ArrayList<Integer>[] graph, int[] distance, int start) {
        Queue<Integer> q=new LinkedList<>();
        ArrayList<Integer> bfs=new ArrayList<>();
        bfs.add(0);
        boolean[] visited=new boolean[distance.length];
        q.add(start);
        bfs.add(start);
        visited[start]=true;
        while (!q.isEmpty()){
            int currentNode=q.poll();
            for (int i=1;i<distance.length;i++){
                if (graph[currentNode].contains(i)&&!visited[i]){
                    q.add(i);
                    bfs.add(i);
                    visited[i]=true;
                    distance[i]=distance[currentNode]+1;
                }
            }
        }
        return bfs;
    }
}
