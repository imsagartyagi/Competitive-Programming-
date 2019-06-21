import java.util.Scanner;

public class RemoveConsecutiveDuplicates {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string =scanner.next();
        System.out.println(removeConsecutiveDuplicates(string));

    }
    public static String removeConsecutiveDuplicates(String s) {
        StringBuilder builder=new StringBuilder();
        return removeDuplicates(s.toCharArray(),0,builder);
    }
    public static String removeDuplicates(char[] arr,int i,StringBuilder builder){
        if(i==arr.length){
            return builder.toString();
        }
        builder.append(arr[i]);
        char temp=arr[i];
        int k=i;
        while(arr[k]==temp){
            k++;
            if (k==arr.length) break;
        }
        i=k;
        return removeDuplicates(arr,i,builder);
    }
}
