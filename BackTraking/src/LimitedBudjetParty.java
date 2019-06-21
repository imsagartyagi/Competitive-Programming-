import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LimitedBudjetParty {
    public static void main(String[] args) {
        FastScanner scanner=new FastScanner();
        int test=scanner.nextInt();
        StringBuilder builder=new StringBuilder();
        while(test-- >0){
            int n=scanner.nextInt();
            long X=scanner.nextInt();
            int[] arr=new int[n];
            for (int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            long[] sumArray=new long[n];
            sumArray[0]=arr[0];
            for (int i=1;i<n;i++){
               sumArray[i]=sumArray[i-1]+arr[i];
            }
            if (binarySearch(sumArray,X)){
                builder.append("YES").append("\n");
            }
            else {
                int i=n-1;
                for (i=n-1;i>=0;i--){
                    if (binarySearch(sumArray,sumArray[i]-X)){
                        builder.append("Yes").append("\n");
                        break;
                    }
                }
                if (i==-1){
                   builder.append("No").append("\n");
                }
            }
        }
        System.out.println(builder);
    }
   public static boolean binarySearch(long arr[], long x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r)
        {
            int m = l + (r-l)/2;

            // Check if x is present at mid
            if (arr[m] == x)
                return true;

            // If x greater, ignore left half
            if (arr[m] < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was
        // not present
        return false;
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

