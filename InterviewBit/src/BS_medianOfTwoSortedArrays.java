import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BS_medianOfTwoSortedArrays {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        List<Integer> a=new ArrayList<>();
        List<Integer> b=new ArrayList<>();
        for (int i=0;i<n;i++){
            a.add(in.nextInt());
        }
        for (int i = 0; i <m; i++) {
            b.add(in.nextInt());
        }
        double ans=findMedian(a,b);
        System.out.println(ans);
    }
    public static double findMedian(List<Integer> a, List<Integer> b) {
        int x=a.size();
        int y=b.size();
        if (x>y){
           return findMedian(b,a);
        }
        int start=0;
        int end=x;
        while (start<=end){
            int partition_x=(start+end)/2;
            int partition_y=(x+y+1)/2-partition_x;
            int maxLeftx,minRightx,maxLefty,minRighty;
            maxLeftx=partition_x==0?Integer.MIN_VALUE:a.get(partition_x-1);
            minRightx=partition_x==x?Integer.MAX_VALUE:a.get(partition_x);
            maxLefty=partition_y==0?Integer.MIN_VALUE:b.get(partition_y-1);
            minRighty=partition_y==y?Integer.MAX_VALUE:b.get(partition_y);

            if (maxLeftx<=minRighty&&maxLefty<=minRightx){
                if ((x+y)%2==0){
                    return (double)(Math.max(maxLeftx,maxLefty)+Math.min(minRightx,minRighty))/2;
                }
                else return Math.max(maxLeftx,maxLefty);
            }
            else if(maxLeftx>minRighty){
                end=partition_x-1;
            }
            else start=partition_x+1;
        }
        return 0.0;
    }
}
