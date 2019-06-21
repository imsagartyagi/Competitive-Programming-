public class LinkedList {
    private Node head;

    public LinkedList(int item){
        head=new Node();
        head.data=item;
        head.next=null;
    }
    public boolean insert_item_beg(int item){
        Node nodeToBeInserted=new Node();
        nodeToBeInserted.data=item;
        nodeToBeInserted.next=head;
        head=nodeToBeInserted;
        return true;
    }
    public boolean insert_item_end(int item){
       Node nodeToBeInserted=new Node();
       nodeToBeInserted.data=item;
       nodeToBeInserted.next=null;
       Node temp=head;
       while (temp.next!=null){
           temp=temp.next;
       }
       temp.next=nodeToBeInserted;
       return true;
    }
    public boolean delete_item(int item){
        if(head.data!=item){
            Node temp = head;
            while (temp.next.data != item) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            return true;
        }
        else head=head.next;
        return true;
    }
    public void sortList(){
        int c=0;
        Node i=head;
        while(i.next!=null){
            Node j=head;
            while(j.next!=null){
                if(j.data>j.next.data){
                    c=j.data;
                    j.data=j.next.data;
                    j.next.data=c;
                }
                j=j.next;
            }
            i=i.next;
        }

    }
    public void reversing_list(){
        Node current=head;
        Node prev=null;
        Node next;
        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        head=prev;
    }
    public void letLastBeFirst(){
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        int data=temp.next.data;
        temp.next=null;
        insert_item_beg(data);
    }
    public Node middle(Node head){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public Node mergesort(Node Head){
        if(Head==null||Head.next==null){
            return Head;
        }
      Node middle=middle(Head);
      Node nextList=middle.next;
      return merge(mergesort(Head),mergesort(nextList));
    }
    public Node merge(Node head1,Node head2){
        Node temp1=head1;
        Node temp2=head2;
        Node Head=null;
        while(temp1!=null&&temp2!=null){
            if(temp1.data>=temp2.data){
                Node temp=new Node();
                temp.data=temp1.data;
                temp=Head;
                Head=temp;
                temp1=temp1.next;
            }
            if(temp1.data<temp2.data){
                Node temp=new Node();
                temp.data=temp2.data;
                temp=Head;
                Head=temp;
                temp2=temp2.next;
            }
            while(temp1!=null){
                Node temp=new Node();
                temp.data=temp1.data;
                temp=Head;
                Head=temp;
                temp1=temp1.next;
            }
            while(temp2!=null){
                Node temp=new Node();
                temp.data=temp2.data;
                temp=Head;
                Head=temp;
                temp2=temp2.next;
            }
        }
        return Head;
    }
    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    class Node{
        int data;
        Node next;
    }
}
