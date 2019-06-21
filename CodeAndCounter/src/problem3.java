import java.util.Scanner;

public class problem3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int[] tree=new int[4*n];
        buildSegment(tree,arr,0,n-1,1);
        int ans[]=func(n,tree);
        for (int i=0;i<n;i++){
            System.out.print(ans[i]+" ");
        }
    }

    public static int[] func(int n, int[] tree) {
        int[] ans = new int[n];
        for (int x = 1; x <= n; x++) {
            int max=Integer.MIN_VALUE;
            for (int i = 0; i <=n-x ; i++) {
                int a = i;
                int b = x +i-1;
                int min_a_b=SegMin(tree,a,b,0,n-1,1);
                if (min_a_b>max){
                    max=min_a_b;
                }
            }
            ans[x-1]=max;
        }
        return ans;
    }

    public static void buildSegment(int[] tree, int[] arr, int start, int end, int treenode){
        if (start>end) return;
        if (start==end){
            tree[treenode]=arr[start];
            return;
        }
        int mid=(start+end)/2;
        buildSegment(tree, arr, start, mid, 2*treenode);
        buildSegment(tree, arr, mid+1, end, 2*treenode +1);
        tree[treenode]=Math.min(tree[treenode*2],tree[treenode*2+1]);
    }
    public static int SegMin(int[] tree, int left, int right,int start,int end,int treenode) {
        // outside
        if (right<start||left>end){
            return Integer.MAX_VALUE;
        }
        // completeoverlap
        if (start>=left&&end<=right){
            return tree[treenode];
        }
        //partial
        int mid=(start+end)/2;
        int op1=SegMin( tree, left, right, start, mid, 2*treenode);
        int op2=SegMin( tree, left, right, mid+1, end, 2*treenode+1);
        return Math.min(op1,op2);
    }
}
