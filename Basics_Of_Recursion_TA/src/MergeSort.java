import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        mergeSort(arr);
        for (int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
    public static void mergeSort(int[] mainArr){
        int n=mainArr.length;
        if (n==1) return;
        int mid=n/2;
        int[] left=new int[mid];
        int[] right=new int[n-mid];
        for (int i=0;i<mid;i++){
            left[i]=mainArr[i];
        }
        for (int i=mid;i<n;i++){
            right[i-mid]=mainArr[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left,right,mainArr);
    }
    public static void merge(int[] left,int[] right,int[] mainArr){
        int nL=left.length;
        int nR=right.length;
        int i=0,j=0,k=0;
        while(i<nL&&j<nR){
            if (left[i]<=right[j]){
                mainArr[k]=left[i];
                k++;
                i++;
            }
            else {
                mainArr[k]=right[j];
                k++;
                j++;
            }
        }
        while(i<nL){
            mainArr[k]=left[i];
            i++;
            k++;
        }
        while(j<nR){
            mainArr[k]=right[j];
            j++;
            k++;
        }
    }
}
