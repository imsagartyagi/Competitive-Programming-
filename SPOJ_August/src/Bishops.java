import java.math.BigInteger;
import java.util.Scanner;

public class Bishops {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.equals("1")){
                System.out.println(1);
                continue;
            }
            BigInteger bigInteger = new BigInteger(s);
            BigInteger ans = bigInteger.subtract(BigInteger.ONE).multiply(new BigInteger("2"));
            System.out.println(ans);
        }
    }
}
