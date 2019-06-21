import java.util.Scanner;

public class Candy3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        while (test-- >0){
            int n=scanner.nextInt();
            long sum=0;
            for (int i=0;i<n;i++){
                long x=scanner.nextLong();
                sum=(((sum%n)+x%n)%n);
            }
            if (sum==0){
                System.out.println("YES");
            }
            else System.out.println("NO");
        }
    }
}
