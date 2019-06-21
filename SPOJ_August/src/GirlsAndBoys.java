import java.util.Scanner;

public class GirlsAndBoys {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        while (a!=-1&&b!=-1){
            int mx=(a>b)?a:b;
            int mn=(a<b)?a:b;
            mn++;
            int ans= (int) Math.ceil(((double)mx)/mn);
            System.out.println(ans);
            a=scanner.nextInt();
            b=scanner.nextInt();
        }
    }
}
