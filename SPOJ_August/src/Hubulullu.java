import java.util.Scanner;

public class Hubulullu {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        StringBuilder builder=new StringBuilder();
        while (test-- >0){
            int n=scanner.nextInt();
            int start=scanner.nextInt();
            int x;
            if (n%2==0){
                x=n/2;
            }
            else x=(n+1)/2;
            int ans=-1;
            if (x%2==0){
                if (start==0){
                    ans=1;
                }
                else ans=0;
            }
            else if (x%2!=0){
                if (start==1){
                    ans=1;
                }
                else ans=0;
            }
            if (ans==0){
                builder.append("Airborne wins.").append("\n");
            }
            else builder.append("Pagfloyd wins.").append("\n");
        }
        System.out.println(builder);
    }
}
