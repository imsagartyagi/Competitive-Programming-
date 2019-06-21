import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class MAin {
    public static void main(String[] args) {
        System.out.println(countPAlindromicsSUbstring("aba"));
    }






















    public static int countPAlindromicsSUbstring(String string){
        if (string.isEmpty()) return 0;
        if (string.length()==1) return 1;
        if (isPalindrome(string)){
            return 1+countPAlindromicsSUbstring(string.substring(1))+countPAlindromicsSUbstring(string.substring(0,string.length()-1))
                    -countPAlindromicsSUbstring(string.substring(1,string.length()-1));
        }
        else
           return countPAlindromicsSUbstring(string.substring(1))+countPAlindromicsSUbstring(string.substring(0,string.length()-1))
                    -countPAlindromicsSUbstring(string.substring(1,string.length()-1));
    }
    public static boolean isPalindrome(String string){
        StringBuilder builder=new StringBuilder(string);
        builder.reverse();
        if (string.equals(builder.toString())){
            return true;
        }
        else return false;
    }

 public static int maxVAlue(int[] arr){
      int max=arr[0];
      for (int i=0;i<arr.length;i++){
          if (arr[i]>max){
              max=arr[i];
          }
      }
      return max;
 }
    public static int minVAlue(int[] arr){
        int min=arr[0];
        for (int i=0;i<arr.length;i++){
            if (arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }
    public static void IncreasingNumbers(int n){
        for (int i = (int) Math.pow(10,n-1); i<Math.pow(10,n);i++){
            if (isDigitCorrect(i)){
                System.out.println(i);
            }
        }
    }
    public static boolean isDigitCorrect(int number){
       while (number%10>(number/10)%10){
           number=number/10;
       }
       if (number==0){
           return true;
       }
       else return false;
    }
    public static int pillars(int[] arr){
        Arrays.sort(arr);
        int pillar=arr[arr.length-2];
        int sum=0;
        for (int i=0;i<arr.length-2;i++){
            sum+=(pillar-arr[i]);
        }
        return sum;
    }
}
