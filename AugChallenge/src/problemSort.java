import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class node implements Comparator<node> {
    int a;
    int b;

    @Override
    public int compare(node o1, node o2) {
        if (o1.a!=o2.a){
            return o1.a-o2.a;
        }
        return o1.b-o2.b;
    }
}
public class problemSort {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StringBuilder builder=new StringBuilder();
        int P=scanner.nextInt();
        int S=scanner.nextInt();
        node[] ans=new node[P];
        for (int i=0;i<P;i++){
            ans[i]=new node();
            node[] arr=new node[S];
            for (int j=0;j<S;j++){
                arr[j]=new node();
                arr[j].a=scanner.nextInt();
            }
            for (int j=0;j<S;j++){
                arr[j].b=scanner.nextInt();
            }
            Arrays.sort(arr,new node());
            int[] temp=new int[S];
            for (int k=0;k<S;k++){
                temp[k]=arr[k].b;
            }
            int diff=mergeSort(temp,S);
            ans[i].a=diff;
            ans[i].b=i+1;
        }
        Arrays.sort(ans,new node());
        for (int i=0;i<P;i++){
            builder.append(ans[i].b+"\n");
        }
        System.out.println(builder);
    }

    private static int mergeSort(int[] temp, int s) {
        int count=0;
        for(int i=1;i<s;i++){
             if (temp[i-1]>temp[i]){
                 count++;
             }
        }
        return count;
    }

}
