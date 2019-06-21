import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Seaco {
    public static void main(String[] args) {
        FastScanner1 scanner1=new FastScanner1();
        StringBuilder stringBuilder=new StringBuilder();
        int test=scanner1.nextInt();
        while (test-- >0){
            StringBuilder builder=new StringBuilder();
            int N=scanner1.nextInt();
            int[] arr=new int[N];
            int m=scanner1.nextInt();
            int[][] query=new int[m][3];
            for (int i=0;i<m;i++) {
                for (int j = 0; j < 3; j++) {
                    query[i][j] = scanner1.nextInt();
                }
                if (query[i][0] == 1) {
                    increasebyone(arr, query[i][1], query[i][2]);
                } else if (query[i][0] == 2) {
                    querytype2(query, arr, query[i][1], query[i][2]);
                }
            }
          for (int i=0;i<N;i++){
                builder.append(arr[i]).append(" ");
          }
        stringBuilder.append(builder).append("\n");
        }
        System.out.println(stringBuilder);
      }
     static void increasebyone(int[] arr, int l, int r){
           for (int i=l;i<=r;i++){
               arr[i-1]+=1;
           }
      }
     static void querytype2( int[][] query, int[] arr, int l, int r){
         for (int i=l;i<=r;i++){
             if (query[i-1][0]==1){
                 increasebyone(arr ,query[i-1][1],query[i-1][2]);
             }
             else if (query[i-1][0]==2){
                 querytype2(query,arr,query[i-1][1],query[i-1][2]);
             }
         }
      }

    }

final class FastScanner1
{
    BufferedReader br;
    StringTokenizer st;

    public FastScanner1()
    {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt()
    {
        return Integer.parseInt(next());
    }

    long nextLong()
    {
        return Long.parseLong(next());
    }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}


