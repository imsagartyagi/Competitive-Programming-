import java.io.*;
import java.util.*;
// adjacencyMAtrix is Not working giving tle because of the fact that there are only n-1 edges
// we should have used adjacencyList
public class LongestPathInATree {
    static class node{
        int val;
        int dist;
    }
    public static void main(String[] args) throws IOException {
        Reader scanner=new Reader();
        int n=scanner.nextInt();
        boolean[][] adjacencyMatrix=new boolean[n+1][n+1];
        for (int i=1;i<=n-1;i++){
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            adjacencyMatrix[a][b]=true;
            adjacencyMatrix[b][a]=true;
        }
        boolean[] visited=new boolean[n+1];
       int s2=BFS(adjacencyMatrix,1,visited,n).val;
       visited=new boolean[n+1];
       int ans=BFS(adjacencyMatrix,s2,visited,n).dist;
       System.out.println(ans);

    }
    public static node BFS(boolean[][] adjacencyMatrix,int start,boolean[] visited,int n){
        int[] dist=new int[n+1];
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(start);
        dist[start]=0;
        visited[start]=true;
        node max=new node();
        max.val=0;
        max.dist=0;
        while (!queue.isEmpty()){
            int currentItem=queue.poll();
            for (int i=1;i<=n;i++){
                if (adjacencyMatrix[currentItem][i]&&!visited[i]){
                    queue.add(i);
                    visited[i]=true;
                    dist[i]=dist[currentItem]+1;
                }
                if (dist[i]>max.dist){
                    max.dist=dist[i];
                    max.val=i;
                }
            }
        }
        return max;
    }

}

 class Reader
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException
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
