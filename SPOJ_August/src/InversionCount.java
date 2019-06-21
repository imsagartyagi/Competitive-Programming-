import java.util.Scanner;

public class InversionCount {
    static int[] arr;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        while (test-- >0){
            int n=scanner.nextInt();
            arr=new int[n];
            for (int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            long inv=invCount(0,n-1);
            System.out.println(inv);
        }
    }
    private static long invCount(int start, int end) {
         if (start==end){
             return 0;
         }
        int mid=(start+end)/2;
        long invLeft=invCount(start, mid);
        long invRight=invCount(mid+1, end);
        int i=start;
        int j=mid+1;
        int k=0;
        int[] temp=new int[end-start+1];
        long mergeCount=0;
        while (i<=mid&&j<=end){
            if (arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }
            else if (arr[i]>arr[j]){
                temp[k++]=arr[j++];
                mergeCount+=mid-i+1;
            }
        }
        while (i<=mid){
            temp[k++]=arr[i++];
        }
        while (j<=end){
            temp[k++]=arr[j++];
        }
        for (int a=start;a<=end;a++){
            arr[a]=temp[a-start];
        }
        return mergeCount+invLeft+invRight;
    }
}
