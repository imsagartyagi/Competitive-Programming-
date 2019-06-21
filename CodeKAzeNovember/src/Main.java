import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        while (test-- >0){
            int mod=1000000007;
            int factorProduct=1;
            long x=scanner.nextLong();
            long a=scanner.nextLong();
            long b=scanner.nextLong();
            long fx=x*x+((a*x)+b);
            if (fx==0){
                System.out.println(0);
                continue;
            }
            int numberOfFactors=calculateNoOFactors((int) fx);
            System.out.println(modularExponentiationRecursively(fx,numberOfFactors/2,mod));

        }
    }
    public static long modularExponentiationRecursively(long a, long b, long c)
    {
        if (b==0){
            return 1;
        }
        if (b%2==0){
            long x=(modularExponentiationRecursively(((a%c)*(a%c))%c,b/2,c))%c;
            return (x%c+c)%c;
        }
        else{
            long x=((a%c)*modularExponentiationRecursively(((a%c)*(a%c))%c,b/2,c))%c;
            return (x%c+c)%c;        }
    }
    static int calculateNoOFactors(int n)
    {
        int[] factor=lpd(n);
        if (n == 1)
            return 1;

        int ans = 1;
        int dup = factor[n];
        int c = 1;
        int j = n / factor[n];
        while (j != 1)
        {
            if (factor[j] == dup)
                c += 1;
            else
            {
                dup = factor[j];
                ans = ans * (c + 1);
                c = 1;
            }
            j = j / factor[j];
        }
        ans = ans * (c + 1);

        return ans;
    }
    public static int[] lpd(int n){
        int[] lpdArray=new int[n+1];
        boolean[] prime=new boolean[n+1];
        Arrays.fill(prime,true);
        for (int i=1;i<=n;i++){
            lpdArray[i]=i;
        }

        for (int i=2;i<=n/2;i++){
            {
                for (int j = 2; j * i <= n; j++) {
                    if (prime[i*j]==true)
                        lpdArray[j * i] = i;
                    prime[j*i]=false;
                }
            }
        }return lpdArray;
    }
    public static int YogeshAndPrimes(int a,int b,int k){
     boolean[] primes=sieveOfErastosthenes(b);
     for (int i=a;i<=b;i++){
         if (primes[i]==true){
             k--;
         }
         if (k==0){
             return i;
         }
     }
      return -1;
    }
    public static boolean[] sieveOfErastosthenes(int N){
        boolean[] primality=new boolean[N+1];
        for (int i=0;i<N+1;i++){
            primality[i]=true;
        }
        for (int i=2;i<Math.sqrt(N+1);i++){
            if (primality[i]==true) {
                for (int j = i; j * i < N + 1; j++) {
                    primality[j * i] = false;
                }
            }
        }
        return primality;
    }
}


