import java.util.Scanner;

public class BS_pow {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        int m=in.nextInt();
        int ans=pow(a,b,m);
        System.out.println(ans%m);
    }

    private static int pow(int a, int b, int m) {
        if(b==0){
            return 1;
        }
        int x=pow((int) (((long)(a%m)*(a%m))%m),b/2,m);
        if (b%2!=0){
            x= (int) (((long)(a%m)*x)%m);
        }
        return x;
    }
}
