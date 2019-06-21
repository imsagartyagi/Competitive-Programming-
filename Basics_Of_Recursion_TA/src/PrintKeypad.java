import java.util.Scanner;

public class PrintKeypad {
    public static void main(String[] args) {
       Scanner scanner=new Scanner(System.in);
       int n=scanner.nextInt();
       String output=new String("");
       printkeyPad(n,output);
    }
    public static void printkeyPad(int num,String output){
        if (num==0){
            System.out.println(output);
        }
        if (num%10==1||num%10==0){
            return;
        }
        else if (num%10==2){
            printkeyPad(num/10,'a'+output);
            printkeyPad(num/10,'b'+output);
            printkeyPad(num/10,'c'+output);
        }
        else if (num%10==3){
            printkeyPad(num/10,'d'+output);
            printkeyPad(num/10,'e'+output);
            printkeyPad(num/10,'f'+output);
        }
        else if (num%10==4){
            printkeyPad(num/10,'g'+output);
            printkeyPad(num/10,'h'+output);
            printkeyPad(num/10,'i'+output);
        }
        else if (num%10==5){
            printkeyPad(num/10,'j'+output);
            printkeyPad(num/10,'k'+output);
            printkeyPad(num/10,'l'+output);
        }
        else if (num%10==6){
            printkeyPad(num/10,'m'+output);
            printkeyPad(num/10,'n'+output);
            printkeyPad(num/10,'o'+output);
        }
        else if (num%10==7){
            printkeyPad(num/10,'p'+output);
            printkeyPad(num/10,'q'+output);
            printkeyPad(num/10,'r'+output);
            printkeyPad(num/10,'s'+output);
        }
        else if (num%10==8){
            printkeyPad(num/10,'t'+output);
            printkeyPad(num/10,'u'+output);
            printkeyPad(num/10,'v'+output);
        }
        else if (num%10==9){
            printkeyPad(num/10,'w'+output);
            printkeyPad(num/10,'x'+output);
            printkeyPad(num/10,'y'+output);
            printkeyPad(num/10,'z'+output);
        }
    }
}
