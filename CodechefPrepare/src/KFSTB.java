import com.sun.xml.internal.stream.Entity;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KFSTB {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        StringBuilder builder=new StringBuilder();
        while (test-- >0) {
            int n = scanner.nextInt();
            int e=scanner.nextInt();
            int start=scanner.nextInt();
            int end=scanner.nextInt();
            ArrayList<Integer>[] graph=new ArrayList[n+1];
            for (int i=0;i<=n;i++){
                graph[i]=new ArrayList<>();
            }
            for (int i=0;i<e;i++){
                graph[scanner.nextInt()].add(scanner.nextInt());
            }
            int[] dp=new int[n+1];
            Arrays.fill(dp,-1);
            builder.append(pathCount(graph,n,start,end,dp)).append("\n");
        }
        System.out.println(builder);
    }

    private static int pathCount(ArrayList<Integer>[] graph, int n, int start, int end,int[] dp) {
        if (start==end){
            return 1;
        }
        if(dp[start]!=-1){
            return dp[start];
        }
        int ans=0;
        for (int i = 1; i <= n; i++) {
            if (graph[start].contains(i)){
                ans+=pathCount(graph,n,i,end,dp);
            }
        }
        dp[start]=ans;
        return ans;
    }
}
