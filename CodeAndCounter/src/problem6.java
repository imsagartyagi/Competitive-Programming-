import java.util.Scanner;

public class problem6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String number=scanner.next();
        String base=scanner.next();
        System.out.println(func(number,base));
    }
    public static boolean func(String num,String base){
        if (base=="Hex"){
          return true;
        }
        else if (base.equals("Decimal")){
            for (int i=0;i<num.length();i++){
                if (num.charAt(i)=='A'||num.charAt(i)=='B'||num.charAt(i)=='C'||num.charAt(i)=='D'||num.charAt(i)=='E'||num.charAt(i)=='F'){
                    return false;
                }
            }
            return true;
        }
        else if (base.equals("Octal")){
            for (int i=0;i<num.length();i++){
                if (Integer.parseInt(num.substring(i,i+1))>7){
                    return false;
                }
            }
            return true;
        }
        else if (base.equals("Binary")){
            for (int i=0;i<num.length();i++){
                if (Integer.parseInt(num.substring(i,i+1))>1){
                    return false;
                }
            }
        }
        return true;
    }
}
