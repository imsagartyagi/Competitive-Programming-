import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {

    public static void main(String[] args) {
        FastScanner1 scanner=new FastScanner1();
     int test=scanner.nextInt();
     int[] arr=sieveOfErastosthenes(1000000);
     while(test-- >0){
         int n=scanner.nextInt();
         int m=scanner.nextInt();
         int sum=0;
         for (int i=n;i<m;i++){
             sum+=arr[i];
         }
         System.out.println(sum);
     }

    }

    public static int[] sieveOfErastosthenes(int N){
        int[] primality=new int[N+1];
        for (int i=2;i<(N);i++){
            if (primality[i]==0) {
                for (int j = 1; j * i < N + 1; j++) {
                    primality[j * i]++;
                }
            }
        }
        return primality;
    }

    static final class FastScanner1 {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner1() {
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

