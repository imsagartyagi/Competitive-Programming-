import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BS_rotatedsortedarraysearch {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }
        int k=in.nextInt();
        System.out.println(f(list,k));
    }
    public static int f(List<Integer> list,int k){
        int n=list.size();
        int left=list.get(0);
        int right=list.get(n-1);
        int start=0;
        int end=n-1;
        int mid=start;
        while (start<=end){
            mid=(start+end)/2;
            if (left>list.get(mid)){
                end=mid-1;
            }
            else if (right<list.get(mid)){
                start=mid+1;
            }
            else break;
        }
        int ans=-1;
        ans=bs(0,mid,list,k);
        if (ans==-1){
            ans=bs(mid+1,n-1,list,k);
        }
        return (ans);
    }
    private static int bs(int start, int end, List<Integer> list,int k) {
        int ans=-1;
        while (start<=end){
            int mid=(start+end)/2;
            if (list.get(mid)==k){
                return mid;
            }
            else if (list.get(mid)<k){
                start=mid+1;
            }
            else end=mid-1;
        }
        return ans;
    }
}
