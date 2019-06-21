import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String string = scanner.next();
            int[] con_Comparison = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                if (string.charAt(i) != string.charAt(i + 1)) {
                    con_Comparison[i] = 1;
                }
            }
            long[] sumArr = new long[n - 1];
            sumArr[0] = con_Comparison[0];
            for (int i = 1; i < n - 1; i++) {
                sumArr[i] = sumArr[i - 1] + con_Comparison[i];
            }
            long[] ans = new long[n - k];
            ans[0] = sumArr[k - 1];
            for (int i = 1; i < n - k; i++) {
                long x = previous_K_1_Sum(k + i - 1, sumArr, k - 1);
                long y = con_Comparison[k + i - 1];
                ans[i] = ans[i - 1] + x + y;
            }
            System.out.println(ans[n - k - 1]);
        }
    }

    private static long previous_K_1_Sum(int i,long[] sumArr,int k) {
        return sumArr[i-1]-sumArr[i-1-k];
    }
}
