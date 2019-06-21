import java.util.Scanner;

public class ToandFro {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        while (n!=0){
            int c=n;
            String s=scanner.next();
            int r=(s.length())/c;
            int k=0;
            char[][] arr=new char[r][c];
            for (int i=0;i<r;i++){
                if (i%2==0){
                    for (int j=0;j<c;j++){
                        arr[i][j]=s.charAt(k++);
                    }
                }
                else {
                    for (int j=c-1;j>=0;j--){
                        arr[i][j]=s.charAt(k++);
                    }
                }
            }
            StringBuilder builder=new StringBuilder();
            for (int j=0;j<c;j++){
                for (int i=0;i<r;i++){
                    builder.append(arr[i][j]);
                }
            }
            System.out.println(builder);
            n=scanner.nextInt();
        }
    }
}
