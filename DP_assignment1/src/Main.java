import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        StringBuilder builder=new StringBuilder();
          int n=scanner.nextInt();
          int k=scanner.nextInt();
          int[] arr=new int[n];
          for (int i=0;i<n;i++){
              arr[i]=scanner.nextInt();
          }
        System.out.println(angryChildren(n,k,arr));
    }

   // do it again bhenchod you did it wrong! " angryChildren"
    public static int angryChildren(int n,int k,int[] xi){
        Arrays.sort(xi);
        int[] output=new int[n];
        output[0]=0;
        output[1]=xi[1]-xi[0];
        // work for k
        int sum=xi[1]+xi[0];
        for (int i=2;i<k;i++){
            output[i]=output[i-1]+(i)*xi[i]-sum;
            sum+=xi[i];
        }
        for (int i=k;i<n;i++){
            output[i]=output[i-1]+((i-1)*xi[i-k])+((i-1)*xi[i])-2*(sum-xi[i-k]);
            sum+=xi[i];
        }
        int min=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            if (output[i]<min){
                min=output[i];
            }
        }
        return min;
    }


    public static  void JonsnowXOR(int[] arr,int k,int x){
        int[] countArray=new int[1024];
        int[] finalAnswer=new int[1024];
        for (int i=0;i<arr.length;i++){
            countArray[arr[i]]++;
        }
        int maxans=-1;
        int minans=-1;
        while (k-- >0) {
            int[] ans=new int[1024];
            int updatedcount = 0;
            for (int i = 0; i <= 1000; i++) {
                if (updatedcount % 2 == 0) {
                    if (countArray[i] % 2 == 0) {
                        int a=i^x;
                        updatedcount += countArray[i];
                        ans[a] += countArray[i] / 2;
                        ans[i] += countArray[i] - countArray[i] / 2;
                    } else {
                        int a=i^x;
                        updatedcount += (countArray[i]);
                        ans[a] += (countArray[i] + 1) / 2;
                        ans[i] += countArray[i] - (countArray[i] + 1) / 2;
                    }
                } else {
                    int a=i^x;
                    updatedcount += countArray[i];
                    ans[a] += countArray[i] / 2;
                    ans[i] += countArray[i] - countArray[i] / 2;
                }
            }
            countArray=new int[1024];
            for (int i = 0; i <= 1000; i++) {
                if (ans[i]!=0) {
                   System.out.println(i);
                    countArray[i] = ans[i];
                }
            }
            if (k==0) {
               for (int i=0;i<=1000;i++){
                   finalAnswer[i]=ans[i];
               }
            }
            for (int a = 0; a <= 1000; a++) {
                if (finalAnswer[a] != 0) {
                    minans = a;
                    break;
                }
            }

            for (int a = 1000; a >= 0; a--) {
                if (finalAnswer[a] != 0) {
                    maxans = a;
                    break;
                }
            }
        }
        System.out.println(maxans+" "+minans);

    }
    public static int adjacentBitcount(int n,int k,int firstbit,int mod,int[][][] output){
        if (n==1){
            if (k==0){
                output[n][k][0]=1;
                output[n][k][1]=1;
                return 1;
            }
           else {
                /*output[n][k][0]=0;
                output[n][k][1]=0;*/
                return 0;
            }
        }
        if (k<0) {
            /*output[n][k][0]=0;
            output[n][k][1]=0;*/
            return 0;
        }
        if (output[n][k][firstbit]!=-1){
            return output[n][k][firstbit];
        }
        if(firstbit==1){
           int option1= adjacentBitcount(n-1,k-1,1,mod,output);
           int option2=adjacentBitcount(n-1,k,0,mod,output);
            output[n][k][firstbit]=((option1%mod)+(option2))%mod;
           return ((option1%mod)+(option2))%mod;

        }
        else {
            int option1= adjacentBitcount(n-1,k,1,mod,output);
            int option2=adjacentBitcount(n-1,k,0,mod,output);
            output[n][k][firstbit]=((option1%mod)+(option2))%mod;
            return ((option1%mod)+(option2))%mod;
        }
    }
    public static void royAndCoins(int n,int[] li,int[] ri,int[] qi){
       int[] arr=new int[n+2];
       int[] ans=new int[n+2];
       rangeupdateinCONSTANT_TIME(li,ri,arr);
        for(int i=1;i<=n;i++){
            arr[i]+=arr[i-1];
                ans[1]++;
                ans[arr[i]+1]--;
        }
        for (int i=2;i<=n;i++){
            ans[i]+=ans[i-1];
        }
        for (int i=0;i<qi.length;i++){
            System.out.println(ans[qi[i]]);
        }
    }
    public static void rangeupdateinCONSTANT_TIME(int[] li,int[] ri,int[] arr){
        int m=li.length;
        for (int i=0;i<m;i++){
            arr[li[i]]++;
            arr[ri[i]+1]--;
        }

    }
    public static int gcd(int a,int b){
        if (b>a) return gcd(b,a);
        if(b==0){
            return a;
        }
        else return gcd(b,a%b);
    }
    public static double hasanAndtrip(int[] Xi, int[] Yi, int[] Fi) {
        int n=Xi.length;
        double[] dynamicSolution=new double[n];
        for(int i=1;i<n;i++){
            dynamicSolution[i]=Double.NEGATIVE_INFINITY;
        }
        dynamicSolution[0]=Fi[0];
        for(int i=1;i<n;i++){
            for (int j=i-1;j>=0;j--){
                dynamicSolution[i]=maxValue(Fi[i]+dynamicSolution[j]-distance(i,j,Xi,Yi),dynamicSolution[i]);
            }
        }
        return dynamicSolution[n-1];
    }
    private static double maxValue(double v, double v1) {
        return (v>v1)?v:v1;
    }
    public static double distance(int a,int b,int[] Xi,int[] Yi){
        return Math.sqrt(Math.pow((Xi[a]-Xi[b]),2)+Math.pow((Yi[a]-Yi[b]),2));
   }
    static final class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}