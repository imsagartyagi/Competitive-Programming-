import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SubArrays {
    public static void main(String[] args) throws IOException {
        Reader4 in=new Reader4();
        int n=in.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=in.nextInt();
        }
        int[] tree=new int[4*n];
        buildSegmentTree(tree,arr,0,n-1,1);
        int k=in.nextInt();
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<=n-k;i++){
            int a=i;
            int b=i+k-1;
            builder.append(segMin(tree,a,b,0,n-1,1)+" ");
        }
        System.out.println(builder);
    }

    private static int segMin(int[] tree, int left, int right, int start, int end, int treenode) {
        if (start>right||end<left){
            return Integer.MIN_VALUE;
        }
        if (start>=left&&end<=right){
            return tree[treenode];
        }
        int mid=(start+end)/2;
        int op1=segMin(tree, left, right, start, mid, treenode*2);
        int op2=segMin(tree, left, right, mid+1, end, treenode*2 + 1);
        return Math.max(op1,op2);
    }

    private static void buildSegmentTree(int[] tree, int[] arr, int start, int end, int treenode) {
        if (start==end){
            tree[treenode]=arr[start];
            return;
        }
        int mid=(start+end)/2;
        buildSegmentTree(tree, arr, start, mid, treenode*2);
        buildSegmentTree(tree, arr, mid+1, end, treenode*2+1);
        tree[treenode]=Math.max(tree[treenode*2],tree[treenode*2+1]);
    }
}
class Reader4
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader4()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader4(String file_name) throws IOException
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


