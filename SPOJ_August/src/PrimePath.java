import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class PrimePath {
    public static void main(String[] args) throws IOException {
        Reader5 scanner=new Reader5();
        HashMap<Integer,Integer> map=new HashMap<>();
        boolean[] prime=sieve((int)1e5);
        int k=0;
        //TreeMap<Integer,Integer> map=new TreeMap<>();
        for (int i=1009;i<=9973;i++){
            if (prime[i]){
                map.put(i,k++);
            }
        }
        ArrayList<Integer>[] graph=new ArrayList[map.size()];
        for (int i:map.keySet()){
            int currentPrime=i;
            graph[map.get(i)]=new ArrayList<>();
            putOnce(graph[map.get(i)],currentPrime,prime);
            putTens(graph[map.get(i)],currentPrime,prime);
            putHundred(graph[map.get(i)],currentPrime,prime);
            putThousand(graph[map.get(i)],currentPrime,prime);
        }
        int test=scanner.nextInt();
        StringBuilder builder=new StringBuilder();
        while(test-- >0){
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            int steps=bfs(map,graph,a,b);
            builder.append(steps).append("\n");
        }
        System.out.println(builder);
    }

    private static int bfs(HashMap<Integer, Integer> map, ArrayList<Integer>[] graph, int start, int end) {
        HashMap<Integer,Boolean> visited=new HashMap<>();
        Queue<Integer> queue=new LinkedList<Integer>();
        HashMap<Integer,Integer> distance=new HashMap<>();
        queue.add(start);
        visited.put(start,true);
        while (!queue.isEmpty()){
           int currentPrime=queue.poll();
           for (int prime_i:map.keySet()){
               int i=map.get(prime_i);
               if (graph[i].contains(currentPrime)&&!visited.getOrDefault(prime_i,false)){
                   queue.add(prime_i);
                   visited.put(prime_i,true);
                   distance.put(prime_i,1+distance.getOrDefault(currentPrime,0));
                   if (prime_i==end){
                       return distance.get(prime_i);
                   }
               }
           }
        }
        return 0;
    }

    private static void putThousand(ArrayList<Integer> arrayList, int currentPrime, boolean[] prime) {
        int x=currentPrime%1000;
        int val=currentPrime/10000;
        for (int i=0;i<=9;i++){
            if (prime[(i*1000)+x]){
                if ((i*1000)+x==currentPrime){
                    continue;
                }
                arrayList.add((i*1000)+x);
            }
        }
    }
    public static void putHundred(ArrayList<Integer> arrayList, int currentPrime, boolean[] prime) {
        int x=currentPrime%100;
        int val=currentPrime/1000;
        for (int i=0;i<=9;i++){
            if (prime[(val*10+i)*100+x]){
                if ((val*10+i)*100+x==currentPrime){
                    continue;
                }
                arrayList.add((val*10+i)*100+x);
            }
        }
    }
    public static void putTens(ArrayList<Integer> arrayList, int currentPrime, boolean[] prime) {
        int x=currentPrime%10;
        int val=currentPrime/100;
        for (int i=0;i<=9;i++){
            if (prime[(val*10+i)*10+x]){
                if ((val*10+i)*10+x==currentPrime) continue;
                arrayList.add((val*10+i)*10+x);
            }
        }
    }
    public static void putOnce(ArrayList<Integer> arrayList, int currentPrime, boolean[] prime) {
        int val=currentPrime/10;
        for (int i=0;i<=9;i++){
            if (prime[val*10+i]){
                if (val*10+i==currentPrime) continue;
                arrayList.add(val*10+i);
            }
        }
    }
    private static boolean[] sieve(int n) {
        boolean[] arr=new boolean[n+1];
        Arrays.fill(arr,true);
        for (int i=2;i*i<=n;i++){
            if (arr[i]==true){
                for (int j=i;j*i<=n;j++){
                    arr[j*i]=false;
                }
            }
        }
        return arr;
    }
}
class Reader5
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader5()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader5(String file_name) throws IOException
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

