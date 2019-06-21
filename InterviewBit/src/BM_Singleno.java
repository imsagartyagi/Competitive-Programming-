import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BM_Singleno {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }
        System.out.println(sn2(list));
    }

    private static int sn2(List<Integer> list) {
        int[] bitArr=new int[32];
        for (int x:list){
            int i=0;
            while (i<32){
                if ((x&(1<<i))!=0){
                    bitArr[i]=(bitArr[i]%3+1)%3;
                }
                i++;
            }
        }
        int ans=0;
        for (int i=0;i<=31;i++){
            if (bitArr[i]==1){
                ans+=1<<i;
            }
        }
        return ans;
    }
    private static int sn(List<Integer> list) {
        int ans=0;
        for (int x:list){
            ans^=x ;
        }
        return ans;
    }
}
