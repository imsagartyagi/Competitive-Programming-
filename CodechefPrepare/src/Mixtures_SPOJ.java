import java.util.Scanner;

public class Mixtures_SPOJ {
    static class node{
        int color,smoke;
        node(int color,int smoke){
            this.smoke=smoke;
            this.color=color;
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        //StringBuilder bui=new StringBuilder();
        while (in.hasNext()){
            int n=in.nextInt();
            int[] arr=new int[n];
            for (int i = 0; i < n; i++) {
                arr[i]=in.nextInt();
            }
            node[][] dp=new node[n][n];
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    dp[i][j]=new node(-1,-1);
                }
            }
            System.out.println(matrixChainMultiplication(arr,0,n-1,dp).smoke);
        }
        /*System.out.println(bui);*/
    }
    public static node matrixChainMultiplication(int[] arr, int i, int j, node[][] dp) {
        if (i==j){
            return new node(arr[i]%100,0);
        }
        if (dp[i][j].smoke!=-1){
            return dp[i][j];
        }
        int minsmoke=Integer.MAX_VALUE;
        int mincolor=-1;
        for (int k=i;k<j;k++){
           node left=matrixChainMultiplication(arr, i, k, dp);
           node right=matrixChainMultiplication(arr, k+1, j, dp);
           int color=(left.color%100+right.color%100)%100;
           int smoke=left.smoke+right.smoke+left.color*right.color;
           if (minsmoke>smoke){
               minsmoke=smoke;
               mincolor=color;
           }
        }
        dp[i][j]=new node(mincolor,minsmoke);
        return dp[i][j];
    }
}
