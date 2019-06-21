import java.io.IOException;
import java.util.Scanner;

public class PrincessFarida {
    public static void main(String[] args) throws IOException {
       Scanner scanner=new Scanner(System.in);
       int test=scanner.nextInt();
       int k=test;
       while (test-- >0){
           int n=scanner.nextInt();
           int[] arr=new int[n];
           for (int i=0;i<n;i++){
               arr[i]=scanner.nextInt();
           }
           long[] dp=new long[n];
           if (arr.length>0)
           dp[0]=arr[0];
           if (arr.length>1)
           dp[1]=Math.max(arr[0],arr[1]);
           for (int i=2;i<n;i++){
               dp[i]=dp[i-1];
              dp[i]= Math.max(dp[i],arr[i]+dp[i-2]);
           }
if (dp.length>=1)          System.out.println("Case "+(k-test)+": "+dp[n-1]);
           else if (dp.length==0){
    System.out.println("Case "+(k-test)+": "+0);
}
       }
    }
}
