public class Main {
    public static void main(String[] args) {
        System.out.println(lis(new int[]{5,4,11,1,16,8}));





    }







    public static int lis(int arr[]) {
        int n=arr.length;
        int[] dynamicSolution=new int[n];
        for(int i=0;i<n;i++){
            dynamicSolution[i]=1;
            for(int j=i-1;j>=0;j--){
                int possiblevalue=dynamicSolution[i];
                if(arr[j]<arr[i]){
                    possiblevalue=dynamicSolution[j]+1;
                }
                dynamicSolution[i]=maxof(dynamicSolution[i],possiblevalue);
            }
        }
        int maxval=-1;
        for(int j=0;j<n;j++){
            if(dynamicSolution[j]>maxval){
                maxval=dynamicSolution[j];
            }

        }
        return maxval;
    }
    public static int getMaxMoney(int arr[], int n){
        int[] dynamicAnswer=new int[n];
        dynamicAnswer[0]=arr[n-1];
        dynamicAnswer[1]=maxof(arr[0],arr[1]);
        for(int i=2;i<n;i++){
            dynamicAnswer[i]=maxof(arr[i]+dynamicAnswer[i-2],dynamicAnswer[i-1]);
        }
        return dynamicAnswer[n-1];
    }
    public static int maxof(int a,int b){
        return (a>b)?a:b;
    }
}
