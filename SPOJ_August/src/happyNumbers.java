import java.util.Scanner;

public class happyNumbers {
    static class node{
        int val;
        boolean is;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        boolean[] visited=new boolean[1500];
        int hv=happyValue(n);
        node ans=dfs(hv,visited);
        if (ans.is){
            System.out.println(ans.val+1);
        }
        else System.out.println(-1);
    }

    private static node dfs(int hv, boolean[] visited) {
        if (happyValue(hv)==1){
            node a=new node();
            visited[1]=true;
            a.is=true;
            a.val=1;
            return a;
        }
        if (!visited[hv]){
            node b;
            visited[hv]=true;
            b=dfs(happyValue(hv),visited);
            if (b.is){
                b.val++;
            }
            return b;
        }
        node c=new node();
        c.val=0;
        c.is=false;
        return c;
    }

    private static int happyValue(int n) {
        int ans=0;
        while (n!=0){
            int x=n%10;
            ans+=(x*x);
            n/=10;
        }
        return ans;
    }
}
