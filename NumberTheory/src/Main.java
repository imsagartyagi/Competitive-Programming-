import javax.sound.midi.Soundbank;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public  static void main(String[] args) {

    }

    public static int noOfDivisors(int N){
        int modulo=(int)Math.pow(10,9)+7;
     boolean[] primality=sieveOfErastosthenes(N);
     int NoOFDivisors=1;
     for (int i=2;i<primality.length;i++){
         if (primality[i]==true){
             NoOFDivisors=(int)((long)NoOFDivisors*(powerOF(N,i)+1)%modulo);
         }
     }
    return NoOFDivisors;
    }
 public static int powerOF(int N,int primeNO){
        int power=0;
        int i=1;
        while((int)(N/(Math.pow(primeNO,i)))>0){
            power+=N/(Math.pow(primeNO,i));
            i++;
        }
        return power;
 }






    public static BigInteger GCDBigInteger(BigInteger a,BigInteger b){
        if (b.compareTo(BigInteger.valueOf(0))==0){
            return a;
        }
        if(a.compareTo(b)>0)
        return GCDBigInteger(b,a.remainder(b));
        else return GCDBigInteger(a,b.remainder(a));
    }
    public static long numberOfSolution(long a,long b,long d){
        long gcd=ExtendedEuclid(a,b).gcd;
        if (d%gcd!=0){
            return 0;
        }
        if (d==0){
            return 1;
        }
        a/=gcd;
        b/=gcd;
        d/=gcd;
        long y1=((d%a)*multiplicativeModuloInverse(b,a))%a;
        long value=(d/b);
        long ans=(value-y1)/a;
        return ans+1;
    }
    static class Threevalue{
        long gcd;
        long x;
        long y;
    }
    public static long multiplicativeModuloInverse(long A,long m){
        Threevalue ans=ExtendedEuclid(A,m);
        return ((ans.x%m)+m)%m;
    }
    public static Threevalue ExtendedEuclid(long a, long b){
        if (b==0){
            Threevalue smallAns = new Threevalue();
            smallAns.gcd=a;
            smallAns.x=1;
            smallAns.y=0;
            return smallAns;
        }
       Threevalue smallAns;
       smallAns=ExtendedEuclid(b,a%b);
       Threevalue currentAns=new Threevalue();
       currentAns.gcd=smallAns.gcd;
       currentAns.x=smallAns.y;
       currentAns.y=smallAns.x-(a/b)*smallAns.y;
       return currentAns;
    }
    public static long GCD(long a,long b)
    {
        if (a<b) return GCD(b,a);
       if (b==0){
           return a;
       }
       return GCD(b,a%b);
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

