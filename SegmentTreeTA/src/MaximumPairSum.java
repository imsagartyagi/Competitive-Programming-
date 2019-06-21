import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MaximumPairSum {
    public static void main(String[] args) throws IOException {
        FastReader scanner=new FastReader();
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        node[] tree=new node[3*n];
        for (int i=0;i<3*n;i++){
            tree[i]=new node();
        }
        buildTree(arr,tree,0,n-1,1);
        int q=scanner.nextInt();
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<q;i++){
            String x=scanner.next();
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            if (x.equals("Q")){
               node ans=query(tree,0,n-1,a-1,b-1,1);
               builder.append(ans.max+ans.secondmax).append("\n");
            }
            else {
                update(arr,tree,0,n-1,a-1,b,1);
            }
        }
        System.out.println(builder);
    }

    public static void update(int[] arr, node[] tree, int start, int end, int indx, int val, int treenode) {
        if (start==end){
            if (start==indx){
                arr[indx]=val;
                tree[treenode].max=val;
                tree[treenode].secondmax=Integer.MIN_VALUE;
                return;
            }
        }

        int mid=(start+end)/2;
        if (indx>mid){
            update(arr, tree, mid+1, end, indx, val, 2*treenode+1);
        }
        else {
            update(arr, tree, start, mid, indx, val, 2*treenode);
        }
        fillTree(tree,treenode);
    }
    private static node query(node[] tree, int start, int end, int left, int right, int treenode) {

        int mid=(start+end)/2;
        if (start>right||end<left){
            node temp=new node();
            temp.max=Integer.MIN_VALUE;
            temp.secondmax=Integer.MIN_VALUE;
            return temp;
        }
        else if (start>=left&&end<=right){
            return tree[treenode];
        }
        node option1=query(tree, start, mid, left, right, (2*treenode));
        node option2=query(tree, mid+1, end, left, right, (2*treenode)+1);
        node ans=new node();
        ans.max=Math.max(option1.max,option2.max);
        if (ans.max==option1.max){
            ans.secondmax= Math.max(option1.secondmax,option2.max);
        }
        else {
            ans.secondmax= Math.max(option1.max,option2.secondmax);
        }
        return ans;
    }
    public static void buildTree(int[] arr, node[] tree, int start, int end, int treenode) {
        if (start==end){
            tree[treenode].max=arr[start];
            tree[treenode].secondmax=Integer.MIN_VALUE;
            return;
        }
        int mid=(start+end)/2;
        buildTree(arr, tree, start, mid, 2*treenode);
        buildTree(arr, tree, mid+1, end, 2*treenode+1);
        fillTree(tree,treenode);
    }
    public static void fillTree(node[] tree,int treenode) {
        tree[treenode].max= Math.max(tree[treenode*2].max,tree[(treenode*2)+1].max);
        if (tree[treenode].max==tree[treenode*2].max){
            tree[treenode].secondmax= Math.max(tree[treenode*2].secondmax,tree[2*treenode+1].max);
        }
        else {
            tree[treenode].secondmax= Math.max(tree[(treenode*2)+1].secondmax,tree[2*treenode].max);
        }
    }
}
class node{
    int max;
    int secondmax;
}
 class FastReader
{
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException  e)
            {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt()
    {
        return Integer.parseInt(next());
    }

    long nextLong()
    {
        return Long.parseLong(next());
    }

    double nextDouble()
    {
        return Double.parseDouble(next());
    }

    String nextLine()
    {
        String str = "";
        try
        {
            str = br.readLine();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return str;
    }
}
