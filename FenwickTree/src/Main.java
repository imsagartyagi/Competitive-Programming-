import java.util.*;

public class Main {

   public static int[] lastindex=new int[1000001];
    public static class event implements Comparator<event>{
        int first,second,index;

        @Override
        public int compare(event object1, event object2) {
           return object1.second-object2.second;
        }
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StringBuilder builder=new StringBuilder();
        int n=scanner.nextInt();
        int[] arr=new int[n+1];
        int[] BIT=new int[n+1];
        for (int i=1;i<=n;i++){
            arr[i]=scanner.nextInt();
        }
        int q=scanner.nextInt();
        event[] queries=new event[q];
        for (int i=0;i<q;i++){
            queries[i]=new event();
            queries[i].first=scanner.nextInt();
            queries[i].second=scanner.nextInt();
            queries[i].index=i;
        }
        Arrays.sort(queries,new event());
        for (int i=0;i<q;i++){
            System.out.println(queries[i].first+" "+queries[i].second);
        }
        Arrays.fill(lastindex,-1);
        int total=0;
        int k=0;
        int[] ans=new int[q];
        for (int i=1;i<=n;i++){
            if (lastindex[arr[i]]!=-1){
                update_BIT(lastindex[arr[i]],-1,BIT);
            }
            else {
                total++;
            }
            update_BIT(i,1,BIT);
            lastindex[arr[i]]=i;
            while(k<q&&queries[k].second==i){
                ans[queries[k].index]=total-query_BIT(queries[k].first-1,BIT);
                k++;
            }
        }
        for (int i=0;i<q;i++){
            builder.append(ans[i]).append("\n");
        }
        System.out.println(builder);
    }









    public static void update_BIT(int index, int value, int[] binaryIndexedTree) {
        int n=binaryIndexedTree.length-1;
        for (;index<=n;index+=index&(-index)){
            binaryIndexedTree[index]+=value;
        }
    }
    public static int query_BIT(int upto,int[] binaryIndexedTree){
        int sum=0;
        for (;upto>0;upto-=upto&(-upto)){
            sum+=binaryIndexedTree[upto];
        }
        return sum;
    }
}
