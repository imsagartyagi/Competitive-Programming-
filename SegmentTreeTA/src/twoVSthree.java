import java.util.Scanner;

public class twoVSthree {
    static class node {
        int ans;
        int length;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        String str=scanner.next();
        char[] arr=str.toCharArray();
        node[] tree=new node[4*n];
        for (int i=0;i<4*n;i++){
            tree[i]=new node();
        }
        buildTree(arr,tree,0,n-1,1);
        int q=scanner.nextInt();
        for (int i=0;i<q;i++){
            int x=scanner.nextInt();
            if (x==0){
                int a=scanner.nextInt();
                int b=scanner.nextInt();
                node ans=query(tree,0,n-1,a,b,1);
                System.out.println(ans.ans);
            }
            else {
                int indx=scanner.nextInt();
                update(arr,tree,0,n-1,indx,1);
            }

        }
    }

    private static void update(char[] arr, node[] tree, int start, int end,int indx, int treenode) {
        if (start==end){
            if (start==indx){
                if (arr[indx]=='0'){
                    arr[indx]='1';
                    tree[treenode].ans=1;
                    tree[treenode].length=1;
                }
            }
            return;
        }
        int mid=(start+end)/2;
        if (indx>mid){
            update(arr, tree, mid+1, end, indx, 2*treenode+1);
        }
        else {
            update(arr, tree, start, mid, indx, 2*treenode);
        }
        tree[treenode].length=tree[2*treenode].length+tree[2*treenode+1].length;
        node leftans=tree[treenode*2];
        node rightans=tree[(treenode*2)+1];
        tree[treenode].ans=(((leftans.ans*modularExponentiation(2,rightans.length,3))%3)+rightans.ans)%3;
    }


    public static node query(node[] tree, int start, int end, int left, int right, int treenode) {

        int mid=(start+end)/2;
        if (start>right||end<left){
            node temp=new node();
            temp.ans=0;
            temp.length=0;
            return temp;
        }
        else if (start>=left&&end<=right){
            return tree[treenode];
        }
        node Ans=new node();
        node leftans=query(tree, start, mid, left, right, 2*treenode);
        node rightans=query(tree,mid+1,end,left,right,2*treenode+1);
        Ans.length=leftans.length+rightans.length;
        Ans.ans=(((leftans.ans*modularExponentiation(2,rightans.length,3))%3)+rightans.ans)%3;
        return Ans;
    }

    private static void buildTree(char[] arr, node[] tree, int start, int end, int treenode) {
        if (start==end){
            tree[treenode].ans=(arr[start]=='1')?1:0;
            tree[treenode].length=1;
            return;
        }
        int mid=(start+end)/2;
        buildTree(arr, tree, start, mid, 2*treenode);
        buildTree(arr, tree, mid+1, end, 2*treenode+1);
        tree[treenode].length=tree[2*treenode].length+tree[2*treenode+1].length;
        node leftans=tree[treenode*2];
        node rightans=tree[(treenode*2)+1];
        tree[treenode].ans=(((leftans.ans*modularExponentiation(2,rightans.length,3))%3)+rightans.ans)%3;
    }

    private static int modularExponentiation(int a, int b, int mod) {
        if (b==0){
            return 1;
        }
        if (b%2==0){
            return modularExponentiation(((a%mod)*(a%mod))%mod,b/2,mod);
        }
        return (a%mod*modularExponentiation(((a%mod)*(a%mod))%mod,b/2,mod))%mod;
    }
}
