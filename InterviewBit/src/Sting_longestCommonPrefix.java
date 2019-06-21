import java.util.ArrayList;
import java.util.Scanner;

public class Sting_longestCommonPrefix {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        ArrayList<String> strings=new ArrayList<>();
        int minlength=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            strings.add(in.next());
            if (strings.get(i).length()<minlength){
                minlength=strings.get(i).length();
            }
        }
        String ans=lcp(strings,minlength);
        System.out.println(ans);
    }
    private static String lcp(ArrayList<String> strings,int minlength) {
        StringBuilder builder=new StringBuilder();
        int flag=0;
        int p=0;
        while (p<minlength) {
            char x=strings.get(0).charAt(p);
            for (int i = 1; i < strings.size(); i++) {
                 if (strings.get(i).charAt(p)==x){
                     continue;
                 }
                 else flag=1; break;
            }
            if (flag==1){
                break;
            }
            builder.append(x);
            p++;
        }
        return builder.toString();
    }
}
