import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PerPalin {
    public static void main(String[] args) {
    FastScanner scanner=new FastScanner();
        int test=scanner.nextInt();
        String[] stringPalindromes=stringPalindrome(20000);
        StringBuilder stringBuilder=new StringBuilder();
        while(test -- >0) {
            StringBuilder builder=new StringBuilder();
            int n = scanner.nextInt();
            int p = scanner.nextInt();
            if (p==1||p==2){
                stringBuilder.append("impossibe").append("\n");
                continue;
            }
            int count=(n/p);
            for (int i=1;i<=count;i++){
                builder.append(stringPalindromes[p]);
            }
            stringBuilder.append(builder).append("\n");
        }
        System.out.println(stringBuilder);

     }

    public static String[] stringPalindrome(int length){
       String[] strings=new String[length+1];
       strings[2] =("ab");
       strings[3] =("aba");
       for (int i=4;i<=length;i++){
          strings[i]=strings[i-1].substring(0,1)+"b"+strings[i-1].substring(1);
       }
       return strings;
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
