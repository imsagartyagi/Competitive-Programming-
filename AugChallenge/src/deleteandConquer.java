import java.util.Arrays;
import java.util.Scanner;

public class deleteandConquer {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.println(deleteandconquer(arr));
    }
    public static int deleteandconquer(int[] A) {
        int n=A.length;
        Arrays.sort(A);
        int count=0;
        int tempCount=0;
        for(int i=1;i<n;i++){
            if(A[i-1]==A[i]){
                tempCount++;
            }
            else{
                tempCount=0;
            }
            if(tempCount>count){
                count=tempCount;
            }
        }
        return n-count-1;
    }
}
