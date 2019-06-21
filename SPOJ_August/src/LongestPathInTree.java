import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LongestPathInTree {
    static class node{
        int val;
        int dist;
    }
    public static void main(String[] args) throws IOException {
        Reader2 scanner=new Reader2();
        int n=scanner.nextInt();
        ArrayList<Integer>[] graph=new ArrayList[n+1];
        for (int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for (int i=1;i<=n-1;i++){
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        boolean[] visited=new boolean[n+1];
        int s2=BFS(graph,1,visited,n).val;
        visited=new boolean[n+1];
        int longestPath=BFS(graph,s2,visited,n).dist;
        System.out.println(longestPath);
    }

    private static node BFS(ArrayList<Integer>[] graph, int start, boolean[] visited, int n) {
        int[] distance=new int[n+1];
        distance[start]=0;
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(start);
        visited[start]=true;
        node max=new node();
                max.val=0;
                max.dist=0;
        while (!q.isEmpty()){
            int current=q.poll();
            for (int i=0;i<graph[current].size();i++){
                int x=graph[current].get(i);
                if (!visited[x]){
                    q.add(x);
                    visited[x]=true;
                     distance[x]=distance[current]+1;
                }
                if (distance[x]>max.dist){
                    max.dist=distance[x];
                    max.val=x;
                }
            }
        }
        return max;
    }

}
class Reader2
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader2()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader2(String file_name) throws IOException
    {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException
    {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1)
        {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt);
    }

    public int nextInt() throws IOException
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do
        {
            ret = ret * 10 + c - '0';
        }  while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }

    public long nextLong() throws IOException
    {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    public double nextDouble() throws IOException
    {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();

        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');

        if (c == '.')
        {
            while ((c = read()) >= '0' && c <= '9')
            {
                ret += (c - '0') / (div *= 10);
            }
        }

        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException
    {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException
    {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }

    public void close() throws IOException
    {
        if (din == null)
            return;
        din.close();
    }
}
