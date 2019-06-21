import java.util.ArrayList;
import java.util.Scanner;

public class BM_diffrentBitSumPairwise {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        ArrayList<Integer> arr=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(in.nextInt());
        }
        System.out.println(cb(arr));
    }

    private static long cb(ArrayList<Integer> arr) {
        int mod=1000000007;
        long[] bit=new long[32];
        for (int x:arr){
            int i=0;
            while (i<32){
                if ((x&(1<<i))!=0){
                    bit[i]++;
                }
                i++;
            }
        }
        long ans=0;
        int n=arr.size();
        for (int i=0;i<32;i++){
            if (bit[i]!=0){
                ans=(ans%mod+((bit[i]%mod*(n-bit[i])%mod)%mod))%mod;
            }
        }
        return (ans*2)%mod;
    }
}
