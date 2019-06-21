import java.util.Scanner;

public class TheLastDigit {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        while (test-- >0){
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            System.out.println(modularExponentiation(a,b,10));
        }
    }
    private static int modularExponentiation(int a, int b, int i) {
        if (b==0){
            return 1;
        }
        if (b%2==0){
            return modularExponentiation(((a%i)*(a%i))%i,b/2,i);
        }
        else return ((a%i)*modularExponentiation(((a%i)*(a%i))%i,b/2,i))%i;
    }
}
