import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(minCost(new int[]{10,70,80,20},new int[]{100,5,15,60},0,new int[]{0,0,0}));

    }
    public static int minCost(int[] MenNumber,int[] costI,int index,int[] Battle){
        int aCost,bCost,cCost;
        if (index==costI.length){
            return 0;
        }
        if (MenNumber[index]<=(Battle[0]+Battle[1]+Battle[2])) {
            aCost = minCost(MenNumber, costI, index + 1, Battle);
            int i = 0;
            while (Battle[0] + Battle[1] + Battle[2] > 0 && i <= 2) {
                if (Battle[i] == 0) {
                    i++;
                    continue;
                }
                if (MenNumber[index] <= 0) {
                    break;
                }
                Battle[i]--;
                MenNumber[index]--;

            }
            Battle[0] = Battle[1];
            Battle[1] = Battle[2];
            Battle[2] = 0;
            return aCost;
        }
        bCost=(costI[index])+minCost(MenNumber,costI,index+1,Battle);
        Battle[2]=MenNumber[index];
        cCost=(2*costI[index])+minCost(MenNumber,costI,index+1,Battle);
        index--;
        return minimumof(bCost,cCost);
    }

    private static int minimumof( int bCost, int cCost) {
        return (bCost<cCost)?bCost:cCost;
    }


    public static class threeValue{
        long gcd;
        long x;
        long y;
    }
    public static threeValue extendedEuclid(long a,long b){
        if (b==0){
            threeValue currentValues = new threeValue();
            currentValues.gcd=a;
            currentValues.x=1;
            currentValues.y=0;
            return currentValues;
        }
        threeValue currentValue=new threeValue();
        threeValue smallerValue=extendedEuclid(b,a%b);
        currentValue.gcd=smallerValue.gcd;
        currentValue.x=smallerValue.y;
        currentValue.y=smallerValue.x-((a/b)*smallerValue.y);
        return currentValue;
    }
    public static long multiplicativeModuloInverse(long A,long m){
        long M=extendedEuclid(A,m).x;
        return (M%m+m)%m;
    }
    public static long professorAssignment(long n){
        long mod=1000000007;
        long ans=0;
        long sqrt= (long) Math.sqrt(n);
        for (long i=1;i<=sqrt;i++){
            long FirstmaxcountI=n/i;
            long countI=(((FirstmaxcountI%mod)*((FirstmaxcountI+1)%mod)%mod)*multiplicativeModuloInverse(2,mod))%mod;
            ans=(ans%mod+((i%mod)*(countI%mod))%mod)%mod;
        }
        long left=sqrt;
        for (long i=sqrt;i>0;i--){
            long right=n/i;
            long RangeSum=rangeSum(left+1,right);
            long FirstmaxCountI=n/right;
            long CountI=(((FirstmaxCountI%mod)*((FirstmaxCountI+1)%mod)%mod)*multiplicativeModuloInverse(2,mod))%mod;
            ans=(ans%mod+((RangeSum%mod)*(CountI%mod))%mod)%mod;
            left=right;
        }

        return ans;
    }
    public static long rangeSum(long a,long b){
        long mod=1000000007;
        a--;
        long sumTillA=(((a%mod)*((a+1)%mod)%mod)*multiplicativeModuloInverse(2,mod))%mod;
        long sumTillb=(((b%mod)*((b+1)%mod)%mod)*multiplicativeModuloInverse(2,mod))%mod;
        return ((sumTillb%mod-sumTillA%mod)+mod)%mod;
    }
   public static void meaningFulongSENTENCE(String input,String output,int index,ArrayList<String> strings) {
     if(index==input.length()){
         System.out.println(output);
     }
     for (int i=index;i<=input.length();i++){
         if (strings.contains(input.substring(index,i))){
             if (output.isEmpty())
             meaningFulongSENTENCE(input,output+input.substring(index,i),i,strings);
             else
                 meaningFulongSENTENCE(input,output+" "+input.substring(index,i),i,strings);
         }
     }

    }
    public static void isDivisible_41(int a0,int a1,int c,int n){
        int[] arr=builtArr(a0, a1, c, n);
        int num=0;
        for (int i=0;i<n;i++){
            num=((num%41)*10)+arr[i];
        }
        if (num%41==0){
            System.out.println("YES");
        }
        else if (num%41!=0){
            System.out.println("NO");
        }

    }
    public static int[] builtArr(int a0,int a1,int c,int n){
        int[] arr=new int[n+1];
        arr[0]=a0; arr[1]=a1;
        for(int i=2;i<n;i++){
            arr[i]=((arr[i-1]*c)+arr[i-2])%10;
        }
        return arr;
    }
}
