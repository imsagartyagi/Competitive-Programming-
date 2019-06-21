import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main3 {
   public static int[] BIT=new int[100001];
    public static class coder implements Comparator<coder> {
        int x,y,index;

        @Override
        public int compare(coder object1, coder object2) {
              if(object1.x-object2.x==0){
                return object1.y-object2.y;
            }
           else
            return object1.x-object2.x;

        }
    }
    public static void main(String[] args) {
       Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        coder[] arr=new coder[n];
        for (int i=0;i<n;i++){
            arr[i]=new coder();
            arr[i].x=scanner.nextInt();
            arr[i].y=scanner.nextInt();
            arr[i].index=i;
        }
        Arrays.sort(arr,new coder());
        coderRating(arr,n);
    }
      public static void coderRating(coder[] arr,int n){
        int[] ans=new int[n];
        StringBuilder builder=new StringBuilder();
         for (int i=0;i<n;){
             int endIndex=i;
             while (endIndex<n&& arr[endIndex].x==arr[i].x&&arr[endIndex].y==arr[i].y){
                 endIndex++;
             }
             for (int j=i;j<endIndex;j++) {
                 ans[arr[j].index] = queryBIT_coderRating(arr[j].y);
             }
             for (int j=i;j<endIndex;j++) {
                 updateBIT_coderRating(arr[j].y);
             }
             i=endIndex;
         }
         for (int i=0;i<n;i++){
             builder.append(ans[i]).append("\n");
         }
          System.out.println(builder);
     }
    private static void updateBIT_coderRating(int y) {
           for (;y<=100000;y+=y&(-y)){
               BIT[y]++;
           }
    }
    private static int queryBIT_coderRating(int y) {
          int ans=0;
          for (;y>0;y-=y&(-y)){
              ans+=BIT[y];
          }
          return ans;
    }
    public static int gcd(int a,int b){
        if (b>a){
            return gcd(b,a);
        }
        if (b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public static void segmetTree_Queries_Gcd(int[] arr,int[] li,int[] ri){
        StringBuilder buider=new StringBuilder();
        int n=arr.length;
        int[] tree=new int[4*n];
           buildTree_gcdQueries(arr,tree,0,n-1,1);
           for (int i=0;i<li.length;i++){
               buider.append(query_segment_tree_gcd(tree,0,n-1,1,li[i]-1,ri[i]-1)).append("\n");
           }
        System.out.println(buider);
    }
    public static int query_segment_tree_gcd(int[] tree, int start, int end, int treenode,int left, int right) {
        if (left>end||right<start){
            return 0;
        }
        else if (start>=left&&end<=right){
            return tree[treenode];
        }
        else
        {
            int mid=(start+end)/2;
           return gcd(query_segment_tree_gcd(tree,start,mid,2*treenode,left,right),query_segment_tree_gcd(tree, mid+1, end, (2*treenode)+1, left, right));
        }
    }
    public static void buildTree_gcdQueries(int[] arr, int[] tree, int start, int end, int treenode) {
        if (start==end){
            tree[treenode]=arr[start];
            return;
        }
        int mid=(start+end)/2;
        buildTree_gcdQueries(arr,tree,start,mid,2*treenode);
        buildTree_gcdQueries(arr,tree,mid+1,end,2*treenode+1);
        tree[treenode]=gcd(tree[2*treenode],tree[(2*treenode)+1]);
    }
    private static int query_BIT(int upto,int[] BIT) {
        int gcd=0;
        for (;upto>0;upto-=upto&(-upto)){
            gcd=gcd(BIT[upto],gcd);
        }
        return gcd;
    }
    private static void update_BIT(int index, int value, int[] BIT,int n) {
        for (;index<=n;index+=index&(-index)){
            BIT[index]=gcd(value,BIT[index]);
        }
    }

}
