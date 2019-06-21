import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class test3 {
    static class node{
        int key;
        int count;
    }
    public static void main(String[] args) throws IOException {
        Reader27 scanner=new Reader27();
        int test=scanner.nextInt();
        StringBuilder builder=new StringBuilder();
        while (test-- >0){
            int n=scanner.nextInt();
            TreeMap<Integer,Integer> map=new TreeMap<Integer, Integer>();
            for (int i=0;i<n;i++){
                int x=scanner.nextInt();
                map.put(x,map.getOrDefault(x,0)+1);
            }
            node[] arr=new node[map.size()];
            for (int i=0;i<map.size();i++){
                arr[i]=new node();
            }
            int k=0;
            for (int i:map.keySet() ){
                if (map.get(i)>=2){
                    arr[k].key=i;
                    arr[k].count=map.get(i);
                    k++;
                }
            }
            int a=-1,b=-1;
            double min=Integer.MAX_VALUE;
            for (int i=0;i<k-1;i++){
                if (arr[i].count>=4){
                    a=arr[i].key;
                    b=arr[i].key;
                    break;
                }
                double possible=Math.pow(arr[i].key+arr[i+1].key,2)/(arr[i].key*arr[i+1].key);
                if (possible<min){
                    min=possible;
                    a=arr[i].key;
                    b=arr[i+1].key;
                }
            }
            if (arr[k-1].count>=4){
                a=arr[k-1].key;
                b=arr[k-1].key;
            }
            builder.append(a+" "+b+" "+a+" "+b).append("\n");
        }
        System.out.println(builder);
    }
}
class Reader27
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader27()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader27(String file_name) throws IOException
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

