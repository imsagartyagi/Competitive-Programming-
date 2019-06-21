import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        int[] prearr=new int[100005];
        for (int i=1;i<100005;i++){
            if (i%10==2||i%10==3||i%10==9){
                prearr[i]=prearr[i-1]+1;
            }
            else prearr[i]=prearr[i-1];
        }
        while (test-- >0){
            int l=scanner.nextInt();
            int r=scanner.nextInt();
            int ans=prearr[r]-prearr[l-1];
            System.out.println(ans);
        }
    }
}
