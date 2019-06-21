import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner=new Scanner(System.in);
       int n=scanner.nextInt();
       int sum=0;
       for (int i=1;i<=n;i++){
           sum+=lcm(i,n);
       }
        System.out.println(sum);
    }



    public static int lcm(int a,int b){
        if (gcd(a,b)==1){
            return a*b;
        }
        else
           return gcd(a,b)*lcm(a/gcd(a,b),b/gcd(a,b));
    }
    private static int gcd(int a, int b) {
        if (b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public static int[] eulerTotient(int n){
        int[] arr=new int[n+1];
        for (int i=1;i<=n;i++){
            arr[i]=i ;
        }
        for (int i=2;i<=n/2;i++){
            if (arr[i]==i){
                arr[i]=i-1;
                for (int j=2;j*i<=n;j++){
                    arr[j*i]=(arr[j*i]*(i-1))/i;
                }
            }
        }
        return arr;
   }
    public static int NthDaySalary(int N,int f0,int f1){
        int mod=1000000007;
        int g0=f0+1;
        int g1=f1+1;
        int fab_N=fab(N);
        int fab_N1=fab(N-1);
        int a=((modularExponentiationRecursively(g0,fab_N1%(mod-1),mod)));
        int b=((modularExponentiationRecursively(g1,fab_N%(mod),mod)));
        int ans=(((a%mod)*(b%mod))%mod);
        return ans-1;
    }
    public static long WilsonsApplication(int n,int p){
        long fact=p-1;
        if (n>=p){
            return 0;
        }
        else if (n<p){
            for (int i=n+1;i<=p-1;i++){
                fact=((fact%p)*(MMIusingFermats(i,p))%p)%p;
            }
        }
        return fact;
    }
    public static long MMIusingFermats(int A,int m){
        return modularExponentiationRecursively(A,m-2,m);
    }
    public static long FabSum(int n, int m){
        int mod=1000000007;
        return ((fab(m+2)%mod-fab(n+1)%mod)+mod)%mod;
    }
    public static int fab(int n){
        int[][] A={{1,1},{1,0}};
        power(A,n-1);
        return A[0][0];
    }
    private static void power(int[][] a, int n) {
        int temp[][]={{1,1},{1,0}};
        if (n==0||n==1){
            return;
        }
        power(a,n/2);
        multiplyMatrix(a,a);
        if (n%2!=0){
            multiplyMatrix(a,temp);
        }
    }
    private static void multiplyMatrix(int[][] a, int[][] a1) {
        int mod=1000000007;
        int firstValue=(((a[0][0]%mod)*(a1[0][0]%mod))%mod+((a[0][1]%mod)*(a1[1][0])%mod)%mod)%mod;
        int secondValue=(((a[0][0]%mod)*(a1[0][1]%mod))%mod+((a[0][1]%mod)*(a1[1][1])%mod)%mod)%mod;
        int ThrdValue=(((a[1][0]%mod)*(a1[0][0]%mod))%mod+((a[1][1]%mod)*(a1[1][0])%mod)%mod)%mod;
        int FourthValue=(((a[1][0]%mod)*(a1[0][1]%mod))%mod+((a[1][1]%mod)*(a1[1][1])%mod)%mod)%mod;
        a[0][0]=firstValue;
        a[0][1]=secondValue;
        a[1][0]=ThrdValue;
        a[1][1]=FourthValue;
    }
    public static int modularExponentiationRecursively(int a, int b, int c){
        if (b==0){
            return 1;
        }
        if (b%2==0){
            int x=modularExponentiationRecursively(((int)((long)(a%c)*(a%c)))%c,b/2,c);
            return (x%c+c)%c;
        }
        else{
            int x=modularExponentiationRecursively(((a%c)*(a%c))%c,b/2,c);
            return (x%c+c)%c;        }
    }
    public static int modularExponentiationIteratively(int a,int b,int c){
        int ans=1;
        while(b!=0){
            int rightMostBit=rMb(b);
            if (rightMostBit==1){
                ans=((ans%c)*(a%c))%c;
            }
            a=((a%c)*(a%c))%c;
            b=b/2;
        }
        return ans;
    }
    private static int rMb(int b) {
        return Integer.parseInt(Integer.toString(b,2))&1;
    }
}
