import java.util.Arrays;
import java.util.Scanner;
// Giving Wrong Answer
public class Candy_I {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        for (int test=1;test<1000000000;test++){
            int n=scanner.nextInt();
            if(n==-1){
                break;
            }
            int[] arr=new int[n];
            int sum=0;
            for (int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
                sum+=arr[i];
            }
            int target=sum/n;
            if ((target*n)!=sum){
                System.out.println(-1);
                break;
            }
            Arrays.sort(arr);
            long cost=0;
            for (int i=0;i<n;i++){
                if (arr[i]<target){
                    cost+=target-arr[i];
                }
            }
            System.out.println(cost);
        }
    }
}