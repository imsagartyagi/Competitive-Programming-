public class Main {
    public static void main(String[] args) {
    BinarySearchTree tree=new BinarySearchTree();
       BinarySearchTree.Node root=null;
       root=tree.insertItem(root,3);
       root=tree.insertItem(root,1);
       root=tree.insertItem(root,2);
        System.out.println(tree.sizeOfTree(root));
        tree.sumtree(root);
        tree.preOrderTraversal(root);
    }
}
