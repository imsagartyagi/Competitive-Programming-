import java.util.Scanner;

public class Procon1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test-- >0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int[] sumarr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sumarr[i] = sumarr[i - 1] + arr[i - 1];
            }
            int max = Integer.MIN_VALUE;
            for (int j = k; j <= n; j++) {
                int a=sumarr[j] - sumarr[j-k];
                if (sumarr[j] - sumarr[j-k] > max) {
                    max = sumarr[j] - sumarr[j - k];
                }
            }
            System.out.println(max);
        }
    }
}
