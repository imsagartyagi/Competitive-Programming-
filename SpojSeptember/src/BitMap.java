import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class BitMap {
    public static void main(String[] args) throws IOException {
        Reader scanner = new Reader();
        int test = scanner.nextInt();
        StringBuilder builderTest=new StringBuilder();
        while (test-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            ArrayList<Integer>[][] graph = new ArrayList[2][n * m];
            for (int i = 0; i < n * m; i++) {
                graph[0][i] = new ArrayList<>();
                graph[1][i] = new ArrayList<>();
            }
            int a = 0;
            for (int i = 0; i < n; i++) {
                String s = scanner.readLine();
                for (int j = 0; j < m; j++) {
                    int x =s.charAt(j);
                    if (x == '0')
                        graph[0][a++].add(-1);
                    else graph[0][a++].add(0);
                }
            }
            for (int i = 0; i < n * m; i++) {
                if (i % m != 0)
                    graph[1][i].add(i - 1);
                if (i % m != m - 1)
                    graph[1][i].add(i + 1);
                if (i + m < n * m)
                    graph[1][i].add(i + m);
                if (i - m >= 0)
                    graph[1][i].add(i - m);
            }
            int[] distance = new int[n * m];
            boolean[] visited = new boolean[n * m];
            Queue<Integer> q=new LinkedList<>();
            for(int i=0;i<n*m;i++){
                if (graph[0][i].contains(0)){
                    distance[i]=0;
                    visited[i]=true;
                    q.add(i);
                }
            }
                    bfs(graph,visited,m,n,distance,q);
            int k = 0;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    builder.append(distance[k++] + " ");
                }
                builder.append("\n");
            }
            builderTest.append(builder).append("\n");
        }
        System.out.println(builderTest);
    }

    public static void bfs(ArrayList<Integer>[][] graph, boolean[] visited, int m, int n, int[] distance,Queue<Integer> q) {
        while (!q.isEmpty()){
            int currentNode=q.poll();
                if (currentNode % m != 0) {
                    if (graph[1][currentNode].contains(currentNode - 1) && !visited[currentNode - 1]&&!graph[0][currentNode-1].contains(0)) {
                        distance[currentNode - 1] = distance[currentNode] + 1;
                        visited[currentNode - 1] = true;
                        q.add(currentNode - 1);
                    }
                }
                if (currentNode % m != m - 1)
                    if (graph[1][currentNode].contains(currentNode+1)&&!visited[currentNode+1]&&!graph[0][currentNode+1].contains(0)){
                        distance[currentNode+1] = distance[currentNode] + 1;
                        visited[currentNode+1]=true;
                        q.add(currentNode+1);
                    }
                if (currentNode + m < n * m)
                    if (graph[1][currentNode].contains(currentNode+m)&&!visited[currentNode+m]&&!graph[0][currentNode+m].contains(0)){
                        distance[currentNode+m] = distance[currentNode] + 1;
                        visited[currentNode+m]=true;
                        q.add(currentNode+m);
                    }
                if (currentNode - m >= 0)
                    if (graph[1][currentNode].contains(currentNode-m)&&!visited[currentNode-m]&&!graph[0][currentNode-m].contains(0)){
                        distance[currentNode-m] = distance[currentNode] + 1;
                        visited[currentNode-m]=true;
                        q.add(currentNode-m);
                    }
            }

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
        byte[] buf = new byte[186]; // line length
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
