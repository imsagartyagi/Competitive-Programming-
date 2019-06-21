import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TwoPointer {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Integer x1=in.nextInt();
        int x2=in.nextInt();
        change(x1,x2);
        System.out.println(x1+" "+x2);
    }

    private static void change(Integer x1, int x2) {
        x1=x1+10;
        x2=x2+10;
        return;
    }

    public static int removeDuplicates(ArrayList<Integer> a) {
        if (a.size() < 2) return a.size();
        int prev = a.get(a.size() - 1);
        for (int i = a.size() - 2; i >= 0; i--) {
            if (a.get(i) == prev) {
                a.remove(i);
            }
            else {
                prev = a.get(i);
            }
        }
        return a.size();
    }


    private static int tsumClosest(ArrayList<Integer> arrayList,int p) {
         Collections.sort(arrayList);
         int n=arrayList.size();
         int min=Integer.MAX_VALUE;
         int ans=0;
         int i=0,j,k;
         while (i<=n-2) {
             int target = p - arrayList.get(i);
             j=i+1;
             k=n-1;
             while (j<k){
                 if (arrayList.get(j)+arrayList.get(k)<target){
                     if (Math.abs((arrayList.get(j)+arrayList.get(k))-target)<min){
                         min=Math.abs((arrayList.get(j)+arrayList.get(k))-target);
                         ans=arrayList.get(i)+arrayList.get(j)+arrayList.get(k);
                     }
                     j++;
                 }
                 else {
                     if (Math.abs((arrayList.get(j)+arrayList.get(k))-target)<min){
                         min=Math.abs((arrayList.get(j)+arrayList.get(k))-target);
                         ans=arrayList.get(i)+arrayList.get(j)+arrayList.get(k);
                     }
                     k--;
                 }
             }
             i++;
         }
         return ans;
    }
}
