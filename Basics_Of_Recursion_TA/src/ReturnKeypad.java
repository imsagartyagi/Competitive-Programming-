import java.util.ArrayList;
import java.util.Scanner;

public class ReturnKeypad {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        ArrayList<String> output=new ArrayList<String>();
        returnKeypad(num,output);
        for (int i=0;i<output.size();i++){
            System.out.println(output.get(i));
        }
    }
    public static void returnKeypad(int num,ArrayList<String> output){
        if(num==0){
            output.add("");
            return ;
        }
        returnKeypad(num/10,output);
        if (num%10==1||num%10==0){
            output.clear();
            return;
        }
        else if (num%10==2){
            int sizeOUtput=output.size();
           for (int i=0;i<sizeOUtput;i++){
              output.add(output.get(i)+'b');
           }
            for (int i=0;i<sizeOUtput;i++){
                output.add(output.get(i)+'c');
            }
            for (int i=0;i<sizeOUtput;i++){
                output.set(i,output.get(i)+'a');
            }
        }
        else if (num%10==3){
            int sizeOUtput=output.size();
            for (int i=0;i<sizeOUtput;i++){
                output.add(output.get(i)+'e');
            }
            for (int i=0;i<sizeOUtput;i++){
                output.add(output.get(i)+'f');
            }
            for (int i=0;i<sizeOUtput;i++){
                output.set(i,output.get(i)+'d');
            }
        }
        else if (num%10==4){
            int sizeOUtput=output.size();
            for (int i=0;i<sizeOUtput;i++){
                output.add(output.get(i)+'h');
            }
            for (int i=0;i<sizeOUtput;i++){
                output.add(output.get(i)+'i');
            }
            for (int i=0;i<sizeOUtput;i++){
                output.set(i,output.get(i)+'g');
            }
        }
        else if (num%10==5){
            int sizeOUtput=output.size();
            for (int i=0;i<sizeOUtput;i++){
                output.add(output.get(i)+'k');
            }
            for (int i=0;i<sizeOUtput;i++){
                output.add(output.get(i)+'l');
            }
            for (int i=0;i<sizeOUtput;i++){
                output.set(i,output.get(i)+'j');
            }
        }
        else if (num%10==6){
            int sizeOUtput=output.size();
            for (int i=0;i<sizeOUtput;i++){
                output.add(output.get(i)+'n');
            }
            for (int i=0;i<sizeOUtput;i++){
                output.add(output.get(i)+'o');
            }
            for (int i=0;i<sizeOUtput;i++){
                output.set(i,output.get(i)+'m');
            }
        }
        else if (num%10==7){
            int sizeOUtput=output.size();
            for (int i=0;i<sizeOUtput;i++){
                output.add(output.get(i)+'q');
            }
            for (int i=0;i<sizeOUtput;i++){
                output.add(output.get(i)+'r');
            }
            for (int i=0;i<sizeOUtput;i++){
                output.add(output.get(i)+'s');
            }
            for (int i=0;i<sizeOUtput;i++){
                output.set(i,output.get(i)+'p');
            }
        }
        else if (num%10==8){
            int sizeOUtput=output.size();
            for (int i=0;i<sizeOUtput;i++){
                output.add(output.get(i)+'u');
            }
            for (int i=0;i<sizeOUtput;i++){
                output.add(output.get(i)+'v');
            }
            for (int i=0;i<sizeOUtput;i++){
                output.set(i,output.get(i)+'t');
            }
        }
        else if (num%10==9){
            int sizeOUtput=output.size();
            for (int i=0;i<sizeOUtput;i++){
                output.add(output.get(i)+'x');
            }
            for (int i=0;i<sizeOUtput;i++){
                output.add(output.get(i)+'y');
            }
            for (int i=0;i<sizeOUtput;i++){
                output.add(output.get(i)+'z');
            }
            for (int i=0;i<sizeOUtput;i++){
                output.set(i,output.get(i)+'w');
            }
        }
    }
}
