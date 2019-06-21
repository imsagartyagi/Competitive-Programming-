import java.util.Scanner;

public class DoubleSidedArrow {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int x=2*n-1;
        int[][] arr=new int[n][x];
        arr[0][x/2]=1;
        int start=(x/2)+1;
        int end=(x/2)-1;
        for (int i=1;i<(n+1)/2;i++){
             start--;
             end++;
             int j=start-1;
             int k=end+1;
             int l=0;
             int r=0;
             while (l++ <i+1){
                 arr[i][j]=l;
                 j--;
             }
            while (r++ <i+1){
                arr[i][k]=r;
                k++;
            }
        }
        int a=0;
        for (int i=(n+1)/2;i<n;i++){
            a+=2;
            for (int j=0;j<x;j++){
                arr[i][j]=arr[i-a][j];
            }

        }
        for (int i=0;i<n;i++){
            for (int j=0;j<x;j++){
                System.out.print((arr[i][j])==0?" ":arr[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
