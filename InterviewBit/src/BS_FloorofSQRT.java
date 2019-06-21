import java.util.Scanner;

public class BS_FloorofSQRT {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int sq=sqrt(n);
        System.out.println(sq);
    }

    private static int sqrt(int n) {
        int start=0;
        int end=n;
        int ans=1;
        while (start<=end){
            int mid=(start+end)/2;
            if ((long)mid*mid<n){
                ans=mid;
                start=mid+1;
            }
            else if ((long)mid*mid==n){
                return mid;
            }
            else end=mid-1;
        }
        return ans;
    }
}
