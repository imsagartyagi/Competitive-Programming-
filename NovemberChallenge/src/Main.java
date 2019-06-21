import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
      FastScanner1 scanner1=new FastScanner1();
      StringBuilder builder=new StringBuilder();
      int test=scanner1.nextInt();
        while(test -- >0){
            String string =scanner1.nextLine();
            int counta=0;
            int lastIndex=0;
            int countb=0;
            for (int i=0;i<string.length();i++){
                if (string.charAt(i)=='A'){
                    counta++;
                    if (string.charAt(lastIndex)=='A'){
                        if (i!=lastIndex)
                        counta+=(i-lastIndex-1);
                    }
                    lastIndex=i;
                    continue;
                }
                else if (string.charAt(i)=='B'){
                    countb++;
                    if (string.charAt(lastIndex)=='B'){
                        if(i!=lastIndex)
                        countb+=(i-lastIndex-1);

                    }
                    lastIndex=i;
                    continue;
                }
            }
           builder.append(counta+" "+countb).append("\n");
        }
        System.out.println(builder);
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
