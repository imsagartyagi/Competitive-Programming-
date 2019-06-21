import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        while (test-- >0) {
            String string1 = scanner.next();
            String string2 = scanner.next();
            int k=scanner.nextInt();
            System.out.println(balikaVAdhu(string1, string2, k));
        }
    }


    // BAlika Vadhu

     public static int balikaVAdhu(String string1, String string2, int k){
        int m=string1.length();
        int n=string2.length();
        int[][] output=lcsIteratively(string1,string2);
        if (k>output[m][n]) return 0;
        ArrayList<StringBuilder> strings =new ArrayList<StringBuilder>();
        for (int a=0;a<=m;a++){
            for (int b=0;b<=n;b++){
                if (output[a][b]==k){
                    int i=a; int j=b;
                    while(i>=1&&j>=1){
                        StringBuilder builder=new StringBuilder();
                        if (string1.charAt(i-1)==string2.charAt(j-1)){
                            builder.append(string1.charAt(i-1));
                            i=i-1;
                            j=j-1;
                        }
                        else {
                            if (output[i-1][j]>output[i][j-1]){
                                i=i-1;
                            }
                            else{
                                j=j-1;
                            }
                        }
                        StringBuilder ans=builder.reverse();
                        strings.add(ans);
                    }

                }
            }
        }
        ArrayList<Integer> answers=new ArrayList<Integer>();
       for (int i=0;i<strings.size();i++){

       }

     }
     public static int[][] lcsIteratively(String s1,String s2){
         int m=s1.length();
         int n=s2.length();
         int[][] output=new int[m+1][n+1];
         for (int i=0;i<=m;i++){
             for (int j=0;j<=n;j++){
                 if (i==0||j==0){
                     output[i][j]=0;
                 }
                 else if (s1.charAt(i-1)==s2.charAt(j-1)){
                     output[i][j]=1+output[i-1][j-1];
                 }
                 else {
                     output[i][j]=maxof(output[i-1][j],output[i][j-1]);
                 }
             }
         }
         return output;
     }





    //primexor_veryImportant

    public static int primexor(int[] arr){
        int max_XorSum=8192;
        int mod=1000000007;
        int size=arr.length;
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        HashSet<Integer> uniqueelemnet=new HashSet<>();
        for (int i=0;i<size;i++){
            uniqueelemnet.add(arr[i]);
            arrayList.add(arr[i]);
        }
        Iterator iterator=uniqueelemnet.iterator();
        int[] arr1=new int[uniqueelemnet.size()];
        int[] frequencyArray=new int[uniqueelemnet.size()];
        int a=0;
        while(iterator.hasNext()){
            arr1[a++]= (int) iterator.next();
            frequencyArray[a-1]=Collections.frequency(arrayList,arr1[a-1]);
        }
        for (int i=0;i<size;i++){

        }
        int[][] output=new int[2][max_XorSum+1];
        int size1=arr1.length;
        output[0][0]=1;
        for (int i=1;i<=max_XorSum;i++){
            output[0][i]=0;
        }
        int flag=1;
        for (int i=1;i<=size1;i++){
            int n=frequencyArray[i-1];
            for(int j=0;j<=8191;j++){
                output[flag][j]=((output[flag^1][j]*(1+(n/2)))%mod+((output[flag^1][j^arr1[i-1]])*(n+1)/2)%mod)%mod;
            }
            flag=flag^1;
        }
        boolean[] sieve_Primes=sieveofErathosthenes(9000);
        int ans=0;
        for (int i=0;i<=max_XorSum;i++){
            if (sieve_Primes[i]==true){
                ans+=output[flag^1][i];
                ans%=mod;
            }
        }
        return ans;
    }
    private static boolean[] sieveofErathosthenes(int num) {
        boolean[] sieve=new boolean[num+1];
        for (int i=2;i<=num;i++){
            sieve[i]=true;
        }
        for (int i=2;i*i<=num;i++){
            if (sieve[i]==false) continue;
            for (int j=i;j*i<=num;j++){
                sieve[j*i]=false;
            }
        }
        return sieve;

    }

    //subsetSum
    public static int subsetSum(int[] arr,int index,int k,int[][] output){
        if (k==0) {
            output[index][k]=1;
            return 1;
        }
        if (index==arr.length&&k!=0){
            output[index][k]=0;
            return 0;
        }
        if (output[index][k]!=-1){
            return output[index][k];
        }
        if (k>=arr[index]) {
            int option1 = subsetSum(arr, index + 1, k - arr[index],output);
            int option2 = subsetSum(arr, index + 1, k,output);
            output[index][k]= (option1==1 || option2==1)?1:0;
            return output[index][k];
        }
        else {
            output[index][k]= subsetSum(arr, index + 1, k, output);
            return output[index][k];
        }

    }
    public static class node{
        int maxfun;
        int budget;
    }
    public static node knapsack_party(int[] funValue,int[] price,int budget,int totalparty){
        node ans=new node();
        int[][] output=new int[totalparty+1][budget+1];
        for (int i=0;i<=totalparty;i++){
            for (int j=0;j<=budget;j++){
                if (i==0||j==0){
                    output[i][j]=0;
                }
                else {
                    output[i][j]=output[i-1][j];
                    if (price[i-1]<=j){
                        output[i][j]=maxof(output[i][j],funValue[i-1]+output[i-1][j-price[i-1]]);
                    }
                }
            }
        }
        int budget1=-1;
        for (int i=0;i<=budget;i++){
            if (output[totalparty][i]==output[totalparty][budget]){
                budget1=i;
                break;
            }
        }
        ans.budget=budget1;
        ans.maxfun=output[totalparty][budget];
        return ans;
    }
    public static int knapsackIterative(int[] item_values,int[] item_weights,int knapsackweight,int items){
        int[][] output=new int[2][knapsackweight+1];
        for (int i=0;i<=1;i++){
            output[i][0]=0;
        }
        for (int i=0;i<=knapsackweight;i++){
            output[0][i]=0;
        }
        int flag=1;
        for (int i=1;i<=items;i++){
            for (int j=1;j<=knapsackweight;j++){
                output[flag][j]=output[flag^1][j];
                if (item_weights[i-1]<=j){
                    output[flag][j]=maxof(output[flag][j],item_values[i-1]+output[flag^1][j-item_weights[i-1]]);
                }
            }
            flag=flag^1;
        }
        return output[flag^1][knapsackweight];
    }
    public static int knapsackRecursively(int[] values,int[] weights,int knapsackweight,int index){
        int size=values.length;
        if (index==size){

            return 0;
        }
        if (weights[index]<=knapsackweight) {
            int option1 = values[index] + knapsackRecursively(values, weights, knapsackweight - weights[index], index + 1);
            int option2 = knapsackRecursively(values, weights, knapsackweight, index + 1);
            return maxof(option1,option2);
        }
        else  {
            return knapsackRecursively(values, weights, knapsackweight, index + 1);
        }
    }
    public static int editDistance(String s1, String s2,int[][] output){
        int m=s1.length();
        int n=s2.length();
       if(m==0) {
           output[m][n]=n;
           return n;
       }
       if (n==0) {
           output[m][n]=m;
           return m;
       }
       if (output[m][n]!=-1){
           return output[m][n];
       }
       if (s1.charAt(0)==s2.charAt(0)){
          int ans= editDistance(s1.substring(1),s2.substring(1),output);
          output[m][n]=ans;
          return ans;
       }
       else {
           int option1=editDistance(s1.substring(1),s2.substring(0),output);
           int option2=editDistance(s1.substring(1),s2.substring(1),output);
           int option3=editDistance(s1.substring(0),s2.substring(1),output);
           output[m][n]= 1+minof(option1,minof(option2,option3));
           return output[m][n];
       }
    }
    private static int minof(int a, int b) {
        return (a<b)?a:b;
    }
    public static int lcsRecursively(String string1,String string2,int m,int n,int[][] output){
        if (m==0||n==0){
            output[m][n]=0;
            return 0;
        }
        if (output[m][n]!=-1){
            return output[m][n];
        }
        if (string1.charAt(0)==string2.charAt(0)){
            output[m][n]= 1+lcsRecursively(string1.substring(1),string2.substring(1),m-1,n-1,output);
            return output[m][n];
        }
        int ans1=lcsRecursively(string1.substring(0),string2.substring(1),m,n-1,output);
        int ans2=lcsRecursively(string1.substring(1),string2.substring(0),m-1,n,output);
        output[m][n]= maxof(ans1,ans2);
        return output[m][n];
    }
    public static int maxof(int a, int b) {
        return (a>b)?a:b;
    }
}
