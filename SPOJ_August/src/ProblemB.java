import java.util.HashSet;
import java.util.Scanner;

public class ProblemB {
    static class pair{
        int a;
        int b;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        pair[] pairs=new pair[n];
        for (int i=0;i<n;i++){
            pairs[i]=new pair();
            pairs[i].a=scanner.nextInt();
            pairs[i].b=scanner.nextInt();
        }
        HashSet<Integer> primes=new HashSet<>();
        putPrimes(pairs[0].a,primes);
        putPrimes(pairs[0].b,primes);
        int ans=-1;
        for (int x:primes){
            int count=0;
            for (int i=0;i<n;i++){
                if (pairs[i].a%x==0||pairs[i].b%x==0){
                    count++;
                }
            }
            if (count==n){
                ans=x;
                break;
            }
        }
        System.out.println(ans);
    }
    public static void putPrimes(int n1, HashSet<Integer> primes) {
            while (n1%2 == 0)
            {
                primes.add(2);
                n1 = n1/2;
            }
            for (int i = 3; i*i <= n1; i = i+2)
            {
                while (n1%i == 0)
                {
                    primes.add(i);
                    n1 = n1/i;
                }
            }
            if (n1 > 2)
                primes.add(n1);
        }
    }

