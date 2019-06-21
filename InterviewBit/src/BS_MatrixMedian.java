import java.util.ArrayList;
import java.util.Scanner;

public class BS_MatrixMedian {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<ArrayList<Integer>>();
        for (int i=0;i<n;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            for (int j=0;j<m;j++){
                temp.add(scanner.nextInt());
            }
            arrayLists.add(temp);
        }
        int ans=findMedian(arrayLists);
        System.out.println(ans);
    }

    private static int findMedian(ArrayList<ArrayList<Integer>> A) {
        for (int i=0;i<A.size();i++){
            for (int j=0;j<A.get(i).size();j++){
                if(checkForThisElement(A,A.get(i).get(j))){
                    return (A.get(i).get(j));
                }
            }
        }
        return -1;
    }

    private static boolean checkForThisElement(ArrayList<ArrayList<Integer>> A, Integer x) {
        int greater=0,smaller=0;
        for (int i=0;i<A.size();i++){
                int pos=binaryS_smaller(A.get(i),x);
                int pos2=bs_greater(A.get(i),x);
                smaller+=pos+1;
                greater+=A.get(i).size()-pos2;

        }
        if (greater==smaller){
            return true;
        }
        else return false;
    }

    private static int bs_greater(ArrayList<Integer> arrayList, Integer x) {
        int start=0;
        int end=arrayList.size()-1;
        int ans=end+1;
        while (start<=end){
            int mid=(start+end)/2;
            if (arrayList.get(mid)>x){
                ans=mid;
                end=mid-1;
            }
            else start=mid+1;
        }
        return ans;
    }

    private static int binaryS_smaller(ArrayList<Integer> arrayList, Integer x) {
        int start=0;
        int end=arrayList.size()-1;
        int ans=-1;
        while (start<=end){
            int mid=(start+end)/2;
            if (arrayList.get(mid)<x){
                ans=mid;
                start=mid+1;
            }
            else end=mid-1;
        }
        return ans;
    }
}
