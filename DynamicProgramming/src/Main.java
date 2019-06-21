

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        while(test-- >0) {
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int[][] arr = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            System.out.println(magicGrid(arr, 0, 0, r - 1, c - 1));
        }
    }
    public static int magicGrid(int[][] arr,int si,int sj,int ei,int ej){
       int[][] output=new int[ei+1][ej+1];
       output[ei][ej]=1;
       for (int i=ei-1;i>=0;i--){
           output[i][ej]=output[i+1][ej]-arr[i][ej];
           if (output[i][ej]<=0){
               output[i][ej]=1;
           }
       }
       for (int i=ej-1;i>=0;i--){
           output[ei][i]=output[ei][i+1]-arr[ei][i];
           if (output[ei][i]<=0){
               output[ei][i]=1;
           }
       }
       for (int i=ei-1;i>=0;i--){
           for (int j=ej-1;j>=0;j--){
               output[i][j]=minof(output[i+1][j],output[i][j+1])-arr[i][j];
               if (output[i][j]<=0){
                   output[i][j]=1;
               }
           }
       }
       return output[0][0];
    }
    private static int minof(int a, int b) {
        return (a<b)?a:b;
    }
    public static int Rk(String string){
        int current_max_subarray=0;
        int max_subarray_sofar=0;
        int count_R=0;
        for(int i=0;i<string.length();i++){
            if (string.charAt(i)=='R'){
                count_R++;
            }
        }
        for(int i=0;i<string.length();i++){
            if (string.charAt(i)=='R'){
                current_max_subarray--;
            }
            else if (string.charAt(i)=='K'){
                current_max_subarray++;
            }
            if (current_max_subarray<0){
                current_max_subarray=0;
            }
            max_subarray_sofar=max(current_max_subarray,max_subarray_sofar);
        }
        if (count_R==string.length()){
            return count_R-1;
        }
        return count_R+max_subarray_sofar;

    }
    public static int max(int a,int b){
        return (a>b)?a:b;
    }
    public static long farida(int[] arr ){
        int n=arr.length;
        if (n==1){
            return arr[0];
        }
        long[] dynamicSoln=new long[n];
        dynamicSoln[0]=arr[0];
        dynamicSoln[1]=max(arr[0],arr[1]);
        for(int i=2;i<n;i++){
            dynamicSoln[i]=max(dynamicSoln[i-1],dynamicSoln[i-2]+arr[i]);
        }
        return dynamicSoln[n-1];
    }
    public static long max(long a,long b){
        return (a>b)?a:b;
    }
    public static int alphaCodeIterative(String string){
        int mod=1000000007;
        int[] output=new int[string.length()+1];
        output[0]=1;
        output[1]=1;
        for (int i=2;i<=string.length();i++){
                if (string.charAt(i-1)=='0'){
                    if(string.substring(i-2,i-1).equals("0")) {
                        return 0;
                    }
                   else if (Integer.parseInt(string.substring(i - 2, i)) <= 26)
                        output[i] = ((output[i] % mod) + (output[i - 2]) % mod) % mod;
                    continue;
                }
            output[i]=output[i-1];
                if(!string.substring(i-2,i-1).equals("0")) {
                    if (Integer.parseInt(string.substring(i - 2, i)) <= 26)
                        output[i] = ((output[i] % mod) + (output[i - 2]) % mod) % mod;
                }
        }
        return output[string.length()];
    }
    public static int longestBitonicSubarray(int[] arr){
        int[] lis=longestIncreasingSubsequencArray(arr);
        int[] lds=longestDecreasingSubsequenceArray(arr);
        int[] bitonicArray=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            bitonicArray[i]=lis[i]+lds[i]-1;
        }
        int maxa=0;
        for(int i=0;i<arr.length;i++){
            if(bitonicArray[i]>maxa){
                maxa=bitonicArray[i];
            }

        }
        return maxa;
    }
    public static int[] longestDecreasingSubsequenceArray(int[] arr){
        int size=arr.length;
        int[] output=new int[size];
        output[size-1]=1;
        for (int i=size-2;i>=0;i--){
            output[i]=1;
            for (int j=i+1;j<=size-10;j++){
                if (arr[j]>=arr[i]){
                    continue;
                }
                int posibbleValue=output[j]+1;
                if (posibbleValue>output[i]){
                    output[i]=posibbleValue;
                }
            }
        }
        return output;
    }
    public static int[] longestIncreasingSubsequencArray(int[] arr){
        int size=arr.length;
        int[] output=new int[size];
        output[0]=1;
        for (int i=1;i<size;i++){
            output[i]=1;
            for (int j=i-1;j>=0;j--){
                if (arr[j]>=arr[i]){
                    continue;
                }
                int possibleValue=output[j]+1;
                if (possibleValue>output[i]){
                    output[i]=possibleValue;
                }

            }
        }
        return output;
    }

}
