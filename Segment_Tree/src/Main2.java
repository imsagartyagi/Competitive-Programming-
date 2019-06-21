import java.util.Scanner;
// 2 vs 3
public class Main2 {
    public static int[] modpower2=new int[100001];
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StringBuilder builder=new StringBuilder();
        modpower2[0]=1; modpower2[1]=2;
        for (int i=2;i<=100000;i++){
            modpower2[i]=(modpower2[i-1]*2)%3;
        }
        int n=scanner.nextInt();
        String s=scanner.next();
        char[] arr=s.toCharArray();
        int[] tree=new int[4*arr.length];
        buildSegmentTree(arr,tree,0,arr.length-1,1);
        int q=scanner.nextInt();
        for (int i=0;i<q;i++){
            int op=scanner.nextInt();
            if (op==0){
                int l=scanner.nextInt();
                int r=scanner.nextInt();
                builder.append((querysegmentTree(tree,1,0,arr.length-1,l,r))%3).append("\n");
            }
            else if(op==1){
                int indx=scanner.nextInt();
                updateSegmentTree(arr,tree,0,arr.length-1,1,indx,'1');
            }
        }
        System.out.println(builder);
    }

    private static int querysegmentTree(int[] tree, int treenode, int start, int end, int left, int right) {
        if (left>end||right<start){
            return 0;
        }
        if (start>=left&&end<=right){
            return (tree[treenode]*modpower2[right-end])%3;
        }
        int mid=(start+end)/2;
        return ((querysegmentTree(tree, 2*treenode+1, mid+1, end, left, right)%3)+((querysegmentTree(tree, 2*treenode, start, mid, left, right)%3))%3);
    }
    private static void updateSegmentTree(char[] arr, int[] tree, int start, int end, int treenode, int indx, char c) {
        if (start==end){
            arr[indx]=c;
            tree[treenode]=1;
            return;
        }
        int mid=(start+end)/2;
        if (indx<=mid) {
            updateSegmentTree(arr, tree, start, mid, 2 * treenode, indx, c);
        }
        else {
            updateSegmentTree(arr, tree, mid + 1, end, 2 * treenode + 1, indx, c);
        }
        tree[treenode]=((tree[2*treenode+1]%3)+((tree[2*treenode]*(modpower2[end-mid]))%3))%3;
    }
    private static void buildSegmentTree(char[] arr, int[] tree, int start, int end, int treenode) {
        if (start==end){
            if (arr[start]=='1'){
                tree[treenode]=1;
            }
            else if(arr[start]=='0'){
                tree[treenode]=0;
            }
            return;
        }
        int mid=(start+end)/2;
        buildSegmentTree(arr,tree,start,mid,2*treenode);
        buildSegmentTree(arr,tree,mid+1,end,2*treenode+1);
        int a=modpower2[end-mid];
        tree[treenode]=((tree[2*treenode+1]%3)+((tree[2*treenode]*(modpower2[end-mid]))%3))%3;
    }
}
