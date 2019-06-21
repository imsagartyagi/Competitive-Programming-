import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TP_mergesortedArray {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        for (int i = 0; i <n; i++) {
            list1.add(in.nextInt());
        }
        for (int i=0;i<m;i++){
            list2.add(in.nextInt());
        }
       ArrayList<Integer> ans= merge2(list1,list2);
        for (int x:ans){
            System.out.print(x+" ");
        }
    }
    private static ArrayList<Integer> merge2(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        int i=0,j=0;
        int n=list1.size();
        int m=list2.size();
        ArrayList<Integer> ans=new ArrayList<>();
        while (i<n&&j<m){
            if (list1.get(i)<list2.get(j)){
                i++;
            }
            else if (list1.get(i)>list2.get(j)){
                j++;
            }
            else {
                ans.add(list1.get(i));
                i++;
                j++;
            }
        }
        return ans;
    }
}
