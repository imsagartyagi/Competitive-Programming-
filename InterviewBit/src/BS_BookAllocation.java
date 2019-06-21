import java.util.ArrayList;
import java.util.Scanner;

public class BS_BookAllocation {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i=0;i<n;i++){
            arrayList.add(in.nextInt());
        }
        int m=in.nextInt();
        int ans=books(arrayList,m);
        System.out.println(ans);
    }
    public static int books(ArrayList<Integer> arrayList, int m) {
        int n=arrayList.size();
        int[] sumarr=new int[n+1];
        for (int i=1;i<=n;i++){
            sumarr[i]=sumarr[i-1]+arrayList.get(i-1);
        }
        int start=0;
        int end=sumarr[n];
        int ans=-1;
        if (arrayList.size()<m){
            return ans;
        }
        while (start<=end){
            int mid=(start+end)/2;
            if (possible(m,mid,arrayList)){
                ans=mid;
                end=mid-1;
            }
            else start=mid+1;
        }
        return ans;
    }

    private static boolean possible(int m, int mid,ArrayList<Integer> arr) {
        int count=0;
        int sum=0;
        for (int i=0;i<arr.size();i++){
            if (arr.get(i)>mid) return false;
            if (sum+arr.get(i)>mid){
                count++;
                i--;
                sum=0;
            }
            else sum+=arr.get(i);
        }
        if (sum<=mid){
            count++;
        }
        if (count<=m){
            return true;
        }
        else return false;
    }
}
