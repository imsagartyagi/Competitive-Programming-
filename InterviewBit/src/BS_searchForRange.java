import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BS_searchForRange {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.nextInt());
        }
        int k=in.nextInt();
        int li=lastIndex(list,k);
        int fi=firstIndex(list,k);
        System.out.println(fi+" "+li);
    }

    private static int firstIndex(List<Integer> list, int k) {
        int start=0;
        int end=list.size()-1;
        int ans=-1;
        while (start<=end){
            int mid=(start+end)/2;
            if (list.get(mid)>k){
                end=mid-1;
            }
            else if (list.get(mid)==k){
                ans=mid;
                end=mid-1;
            }
            else start=mid+1;
        }
        return ans;
    }

    private static int lastIndex(List<Integer> list, int k) {
        int start=0;
        int end=list.size()-1;
        int ans=-1;
        while (start<=end){
            int mid=(start+end)/2;
            if (list.get(mid)<k){
                start=mid+1;
            }
            else if (list.get(mid)==k){
                ans=mid;
                start=mid+1;
            }
            else end=mid-1;
        }
        return ans;
    }
}
