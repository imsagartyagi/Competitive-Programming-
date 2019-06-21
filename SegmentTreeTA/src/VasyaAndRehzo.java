import javax.print.attribute.standard.MediaSize;
import java.util.Scanner;

public class VasyaAndRehzo {
    static class node{
        int a;
        int b;
        int indx;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        node[] arr=new node[n];
        for (int i=0;i<n;i++){
            arr[i]=new node();
            arr[i].a=scanner.nextInt();
            arr[i].indx=i;
        }
        for (int i=0;i<n;i++){
            arr[i].b=scanner.nextInt();
        }
        node[] tree=new node[3*n];
        for (int i=0;i<3*n;i++){
            tree[i]=new node();
        }
        buildTree(arr,tree,0,n-1,1);
        int q=scanner.nextInt();
        StringBuilder builder =new StringBuilder();
        for (int i=0;i<q;i++){
            int l=scanner.nextInt();
            int r=scanner.nextInt();
            node ans=query(tree,0,n-1,l-1,r-1,1);
            builder.append(ans.indx+1).append("\n");
        }
        System.out.println(builder);
    }

    private static node query(node[] tree, int start, int end, int left, int right, int treenode) {


        int mid=(start+end)/2;
        if (start>right||end<left){
            node temp=new node();
            temp.a=Integer.MIN_VALUE;
            temp.b=Integer.MAX_VALUE;
            temp.indx=Integer.MAX_VALUE;
            return temp;
        }
        else if (start>=left&&end<=right){
            return tree[treenode];
        }
        node ans=new node();
        node leftnode=query(tree, start, mid, left, right, 2*treenode);
        node rightnode=query(tree, mid+1, end, left, right, 2*treenode+1);
        if (leftnode.a>rightnode.a){
            ans.a=leftnode.a;
            ans.b=leftnode.b;
            ans.indx=leftnode.indx;
        }
        else if (leftnode.a<rightnode.a){
            ans.a=rightnode.a;
            ans.b=rightnode.b;
            ans.indx=rightnode.indx;
        }
        else if (leftnode.a==rightnode.a){
            if (leftnode.b<rightnode.b){
               ans.a=leftnode.a;
                ans.b=leftnode.b;
                ans.indx=leftnode.indx;
            }
            else  if (leftnode.b>rightnode.b){
                ans.a=rightnode.a;
                ans.b=rightnode.b;
                ans.indx=rightnode.indx;
            }
            else  if (leftnode.b==rightnode.b){
                if (leftnode.indx<rightnode.indx){
                    ans.a=leftnode.a;
                    ans.b=leftnode.b;
                    ans.indx=leftnode.indx;
                }
                else  if (leftnode.indx>rightnode.indx){
                   ans.a=rightnode.a;
                    ans.b=rightnode.b;
                   ans.indx=rightnode.indx;
                }
            }
        }
        return ans;
    }

    public static void buildTree(node[] arr, node[] tree, int start, int end, int treenode) {

        if (start==end){
            tree[treenode].a=arr[start].a;
            tree[treenode].b=arr[start].b;
            tree[treenode].indx=arr[start].indx;
            return;
        }
        int mid=(start+end)/2;
        buildTree(arr, tree, start, mid, 2*treenode);
        buildTree(arr, tree, mid+1, end, 2*treenode+1);
        if (tree[treenode*2].a>tree[2*treenode+1].a){
            tree[treenode].a=tree[treenode*2].a;
            tree[treenode].b=tree[treenode*2].b;
            tree[treenode].indx=tree[treenode*2].indx;
        }
        else if (tree[treenode*2].a<tree[2*treenode+1].a){
            tree[treenode].a=tree[treenode*2+1].a;
            tree[treenode].b=tree[treenode*2+1].b;
            tree[treenode].indx=tree[treenode*2+1].indx;
        }
        else if (tree[treenode*2].a==tree[2*treenode+1].a){
            if (tree[treenode*2].b<tree[2*treenode+1].b){
                tree[treenode].a=tree[treenode*2].a;
                tree[treenode].b=tree[treenode*2].b;
                tree[treenode].indx=tree[treenode*2].indx;
            }
            else  if (tree[treenode*2].b>tree[2*treenode+1].b){
                tree[treenode].a=tree[treenode*2+1].a;
                tree[treenode].b=tree[treenode*2+1].b;
                tree[treenode].indx=tree[treenode*2+1].indx;
            }
            else  if (tree[treenode*2].b==tree[2*treenode+1].b){
                if (tree[treenode*2].indx<tree[2*treenode+1].indx){
                    tree[treenode].a=tree[treenode*2].a;
                    tree[treenode].b=tree[treenode*2].b;
                    tree[treenode].indx=tree[treenode*2].indx;
                }
                else  if (tree[treenode*2].indx>tree[2*treenode+1].indx){
                    tree[treenode].a=tree[treenode*2+1].a;
                    tree[treenode].b=tree[treenode*2+1].b;
                    tree[treenode].indx=tree[treenode*2+1].indx;
                }
            }
        }
    }
}
