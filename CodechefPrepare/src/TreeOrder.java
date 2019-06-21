import java.util.Scanner;

public class TreeOrder {
    // Incomplete Do It If You can
    static int i=1;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[] tree=new int[n+1];
        int[] preOrder=new int[n+1];
        int[] postOrder=new int[n+1];
        int[] InOrder=new int[n+1];
        for (int i=1;i<=n;i++){
            preOrder[i]=in.nextInt();
        }
        fillTree(tree,preOrder,1);
        i=1;
        fillInOrder(tree,InOrder,1);

    }

    private static void fillInOrder(int[] tree, int[] InOrder, int treenode) {
        if (treenode>tree.length||i>=tree.length-1){
            return;
        }
        fillInOrder(tree, InOrder, 2*treenode);
        InOrder[i++]=tree[treenode];
        fillInOrder(tree, InOrder, 2*treenode+1);
    }

    public static void fillTree(int[] tree, int[] preOrder,int treenode) {
        if (treenode>tree.length||i>=tree.length){
            return;
        }
        tree[treenode]=preOrder[i++];
        fillTree(tree, preOrder, 2*treenode);
        fillTree(tree, preOrder, 2*treenode+1);
    }
}
