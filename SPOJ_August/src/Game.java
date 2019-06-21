import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws IOException {
       Scanner scanner =new Scanner(System.in);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        args=bufferedReader.readLine().split(" ");
        for (int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
       /* long n=scanner.nextInt();
        if (n%10==0){
            System.out.println(2);
        }
        else {
            System.out.println(1);
            System.out.println(n%10);
        }*/
    }
}
