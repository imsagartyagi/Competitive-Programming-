import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class GSS3 {
    static class node{
        int pS;
        int sS;
        int tS;
        int mSS;
    }
    static final int Min=-10500;
    public static void main(String[] args) throws IOException {
        Reader5 in=new Reader5();
        int n=in.nextInt();
        int[] arr=new int[n];
        node[] tree=new node[4*n];
        for (int i = 0; i < 4 * n; i++) {
            tree[i]=new node();
        }
        for (int i = 0; i < n; i++) {
            arr[i]=in.nextInt();
        }
        buildTree(tree,arr,0,n-1,1);
        int q=in.nextInt();
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < q; i++) {
            int x=in.nextInt();
            int a=in.nextInt();
            int b=in.nextInt();
            if (x==0){
                updateTree(tree,arr,0,n-1,a-1,b,1);
            }
            else builder.append(queryTree(tree,a-1,b-1,0,n-1,1).mSS).append("\n");
        }
        System.out.println(builder);
    }
    public static node queryTree(node[] tree, int left, int right, int start, int end, int treenode) {
        if (start>right||end<left){
            node temp=new node();
            temp.mSS=Min;
            temp.pS=Min;
            temp.sS=Min;
            temp.tS=Min;
            return temp;
        }
        if (start>=left&&end<=right){
            return tree[treenode];
        }
        int mid=(start+end)/2;
        node op1=queryTree(tree, left, right, start, mid, 2*treenode);
        node op2=queryTree(tree, left, right, mid+1, end, 2*treenode+1);
        return mergeNode(op1,op2);
    }
    private static void updateTree(node[] tree, int[] arr, int start, int end, int indx, int val,int treenode) {
        if (start==end){
            tree[treenode].mSS=arr[start]=val;
            tree[treenode].pS=arr[start]=val;
            tree[treenode].sS=arr[start]=val;
            tree[treenode].tS=arr[start]=val;
            return;
        }
        int mid=(start+end)/2;
        if (indx>mid){
            updateTree(tree, arr, mid+1, end, indx, val,2*treenode+1);
        }
        else if (indx<=mid){
            updateTree(tree, arr, start, mid, indx, val, 2*treenode);
        }
       tree[treenode]=mergeNode(tree[2*treenode],tree[treenode*2+1]);
    }
    public static void buildTree(node[] tree, int[] arr, int start, int end, int treenode) {
        if (start==end){
            tree[treenode].mSS=arr[start];
            tree[treenode].pS=arr[start];
            tree[treenode].sS=arr[start];
            tree[treenode].tS=arr[start];
            return;
        }
        int mid=(start+end)/2;
        buildTree(tree, arr, start, mid, 2*treenode);
        buildTree(tree, arr, mid+1, end, 2*treenode+1);
        tree[treenode]=mergeNode(tree[2*treenode],tree[2*treenode+1]);
    }
    public static node mergeNode(node left, node right) {
        node temp=new node();
        temp.mSS=Math.max(left.mSS,Math.max(right.mSS,Math.max(left.sS+right.pS,Math.max(left.tS+right.pS,right.tS+left.sS))));
        temp.pS=Math.max(left.pS,left.tS+right.pS);
        temp.sS=Math.max(right.sS,right.tS+left.sS);
        temp.tS=left.tS+right.tS;
        return temp;
    }
}
class Reader5
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader5()
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
