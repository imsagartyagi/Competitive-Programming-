import java.util.Scanner;

public class bytelandsCoins {
     static int[] dp=new int[125000000];
    public static void main(String[] args) {
        dp[1]=1;
        dp[0]=0;
        for (int i=2;i<125000000;i++){
            dp[i]=Math.max(dp[i/2]+dp[i/3]+dp[i/4],i);
        }
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
                long ans = goldCoin(n);
                System.out.println(ans);
            }
        }
    private static long goldCoin(int n) {
        if (n<125000000){
            return
            dp[n];
        }
        long x= goldCoin(n/2)+goldCoin(n/3)+goldCoin(n/4);
        return Math.max(n,x);
    }
}
