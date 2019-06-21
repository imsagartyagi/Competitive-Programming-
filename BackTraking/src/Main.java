import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /*System.out.println(sudokuSolver(new int[][]{{9,0,0,0,2,0,7,5,0},{6,0,0,0,5,0,0,4,0},
                                                    {0,2,0,4,0,0,0,1,0},{2,0,8,0,0,0,0,0,0},
                                                    {0,7,0,5,0,9,0,6,0},{0,0,0,0,0,0,4,0,1},
                                                    {0,1,0,0,0,5,0,8,0},{0,9,0,0,7,0,0,0,4},
                                                           {0,8,2,0,4,0,0,0,6}},9,0));*/

        System.out.println(DistributeCandies(new int[]{52,3,65,3,62,2,78,60,41,96,77,15,21,44,25,75,26,11,11},9,1,85));

    }
    public static int DistributeCandies(int[] arr,int K,int minCandies,int maxCandies){
        int middle;
        if ((minCandies+maxCandies)%2==0)
         middle=(minCandies+maxCandies)/2;
        else middle=((minCandies+maxCandies)/2)+1;
     if (minCandies==maxCandies){
         return maxCandies;
     }
    if (correctDistribution(arr,K,middle)){
         return DistributeCandies(arr,K,middle,maxCandies);
    }
    else return DistributeCandies(arr,K,minCandies,middle-1);

    }
    public static boolean correctDistribution(int[] array,int k,int candyNumber){
        int sum_For_K=0;
        for (int i=0;i<array.length;i++){
            int val=array[i]/candyNumber;
            sum_For_K+=val;
            if(sum_For_K>=k){
                return true;
            }
        }

        return false;
    }


    public static long sum(int[] arr){
        long sum=0;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
















    public static boolean sudokuSolver(int[][] board,int n,int row){
        if (row==n){
            return true;
        }
        if (correctConfiguation(board,n,row)){
            return sudokuSolver(board,n,row+1);
        }
        else
            return false;

    }
    public static boolean correctConfiguation(int[][] board,int n,int row){
         if (isRowCorrect(board, n, row)){
             for (int i=0;i<n;i++){
                 if(!isColoumnCorrect(board,row,i)){
                     return false;
                 }
             }
             return true;
         }
        else
            return false;

    }
    public static boolean isRowCorrect(int[][] board,int n,int row){
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        for (int i=0;i<n;i++){

            arrayList.add(board[row][i]);
            if (Collections.frequency(arrayList,arrayList.get(i))>1&&arrayList.get(i)!=0)
                return false;
        }
        return true;
    }
    public static boolean isColoumnCorrect(int[][] board,int row,int coloumn){
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
         for (int i=0;i<=row;i++){
             arrayList.add(board[i][coloumn]);
             if (Collections.frequency(arrayList,arrayList.get(i))>1&&arrayList.get(i)!=0){
                 return false;
             }
         }
         return true;
    }
    public static boolean isSQUAREScorrect(int[][] board){
        for (int k=0;k<9;k=k+3){
            ArrayList<Integer> arr=new ArrayList<Integer>();
            for (int i=k;i<3;i++){
                for (int j=k;j<3;j++){
                   if (arr.contains(board[i][j])&&board[i][j]!=0){
                       return false;
                   }
                   arr.add(board[i][j]);
                }
            }

        }
        return true;
    }
    public static long murder(long[] arr,int N){
        if (N==1){
            return 0;
        }
        long[] leftArray=new long[N/2];
        for (int i=0;i<N/2;i++){
            leftArray[i]=arr[i];
        }
        long[] rightArray=new long[N-N/2];
        for (int i=0;i<N-N/2;i++){
            rightArray[i]=arr[i+N/2];
        }
        long sLeft=murder(leftArray,N/2);
        long sRght=murder(rightArray,N-N/2);
        long[] resultarray=new long[N];
        long sduringMerge=sumDuringMerge(leftArray,rightArray,resultarray);
        for (int i=0;i<N;i++){
            arr[i]=resultarray[i];
        }
        return sLeft+sRght+sduringMerge;
    }
     public static long sumDuringMerge(long[] left,long[] right,long[] resultArray){
        int i=0,j=0,k=0;
        long sum=0;
        for (int x=0;x<right.length;x++){
            for (int y=0;y<left.length;y++){
                if (left[y]<right[x]){
                    sum+=left[y];
                }
            }
        }
        while (i<left.length&&j<right.length){
            if (left[i]<right[j]){
                resultArray[k]=left[i];
                k++;
                i++;

            }
            else if (left[i]>=right[j]){
                resultArray[k]=right[j];
                k++;
                j++;
            }
        }
        while(i<left.length){
            resultArray[k]=left[i];
            k++;
            i++;
        }
        while (j<right.length){
            resultArray[k]=right[j];
            k++;
            j++;

        }
        return sum;
     }
    public static void allpermutation(String string,int sIndex, int eIndex){
        if (sIndex==eIndex){
            System.out.println(string);
            return;
        }
        for (int i=sIndex;i<string.length();i++){
          string=swap(string,sIndex,i);
          allpermutation(string,sIndex+1,eIndex);
          string=swap(string,sIndex,i);
        }
    }
    public static String swap(String str,int i,int j){
       char[] array=new char[str.length()];
       for (int a=0;a<str.length();a++){
       array[a]=str.charAt(a);
       }
       char temp;
        temp=array[i];
        array[i]=array[j];
        array[j]=temp;
        String string=new String(array);
        return string;
    }
    public static long power(int x,int n){
        if (n==0){
            return 1;
        }
        return x*power(x,n-1);
    }
    public static long inversionCount(long[] arr,int N){
        if(arr.length==1){
            return 0;
        }
        long[] leftArray=new long[N/2];
        long[] rightArray=new long[N-N/2];
        for (int i=0;i<(N/2);i++){
            leftArray[i]=arr[i];
        }
        for (int i=0;i<(N-N/2);i++){
            rightArray[i]=arr[(N/2)+i];
        }
        long leftInversionCount=inversionCount(leftArray,leftArray.length);
        long rightInversionCount=inversionCount(rightArray,rightArray.length);
        long[] resultArray=new long[N];
        long InversionCountDuringMerge=inversionduringMERGE(leftArray,rightArray,resultArray);
        for (int a=0;a<resultArray.length;a++) {
            arr[a] = resultArray[a];
        }
        return leftInversionCount+rightInversionCount+InversionCountDuringMerge;

    }
      public static long inversionduringMERGE(long[] leftArray,long[] rightArray,long[] resultArray){
        int i=0,j=0,k=0;
        long count=0;

        while(i<leftArray.length&&j<rightArray.length){
            if (leftArray[i]<=rightArray[j]){
                resultArray[k]=leftArray[i];
                k++;
                i++;
            }
            else if (leftArray[i]>rightArray[j]){
                resultArray[k]=rightArray[j];
                k++;
                j++;
                count+=leftArray.length-i;
            }
        }
          while(i<leftArray.length){
              resultArray[k]=leftArray[i];
              k++;
              i++;
          }
          while(j<rightArray.length){
              resultArray[k]=rightArray[j];
              k++;
              j++;
          }
        return count;
      }
   public static int Agressivecows(int[] arr,int cows,int sValue,int eValue,int ans){
        if (sValue>eValue){
            return ans;
        }
        int mid=(sValue+eValue)/2;
        ans=mid;
        if (isPossible(arr,cows,mid)){

           ans= Agressivecows(arr,cows,mid+1,eValue,ans);
        }
        else
            ans=Agressivecows(arr,cows,sValue,mid-1,ans);
        return ans;
   }
       public static boolean isPossible(int[] arr,int cows,int mid){
          int count=1;
          int last_position=0;
          int k=1;
          while(last_position<arr.length&&k<arr.length){
              if (arr[k]-arr[last_position]>=mid){
                  last_position=k;
                  count++;
              }
              if (count==cows) return true;
              k++;
          }
         return false;
       }













    public static void ratMazeProblem(int[][] input,int[][] output,int i,int j,int N) {
             if (i==N-1&&j==N-1){
                 print(output);
                 return;
             }
            output[i][j]=1;
            if (checkposition(input,output,i-1,j,N)) ratMazeProblem(input,output,i-1,j,N);
            if (checkposition(input,output,i+1,j,N)) ratMazeProblem(input,output,i+1,j,N);
            if (checkposition(input,output,i,j-1,N)) ratMazeProblem(input,output,i,j-1,N);
            if (checkposition(input,output,i,j+1,N)) ratMazeProblem(input,output,i,j+1,N);
            output[i][j]=0;
          }
    public static boolean checkposition(int[][] input,int[][] output,int i,int j,int N){
       if (i==-1||j==-1||i==N||j==N) return false;
       if (input[i][j]==0) return false;
       if (output[i][j]==1) return false;
        return true;
    }
    public static void print(int[][] arr){
        //arr[arr.length-1][arr.length-1]=1;
           for (int i=0;i<arr.length;i++){
               for (int j=0;j<arr[i].length;j++){
                   if (i==arr.length-1&&j==arr.length-1) System.out.print("1");
                   else System.out.print(arr[i][j]+" ");
               }
           }
        System.out.println("\n");
        }
    public static boolean solveNqueen(int[][] board,int n,int row){
        if (row==n){
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    System.out.print(board[i][j]+" ");
                }

            }

            return false;
        }
        for (int j=0;j<n;j++){
            if (isPositionSafe(board,row,j,n)){
                board[row][j]=1;

                boolean rakhPaaye=solveNqueen(board,n,row+1);
                if (rakhPaaye) return true;
                board[row][j]=0; //BAckTracking
            }
        }
        return false;
    }
    public static boolean isPositionSafe(int[][] board,int i,int j,int n){
          for (int row=0;row<i;row++){
              if (board[row][j]==1){
                  return false;
              }
          }
          int x=i,y=j;
          while (x>=0&&y>=0){
              if (board[x][y]==1){
                  return false;
              }
              x--;
              y--;
          }
         x=i;y=j;
        while (x>=0&&y<n){
            if (board[x][y]==1){
                return false;
            }
            x--;
            y++;
        }

      return true;
    }

}
