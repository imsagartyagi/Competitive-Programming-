import java.io.*;

public class GSS1{
    static class node{
        long sum;
        long prefixSum;
        long suffixSum;
        long maxSum;
    }
    static long Const_Min=-16000;
    public static void main(String[] args) throws IOException {
        Reader1 scanner =new Reader1();
        int n=scanner.nextInt();
        int[] arr=new int [n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        node[] tree=new node[4*n];
        for (int i=0;i<4*n;i++){
            tree[i]=new node();
        }
        StringBuilder builder=new StringBuilder();
        buildTree(arr,tree,0,n-1,1);
        int q=scanner.nextInt();
        for (int i=0;i<q;i++){
            int l=scanner.nextInt();
            int r=scanner.nextInt();
            node ans=query(tree,0,n-1,l-1,r-1,1);
            builder.append(ans.maxSum).append("\n");
        }
        System.out.println(builder);
    }

    private static node query(node[] tree, int start, int end, int left, int right, int treenode) {

        int mid=(start+end)/2;
        if (start>right||end<left){
            node temp=new node();
            temp.maxSum=Const_Min;
            temp.suffixSum=Const_Min;
            temp.sum=Const_Min;
            temp.prefixSum=Const_Min;
            return temp;
        }
        else if (start>=left&&end<=right){
            return tree[treenode];
        }
        node ans=new node();
        node leftnode=query(tree, start, mid, left, right, 2*treenode);
        node rightnode=query(tree, mid+1, end, left, right, 2*treenode+1);
        ans.prefixSum= Math.max(leftnode.prefixSum,leftnode.sum+rightnode.prefixSum);
        ans.sum=leftnode.sum+rightnode.sum;;
        ans.suffixSum=Math.max(rightnode.suffixSum,rightnode.sum+leftnode.suffixSum);
        ans.maxSum=Math.max(leftnode.maxSum,Math.max(rightnode.maxSum,Math.max(leftnode.sum+rightnode.prefixSum,Math.max(rightnode.sum+leftnode.suffixSum,
                leftnode.suffixSum+rightnode.prefixSum))));
        return ans;
    }

    private static void buildTree(int[] arr, node[] tree, int start, int end, int treenode) {
        if (start==end){
            tree[treenode].sum=arr[start];
            tree[treenode].prefixSum=arr[start];
            tree[treenode].suffixSum=arr[start];
            tree[treenode].maxSum=arr[start];
            return;
        }
        int mid=(start+end)/2;
        buildTree(arr,tree,start,mid,2*treenode);
        buildTree(arr,tree,mid+1,end,2*treenode+1);
        fillTree(tree,tree[treenode*2],tree[treenode*2+1],treenode);
    }
    private static void fillTree(node[] tree, node leftnode,node rightnode,int treenode) {
        tree[treenode].sum=leftnode.sum+rightnode.sum;
        tree[treenode].prefixSum=Math.max(leftnode.prefixSum,leftnode.sum+rightnode.prefixSum);
        tree[treenode].suffixSum=Math.max(rightnode.suffixSum,rightnode.sum+leftnode.suffixSum);
        tree[treenode].maxSum=Math.max(leftnode.maxSum,Math.max(rightnode.maxSum,Math.max(leftnode.sum+rightnode.prefixSum,Math.max(rightnode.sum+leftnode.suffixSum,
                leftnode.suffixSum+rightnode.prefixSum))));
    }
}
class Reader1
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader1()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public int nextInt() throws IOException
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do
        {
            ret = ret * 10 + c - '0';
        }  while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException
    {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException
    {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }
}
 