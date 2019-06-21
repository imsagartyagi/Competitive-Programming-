import javax.management.MalformedObjectNameException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        int test=scanner.nextInt();
        ArrayList<Integer> primes=Primes(9999129);
        while(test-- >0){
            int l=scanner.nextInt();
            int r=scanner.nextInt();
            int k=scanner.nextInt();
            segmentedEulerToitent(l,r,primes,k);
        }
    }
    public static void segmentedEulerToitent(long l,long r,ArrayList<Integer> primes,int k){
        int[] primeGreaterThanRootN=new int[(int) (r-l+1)];
        long[] eulerToitent=new long[(int) (r-l+1)];
        for (int i=0;i<=r-l;i++){
            eulerToitent[i]=i+l;
        }

            for (int j=0; primes.get(j) <= r; j++) {
                int currentPrime = primes.get(j);
                long baseValue = ((l / currentPrime) * currentPrime);
                if (baseValue < l) {
                    baseValue += currentPrime;
                }
                for (long i = baseValue; i <= r; i += currentPrime) {
                    eulerToitent[(int) (i - l)] = (eulerToitent[(int) (i - l)] / currentPrime) * (currentPrime - 1);
                    while (currentPrime*currentPrime<eulerToitent[(int) (i-l)]&&eulerToitent[(int) (i-l)]%primes.get(j)==0){
                        primeGreaterThanRootN[(int) (i-l)]= (int) (eulerToitent[(int) (i-l)]/primes.get(j));
                    }
                    if (primeGreaterThanRootN[(int) (i-l)]>0)
                    eulerToitent[(int) (i - l)] = (eulerToitent[(int) (i - l)] / primeGreaterThanRootN[(int) (i-l)]) * ( primeGreaterThanRootN[(int) (i-l)] - 1);
                }
                if (baseValue == currentPrime) {
                    eulerToitent[(int) (baseValue - l)] = currentPrime - 1;
                }
                if (j+1<primes.size()){
                    continue;
                }
                else break;
            }


        double count=0;
        double x=(r-l+1);
        for (int i=0;i<r-l+1;i++){
            if (eulerToitent[i]%k==0){
                count++;
            }
        }
        double ans=count/x;
        System.out.printf("%.6f",ans);
        System.out.printf("\n");
    }
    public static ArrayList<Integer> Primes(int range){
        ArrayList<Integer> primes=new ArrayList<Integer>();
        boolean[] sieve=new boolean[range+1];
        Arrays.fill(sieve,true);
        for (int i=2;i*i<=range;i++){
            if (sieve[i]==true){
                for (int j=2;j*i<=range;j++){
                    sieve[j*i]=false;
                }
            }
        }
        for (int k=2;k<=range;k++){
            if (sieve[k]==true){
                primes.add(k);
            }
        }
        return primes;
    }
    public static int wilsonsFactorial(int n,int m){
        int res=-1;
        if (n>=m){

        }
        else if (n<m){
            for (int i=n+1;i<m;i++){
                res=(res*FermatsMMI(i,m))%m;
            }
        }
        return res+m;
    }
     public static long sachinAndNuclearReactor(long t,long m){
        long fact=1;
        if (t<m){
            while(t>0){
            fact=((fact%m)*(t--))%m;
            }
        }
        else if(t>=m){
            if((t/m)%2==0){
                int tv= (int) (t%m);
                while(tv>0){
                    fact=((fact%m)*(tv--))%m;
                }
            }
            else if((t/m)%2!=0){
                int tv= (int) (t%m);
                while(tv>0){
                    fact=((fact%m)*(tv--))%m;
                }
                fact=((fact%m)*(m-1)%m)%m;
            }
        }
        return fact;
    }
    private static int FermatsMMI(int i, int m) {
        int x=modularExponentiation(i,m-2,m);
        return (x%m+m)%m;
    }
    public static int modularExponentiation(long a,long b,int mod){
        if (b==0){
            return 1;
        }
        if (b%2==0){
            return modularExponentiation(((a%mod)*(a%mod))%mod,b/2,mod);
        }
        return ((a%mod)*modularExponentiation(((a%mod)*(a%mod))%mod,b/2,mod))%mod;
    }
    public static void SegmentedSeive(int l, int r, ArrayList<Integer> primes){
      boolean[] SegmentedPrime=new boolean[r-l+1];
      Arrays.fill(SegmentedPrime,true);
      for (int i=0;primes.get(i)*primes.get(i)<=r;i++){
          int currentPrime=primes.get(i);
          int base=((l/currentPrime)*currentPrime);
          if (base<l){
              base=base+currentPrime;
          }
          for (int j=base;j<=r;j=j+currentPrime){
              SegmentedPrime[j-l]=false;
          }
          if (base==currentPrime){
              SegmentedPrime[base-l]=true;
          }
      }
      for (int i=0;i<r-l+1;i++){
          if (SegmentedPrime[i]==true){
              System.out.println(i+l);
          }
      }
   }
    public static long innocentSwaps(long[] factorial, int n, int k, int mod){
       long Factor2=modularExponentiation(2,k,mod);
       long nCk=nCk(factorial,n,k,mod);
       return ((nCk%mod)*(Factor2%mod))%mod;
    }
    private static long nCk(long[] factorial, int n, int k, int mod) {
        long nFact=factorial[n];
        long kFact=factorial[k];
        long kFactor=fermatsMMI(kFact,mod);
        long n_kFact=factorial[n-k];
        long n_kFactor=fermatsMMI(n_kFact,mod);
        return ((((nFact)*(kFactor))%mod)*(n_kFactor))%mod;
    }
    public static long fermatsMMI(long A,long m){
        long x=modularExponentiation(A,m-2, (int) m);
        return (x%m+m)%m;
    }
    public static long[] ExtremeGcd(int n,int[] phi){
        long[] result_J= new long[n + 1];
        for (int i=1;i<=n;i++){
            for (int j=2;j*i<=n;j++){

                result_J[i*j]+=i*phi[j];
            }

        }
        for (int i=1;i<=n;i++){
            result_J[i]+=result_J[i-1];
        }
        return result_J;
    }
    public static int[] eulerTotient(int n){
        int[] arr=new int[n+1];
        for (int i=1;i<=n;i++){
            arr[i]=i ;
        }
        for (int i=2;i<=n;i++){
            if (arr[i]==i){
                arr[i]=i-1;
                for (int j=2;j*i<=n;j++){
                    arr[j*i]=(arr[j*i]/i)*(i-1);
                }
            }
        }
        return arr;
    }
    public static long cubicSquare(long a,String b,long mod){
      long ans=1;
      for (int i=b.length()-1;i>0;i--){
          if (b.charAt(i)=='1'){
              ans=((ans%mod)*(a%mod))%mod;
          }
          else if (b.charAt(i)=='2') {
              ans = ((((ans % mod) * (a % mod)) % mod)*a%mod)%mod;
          }
          a=((((a%mod)*(a%mod))%mod)*(a%mod))%mod;

      }

    return ans;
    }
}
