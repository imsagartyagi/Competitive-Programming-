import java.util.Scanner;

public class dnaSequence {
    static class node{
        boolean is;
        int length;

        node(boolean is,int length){
            this.is=is;
            this.length=length;
        }
    }

    //This is an InComplete Solution and Infact a wrong Solution! Do it Now! Please

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int k=in.nextInt();
        while (k!=0) {
            String str1 = in.next();
            String str2 = in.next();
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();
            System.out.println(compute(arr1, arr2, k, 0, 0));
            k=in.nextInt();
        }
    }

    private static int compute(char[] arr1, char[] arr2, int k, int i, int j) {
        if (i>=arr1.length||j>=arr2.length){
            return 0;
        }
        if (arr1[i]!=arr2[j]){
            int op2=compute(arr1, arr2, k, i, j+1);
            int op1=compute(arr1, arr2, k, i+1, j);
            return Math.max(op1,op2);
        }
        else {
            node check=isnext_K_Equal(arr1,arr2,i,j,k);
            if (check.is){
                return check.length+compute(arr1, arr2, k, i+check.length, j+check.length);
            }
            else return compute(arr1, arr2, k, i+1, j+1);
        }
    }

    private static node isnext_K_Equal(char[] arr1, char[] arr2, int i, int j,int k) {
        int count=0;
        for (int a=i,b=j;a<arr1.length&&b<arr2.length;a++,b++){
            if (arr1[a]==arr2[b]){
                count++;
            }
            else if (arr1[a]!=arr2[b]){
                if (count>=k){
                    return new node(true,count);
                }
                else return new node(false,0);
            }
        }
        if (count>=k){
            return new node(true,count);
        }
        else return new node(false,0);
    }

}
