import java.util.Scanner;

public class TheMAxLine {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int tesr=scanner.nextInt();
        while (tesr-- >0){
            double n=scanner.nextDouble();
            double ans=(4*(n*n))+0.25;
            System.out.println(ans);
        }
    }
}
