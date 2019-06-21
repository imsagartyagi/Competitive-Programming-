import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//greatQuestion try it some other time!


public class SillySort {
    static class node{
        int min,sum,count,cost;
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        StringBuilder builder=new StringBuilder();
        int n = in.nextInt();
        while (n != 0) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int[] arrcpy = arr.clone();
            Arrays.sort(arrcpy);
            HashMap<Integer, Integer> graph = new HashMap<>();
            for (int i = 0; i < n; i++) {
                graph.put(arrcpy[i], arr[i]);
            }
            // Starting Cycle !
            HashMap<Integer, Boolean> visitedCycle = new HashMap<>();
            for (int i=0;i<n;i++){
                visitedCycle.put(arrcpy[i],false);
            }
            int ans = 0;
            for (int i : graph.keySet()) {
                int minAns=0;
                if (!visitedCycle.get(i) && graph.get(i) != i) {
                    node cycleCost=Cost(i,graph,visitedCycle);
                    //for checking of all cycle Introduction!
                    HashMap<Integer, Boolean> tempvisitedCycle = new HashMap<>();
                        tempvisitedCycle= (HashMap<Integer, Boolean>) visitedCycle.clone();
                    for (int j : graph.keySet()) {
                        if (!tempvisitedCycle.get(j)) {
                            node tempCost=Cost(j,graph,tempvisitedCycle);
                            int sum=cycleCost.sum+tempCost.sum;
                            int count=cycleCost.count+tempCost.count;
                            int min=Math.min(cycleCost.min,tempCost.min);
                            int cost=sum+min*(count-2)+cycleCost.min+tempCost.min;
                            minAns=cycleCost.cost;
                            if (cost<(cycleCost.cost+tempCost.cost)) {
                                tempvisitedCycle.put(j, true);
                                minAns=cost;
                                break;
                            }
                        }
                    }
                    ans += minAns;
                }
            }
            builder.append(ans).append("\n");
            n=in.nextInt();
        }
        System.out.println(builder);
    }
    public static node Cost(int i,HashMap<Integer,Integer> graph,HashMap<Integer,Boolean> visitedCycle ){
        visitedCycle.put(i, true);
        int f = graph.get(i);
        int count = 1;
        int min = i;
        int sum = i;
        while (f!= i) {
            visitedCycle.put(f, true);
            count++;
            if (f < min) {
                min = f;
            }
            sum += f;
            f = graph.get(f);
        }
        int cycleCost = sum + (count - 2) * min;
        node ans=new node();
        ans.min=min;
        ans.count=count;
        ans.sum=sum;
        ans.cost=cycleCost;
        return ans;
    }
}
