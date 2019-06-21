import java.util.Scanner;

public class forces2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int s=scanner.nextInt();
        int t=scanner.nextInt();
        int q=scanner.nextInt();
        int[] arr=new int[s];
        String s1=scanner.next();
        String s2=scanner.next();
        for (int i=0;i<s-t+1;i++){
           String temp=s1.substring(i,i+t);
           if (temp.equals(s2)){
               if ((i)==0){
                   arr[i]=1;
               }
               else arr[i]=arr[i-1]+1;
           }else {
               if (i==0) continue;
               arr[i] = arr[i - 1];
           }
        }
        for (int i=s-t+1;i<s;i++){
            arr[i]=arr[i-1]+arr[i];
        }
        for (int i=0;i<q;i++){
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            if (a==1){
                System.out.println(arr[b-1]);
                continue;
            }
            int ans=arr[b-1]-arr[a-2];
            System.out.println(ans);
        }
    }
}
