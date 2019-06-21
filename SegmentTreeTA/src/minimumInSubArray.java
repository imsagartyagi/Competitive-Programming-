import java.util.Scanner;

public class minimumInSubArray {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int q=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int[] tree=new int[3*n];
        buildTree(arr,tree,0,n-1,1);
        for (int i=0;i<q;i++){
            String x=scanner.next();
            int a=scanner.nextInt();
            int b=scanner.nextInt();
            if (x.equals("q")) {
                int ans = query(tree, 0, n - 1, a - 1, b - 1, 1);
                System.out.println(ans);
            }
            else {
                update(arr,tree,0,n-1,a-1,b,1);
            }
        }
    }

    private static void update(int[] arr, int[] tree, int start, int end, int indx, int val, int treenode) {
        if (start==end){
            if (start==indx){
                arr[indx]=val;
                tree[treenode]=val;
            }
            return;
        }
        int mid=(start+end)/2;
        if (indx>mid){
            update(arr, tree, mid+1, end, indx, val, 2*treenode+1);
        }
        else {
            update(arr, tree, start, mid, indx, val, 2*treenode);
        }
        tree[treenode]=Math.min(tree[2*treenode],tree[(2*treenode)+1]);
    }

    public static int query(int[] tree, int start, int end, int left, int right, int treenode) {

        int mid=(start+end)/2;
        if (start>right||end<left){
            return Integer.MAX_VALUE;
        }
        else if (start>=left&&end<=right){
            return tree[treenode];
        }
        int option1=query(tree, start, mid, left, right, 2*treenode);
        int option2=query(tree, mid+1, end, left, right, 2*treenode+1);
        return Math.min(option1,option2);
    }

    public static void buildTree(int[] arr, int[] tree, int start, int end, int treenode) {

        if (start==end){
            tree[treenode]=arr[start];
            return;
        }
        int mid=(start+end)/2;
        buildTree(arr,tree,start,mid,2*treenode);
        buildTree(arr,tree,mid+1,end,2*treenode+1);
        tree[treenode]=Math.min(tree[treenode*2],tree[(treenode*2)+1]);
    }
}
