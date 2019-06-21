import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[10000005];
        arr[0]=0;
        arr[1]=0;
        arr[2]=1;
        int mod=1000000007;
        for (int i=3;i<10000002;i++){
            arr[i]=((arr[i-1])%mod+((arr[i-2])%mod+(arr[i-3])%mod)%mod)%mod;
        }
        while (n-- >0){
         int a=scanner.nextInt();
            System.out.println(arr[a-1]);
        }
    }
}
