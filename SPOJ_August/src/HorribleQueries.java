import java.util.Scanner;


public class HorribleQueries {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        StringBuilder builder=new StringBuilder();
        while(test-- >0){
            int n=scanner.nextInt();
            int[] arr=new int[n];
            long[] tree=new long[4*n];
            long[] lazy=new long[4*n];
            buildSegmentTree(arr,tree,1,0,n-1);
            long c=scanner.nextInt();
            for (int i=0;i<c;i++){
                int op=scanner.nextInt();
                if (op==0){
                    int l=scanner.nextInt();
                    int r=scanner.nextInt();
                    long val=scanner.nextInt();
                    updateSegmentLazy(tree,lazy,0,n-1,l-1,r-1,1,val);
                }
                else if (op==1){
                    int left=scanner.nextInt();
                    int right=scanner.nextInt();
                    builder.append(querySegmentLazy(tree,lazy,0,n-1,left-1,right-1,1)).append("\n");
                }
            }
        }
        System.out.println(builder);
    }
    private static long querySegmentLazy(long[] tree, long[] lazy, int start, int end, int left, int right, int treenode) {
        if (lazy[treenode]!=0){
            tree[treenode]+=lazy[treenode]*(end-start+1);
            if (start!=end){
                lazy[2*treenode]+=lazy[treenode];
                lazy[2*treenode+1]+=lazy[treenode];
            }
            lazy[treenode]=0;
        }
        // no overlap
        if (start>right||end<left){
            return 0;
        }
        //completly overlap
        if (left<=start&&end<=right){
            return tree[treenode];
        }
        int mid=(start+end)/2;
        long option1=querySegmentLazy(tree, lazy, start, mid, left, right, 2*treenode);
        long option2=querySegmentLazy(tree, lazy, mid+1, end, left, right, 2*treenode+1);
        return option1+option2;
    }
    private static void updateSegmentLazy(long[] tree, long[] lazy, int start, int end, int left, int right, int treenode, long val) {
        if (start>end){
            return;
        }
        if (lazy[treenode]!=0){
            tree[treenode]+=lazy[treenode]*(end-start+1);
            if (start!=end){
                lazy[2*treenode]+=lazy[treenode];
                lazy[2*treenode+1]+=lazy[treenode];
            }
            lazy[treenode]=0;
        }
        // no overlap
        if (start>right||end<left){
            return;
        }
        // complete overlap
        if (left<=start&&end<=right){
            tree[treenode]+=val*(end-start+1);
            if (start!=end){
                lazy[2*treenode]+=val;
                lazy[2*treenode+1]+=val;
            }
            return;
        }
        // partial overlap
        int mid=(start+end)/2;
        updateSegmentLazy(tree, lazy, start, mid, left, right, 2*treenode, val);
        updateSegmentLazy( tree, lazy, mid+1, end, left, right, 2*treenode+1, val);
        tree[treenode]=tree[treenode*2]+tree[treenode*2+1];
    }
    private static void buildSegmentTree(int[] arr, long[] tree, int treenode, int start, int end) {
        if (start==end){
            tree[treenode]=arr[start];
            return;
        }
        int mid=(start+end)/2;
        buildSegmentTree(arr, tree, 2*treenode, start, mid);
        buildSegmentTree(arr, tree, 2*treenode+1, mid+1, end);
        tree[treenode]=tree[treenode*2]+tree[treenode*2+1];
    }
}