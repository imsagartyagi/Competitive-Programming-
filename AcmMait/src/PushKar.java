import java.util.Scanner;

public class PushKar {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int maxWeight=scanner.nextInt();
        int[] itemValue=new int[n];
        int[] itemWeight=new int[n];
        for (int i=0;i<n;i++){
            itemValue[i]=scanner.nextInt();
            itemWeight[i]=scanner.nextInt();
        }
        System.out.println(knapsackIterative(itemValue,itemWeight,maxWeight,n));
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

    private static int maxof(int a, int b) {
        return (a>b)?a:b;
    }
}
