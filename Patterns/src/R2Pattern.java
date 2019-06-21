import java.util.Scanner;

public class R2Pattern {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        if (n%2==0){
            for (int i=n-1;i>=1;i-=2){
                System.out.println(i+"\n");
            }
            for (int i=2;i<=n;i+=2){
                System.out.println(i+"\n");
            }
        }
        else {
            for (int i=n;i>=1;i-=2){
                System.out.println(i+"\n");
            }
            for (int i=2;i<n;i+=2){
                System.out.println(i+"\n");
            }
        }
    }
}
