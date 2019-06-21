import java.util.ArrayList;
import java.util.Scanner;

public class spellBob {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test =scanner.nextInt();
        while (test-- >0){
            String s1=scanner.next();
            String s2=scanner.next();
            char[] a=s1.toCharArray();
            char[] b=s2.toCharArray();
            boolean ans=check(a,b);
            System.out.println((ans==true)?"yes":"no");
        }
    }

    private static boolean check(char[] a, char[] b) {
        for (int i=0;i<3;i++){
            if (a[i]!='b'&&a[i]!='o'&&b[i]!='b'&&b[i]!='o'){
                return false;
            }
        }
        ArrayList<Integer> temp=new ArrayList<Integer>();
        temp.add((int) a[0]); temp.add((int) a[1]); temp.add((int) a[2]);
        if (chck(temp)){
            return true;
        }
        temp =new ArrayList<Integer>();
        temp.add((int) a[0]); temp.add((int) a[1]); temp.add((int) b[2]);
        if (chck(temp)){
            return true;
        }
        temp =new ArrayList<Integer>();
        temp.add((int) a[0]); temp.add((int) b[1]); temp.add((int) a[2]);
        if (chck(temp)){
            return true;
        }
        temp =new ArrayList<Integer>();
        temp.add((int) a[0]); temp.add((int) b[1]); temp.add((int) b[2]);
        if (chck(temp)){
            return true;
        }
        temp =new ArrayList<Integer>();
        temp.add((int) b[0]); temp.add((int) a[1]); temp.add((int) a[2]);
        if (chck(temp)){
            return true;
        }
        temp =new ArrayList<Integer>();
        temp.add((int) b[0]); temp.add((int) a[1]); temp.add((int) b[2]);
        if (chck(temp)){
            return true;
        }
        temp =new ArrayList<Integer>();
        temp.add((int) b[0]); temp.add((int) b[1]); temp.add((int) a[2]);
        if (chck(temp)){
            return true;
        }
        temp =new ArrayList<Integer>();
        temp.add((int) b[0]); temp.add((int) b[1]); temp.add((int) b[2]);
        if (chck(temp)){
            return true;
        }
        return false;
    }

    private static boolean chck(ArrayList<Integer> temp) {
        int countb=0;
        int counto=0;
        for (int i=0;i<3;i++){
            if (temp.get(i)=='b'){
                countb++;
            }
            else if (temp.get(i)=='o'){
                counto++;
            }
        }
        if (countb==2&&counto==1){
            return true;
        }
        else return false;
    }
}
