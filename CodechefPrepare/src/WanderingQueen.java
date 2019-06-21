import java.util.Scanner;

public class WanderingQueen {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int test=in.nextInt();
        while (test-- >0){
            int n=in.nextInt();
            int m=in.nextInt();
            String[] strings=new String[m];
            for (int i=0;i<m;i++){
                strings[i]=in.nextLine();
            }
            char[][] arr=new char[n][m];
            for (int i=0;i<m;i++){
                arr[i]=strings[i].toCharArray();
            }
        }
    }
}
