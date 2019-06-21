import java.util.Queue;

public class BinarySearchTree {


    public Node GenerateNode(int data){
        Node temp=new Node();
        temp.data=data;
        temp.left=null;
        temp.right=null;
        return temp;
    }
    public Node insertItem(Node root,int data){
        if(root==null){
            root=GenerateNode(data);
        }
        else if(root.data>=data){
           root.left=insertItem(root.left,data);
        }
        else if(root.data<data){
            root.right=insertItem(root.right,data);
        }
        return root;
    }
    public boolean searchItem(Node root,int item){
       if(root==null){
           return false;
       }
       else if (root.data==item){
           return true;
       }
       else if (item<=root.data){
          return searchItem(root.left,item);
       }
       else return searchItem(root.right,item);
    }
    public int maxElement(Node root) {
        if (root.right == null) {
            return root.data;
        }
        return maxElement(root.right);
    }
    public int minElement(Node root){
        if(root.left==null){
            return root.data;
        }
        return minElement(root.left);
    }
    public int heightofTree(Node root){
        if (root==null){
            return -1;
        }
        int hleft=heightofTree(root.left);
        int hright=heightofTree(root.right);
        return max(hleft,hright)+1;
    }
    public int max(int a,int b){
        return a>b?a:b;
    }
    public void InOrderTRaversal(Node root){
        if (root==null) return;
        InOrderTRaversal(root.left);
        System.out.println(root.data);
        InOrderTRaversal(root.right);
    }
    public void preOrderTraversal(Node root){
        if (root==null) return;
        System.out.println(root.data);
        InOrderTRaversal(root.left);
        InOrderTRaversal(root.right);
    }
    public Node deleteNode(Node root,int item){
        if(root==null){
            return root;
        }
        if (item<root.data){
            root.left=deleteNode(root.left, item);
        }
        else if (item>root.data){
            root.right=deleteNode(root.right,item);
        }
        else{
            if(root.right==null&&root.left==null){
                root=null;

            }
            else if (root.right==null){
                root=root.left;

            }
            else if (root.left==null){
                root=root.right;
            }
            else{
                root.data=minElement(root.right);
                root.right=deleteNode(root.right,root.data);
            }

        }
        return root;
    }
    public int sizeOfTree(Node root){
        if(root==null) return 0;
        return sizeOfTree(root.left)+sizeOfTree(root.right)+1;
    }

    class Node{
        int data;
        Node left;
        Node right;
    }
}
