public class Queue {
    private int[] queue;
    private int size;
    private int total;
    private int front;
    private int rear;
    public Queue(){
        size=100;
        front=0;
        rear=0;
        total=0;
        queue=new int[size];
    }
    public Queue(int size){
        this.size=size;
        front=0;
        rear=0;
        total=0;
        queue=new int[this.size];
    }
    public boolean enqueue(int item){
        if (isFull()){
            return false;
        }
        else
        {
            total++;
            queue[rear]=item;
            rear++;
            return true;
        }

    }
    public int dequeue(){
        total--;
        return queue[front++];

    }
    public boolean isEmpty(){
        return (total==0);
    }
    public boolean isFull(){
        if (total==size){
            return true;
        }
        else return false;
    }
}
