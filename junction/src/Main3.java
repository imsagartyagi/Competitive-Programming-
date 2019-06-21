import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        long[] arr=new long[10000005];
        arr[0]=12;
        long mod=1000000007;
        for (int i=1;i<10000001;i++){
           arr[i]=((arr[i-1]%mod)*12)%mod;
        }
        while (n-- >0){
           int a=scanner.nextInt();
            System.out.println(arr[a-1]);
        }
    }
}
