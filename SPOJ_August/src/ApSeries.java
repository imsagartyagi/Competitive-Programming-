import java.util.Scanner;

public class ApSeries {
    // Wrong Code Do IT again
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        while (test-- >0) {
            long a = scanner.nextInt();
            long b = scanner.nextInt();
            long sum = scanner.nextInt();
            long n=(sum*2)/(a+b);
            long d=(b-a)/(n-5);
            long start=a-(2*d);
            System.out.println(n);
            long i=start;
            while(n-- >0){
                System.out.print(i +" ");
                i+=d;
            }

        }
    }
}
