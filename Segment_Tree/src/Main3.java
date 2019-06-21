import java.util.Scanner;

//Horrible Queries
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        StringBuilder builder=new StringBuilder();
        while(test-- >0){
            int n=scanner.nextInt();
            int[] arr=new int[n];
            int[] tree=new int[4*n];
            int[] lazy=new int[4*n];
            buildSegmentTree(arr,tree,1,0,n-1);
            int c=scanner.nextInt();
            for (int i=0;i<c;i++){
                int op=scanner.nextInt();
                if (op==0){
                    int l=scanner.nextInt();
                    int r=scanner.nextInt();
                    int val=scanner.nextInt();
                    updateSegmentLazy(arr,tree,lazy,0,n-1,l-1,r-1,1,val);
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
    private static int querySegmentLazy(int[] tree, int[] lazy, int start, int end, int left, int right,int treenode) {
        if (lazy[treenode]!=0){
            tree[treenode]+=lazy[treenode]*(end-start+1);
            if (start==end){
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
        int option1=querySegmentLazy(tree, lazy, start, mid, left, right, 2*treenode);
        int option2=querySegmentLazy(tree, lazy, mid+1, end, left, right, 2*treenode+1);
        return option1+option2;
    }
    private static void updateSegmentLazy(int[] arr, int[] tree, int[] lazy, int start, int end, int left, int right, int treenode, int val) {
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
        updateSegmentLazy(arr, tree, lazy, start, mid, left, right, 2*treenode, val);
        updateSegmentLazy(arr, tree, lazy, mid+1, end, left, right, 2*treenode+1, val);
        tree[treenode]=tree[treenode*2]+tree[treenode*2+1];
    }
    private static void buildSegmentTree(int[] arr, int[] tree, int treenode, int start, int end) {
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
