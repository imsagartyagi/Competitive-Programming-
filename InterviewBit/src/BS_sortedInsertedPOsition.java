import java.util.ArrayList;
import java.util.Scanner;

public class BS_sortedInsertedPOsition {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i=0;i<n;i++){
            arrayList.add(in.nextInt());
        }
        int k=in.nextInt();
        int ans=bs(arrayList,k);
        System.out.println(ans+1);
    }

    private static int bs(ArrayList<Integer> arrayList, int k) {
        int start=0;
        int end=arrayList.size()-1;
        int mid=0;
        int ans=-1;
        while (start<=end){
            mid=(start+end)/2;
            if (arrayList.get(mid)==k){
                return mid;
            }
            else if (arrayList.get(mid)<k){
                ans=mid;
                start=mid+1;
            }
            else end=mid-1;
        }
        return ans;
    }
}
