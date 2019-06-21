import java.util.Scanner;

public class AIBOHP {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        while (test-- >0){
            String s=scanner.next();
            char[] arr=s.toCharArray();
            int[][] dp=new int[arr.length+1][arr.length+1];
            for (int i=0;i<=arr.length;i++){
                for (int j=0;j<=arr.length;j++){
                    dp[i][j]=-1;
                }
            }
            int ans=approach(arr,0,arr.length-1,dp);
            System.out.println(ans);
        }
    }

    public static int approach(char[] arr, int i, int j, int[][] dp) {
        if (i>=j){
            dp[i][j]=0;
            return 0;
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        if (arr[i]==arr[j]){
            int x= approach(arr, i+1, j-1, dp);
            dp[i][j]=x;
            return x;
        }
        int option1=1+approach(arr, i+1, j, dp);
        int option2=1+approach(arr, i, j-1, dp);
        int x= Math.min(option1,option2);
        dp[i][j]=x;
        return x;
    }
}
