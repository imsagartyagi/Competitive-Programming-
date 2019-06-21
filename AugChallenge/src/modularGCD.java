import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class modularGCD {
    public static void main(String[] args) throws IOException {
        Reader scanner=new Reader();
        int test=scanner.nextInt();
        while (test-- >0){
            long a= scanner.nextLong();
            long b=scanner.nextLong();
            long n=scanner.nextLong();
            System.out.println(ourResult(a,b,n));
        }
    }
    public static long ourResult(long a,long b,long n){
        long q=Math.abs(a-b);
        if (q==0){
            int mod=1000000007;
            long x=modularexponentiation(a,n,mod);
            long y=modularexponentiation(b,n,mod);
            long p=(x+y)%mod;
            return (int) p;
        }
        else {
            long x = modularexponentiation(a, n, q);
            long y = modularexponentiation(b, n, q);
            long p = (x + y) % q;
            long ans = gcd(p, q)%1000000007;
            return ans;
        }
    }

    private static long gcd(long a,long b)
    {   long t;
        while (b != 0)
        {
            t = b;
            b = a%b;
            a = t;
        }
        return a;
    }
    public static long modularexponentiation(long a,long b,long c){
        long ans=1;
        while(b!=0){
            int rightMostBit= (int) (b&1);
            if (rightMostBit==1){
                ans=((ans%c)*(a%c))%c;
            }
            a=((a%c)*(a%c))%c;
            b=b/2;
        }
        return ans;
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
