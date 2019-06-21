import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Scanner;

public class searchMatrix {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        ArrayList<ArrayList<Integer>> matrix=new ArrayList<>();
        for (int i=0;i<n;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            for (int j=0;j<m;j++){
                temp.add(in.nextInt());
            }
            matrix.add(temp);
        }
        int k=in.nextInt();
        boolean ans=find(matrix,k);
        System.out.println(ans==true?1:0);
    }

    private static boolean find(ArrayList<ArrayList<Integer>> matrix, int k) {
        int i=0;
        int j=matrix.get(0).size()-1;
        while (j>=0&&i<matrix.size()){
             if (matrix.get(i).get(j)==k){
                 return true;
             }
             if (matrix.get(i).get(j)>k){
                 j--;
             }
             else if (matrix.get(i).get(j)<k){
                 i++;
             }
        }
        return false;
    }
}
