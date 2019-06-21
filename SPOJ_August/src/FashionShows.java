import java.util.Arrays;
import java.util.Scanner;

public class FashionShows {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        while (test-- > 0) {
            int n=scanner.nextInt();
            int[] men=new int[n];
            int[] women=new int[n];
            for (int i=0;i<n;i++){
                men[i]=scanner.nextInt();
            }
            for (int i=0;i<n;i++){
                women[i]=scanner.nextInt();
            }
            Arrays.sort(men);
            Arrays.sort(women);
            int ans=0;
            for (int i=0;i<n;i++){
                ans+=(men[i]*women[i]);
            }
            System.out.println(ans);
        }
    }
}
