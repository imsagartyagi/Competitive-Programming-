import java.util.Scanner;

public class EditDistance {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        while (test-- >0){
            String s1=scanner.next();
            String s2=scanner.next();
            int n=s1.length();
            int m=s2.length();
            int[][] dp=new int[n+1][m+1];
            for (int i=0;i<=n;i++){
                dp[i][0]=i;
            }
            for (int j=0;j<=m;j++){
                dp[0][j]=j;
            }
            for (int i=1;i<=n;i++){
                for (int j=1;j<=m;j++){
                    if (s1.charAt(i-1)==s2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1];
                    }
                    else {
                        dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
                    }
                }
            }
            int ans=dp[n][m];
            System.out.println(ans);
        }
    }
}
