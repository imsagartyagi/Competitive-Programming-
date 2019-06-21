import java.util.ArrayList;
import java.util.Scanner;

public class TP_minimizeabsolutediffrence {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n1=in.nextInt();
        int n2=in.nextInt();
        int n3=in.nextInt();
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        ArrayList<Integer> list3=new ArrayList<>();
        System.out.println(md(list1,list2,list3));
    }
    public static int md(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> list3) {
        int i=list1.size()-1;
        int j=list2.size()-1;
        int k=list3.size()-1;
        int ans=Integer.MAX_VALUE;
        while (i>=0&&j>=0&&k>=0){
            int currentMax=Math.abs(maxEl(list1.get(i),list2.get(j),list3.get(k))-minEl(list1.get(i),list2.get(j),list3.get(k)));
            if (currentMax < ans)
                ans = currentMax;
            int max = maxEl(list1.get(i), list2.get(j), list3.get(k));
            if (list1.get(i)== max)
                i -= 1;
            else if (list2.get(j)== max)
                j -= 1;
            else
                k -= 1;
        }
        return ans;
    }
    private static int minEl(int i, int j, int k) {
        return Math.min(i,Math.min(j,k));
    }
    private static int maxEl(int i, int j, int k) {
       return Math.max(i,Math.max(j,k));
    }
}
