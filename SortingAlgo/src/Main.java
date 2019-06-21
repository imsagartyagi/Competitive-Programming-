
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=new String();
         str="hello";
         ArrayList<java.lang.String> strings=new ArrayList<String>();
         subsequence(str,strings);
         for (int i=0;i<strings.size();i++){
             System.out.println(strings.get(i));
         }

        }

       public static void subsequence(String str, ArrayList<String> stringArrayList){
        if (str.isEmpty()){
            stringArrayList.add("");
            return;
        }
        subsequence(str.substring(1),stringArrayList);
        for (int i=0;i<stringArrayList.size();i++){
            stringArrayList.add(str.charAt(0)+stringArrayList.get(i));
        }
       }














    public static void quickSort(int[] input,int startIndex,int endIndex){
        if (startIndex>=endIndex){
            return;
        }
       int pIndex= randomisedPartition(input,startIndex,endIndex);
        quickSort(input,startIndex,pIndex-1);
        quickSort(input,pIndex+1,endIndex);

    }
    public static int randomisedPartition(int[] input,int start,int end){
        Random random=new Random();
        int rIndex=random.nextInt(end-start)+start;
        swap(input,rIndex,end);
        int pivot=input[end];
        int partitionIndex=start;
        for (int i=start;i<=end-1;i++){
            if (input[i]<=pivot){
                swap(input,partitionIndex,i);
                partitionIndex++;
            }
        }
        swap(input,partitionIndex,end);
        return partitionIndex;
    }
   public static void swap(int[] input,int i,int j){
        int temp;
        temp=input[i];
        input[i]=input[j];
        input[j]=temp;

   }
    public static void mergeSort(int[] input,int startIndex,int endIndex){
        if (startIndex>=endIndex){
            return;
        }
        mergeSort(input,startIndex,(startIndex+endIndex)/2);
        mergeSort(input, (startIndex+endIndex)/2+1, endIndex);
        merge(input,startIndex,endIndex);
    }
    public static void merge(int[] input,int sIndex,int eIndex){
        int mid=(sIndex+eIndex)/2;
        int[] arr=new int[eIndex-sIndex+1];
        int i=sIndex,j=mid+1,k=0;
        while(i<=mid&&j<=eIndex){
            if (input[i]<=input[j]){
                arr[k]=input[i];
                k++;
                i++;
            }
            if (input[i]>input[j]){
                arr[k]=input[j];
                k++;
                j++;
            }
        }
        while (i<=mid){
            arr[k]=input[i];
            k++;
            i++;
        }
        while (j<=eIndex){
            arr[k]=input[j];
            k++;
            j++;
        }
        int z=0;
        for (int a=sIndex;a<=(eIndex);a++){
            input[a]=arr[z++];
        }
    }
    public static char[] replaceCharacter(char[] string,int index,char a,char b){
      if(index==string.length){
          return string;
      }
      if (string[index]==a){
          string[index]=b;
      }
      return replaceCharacter(string,index+1,a,b);

    }
    public static ArrayList<Integer> allIndex(int input[],int x,int index,ArrayList<Integer> arrayList){
        if (index==input.length){
            return arrayList;
        }
        if (input[index]==x){
            arrayList.add(index);
        }
        return allIndex(input,x,index+1,arrayList);
        }
    public static int lastindex(int input[], int x,int index,int rIndex){
        if(input[index]==x){
            rIndex=index;
       }
        if (index==input.length-1){
           return rIndex;
       }
        return lastindex(input,x,index+1,rIndex);


    }
    public static boolean checkNumber(int input[], int x) {
        return checkNumberExist(input,x,0);

    }
    public static boolean checkNumberExist(int input[],int x,int index){

        if(index==input.length){
            return false;
        }
        if(input[index]==x) {
            return true;
        }
        return checkNumberExist(input,x,index+1);

    }

}
