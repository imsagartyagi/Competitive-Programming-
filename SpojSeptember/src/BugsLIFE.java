import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class BugsLIFE {
    // We are just Checking Here weather the graph is bipartrite of not!
    public static void main(String[] args) throws IOException {
        Reader2 in=new Reader2();
        int test=in.nextInt();
        int x=test;
        StringBuilder builder=new StringBuilder();
        while(test-- >0){
            int v=in.nextInt();
            int e=in.nextInt();
            boolean[][] adjacencyMatrix=new boolean[v+1][v+1];
            for (int i = 0; i < e; i++) {
                int a=in.nextInt();
                int b=in.nextInt();
                adjacencyMatrix[a][b]=true;
                adjacencyMatrix[b][a]=true;
            }
            int[] colored=new int[v+1];
            Arrays.fill(colored,-1);
            boolean ans=true;
            for (int i=1;i<colored.length;i++){
                if (colored[i]==-1){
                    boolean isBipartrite=Bipartrite(adjacencyMatrix,colored,i);
                    ans=ans&isBipartrite;
                }
            }
           if (ans){
               builder.append("Scenario #"+(x-test)+":").append("\n");
               builder.append("No suspicious bugs found!").append("\n");
           }
           else {
               builder.append("Scenario #"+(x-test)+":").append("\n");
               builder.append("Suspicious bugs found!").append("\n");
           }
        }
        System.out.println(builder);

    }
    public static boolean Bipartrite(boolean[][] adjacencyMatrix, int[] colored, int start) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);
        colored[start]=1;
        while (!queue.isEmpty()){
            int currentVertex=queue.poll();
            for (int i=1;i<colored.length;i++){
                if (adjacencyMatrix[currentVertex][i]&&colored[i]==-1){
                    colored[i]=colored[currentVertex]^1;
                    queue.add(i);
                }
                else if (adjacencyMatrix[currentVertex][i]&&colored[i]!=-1){
                    if (colored[i]==colored[currentVertex]){
                        return false;
                    }
                }
            }
        }
        return true;
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

