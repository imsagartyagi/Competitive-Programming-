import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class bruteforce {
    public static void main(String[] args) throws IOException {
        Reader1 scanner = new Reader1();
        int test = scanner.nextInt();
        StringBuilder builder=new StringBuilder();
        while (test-- >0){
            BigInteger a= new BigInteger(String.valueOf(scanner.nextLong()));
            BigInteger b= new BigInteger(String.valueOf(scanner.nextLong()));
            BigInteger n= new BigInteger(String.valueOf(scanner.nextLong()));
            builder.append(ourResult(a,b,n)).append("\n");
        }
        System.out.println(builder);
    }
    public static BigInteger ourResult(BigInteger a, BigInteger b, BigInteger n){
        BigInteger temp=a.subtract(b);
        BigInteger q=temp.abs();
        BigInteger mod= BigInteger.valueOf(1000000007);
        if (q.equals(BigInteger.ZERO)){
            BigInteger x=a.modPow(n,mod);
            BigInteger y=b.modPow(n,mod);
            BigInteger p=x.add(y).mod(mod);
            return  p;
        }
        else {
            BigInteger x =a.modPow(n,q);
            BigInteger y =b.modPow(n,q);
            BigInteger p = x.add(y).mod(q);
            BigInteger ans = p.gcd(q).mod(mod);
            return ans;
        }

    }
}
class Reader1
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader1()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader1(String file_name) throws IOException
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

