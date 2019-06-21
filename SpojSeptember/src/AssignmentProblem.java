import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

public class AssignmentProblem {
    //Bitmasking-Dp
    public static void main(String[] args) throws IOException {
        Reader6 in=new Reader6();
        int test=in.nextInt();
        StringBuilder builder=new StringBuilder();
        while (test-- >0){
            int n=in.nextInt();
            boolean[][] valid=new boolean[n][n];
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    valid[i][j]=(in.nextInt()==1)?true:false;
                }
            }
            long[] ans=new long[(1<<n)];
            ans[ans.length-1]=1;
            for (int mask=ans.length-2;mask>=0;mask--){
                int countBits=countSetBits(mask,n);
                for (int j=0;j<n;j++){
                    if ((mask&(1<<j))==0){
                        if (valid[countBits][j]==true)
                          ans[mask]+=ans[mask|(1<<j)];
                    }
                }
            }
           builder.append(ans[0]).append("\n");
        }
        System.out.println(builder);
    }
    private static int countSetBits(int mask, int n) {
        int count=0;
        for (int i=0;i<n;i++ ){
            if ((mask&(1<<i))!=0){
                count++;
            }
        }
        return count;
    }
}
class Reader6
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader6()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
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
}

