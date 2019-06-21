import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] likes=new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                likes[i][j]=scanner.nextInt();
            }
        }
        System.out.println(candy(likes,n));
    }
    // dp_BITMASKING

    public static long candy(int[][] like,int N ){
        long[] dp=new long[(1<<N)];
        dp[dp.length-1]=1;
        for(int mask=(1<<N)-2;mask>=0;mask--){
            int temp=mask;
            int k=0;
            while (temp>0){
                int lastBit=temp&1;
                k=k+lastBit;
                temp/=2;
            }
            for (int i=0;i<N;i++){
                if (like[k][i]==1&&(mask&(1<<i))==0){
                    dp[mask]+=dp[mask | (1<<i)];
                }
            }
        }
          return dp[0];
    }



//DP
    public static int Mixtures(int[] arr,int[][] dp,int i,int j){
        if (i==j){
            dp[i][j]=0;
            return 0;
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        int minAns=Integer.MAX_VALUE;
        for (int k=i;k<j;k++){
            int possibleAns=Mixtures(arr,dp,i,k)+Mixtures(arr, dp,k+1, j)+modSum(arr,i,k)*modSum(arr,k+1,j);
            minAns=min_of(possibleAns,minAns);
        }
        dp[i][j]=minAns;
        return minAns;
    }
    public static int modSum(int[] arr,int start,int end){
        int mod=100;
        int ans=0;
        for (int i=start;i<=end;i++){
            ans=(ans%mod+arr[i]%mod)%mod;
        }
        return ans;
    }
    public static int MatrixChainMultiplication(int[] arr, int[][] dp,int i ,int j){
        if (i==j){
            dp[i][j]=0;
            return 0;
        }
        if (dp[i][j]!=-1){
            return dp[i][j];
        }
        int minAnswer=Integer.MAX_VALUE;
      for (int k=i;k<j;k++){
          int possibleAns=MatrixChainMultiplication(arr,dp,i,k)+MatrixChainMultiplication(arr,dp,k+1,j)+((arr[i-1]*arr[k])*arr[j]);
          minAnswer=min_of(minAnswer,possibleAns);
      }
        dp[i][j]=minAnswer;
      return minAnswer;
    }
    private static int min_of(int a, int b) {
        return (a<b)?a:b;
    }
}
