import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k=0,flag=0;
        int[] slash = new int[str.length()];
        for(int i=0;i<str.length()-1;i++) {
            if(str.charAt(i)=='/') {
                slash[k]=i;
                k++;
            }
            if(str.charAt(i)=='.'&&str.charAt(i+1)=='.'){
                if(k<2) {
                    System.out.println("-1");
                    flag=1;
                    break;
                }
                else {
                    i=slash[k-2]-1;
                    str = str.replace(str.substring(slash[k-2], slash[k-1]+3), "");
                    slash[k-1]=0;
                    slash[k-2]=0;
                    k=k-2;
                }
                continue;
            }
            if(str.charAt(i)=='.') {
                if(k<1) {
                    System.out.println("-1");
                    flag=1;
                    break;
                }
                i = i-slash[k-1]-1;
                str = str.replace(str.substring(slash[k-1],slash[k-1]+2), "");
                slash[k-1]=0;
                k--;
            }
        }
        if(flag==0) {
            System.out.println(str);
        }
    }
}

