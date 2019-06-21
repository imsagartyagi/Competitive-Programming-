import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Random;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i] =scanner.nextInt();
        }
        QuickSort(arr,0,n-1);
        for (int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
    public static void QuickSort(int[] mainArr,int start,int end){
        if (start>=end) return;
        int pIndex=RandomisedPartition(mainArr,start,end);
        QuickSort(mainArr,start,pIndex-1);
        QuickSort(mainArr,pIndex+1,end);
    }

    private static int RandomisedPartition(int[] mainArr, int start, int end) {
        int pIndex=start;
        int rnd = start+(int) (Math.random()*((end-start)+1));
        swap(mainArr,end,rnd);
        int pivot=mainArr[end];
        for (int i=start;i<end;i++){
            if (mainArr[i]<=pivot){
                swap(mainArr,pIndex,i);
                pIndex++;
            }
        }
        swap(mainArr,end,pIndex);
        return pIndex;
    }

    private static void swap(int[] mainArr, int a, int b) {
        int temp=mainArr[a];
        mainArr[a]=mainArr[b];
        mainArr[b]=temp;
    }
}
