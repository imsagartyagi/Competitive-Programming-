import java.util.HashSet;
import java.util.Scanner;

public class BehiveNumbers {
    public static void main(String[] args) {
        HashSet<Integer> set=new HashSet<Integer>();
        int x=1;
        for (int i=1;x<1000000005;i++){
            set.add(x);
            x+=i*6;
        }
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        while (n!=-1) {
            if (set.contains(n)) {
                System.out.println("Y");
            } else System.out.println("N");
            n=scanner.nextInt();
        }
    }
}
