import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

/**** A Great DFS Question! My logic is absolutely Correct But The Implementation is absolutely wrong! ****/

public class paradox_SPOJ {
    static class node{
        int indx,val;
        boolean x;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        StringBuilder builder=new StringBuilder();
        while (n!=0) {
            node[] arr = new node[n+1];
            for (int i = 1; i <= n; i++) {
                arr[i] = new node();
                arr[i].indx = i;
                arr[i].val = sc.nextInt();
                arr[i].x = sc.next().equals("true")?true:false;
            }
            int flag = 0;
            for (int i = 1; i <= n; i++) {
                boolean option1 = dfs(arr, i, false);
                boolean option2 = dfs(arr, i, true);
                if (option1 | option2 == true) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                builder.append("PARADOX").append("\n");
            } else builder.append("NOT PARADOX").append("\n");
            n=sc.nextInt();
        }
        System.out.println(builder);
    }

    public static boolean dfs(node[] arr, int i, boolean b) {
        boolean[] visited=new boolean[arr.length];
        visited[i]=true;
         int f=arr[i].val;
         boolean fb=arr[i].x;
         if (!b){
             fb=arr[i].x^true;
         }
        boolean sas=fb;
         while (!visited[f]&&f!=i){
             visited[f]=true;
             if (!fb){
                 fb=arr[f].x^true;
             }
             else fb=arr[f].x;
             f=arr[f].val;
             if (arr[f].val==arr[f].indx){
                 if (arr[f].x==false){
                     return true;
                 }
                 else return false;
             }
         }
         if (fb==sas){
             return false;
         }
         else return true;
    }
}
