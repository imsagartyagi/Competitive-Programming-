/*


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringBuilder builder=new StringBuilder();
       Scanner scanner=new Scanner(System.in);
          int n=scanner.nextInt();
          int[] arr=new int[n];
          for (int i=0;i<n;i++){
              arr[i]=scanner.nextInt();
          }
          int Q=scanner.nextInt();
          int[] li=new int[Q];
          int[] ri=new int[Q];
          for (int i=0;i<Q;i++){
              li[i]=scanner.nextInt();
              ri[i]=scanner.nextInt();
          }
          node[] tree=new node[4*n];
          for(int i=0;i<3*n;i++){
              tree[i]=new node();
          }
          build_Mx_sumInSubArray_Segment_tree(arr,tree,0,n-1,1);
          for (int i=0;i<Q;i++){
              builder.append(maxSuminSubArrayQuery(tree,1,0,n-1,li[i]-1,ri[i]-1).maxSum).append("\n");
          }
        System.out.println(builder);
    }


    // maximum sum in subarray query
    public static class node{
        int maxSum;
        int sum;
        int bpsum;
        int bssum;
    }
      public static node maxSuminSubArrayQuery(node[] tree,int treenode,int start,int end,int left,int right){
        if (left>end||right<start){
            node temp=new node();
            temp.maxSum=Integer.MIN_VALUE;
            temp.sum=Integer.MIN_VALUE;
            temp.bpsum=Integer.MIN_VALUE;
            temp.bssum=Integer.MIN_VALUE;
            return temp;

        }
        else if (start>=left&&end<=right){
            node temp=new node();
            temp.maxSum=tree[treenode].maxSum;
            temp.sum=tree[treenode].sum;
            temp.bpsum=tree[treenode].bpsum;
            temp.bssum=tree[treenode].bssum;
            return temp;
        }
        else{
            node temp=new node();
            int mid=(start+end)/2;
            int leftMax=maxSuminSubArrayQuery(tree,2*treenode,start,mid,left,right).maxSum;
            int rightMax=maxSuminSubArrayQuery(tree,(2*treenode)+1,mid+1,end,left,right).maxSum;
            int leftBpsum=maxSuminSubArrayQuery(tree,2*treenode,start,mid,left,right).bpsum;
            int rightBpsum=maxSuminSubArrayQuery(tree,(2*treenode)+1,mid+1,end,left,right).bpsum;
            int leftBssum=maxSuminSubArrayQuery(tree,(2*treenode),start,mid,left,right).bssum;
            int rightBssum=maxSuminSubArrayQuery(tree,2*treenode+1,mid+1,end,left,right).bssum;
            int leftSum=maxSuminSubArrayQuery(tree,2*treenode,start,mid,left,right).sum;
            int rightSum=maxSuminSubArrayQuery(tree,2*treenode+1,mid+1,end,left,right).sum;
            temp.maxSum=maxof(leftMax,maxof(rightMax,maxof(leftSum+rightBpsum,maxof(rightSum+leftBssum,maxof(leftSum+rightSum,leftBssum+rightBpsum)))));
            temp.sum=leftSum+rightSum;
            temp.bpsum=maxof(leftBpsum,leftSum+rightBpsum);
            temp.bssum=maxof(rightBssum,rightSum+leftBssum);
            return temp;
        }
     }
      public static void build_Mx_sumInSubArray_Segment_tree(int[] arr,node[] tree,int start,int end,int treenode){
        if (start==end){
            tree[treenode].maxSum=arr[start];
            tree[treenode].sum=arr[start];
            tree[treenode].bpsum=arr[start];
            tree[treenode].bssum=arr[start];
            return;
        }
        int mid=(start+end)/2;
        build_Mx_sumInSubArray_Segment_tree(arr,tree,start,mid,2*treenode);
        build_Mx_sumInSubArray_Segment_tree(arr,tree,mid+1,end,(2*treenode)+1);
        int leftMax=tree[2*treenode].maxSum; int rightMax=tree[(2*treenode)+1].maxSum;
        int leftBpsum=bestPrefixSum(arr,start,mid); int rightBpsum=bestPrefixSum(arr,mid+1,end);
        int leftBssum=bestSuffixSum(arr,start,mid); int rightBssum=bestSuffixSum(arr,mid+1,end);
        int leftSum=justSum(arr,start,mid);  int rightSum=justSum(arr,mid+1,end);
        tree[treenode].maxSum=maxof(leftMax,maxof(rightMax,maxof(leftSum+rightBpsum,maxof(rightSum+leftBssum,maxof(leftSum+rightSum,leftBssum+rightBpsum)))));
        tree[treenode].sum=leftSum+rightSum;
        tree[treenode].bpsum=maxof(leftBpsum,leftSum+rightBpsum);
        tree[treenode].bssum=maxof(rightBssum,rightSum+leftBssum);
      }
      public static int justSum(int[] arr, int start, int end) {
       int sum=0;
       for (int i=start;i<=end;i++){
           sum+=arr[i];
       }
       return sum;
    }
      public static int bestSuffixSum(int[] arr, int start, int end) {
          int sum=0;
          int totalSum=0;
          for (int i=start;i<=end;i++){
              sum+=arr[i];
              if (sum>=totalSum){
                  totalSum=sum;
              }
          }
          return totalSum;
    }
      public static int bestPrefixSum(int[] arr, int start, int end) {
        int sum=0;
        int totalSum=0;
        for (int i=end;i>=start;i--){
            sum+=arr[i];
            if (sum>=totalSum){
                totalSum=sum;
            }
        }
        return totalSum;
    }


    //max Pair sum
    public static class nodalTree{
        int maximum;
        int secondmaximum;
   }
    public static void maxPairSum(int[] arr,nodalTree[] tree,String[] qi,int[] li,int[] ri){
        StringBuilder builder=new StringBuilder();
        int n=arr.length;
        builtmaxPairSegmentTree(arr,tree,0,n-1,1);
        for (int i=0;i<qi.length;i++){
            if (qi[i].equals("U")){
               updateSegmentTree_MaxPairSum(arr,tree,0,n-1,1,li[i]-1,ri[i]);
            }
            else if (qi[i].equals("Q")){
                int q1=QuerySegmentTree_MaxPairSum(tree,0,n-1,1,li[i]-1,ri[i]-1).maximum;
                int q2=QuerySegmentTree_MaxPairSum(tree,0,n-1,1,li[i]-1,ri[i]-1).secondmaximum;
                int ans=QuerySegmentTree_MaxPairSum(tree,0,n-1,1,li[i]-1,ri[i]-1).maximum+QuerySegmentTree_MaxPairSum(tree,0,n-1,1,li[i]-1,ri[i]-1).secondmaximum;
                builder.append(ans).append("\n");
            }
        }
        System.out.println(builder);
    }
    public static nodalTree QuerySegmentTree_MaxPairSum(nodalTree[] tree,int start,int end,int treenode,int left,int right){
       if (start>right||end<left){
           nodalTree node = new nodalTree();
           node.maximum=0;
           node.secondmaximum=0;
           return node;
       }
       else if (start>=left&&end<=right){
           nodalTree node=new nodalTree();
           node.maximum=tree[treenode].maximum;
           node.secondmaximum=tree[treenode].secondmaximum;
           return node;
       }
       int mid=(start+end)/2;
       nodalTree node=new nodalTree();
       nodalTree leftans=QuerySegmentTree_MaxPairSum(tree,start,mid,2*treenode,left,right);
       nodalTree rightans=QuerySegmentTree_MaxPairSum(tree,mid+1,end,2*treenode+1,left,right);
       int leftMAx=leftans.maximum; int rightMAx=rightans.maximum; int leftSecondMax=leftans.secondmaximum; int rightSecondMax=rightans.secondmaximum;
       node.maximum=maxof(leftMAx,rightMAx);
       node.secondmaximum=minof(maxof(leftMAx,rightSecondMax),maxof(leftSecondMax,rightMAx));
       return node;
    }
    public static void updateSegmentTree_MaxPairSum(int[] arr, nodalTree[] tree, int start, int end, int treenode,int indx, int value) {
        if (start==end){
            arr[indx]=value;
            tree[treenode].maximum=value;
            tree[treenode].secondmaximum=Integer.MIN_VALUE;
            return;
        }
        int mid=(start+end)/2;
        if (indx<=mid) {
            updateSegmentTree_MaxPairSum(arr, tree, start, mid, 2 * treenode, indx, value);
        }
        else {
            updateSegmentTree_MaxPairSum(arr, tree, mid + 1, end, 2 * treenode + 1, indx, value);
        }
        tree[treenode].maximum=maxof(tree[2*treenode].maximum,tree[(2*treenode)+1].maximum);
        tree[treenode].secondmaximum=minof(maxof(tree[2*treenode].maximum,tree[(2*treenode)+1].secondmaximum),maxof(tree[2*treenode].secondmaximum,tree[(2*treenode)+1].maximum));
    }
    public static void builtmaxPairSegmentTree(int[] arr, nodalTree[] tree, int start, int end, int treenode) {
        if (start==end){
            tree[treenode].maximum=arr[start];
            tree[treenode].secondmaximum=Integer.MIN_VALUE;
            return;
        }
        int mid=(start+end)/2;
        builtmaxPairSegmentTree(arr,tree,start,mid,2*treenode);
        builtmaxPairSegmentTree(arr,tree,mid+1,end,(2*treenode)+1);
        tree[treenode].maximum=maxof(tree[2*treenode].maximum,tree[(2*treenode)+1].maximum);
        tree[treenode].secondmaximum=minof(maxof(tree[2*treenode].maximum,tree[(2*treenode)+1].secondmaximum),maxof(tree[2*treenode].secondmaximum,tree[(2*treenode)+1].maximum));
    }
    public static int maxof(int a, int b) {
        return (a>b)?a:b;
    }


    //even or odd
    public static void evenORodd(int[] arr,int[] treeEven,int[] treeOdd,int qi[],int[] xi,int[] yi){
        StringBuilder builder=new StringBuilder();
        int n=arr.length;
        buildEvenSegmentTree(arr,treeEven,0,n-1,1);
        buildOddSegmentTree(arr,treeOdd,0,n-1,1);
        for (int i=0;i<qi.length;i++){
            if (qi[i]==0){
                updateEvenSegmentTree(arr,treeEven,0,n-1,1,xi[i]-1,yi[i]);
                updateOddSegmentTree(arr,treeOdd,0,n-1,1,xi[i]-1,yi[i]);
            }
           else if (qi[i]==1){
               builder.append(Segment_Tree_Query(treeEven,0,n-1,1,xi[i]-1,yi[i]-1)).append("\n");
            }
            else if (qi[i]==2){
                builder.append(Segment_Tree_Query(treeOdd,0,n-1,1,xi[i]-1,yi[i]-1)).append("\n");
            }
        }
        System.out.println(builder);
    }
    public static void buildOddSegmentTree(int[] arr,int[] tree,int start,int end,int treenode){
        if (start==end){
            if (arr[start]%2!=0){
                tree[treenode]++;
            }
            return;
        }
        int mid=(start+end)/2;
        buildOddSegmentTree(arr,tree,start,mid,2*treenode);
        buildOddSegmentTree(arr,tree,mid+1,end,(2*treenode)+1);
        tree[treenode]=tree[treenode*2]+tree[(treenode*2)+1];
    }
    public static void buildEvenSegmentTree(int[] arr,int[] tree,int start,int end,int treenode){
        if (start==end){
            if (arr[start]%2==0){
                tree[treenode]++;
            }
            return;
        }
        int mid=(start+end)/2;
        buildEvenSegmentTree(arr,tree,start,mid,2*treenode);
        buildEvenSegmentTree(arr,tree,mid+1,end,(2*treenode)+1);
        tree[treenode]=tree[treenode*2]+tree[(treenode*2)+1];
    }
    public static void updateEvenSegmentTree(int[] arr,int[] tree,int start,int end,int treenode,int indx ,int value){
        if (start==end){
            arr[indx]=value;
            if (value%2==0)
            tree[treenode]=1;
            else  tree[treenode]=0;
            return;
        }
        int mid=(start+end)/2;
        if (indx<=mid) {
            updateEvenSegmentTree(arr, tree, start, mid, 2 * treenode, indx, value);
        }
        else {
            updateEvenSegmentTree(arr, tree, mid + 1, end, 2 * treenode + 1, indx, value);
        }
        tree[treenode]=tree[treenode*2]+tree[(treenode*2)+1];
    }
    public static void updateOddSegmentTree(int[] arr,int[] tree,int start,int end,int treenode,int indx ,int value){
        if (start==end){
            arr[indx]=value;
            if (value%2!=0)
            tree[treenode]=1;
            else tree[treenode]=0;
            return;
        }
        int mid=(start+end)/2;
        if (indx<=mid) {
            updateOddSegmentTree(arr, tree, start, mid, 2 * treenode, indx, value);
        }
        else {
            updateOddSegmentTree(arr, tree, mid + 1, end, 2 * treenode + 1, indx, value);
        }
        tree[treenode]=tree[treenode*2]+tree[(treenode*2)+1];
    }
    //minimum in subArray
    public static void minimumInSubarray(int[] arr,int n,char[] qi,int[] li,int[] ri){
        int[] tree=new int[2*arr.length];
        buildSegmentTree_minInSub(arr,tree,0,n-1,1);
       for(int i=0;i<qi.length;i++){
           if (qi[i]=='u'){
               updateSegmentTree(arr,tree,0,n-1,1,li[i]-1,ri[i]-1);
           }
           else if (qi[i]=='q'){
               System.out.println(Segment_Tree_Query(tree,0,n-1,1,li[i]-1,ri[i]-1));
           }
       }
    }
    public static void buildSegmentTree_minInSub(int[] arr,int[] tree,int start,int end,int treenode){
        if (start==end){
            tree[treenode]=arr[start];
            return;
        }
        int mid=(start+end)/2;
        buildSegmentTree_minInSub(arr,tree,start,mid,2*treenode);
        buildSegmentTree_minInSub(arr,tree,mid+1,end,2*treenode+1);
        tree[treenode]=minof(tree[2*treenode],tree[2*treenode+1]);
    }
    public static int minof(int a, int b) {
        return (a>b)?b:a;
    }
    // query of a segment tree
    public static int Segment_Tree_Query(int[] tree,int start,int end,int treenode,int left, int right){
        if (left>end||right<start){
            return 0;
        }
        if (start>=left&&end<=right){
            return tree[treenode];
        }
        int mid=(start+end)/2;
        return (Segment_Tree_Query(tree,start,mid,2*treenode,left,right)+Segment_Tree_Query(tree,mid+1,end,2*treenode+1,left,right));
    }
    public static void buildSegmentTree(int[] arr,int[] tree,int start,int end,int treenode){
        if (start==end){
            tree[treenode]=arr[start];
            return;
        }
        int mid=(start+end)/2;
        buildSegmentTree(arr,tree,start,mid,2*treenode);
        buildSegmentTree(arr, tree, mid+1, end, 2*treenode+1);
        tree[treenode]=tree[2*treenode]+tree[2*treenode+1];
    }
    //update a segment tree
    public static void updateSegmentTree(int[] arr,int[] tree,int start,int end,int treenode,int indx ,int value){
        if (start==end){
           arr[indx]=value;
           tree[treenode]=value;
                return;
        }
        int mid=(start+end)/2;
        if (indx<=mid) {
            updateSegmentTree(arr, tree, start, mid, 2 * treenode, indx, value);
        }
        else {
            updateSegmentTree(arr, tree, mid + 1, end, 2 * treenode + 1, indx, value);
        }
        tree[treenode]=tree[treenode*2]+tree[(treenode*2)+1];
    }
}

*/

import java.util.Scanner;

public class Main {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int n= scn.nextInt();
        int[] arr= new int[n];
        int q= scn.nextInt();
        for(int i=0;i<n;i++)
        {
            arr[i]=scn.nextInt();
        }
        int[] segTree=new int[4*n];
        segTree=ConstructTree(arr,segTree,0,arr.length-1,0);
        while(q>0)
        {
            int qlow=scn.nextInt();
            int qhigh=scn.nextInt();
            int p= rangeMinQuery(segTree,qlow-1,qhigh-1,0,arr.length-1,0);
            // System.out.println(p);
            int ans=(int) (Math.pow(2, 31))-p;
            System.out.println(ans);
            q--;
        }
    }
    public static int[] ConstructTree(int[] input,int[] segTree,int low,int high,int pos)
    {
        if(low==high)
        {segTree[pos]=input[low];
            //	System.out.println(segTree[pos]);
            return null;}
        int mid=(low+high)/2;
        ConstructTree(input,segTree,low,mid,2*pos+1);
        ConstructTree(input,segTree,mid+1,high,2*pos+2);
        if(checkComplement(segTree[2*pos+1],segTree[2*pos+2]))
        {
            segTree[pos]=max(segTree[2*pos+1],segTree[2*pos+2]);
        }
        else
        {
            segTree[pos]=min(segTree[2*pos+1],segTree[2*pos+2]);
        }
        return segTree;

    }

    public static int min(int a,int b)
    {
        if(a<b)
            return a;
        else
            return b;
    }
    public static int max(int a,int b)
    {
        if(a>b)
            return a;
        else
            return b;
    }
    public static int rangeMinQuery(int[] segTree,int qlow,int qhigh,int low,int high,int pos)
    {
        if(qlow<=low&&qhigh>=high) {
            return segTree[pos];
        }
        if(qlow>high||qhigh<low)
        {
            return -1;
        }
        int mid=(low+high)/2;
        int leftans=(rangeMinQuery(segTree,qlow,qhigh,low,mid,2*pos+1));
        int rightans=rangeMinQuery(segTree,qlow,qhigh,mid+1,high,2*pos+2);
        if(leftans==-1||rightans==-1)
        {
            if(leftans==-1)
                return rightans;
            else
                return leftans;
        }
        else
        {
            if(checkComplement(leftans,rightans))
                return (max(leftans,rightans));
            else
                return (min(leftans,rightans));
        }

    }
    public static boolean checkComplement(int a,int b)
    {
        int a1,b1;
        if(a>b)
        {
            a1=DecimaltoBinary(a);
            b1=DecimaltoBinary(b);
        }
        else
        {
            b1=DecimaltoBinary(a);
            a1=DecimaltoBinary(b);
        }

        int ans=0,power=1;
        while(a1!=0)
        {
            int rem=a1%10;
            if(rem==1)
            {
                int rem1=0;
                ans=ans+power*rem1;
            }
            else if(rem==0)
            {
                int rem1=1;
                ans=ans+power*rem1;
            }
            power=power*10;
            a1=a1/10;

        }
        if(ans==b1)
        {
            return true;
        }
        else
            return false;
    }
    public static int DecimaltoBinary(int decimal)
    {
        int binary=0;
        int power=1;
        while(decimal!=0)
        {
            int rem=decimal%2;
            binary=binary+power*rem;
            power=power*10;
            decimal=decimal/2;
        }
        return binary;
    }

}

