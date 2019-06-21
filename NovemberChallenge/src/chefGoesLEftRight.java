import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chefGoesLEftRight {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        StringBuilder stringBuilder = new StringBuilder();
        int test = scanner.nextInt();
        while (test-- > 0) {
            int N = scanner.nextInt();
            int r = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            int max = maximumElement(arr);
            int min = minumumElement(arr);
            int i;
            for (i = 0; i < N; i++) {
                if (arr[i] > r && arr[i] < max && arr[i] > min) {
                    max = arr[i];
                } else if (arr[i] < r && arr[i] < max && arr[i] > min) {
                    min = arr[i];
                } else if (arr[i] == r) {
                    stringBuilder.append("YES").append("\n");
                } else if (arr[i]>max||arr[i]<min){
                    stringBuilder.append("NO").append("\n");
                    break;
                }
            }
        }
        System.out.println(stringBuilder);
    }

    public static int minumumElement(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int maximumElement(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static final class FastScanner {
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

