import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(cardGame(new int[]{2,3,5,7,11,13,17,19,23,29,31,33,32,36,36},6));


    }
    public static int cardGame(int[] arr,int k){
       int sum=0;
       int prod=1;
       int j=0;
       for (int i=0;i<arr.length;i++){
           if (arr[i]%k!=0){
               prod=((prod%k)*(arr[i]%k))%k;
               if (prod%k==0) {
                   sum+=arr.length-i;
                   int temp=i;
                   int tempProduct=1;
                   for (int a=temp;a>=j;a--){
                       tempProduct=((tempProduct%k)*(arr[a]%k))%k;
                       if (tempProduct%k==0){
                           sum+=temp-j+1;
                           tempProduct=1;
                           prod=1;
                           break;
                       }
                   }
                   prod=1;
                   j=i+1;
                   continue;
               }
           }
           else if (arr[i]%k==0){
               sum+=(i-j+1)*(arr.length-i);
               prod=1;
               j=i+1;
           }
       }
       return sum;
    }
    public static void strangeOrder(int n){
        int[] arr=new int[n+1];
        int[] leastPrimeDivisor=lpd(n);
        for (int i=1;i<=n;i++){
            arr[i]=i;
        }
      for (int i=n;i>=1;i--){
           ArrayList<Integer> ans=new ArrayList<Integer>();
          if (arr[i]!=-1){
              int lpd_i=leastPrimeDivisor[i];
              int x=i;
              while(lpd_i>1) {
                  int temp=lpd_i;
                  for (int j = i; j >= 1; j = j - lpd_i) {
                      if (arr[j]!=-1) {
                          ans.add(j);
                          arr[j] = -1;
                      }
                  }
                  while(lpd_i==temp){
                      x/=lpd_i;
                      lpd_i=leastPrimeDivisor[x];
                  }

              }
             Collections.sort(ans);
              for (int l=ans.size()-1;l>=0;l--){
                  System.out.print(ans.get(l)+" ");
              }
          }
      }


        System.out.print("1");
    }
    public static int[] lpd(int n){
        int[] lpdArray=new int[n+1];
        boolean[] prime=new boolean[n+1];
        Arrays.fill(prime,true);
        for (int i=1;i<=n;i++){
            lpdArray[i]=i;
        }

        for (int i=2;i<=n/2;i++){
            {
                for (int j = 2; j * i <= n; j++) {
                    if (prime[i*j]==true)
                        lpdArray[j * i] = i;
                    prime[j*i]=false;
                }
            }
        }return lpdArray;
    }
   public static int maxElement(int[] arr){
        int max=arr[0];
        for (int i=1;i<arr.length;i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        return max;
   }
   public static int[] GoodSetsSieve(int[] setElement,int num){
     int[] arr=new int[num+1];
     for (int i=0;i<setElement.length;i++){
         arr[setElement[i]]=1;
     }
       for (int i=1;i<=num/2;i++){
         if (arr[i]>=1) {
             for (int j = 2; j * i <= num; j++) {
                 if (arr[i*j] >= 1) {
                     arr[j * i] += arr[i];
                 }

             }
         }
       }
         return arr;
   }
    public static int[] postionNumber(boolean[] arr){
       int[] positionNumber=new int[arr.length];
       for (int i=1;i< arr.length;i++){
           if (arr[i-1]==false) positionNumber[i]=positionNumber[i-1]+1;
           else positionNumber[i]=positionNumber[i-1];
       }
       return positionNumber;
    }
    public static boolean[] sieveOFcubeNumber(int num){
        boolean[] arr=new boolean[num+1];
        for (int i=2;i*i*i<=num;i++){
            arr[i*i*i]=true;
        }
        for (int i=8;i<=(num)/2;i++){
            if (arr[i]==true){
                {
                if (arr[i*2]!=true)
                {
                    for (int j=2;i*j<=num;j++){
                        arr[i*j]=true;
                    }
                }
            }

            }
        }
        return arr;
    }
    public static int[] sieveOFprimeFactor(int num) {
        int[] arr = new int[num + 1];
        for (int i = 2; i <= num + 1 / 2; i++) {
            if (arr[i] == 0) {
                for (int j = 1; j * i <= num; j++) {
                    arr[j * i] += 1;
                }
            }
        }
        for (int k = num + 1 / 2; k < arr.length; k++) {
            if (arr[k] == 0) {
                arr[k] = 1;
            }
        }
        return arr;

    }

}
