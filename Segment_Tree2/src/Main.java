import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arrA=new int[n];
        int[] arrB=new int[n];
        for (int i=0;i<n;i++){
            arrA[i]=scanner.nextInt();
        }
        for (int i=0;i<n;i++){
            arrB[i]=scanner.nextInt();
        }
        int q=scanner.nextInt();
        int[] li=new int[q];
        int[] ri=new int[q];
        for (int j=0;j<q;j++){
            li[j]=scanner.nextInt();
            ri[j]=scanner.nextInt();
        }
        nodalTree[] tree=new nodalTree[4*n];
        for (int i=0;i<4*n;i++){
            tree[i]=new nodalTree();
        }
        buildTree(arrA,arrB,tree,0,n-1,1);
        for (int i=0;i<q;i++){
            System.out.println(query(arrA,arrB,tree,0,n-1,1,li[i]-1,ri[i]-1).index+1);
        }
    }
    //vasya And Rhezo
    public static class nodalTree{
        int index;
        int maxElement;
        int minElement;
    }
    public static void buildTree(int[] arrA,int[] arrB,nodalTree[] tree,int start,int end,int treenode){
        if (start==end){
            tree[treenode].maxElement=arrA[start];
            tree[treenode].minElement=arrB[start];
            tree[treenode].index=start;
            return;
        }

        int mid=(start+end)/2;
        buildTree(arrA,arrB,tree,start,mid,2*treenode);
        buildTree(arrA,arrB,tree,mid+1,end,(2*treenode)+1);
        if (tree[treenode*2].maxElement!=tree[(2*treenode)+1].maxElement){
            tree[treenode].index=(tree[2*treenode].maxElement>tree[(treenode*2)+1].maxElement)?tree[treenode*2].index:tree[(treenode*2)+1].index;
            tree[treenode].maxElement=arrA[tree[treenode].index];
            tree[treenode].minElement=arrB[tree[treenode].index];
        }
        else if (tree[2*treenode].maxElement==tree[(2*treenode)+1].maxElement){
            tree[treenode].index=(tree[2*treenode].minElement<tree[(treenode*2)+1].minElement)?tree[treenode*2].index:tree[(treenode*2)+1].index;
            tree[treenode].maxElement=arrA[tree[treenode].index];
            tree[treenode].minElement=arrB[tree[treenode].index];
        }
        else if (tree[2*treenode].maxElement==tree[(2*treenode)+1].maxElement&&tree[2*treenode].minElement==tree[(2*treenode)+1].minElement){
            tree[treenode].index=minof(tree[treenode*2].index,tree[(2*treenode)+1].index);
            tree[treenode].maxElement=arrA[tree[treenode].index];
            tree[treenode].minElement=arrB[tree[treenode].index];
        }
    }
    public static nodalTree query(int[] arrA,int[] arrB,nodalTree[] tree,int start,int end,int treenode,int left,int right){
        if (left>end||right<start){
            nodalTree node=new nodalTree();
            node.maxElement=Integer.MIN_VALUE;
            node.minElement=Integer.MAX_VALUE;
            node.index=-1;
            return node;
        }
        else if (start>=left&&end<=right){
            nodalTree node=new nodalTree();
            node.maxElement=tree[treenode].maxElement;
            node.minElement=tree[treenode].minElement;
            node.index=tree[treenode].index;
            return node;
        }
        nodalTree node=new nodalTree();
        int mid=(start+end)/2;
        nodalTree leftans=query(arrA,arrB,tree,start,mid,2*treenode,left,right);
        nodalTree rightans=query(arrA,arrB,tree,mid+1,end,(2*treenode)+1,left,right);
        if (leftans.maxElement!=rightans.maxElement){
            node.index=(leftans.maxElement>rightans.maxElement)?leftans.index:rightans.index;
            node.maxElement=arrA[node.index];
            node.minElement=arrB[node.index];
        }
        else if (leftans.maxElement==rightans.maxElement){
            node.index=(leftans.minElement<rightans.minElement)?leftans.index:rightans.index;
            node.maxElement=arrA[node.index];
            node.minElement=arrB[node.index];
        }
        else if (leftans.maxElement==rightans.maxElement&&leftans.minElement==rightans.minElement){
            node.index=minof(leftans.index,rightans.index);
            node.maxElement=arrA[node.index];
            node.minElement=arrB[node.index];
        }
        return node;
    }
    private static int minof(int a, int b) {
        return (a<b)?a:b;

    }

}

/*
    public static FastScanner scanner=new FastScanner();
    public static int n= scanner.nextInt();
    public static int[] arr=new int[n];
    public static node[] tree=new node[4*n];
    public static void main(String[] args) {
        StringBuilder builder=new StringBuilder();

        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int Q=scanner.nextInt();
        int[] li=new int[Q];
        int[] ri=new int[Q];
        for (int i=0;i<Q;i++){
            li[i]=scanner.nextInt();
            ri[i]=scanner.nextInt();
        }
        for(int i=0;i<4*n;i++){
            tree[i]=new node();
        }
        build_Mx_sumInSubArray_Segment_tree(arr,tree,0,n-1,1);
        for (int i=0;i<4*n;i++){
            System.out.println(tree[i].maxSum+" "+tree[i].prefix_max+" "+tree[i].suffix_Max);
        }
        for (int i=0;i<Q;i++){
            builder.append(SumIn_SubArrayQuery(arr,tree,0,n-1,1,li[i]-1,ri[i]-1).maxSum).append("\n");
        }
        System.out.println(builder);
    }


    // maximum sum in subarray query
    public static class node{
        int maxSum;
        int prefix_max;
        int suffix_Max;

    }
    public static void build_Mx_sumInSubArray_Segment_tree(int[] arr,node[] tree,int start,int end,int treenode){
        if (start==end){
            tree[treenode].maxSum=arr[start];
            tree[treenode].suffix_Max=arr[start];
            tree[treenode].prefix_max=arr[start];
            return;
        }
        int mid=(start+end)/2;
        build_Mx_sumInSubArray_Segment_tree(arr,tree,start,mid,2*treenode);
        build_Mx_sumInSubArray_Segment_tree(arr,tree,mid+1,end,(2*treenode)+1);
        tree[treenode].maxSum=maxof(tree[2*treenode].maxSum,maxof(tree[(treenode*2)+1].maxSum,tree[2*treenode].suffix_Max+tree[(2*treenode)+1].prefix_max));
        tree[treenode].prefix_max=prefixSum(arr,start,end);
        tree[treenode].suffix_Max=suffixSum(arr,start,end);
    }
    public static node SumIn_SubArrayQuery(int[] arr,node[] tree,int start,int end,int treeNode,int left,int right){
        if (left>end||right<start){
            node node=new node();
            node.maxSum=Integer.MIN_VALUE;
            node.prefix_max=Integer.MIN_VALUE;
            node.suffix_Max=Integer.MIN_VALUE;
            return node;
        }
        else if (start>=left&&end<=right){
            node node=new node();
            node.maxSum=tree[treeNode].maxSum;
            node.suffix_Max=tree[treeNode].suffix_Max;
            node.prefix_max=tree[treeNode].prefix_max;
            return node;
        }
        int mid=(start+end)/2;
        node node=new node();
        node leftAns=SumIn_SubArrayQuery(arr,tree,start,mid,2*treeNode,left,right);
        node rightAns=SumIn_SubArrayQuery(arr,tree,mid+1,end,(2*treeNode)+1,left,right);
        node.maxSum=maxof(leftAns.maxSum,maxof(rightAns.maxSum,leftAns.suffix_Max+rightAns.prefix_max));
       node.prefix_max=leftAns.prefix_max;
       node.suffix_Max=rightAns.suffix_Max;
        return node;

    }
    public static int prefixSum(int[] arr, int start, int end) {
        int globalmax=Integer.MIN_VALUE;
        int localmax=0;
        int n=arr.length;
        for (int i=start;i<=end;i++){
            localmax+=arr[i];
            globalmax=maxof(localmax,globalmax);
        }
        return globalmax;
    }
    public static int suffixSum(int[] arr, int start, int end) {
        int globalmax=Integer.MIN_VALUE;
        int localmax=0;
        int n=arr.length;
        for (int i=end;i>=start;i--){
            localmax+=arr[i];
            globalmax=maxof(localmax,globalmax);
        }
        return globalmax;
    }

    public static int maxof(int a, int b) {
        return (a>b)?a:b;
    }
    static final class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
*/















