import java.util.Arrays;
import java.util.Scanner;

public class MaheshAndLostArray {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        while (test-- >0){
            int n=scanner.nextInt();
            int[] arr=new int[(int) Math.pow(2,n)];
            for (int i=0;i<Math.pow(2,n);i++){
                arr[i]=scanner.nextInt();
            }
            Arrays.sort(arr);
            StringBuilder builder=new StringBuilder();
            for (int i=1;i<=n;i++){
               builder.append(arr[i]+" ");
            }
            System.out.println(builder);
        }
    }
}
