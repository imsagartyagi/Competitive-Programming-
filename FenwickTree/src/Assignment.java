import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.*;

public class Assignment {
   public static int[] BIT=new int[30002];
    public static class event implements Comparator<event>{
        int left;
        int right;
        long value;
        int index;
        @Override
        public int compare(event o1, event o2) {
            if (o1.value==o2.value){
               return o2.left-o1.left;
            }
            else {
                return (int) (o2.value-o1.value);
            }
        }
    }
    public static void main(String[] args) {
       Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n+1];
        ArrayList<event> eventArrayList=new ArrayList<event>();
        for (int i=1;i<=n;i++){
            arr[i]=scanner.nextInt();
            event temp=new event();
            temp.left=0;
            temp.right=i;
            temp.value=arr[i];
            temp.index=0;
            eventArrayList.add(temp);
        }
        int q=scanner.nextInt();
        for (int i=0;i<q;i++){
            event temp=new event();
            temp.left=scanner.nextInt();
            temp.right=scanner.nextInt();
            temp.value=scanner.nextInt();
            temp.index=i+1;
            eventArrayList.add(temp);
        }
        Collections.sort(eventArrayList,new event());
        StringBuilder builder=new StringBuilder();
        int[] ans=new int[q+1];
        for (int i=0;i<eventArrayList.size();i++){
           // System.out.println(eventArrayList.get(i).index+" "+eventArrayList.get(i).left+" "+eventArrayList.get(i).right+" "+eventArrayList.get(i).value);
              if (eventArrayList.get(i).left!=0){
                ans[eventArrayList.get(i).index]=(queryBIT(eventArrayList.get(i).right)-queryBIT(eventArrayList.get(i).left-1));
            }
             else if (eventArrayList.get(i).left==0){
                updateBIT(eventArrayList.get(i).right);
            }
        }
       for (int i=1;i<=q;i++){
           builder.append(ans[i]).append("\n");
       }
        System.out.println(builder);
    }

    private static int queryBIT(int right) {
        int ans=0;
        for (;right>0;right-=right&(-right)){
            ans+=BIT[right];
        }
        return ans;
    }

    public static void updateBIT(int right) {
        for (;right<=30001;right+=right&(-right)){
            BIT[right]++;
        }
    }
}
