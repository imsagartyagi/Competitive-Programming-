import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice {
    public static void main(String[] args) {
    FastScanner1 scanner1=new FastScanner1();
    StringBuilder stringBuilder=new StringBuilder();
    int test=scanner1.nextInt();
    while (test-- >0){
        StringBuilder builder=new StringBuilder();
        int N=scanner1.nextInt();
        for (int i=0;i<N;i++){
            if (((i+1)%3==0)&&((i+1)%5==0)){
                builder.append("FizzBuzz").append("\n");
            }
           else if ((i+1)%3==0){
             builder.append("Fizz").append("\n");
            }
           else if ((i+1)%5==0){
                builder.append("Buzz").append("\n");
            }
            else {
                builder.append(i+1).append("\n");
            }

        }
        stringBuilder.append(builder).append("\n");
    }
        System.out.println(stringBuilder);
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

