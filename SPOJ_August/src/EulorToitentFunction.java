import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

public class EulorToitentFunction {
    public static void main(String[] args) throws IOException {
        Reader55 scanner = new Reader55();
        int Max = 1000005;
        int[] EulorToitent = new int[Max];
        for (int i = 0; i < Max; i++) {
            EulorToitent[i] = i;
        }
        for (int i = 2; i <Max; i++) {
            if (EulorToitent[i] == i) {
                for (int j = i; j < Max; j += i) {
                    EulorToitent[j] = (int) (((long)EulorToitent[j] * (i - 1)) / i);
                }
            }
        }
        for (int i = 2; i < Max; i++) {
           if(EulorToitent[i] == i){
               EulorToitent[i]=i-1;
           }
            System.out.println(EulorToitent[i]);
        }
        int test = scanner.nextInt();
        StringBuilder builder = new StringBuilder();
        while (test-- > 0) {
            builder.append(EulorToitent[scanner.nextInt()]).append("\n");
        }
        System.out.println(builder);
    }
}
    class Reader55
{
final private int BUFFER_SIZE = 1 << 16;
private DataInputStream din;
private byte[] buffer;
private int bufferPointer, bytesRead;

public Reader55()
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


