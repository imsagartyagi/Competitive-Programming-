import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<String> strings=new ArrayList<String>();
        System.out.println(removeX("aaabxxxcxddax"));

    }
   public static String removeX(String string){
        if (string.length()==0){
            return string;
        }
        if (string.charAt(0)=='x'){
            return removeX(string.substring(1));
        }
        else{
            return string.charAt(0)+removeX(string.substring(1));
        }
    }









    public static void printKeypad(int input,String output){
        if (input==0){
            System.out.println(output);
            return;
        }
        if (input%10==2){
            printKeypad(input/10,"a"+output);
            printKeypad(input/10,"b"+output);
            printKeypad(input/10,"c"+output);
        }
        if (input%10==3){
           printKeypad(input/10,"d"+output);
           printKeypad(input/10,"e"+output);
           printKeypad(input/10,"f"+output);
        }
        if (input%10==4){
            printKeypad(input/10,"g"+output);
            printKeypad(input/10,"h"+output);
            printKeypad(input/10,"i"+output);
        }
        if (input%10==5){
            printKeypad(input/10,"j"+output);
            printKeypad(input/10,"k"+output);
            printKeypad(input/10,"l"+output);
        }
        if (input%10==6){
            printKeypad(input/10,"m"+output);
            printKeypad(input/10,"n"+output);
            printKeypad(input/10,"o"+output);
        }
        if (input%10==7){
            printKeypad(input/10,"p"+output);
            printKeypad(input/10,"q"+output);
            printKeypad(input/10,"r"+output);
            printKeypad(input/10,"s"+output);
        }
        if (input%10==8){
            printKeypad(input/10,"t"+output);
            printKeypad(input/10,"u"+output);
            printKeypad(input/10,"v"+output);
        }
        if (input%10==9){
            printKeypad(input/10,"w"+output);
            printKeypad(input/10,"x"+output);
            printKeypad(input/10,"y"+output);
            printKeypad(input/10,"z"+output);
        }

    }
    public static String removeConsecutiveDuplicates(String s) {
        if(s.length()<=1){
            return s;
        }
        if(s.substring(1,2).equals(s.substring(0,1))){
            return removeConsecutiveDuplicates(s.substring(1));
        }
        else {
            return s.substring(0,1)+removeConsecutiveDuplicates(s.substring(1));
        }
    }
   public static void printSubsequence(String str, String s){
        if (str.isEmpty()){
            System.out.println(s);
            return;
        }
        printSubsequence(str.substring(1),s);
        printSubsequence(str.substring(1),s+str.substring(0,1));

   }

    public static void keypadcode(int num,ArrayList<String> stringArrayList) {
        int callnum=num%10;
        if (callnum == 0) {
            stringArrayList.add("");
            return;
        }
        keypadcode(num / 10,  stringArrayList);
        if (callnum == 2) {
            int listsize = stringArrayList.size();
            for (int i = 0; i < listsize; i++) {
                stringArrayList.add(stringArrayList.get(i));
                stringArrayList.set(i, stringArrayList.get(i) + "a");

            }
            for (int i = listsize; i < 2 * listsize; i++) {
                stringArrayList.add(stringArrayList.get(i));
                stringArrayList.set(i, stringArrayList.get(i) + "b");

            }
            for (int i = 2 * listsize; i < 3 * listsize; i++) {
                stringArrayList.set(i, stringArrayList.get(i) + "c");

            }


        } else if (callnum == 3) {
            int listsize = stringArrayList.size();
            for (int i = 0; i < listsize; i++) {
                stringArrayList.add(stringArrayList.get(i));
                stringArrayList.set(i, stringArrayList.get(i) + "d");

            }
            for (int i = listsize; i < 2 * listsize; i++) {
                stringArrayList.add(stringArrayList.get(i));
                stringArrayList.set(i, stringArrayList.get(i) + "e");

            }
            for (int i = 2 * listsize; i < 3 * listsize; i++) {
                stringArrayList.set(i, stringArrayList.get(i) + "f");

            }
        } else if (callnum == 4) {
            int listsize = stringArrayList.size();
            for (int i = 0; i < listsize; i++) {
                stringArrayList.add(stringArrayList.get(i));
                stringArrayList.set(i, stringArrayList.get(i) + "g");

            }
            for (int i = listsize; i < 2 * listsize; i++) {
                stringArrayList.add(stringArrayList.get(i));
                stringArrayList.set(i, stringArrayList.get(i) + "h");

            }
            for (int i = 2 * listsize; i < 3 * listsize; i++) {
                stringArrayList.set(i, stringArrayList.get(i) + "i");

            }
        } else if (callnum == 5) {
            int listsize = stringArrayList.size();
            for (int i = 0; i < listsize; i++) {
                stringArrayList.add(stringArrayList.get(i));
                stringArrayList.set(i, stringArrayList.get(i) + "j");

            }
            for (int i = listsize; i < 2 * listsize; i++) {
                stringArrayList.add(stringArrayList.get(i));
                stringArrayList.set(i, stringArrayList.get(i) + "k");

            }
            for (int i = 2 * listsize; i < 3 * listsize; i++) {
                stringArrayList.set(i, stringArrayList.get(i) + "l");

            }
        } else if (callnum == 6) {
            int listsize = stringArrayList.size();
            for (int i = 0; i < listsize; i++) {
                stringArrayList.add(stringArrayList.get(i));
                stringArrayList.set(i, stringArrayList.get(i) + "m");

            }
            for (int i = listsize; i < 2 * listsize; i++) {
                stringArrayList.add(stringArrayList.get(i));
                stringArrayList.set(i, stringArrayList.get(i) + "n");

            }
            for (int i = 2 * listsize; i < 3 * listsize; i++) {
                stringArrayList.set(i, stringArrayList.get(i) + "o");

            }
        } else if (callnum == 7) {
            int listsize = stringArrayList.size();
            for (int i = 0; i < listsize; i++) {
                stringArrayList.add(stringArrayList.get(i));
                stringArrayList.set(i, stringArrayList.get(i) + "p");

            }
            for (int i = listsize; i < 2 * listsize; i++) {
                stringArrayList.add(stringArrayList.get(i));
                stringArrayList.set(i, stringArrayList.get(i) + "q");

            }
            for (int i = 2 * listsize; i < 3 * listsize; i++) {
                stringArrayList.add(stringArrayList.get(i));
                stringArrayList.set(i, stringArrayList.get(i) + "r");

            }
            for (int i = 3 * listsize; i < 4 * listsize; i++) {
                stringArrayList.set(i, stringArrayList.get(i) + "s");

            }
        } else if (callnum == 8) {
            int listsize = stringArrayList.size();
            for (int i = 0; i < listsize; i++) {
                stringArrayList.add(stringArrayList.get(i));
                stringArrayList.set(i,  stringArrayList.get(i)+"t");

            }
            for (int i = listsize; i < 2 * listsize; i++) {
                stringArrayList.add(stringArrayList.get(i));
                stringArrayList.set(i, stringArrayList.get(i)+"u");

            }
            for (int i = 2 * listsize; i < 3 * listsize; i++) {
                stringArrayList.set(i, stringArrayList.get(i)+"v");

            }
        } else if (callnum == 9) {
            int listsize = stringArrayList.size();
            for (int i = 0; i < listsize; i++) {
                stringArrayList.add(stringArrayList.get(i));
                stringArrayList.set(i, stringArrayList.get(i) + "w");

            }
            for (int i = listsize; i < 2 * listsize; i++) {
                stringArrayList.add(stringArrayList.get(i));
                stringArrayList.set(i, stringArrayList.get(i) + "x");

            }
            for (int i = 2 * listsize; i < 3 * listsize; i++) {
                stringArrayList.add(stringArrayList.get(i));
                stringArrayList.set(i, stringArrayList.get(i) + "y");

            }
            for (int i = 3 * listsize; i < 4 * listsize; i++) {
                stringArrayList.set(i, stringArrayList.get(i) + "z");

            }

        }
    }
    public static int revNum(int n){
        int revnumber=0;
        while (n!=0){
            revnumber=revnumber*10+n%10;
            n=n/10;
        }
        return revnumber;
    }
    public static void subsequence(String str, ArrayList<String> stringArrayList){
        if (str.isEmpty()){
            stringArrayList.add("");
            return;
        }
        subsequence(str.substring(1),stringArrayList);
        int listsize=stringArrayList.size();
        for (int i=0;i<listsize;i++){
            stringArrayList.add(str.charAt(0)+stringArrayList.get(i));
        }
    }
}
