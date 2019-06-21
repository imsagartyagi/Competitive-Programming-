import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PrimeGenerator {
     static boolean[] primes=new boolean[100002];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Arrays.fill(primes,true);
        primes[0]=false;
        primes[1]=false;
        for (int i=2;i*i<100002;i++){
            if (primes[i]==true){
                for (int j=i*i;j<100002;j+=i){
                    primes[j]=false;
                }
            }
        }
        ArrayList<Integer> primesList=new ArrayList<Integer>();
        for (int i=0;i<100002;i++){
            if (primes[i]){
                primesList.add(i);
            }
        }
        int test=scanner.nextInt();
        StringBuilder builder=new StringBuilder();
        while (test-- >0){
            int l=scanner.nextInt();
            int r=scanner.nextInt();
            boolean[] ans=new boolean[r-l+1];
            Arrays.fill(ans,true);
            for (int i=0;primesList.get(i)*primesList.get(i)<=r;i++){
                int currentPrime=primesList.get(i);
                int base=(l/currentPrime)*currentPrime;
                if (base<l){
                    base+=currentPrime;
                }
                for (int j=base;j<=r;j+=currentPrime){
                    ans[j-l]=false;
                }
                if (base==currentPrime){
                    ans[base-l]=true;
                }
            }
            for (int i=0;i<=r-l;i++){
                if (ans[i]==true){
                    if(i+l==1){
                        continue;
                    }
                    builder.append(i+l).append("\n");
                }
            }
            builder.append("\n");
        }
        System.out.println(builder);
    }
}
