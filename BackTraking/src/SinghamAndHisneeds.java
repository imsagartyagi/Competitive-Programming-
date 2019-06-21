import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SinghamAndHisneeds {
    public static void main(String[] args) {
        FastScanner scanner=new FastScanner();
        int test=scanner.nextInt();
        StringBuilder builder=new StringBuilder();
        while(test-- >0){
            int n=scanner.nextInt();
            int k=scanner.nextInt();
            builder.append(Largestpower(n,k)).append("\n");
        }
        System.out.println(builder);
    }
    static int Largestpower(int n, int p)
    {
        int ans = 0;
        while (n > 0)
        {
            n /= p;
            ans += n;
        }
        return ans;
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

