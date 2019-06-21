import java.util.Scanner;

public class forces1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StringBuilder builder=new StringBuilder();
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[] arr=new int[n];
        long[] sumarr=new long[n];
        long[] ansArr=new long[n];
        long abtak=0;
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        sumarr[0]=arr[0];
        for (int i=1;i<n;i++){
            sumarr[i]=sumarr[i-1]+arr[i];
        }
        for (int i=0;i<n;i++){
            long val=(sumarr[i]/m);
            ansArr[i]=val-abtak;
            abtak+=ansArr[i];
        }
        for (int i=0;i<n;i++){
            builder.append(ansArr[i]+" ");
        }
        System.out.println(builder);
    }
}
