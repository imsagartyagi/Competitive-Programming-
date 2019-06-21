import javax.security.sasl.SaslServer;
import java.util.Scanner;

public class BM_numberofsetBits {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        long n=in.nextLong();
        System.out.println(rb(n));
    }

    public static long  rb(long n){
        long ans=0;
        long i=0;
        while (i<=31){
            long x=(n&(1<<i));
            if (x!=0){
                ans+=1l<<(31-i);
            }
            i++;
        }
        return ans;
    }

    private static int lastBitPosition(long n) {
        n|=n>>1;
        n|=n>>2;
        n|=n>>4;
        n|=n>>8;
        n|=n>>16;
        n=n+1;
        n=n>>1;
        int x=0;
        while (n!=0){
            n=n/2;
            x++;
        }
        return x;
    }

    private static int nsb(long n) {
        int sum=0;
        while (n!=0){
            n&=(n-1);
            sum++;
        }
        return sum;
    }
}
