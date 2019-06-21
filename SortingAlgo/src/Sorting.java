import java.util.ArrayList;
import java.util.Random;

public class Sorting {

    public int[] mergeSort(int[] arr){
        if (arr.length==1){
            return arr;
        }
        int size=arr.length;
        int N;
        if(size%2==0){
            N=size/2;
        }
        else N=(size+1)/2;
        int[] leftArray=new int[N];
        for(int i=0;i<N;i++){
            leftArray[i]=arr[i];
        }
        int[] rightArray=new int[size-N];
        for(int i=0;i<size-N;i++){
            rightArray[i]=arr[N+i];
        }
        return merge(mergeSort(leftArray),mergeSort(rightArray));
    }
    public int[] merge(int[] arr1,int[] arr2){
        int[] resultArr =new int[arr1.length+arr2.length];
        int i=0,j=0,k=0;
        while(i!=arr1.length&&j!=arr2.length){
            if(arr1[i]<=arr2[j]){
                resultArr[k]=arr1[i];
                k++;
                i++;
            }
           else if(arr1[i]>arr2[j]){
                resultArr[k]=arr2[j];
                k++;
                j++;
            }
        }
        while (i!=arr1.length){
            resultArr[k]=arr1[i];
            k++;
            i++;
        }
        while (j!=arr2.length){
            resultArr[k]=arr2[j];
            k++;
            j++;
        }

        return resultArr;
    }
    public void quickSort(int[] arr,int start,int end){
        if (start>=end){
            return;
        }
        int pIndex=randonmisedPartition(arr,start,end);
        quickSort(arr,start,pIndex-1);
        quickSort(arr,pIndex+1,end);
    }
    public int randonmisedPartition(int[] arr,int start,int end){

        Random random=new Random();
        int rIndex=random.nextInt(end-start)+start;
        swap(arr,rIndex,end);
        int pivot=arr[end];
        int pIndex=start;
        for (int i=start;i<end;i++){
            if (arr[i]<pivot){
                swap(arr,i,pIndex);
                pIndex++;
            }
        }
        swap(arr,pIndex,end);
        return pIndex;
    }
    public void swap(int[] arr,int a,int b){
        int temp;
        temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
