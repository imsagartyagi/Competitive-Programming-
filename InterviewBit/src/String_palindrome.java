import java.util.Scanner;

public class String_palindrome {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        if(isPalindrome(s)){
            System.out.println(1);
        }
        else System.out.println(0);
    }

    private static boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        int flag=0;
        while (i<j){
            if (Character.isLetterOrDigit(s.charAt(i))&&Character.isLetterOrDigit(s.charAt(j))){
                if (Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(j))){
                    i++;
                    j--;
                    continue;
                }
                else {
                    flag=1;
                    break;
                }
            }
            else if (!Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            else if (!Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
        }
        if (flag==0){
            return true;
        }
        else return false;
    }
}
