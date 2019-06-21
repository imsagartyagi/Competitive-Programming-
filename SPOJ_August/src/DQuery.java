import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DQuery {
    static class node implements Comparator<node>{
        int a;
        int b;
        int indx;
        @Override
        public int compare(node o1, node o2) {
            return o1.b-o2.b;
        }
    }
    public static void main(String[] args) throws IOException {
        Reader3 scanner=new Reader3();
        int n=scanner.nextInt();
        int[] lastIndex=new int[1000005];
        for (int i=0;i<1000005;i++){
            lastIndex[i]=-1;
        }
        int[] arr=new int[n+1];
        for (int i=1;i<=n;i++){
            arr[i]=scanner.nextInt();
        }
        int[] BIT=new int[n+1];
        int q=scanner.nextInt();
        node[] queries=new node[q];
        for (int i=0;i<q;i++){
            queries[i]=new node();
            queries[i].a=scanner.nextInt();
            queries[i].b=scanner.nextInt();
            queries[i].indx=i;
        }
        Arrays.sort(queries,new node());
        int k=0;
        int[] ans=new int[q];
        for (int i=1;i<=n;i++){
            update(BIT,i,1);
            if (lastIndex[arr[i]]!=-1){
                update(BIT,lastIndex[arr[i]],-1);
            }
            lastIndex[arr[i]]=i;
            while (k<q&&queries[k].b==i){
                ans[queries[k].indx]=query(BIT,queries[k].b)-query(BIT,queries[k].a-1);
                k++;
            }
        }
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<q;i++){
            builder.append(ans[i]).append("\n");
        }
        System.out.println(builder);
    }

    public static int query(int[] BIT, int indx) {
        int sum=0;
        for (;indx>0;indx-=indx&(-indx)){
              sum+=BIT[indx];
        }
        return sum;
    }

    public static void update(int[] BIT, int indx, int val) {
         for (;indx<BIT.length;indx+=indx&(-indx)){
             BIT[indx]+=val;
         }
    }
}
class Reader3
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader3()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader3(String file_name) throws IOException
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
