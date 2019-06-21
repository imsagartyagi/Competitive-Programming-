import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StringBuilder builder =new StringBuilder();
        int test=scanner.nextInt();
        while(test-- >0){
           int n=scanner.nextInt();
           int k=scanner.nextInt();
           boolean[] arr=new boolean[2*n];
           for (int i=0;i<k;i++){
               arr[scanner.nextInt()-1]=true;
           }
            builder.append(squareBrackets(arr,n,0,0)).append("\n");
        }
        System.out.println(builder);
    }

     public static int squareBrackets(boolean[] arr,int n,int oBrak,int cBrak){
        if (oBrak>n||cBrak>n){
            return 0;
        }
        if (oBrak==n&&cBrak==n){
            return 1;
        }
        if (oBrak==cBrak&&arr[oBrak+cBrak]==true){
            return squareBrackets(arr,n,oBrak+1,cBrak);
        }
        else if (oBrak==n){
            return squareBrackets(arr,n,oBrak,cBrak+1);
        }
        else {
            if (arr[oBrak+cBrak]==true){
                return squareBrackets(arr, n, oBrak+1, cBrak)+squareBrackets(arr, n, oBrak, cBrak+1);
            }
            return squareBrackets(arr, n, oBrak, cBrak+1);
         }
     }


    public static int tradersProfit(int[]arr,int k,int index,int ongoingTransaction,int[][][] output){
        if (k==0||index==arr.length){
            return 0;
        }
        if (output[k][index][ongoingTransaction]!=-1){
            return output[k][index][ongoingTransaction];
        }
        if (ongoingTransaction==1){
            int option1=tradersProfit(arr,k,index+1,1,output);
            int option2=arr[index]+tradersProfit(arr, k-1, index+1, 0,output);
            output[k][index][ongoingTransaction]= maxof(option1,option2);
            return output[k][index][ongoingTransaction];
        }
        else{
            int option1=tradersProfit(arr,k,index+1,0,output);
            int option2=tradersProfit(arr,k,index+1,1,output)-arr[index];
            output[k][index][ongoingTransaction]= maxof(option1,option2);
            return output[k][index][ongoingTransaction];
        }
    }
    private static int maxof(int a, int b) {
        return (a>b)?a:b;
    }
    public static long sumofDigit(long num){
        if (num==0) return 0;
       else if (num/10==0) {
         return (num*(num+1))/2;
     }

     int nOD=numberofDigits(num);
        long nines=0;
     while(nOD-- >1){
         nines+=9;
         nines*=10;
     }
     nines/=10;
     long firstDigit=reversedigit(num)%10;
     long  n=firstDigit-1;
     long ans1=(nines+1)*((n*(n+1))/2) + firstDigit*sumofDigit(nines);
     long ans2=(firstDigit*((reversedigit(reversedigit(num)/10)))+firstDigit)+sumofDigit(reversedigit(reversedigit(num)/10));
     return ans1+ans2;
    }
    public static long reversedigit(long num){
        long ans=0;
        while(num!=0){
            ans+=(num%10);
            ans*=10;
            num=num/10;
        }
        return ans/10;
    }
   public static int numberofDigits(long num){
        int ans=0;
        while(num!=0){
            ans++;
            num/=10;
        }
        return ans;
   }
     //wrong
    public static int charlieAndpilot(int[] a,int[] c, int diff,int n,int[][] output){
        if (n==-1) return 0;
        if (output[diff][n]!=-1) return output[diff][n];
        if (diff==0){
            output[diff][n]= a[n]+charlieAndpilot(a,c,diff+1,n-1,output);
            return output[diff][n];
        }
        else if (diff==n){
            output[diff][n]= c[n]+charlieAndpilot(a,c,diff-1,n-1,output);
            return output[diff][n];
        }
        else {
            int option1=a[n]+charlieAndpilot(a,c,diff+1,n-1,output);
            int option2=c[n]+charlieAndpilot(a,c,diff-1,n-1,output);
            output[diff][n]= minof(option1,option2);
            return output[diff][n];
        }
    }
    public static int wiserMan(int[][] arr,int m,int n){
       int[][] output=new int[m][n];
       for (int i=0;i<n;i++){
           output[m-1][i]=arr[m-1][i];
       }
       for (int i=m-2;i>=0;i--){
           for (int j=0;j<n;j++){
               if (j==0){
                   output[i][j]=arr[i][j]+minof(output[i+1][j],output[i+1][j+1]);
               }
               else if (j==n-1){
                   output[i][j]=arr[i][j]+minof(output[i+1][j-1],output[i+1][j]);
               }
               else
               output[i][j]=arr[i][j]+minof(output[i+1][j-1],minof(output[i+1][j],output[i+1][j+1]));
           }
       }
       int minans=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            if (output[0][i]<minans){
                minans=output[0][i];
            }
        }
        return minans;
    }
    private static int minof(int a, int b) {
        return (a<b)?a:b;
    }


    // TEST 2
    public static int tetrahedron(int n,int vertex,int[][] output){
        int mod=1000000007;
        if (n==0&&vertex==1){
            output[n][vertex]=1;
            return 1;
        }
        else if (n<=0){
            output[n][vertex]=0;
            return 0;
        }
        if (output[n][vertex]!=-1){
            return output[n][vertex];
        }
        if (vertex==1) {
            int option1 = tetrahedron(n - 1, 2,output);
            int option2 = tetrahedron(n - 1, 3,output);
            int option3 = tetrahedron(n - 1, 4,output);
            output[n][vertex]=((((option1%mod) + (option2%mod))%mod) + (option3)%mod)%mod;
            return ((((option1%mod) + (option2%mod))%mod) + (option3)%mod)%mod;
        }
       else if (vertex==2) {
            int option2 = tetrahedron(n - 1, 3,output);
            int option3 = tetrahedron(n - 1, 4,output);
            int option1 = tetrahedron(n - 1, 1,output);
            output[n][vertex]=((((option1%mod) + (option2%mod))%mod) + (option3)%mod)%mod;
            return ((((option1%mod) + (option2%mod))%mod) + (option3)%mod)%mod;
        }
        else if (vertex==3) {
            int option1 = tetrahedron(n - 1, 1,output);
            int option2 = tetrahedron(n - 1, 2,output);
            int option3 = tetrahedron(n - 1, 4,output);
            output[n][vertex]=((((option1%mod) + (option2%mod))%mod) + (option3)%mod)%mod;
            return ((((option1%mod) + (option2%mod))%mod) + (option3)%mod)%mod;
        }
        else {
            int option1 = tetrahedron(n - 1, 1,output);
            int option2 = tetrahedron(n - 1, 2,output);
            int option3 = tetrahedron(n - 1, 3,output);
            output[n][vertex]=((((option1%mod) + (option2%mod))%mod) + (option3)%mod)%mod;
            return ((((option1%mod) + (option2%mod))%mod) + (option3)%mod)%mod;
        }
    }
}
