import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        while(test-- >0){
            int n=scanner .nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            System.out.println(farida(arr,0,n,0));
        }

    }
    public static int farida(int[] arr,int index,int n,int maxvalue){
        if(index>=n){
            return 0;
        }
        for(int i=index;i<n;i++){
            maxvalue=maxValue(maxvalue,farida(arr,i+2,n,maxvalue+arr[i]));
        }
        return maxvalue;
    }
    public static int maxValue(int a,int b){
        return (a>b)?a:b;
    }
    public static int coinChange(int n,int[] arr,int index,int[][] output){
        if (n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if (index==arr.length){
            return 0;
        }
        if (output[n][index]!=-1) return output[n][index];
        int ans1=coinChange(n-arr[index],arr,index,output);
        int ans2=coinChange(n,arr,index+1,output);
        output[n][index]=ans1+ans2;
        return ans1+ans2;
    }
    public static int longestCommonSubsequence(String a,String b,int[][] output){
        int m=a.length();
        int n=b.length();
        if (m==0||n==0){
            int returnval=0;
            output[m][n]=0;
            return returnval;
        }
        if (output[m][n]!=0){
            return output[m][n];
        }
        if (a.charAt(m-1)==b.charAt(n-1)){
            int returnvalue= 1+longestCommonSubsequence(a.substring(0,m-1),b.substring(0,n-1),output);
            output[m][n]=returnvalue;
            return returnvalue;
        }
        int returnvalue=  maxvalue(longestCommonSubsequence(a.substring(0,m-1),b,output),longestCommonSubsequence(a,b.substring(0,n-1),output));
        output[m][n]=returnvalue;
        return returnvalue;
    }
    private static int maxvalue(int a, int b) {
        return (a>b)?a:b;
    }
    public static long nCr(int n,int r,long[][] arr){
        if (r==0||r==n){
            return 1;
        }
        if (arr[n][r]!=0){
            return arr[n][r];
        }
        long output= nCr(n-1,r,arr)+nCr(n-1,r-1,arr);
        arr[n][r]=output;
        return output;

    }
}
