import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class PhilospherStone {
    public static void main(String[] args) throws IOException {
        Reader10 sc=new Reader10();
        int test=sc.nextInt();
        StringBuilder builder=new StringBuilder();
        while (test-- >0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[][] arr=new int[n][m];
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            int[][] dp=new int[n][m];
            for (int j=0;j<m;j++){
                dp[n-1][j]=arr[n-1][j];
            }
            for (int i=n-2;i>=0;i--){
                for (int j=0;j<m;j++){
                    if (j==0){
                        dp[i][j]=arr[i][j]+Math.max(dp[i+1][j],dp[i+1][j+1]);
                    }
                    else if (j==m-1){
                        dp[i][j]=arr[i][j]+Math.max(dp[i+1][j],dp[i+1][j-1]);
                    }
                    else{
                        dp[i][j]=arr[i][j]+Math.max(dp[i+1][j],Math.max(dp[i+1][j+1],dp[i+1][j-1]));
                    }
                }
            }
            int max=Integer.MIN_VALUE;
            for (int j=0;j<m;j++){
                if (dp[0][j]>max){
                    max=dp[0][j];
                }
            }
            builder.append(max).append("\n");
        }
        System.out.println(builder);
    }
}
class Reader10
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader10()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader10(String file_name) throws IOException
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
