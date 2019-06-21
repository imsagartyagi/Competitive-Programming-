import java.util.Scanner;

public class DistinctPrimes {
    static class node{
        int g;
        int pd;
    }
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);
         int n=scanner.nextInt();
         int[] arr=new int[n];
         for (int i=0;i<n;i++){
             arr[i]=scanner.nextInt();
         }
        System.out.println(solve(arr));
    }
        public static int solve(int[] A) {
            int[] primeDivisor=new int[100005];
            for(int i=2;i<100005;i++){
                if(primeDivisor[i]==0){
                    for(int j=1;i*j<100005;j++){
                        primeDivisor[i*j]++;
                    }
                }
            }
            node ans=solve1(A,0,A.length-1,primeDivisor);
            return ans.pd;

        }
        public static node solve1(int[] arr, int left, int right, int[] primeDivisor) {

            if(right==left){
                node temp=new node();
                temp.g=arr[left];
                temp.pd=primeDivisor[arr[left]];
                return temp;
            }
            int mid=(left+right)/2;
            node leftans=new node();
            leftans=solve1(arr,left,mid,primeDivisor);
            node rightans=new node();
            rightans=solve1(arr,mid+1,right,primeDivisor);
            int combinedGcd=gcd(leftans.g,rightans.g);
            int gcdPd=primeDivisor[combinedGcd];
            int combinedPd=(leftans.pd-gcdPd)+(rightans.pd);
            node trueans=new node();
            trueans.pd=combinedPd;
            trueans.g=combinedGcd;
            return trueans;

        }
        public static int gcd(int a, int b){
            if(b>a)return gcd(b,a);
            if(b==0) return a;
            return gcd(b,a%b);
        }

}
