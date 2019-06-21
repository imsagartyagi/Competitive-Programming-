import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Codeforces503_Election {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int voters=scanner.nextInt();
        int parties=scanner.nextInt();
        ArrayList<Integer>[] arrayLists=new ArrayList[parties+1];
        for (int i = 0; i < parties + 1; i++) {
            arrayLists[i] = new ArrayList<Integer>();
        }
        for (int i=0;i<voters;i++){
            int pi=scanner.nextInt();
            int bc_i=scanner.nextInt();
            arrayLists[pi].add(bc_i);
        }
        for (int i=1;i<=parties;i++){
            Collections.sort(arrayLists[i]);
        }
        //for all possible values of votes
        long finalans=Long.MAX_VALUE;
        for (int i=1;i<=voters;i++){
            PriorityQueue<Integer> priorityQueue=new PriorityQueue<Integer>();
            long cost_i=0;
            int votercount=arrayLists[1].size();;
            for (int j=2;j<=parties;j++){
                for (int k=0;k<arrayLists[j].size();k++){
                    if (arrayLists[j].size()-k>=i){
                        votercount++;
                        cost_i+=arrayLists[j].get(k);
                    }
                    else {
                        priorityQueue.add(arrayLists[j].get(k));
                    }
                }
            }
            while (votercount<i){
                votercount++;
                cost_i+=priorityQueue.poll();
            }
            finalans=Math.min(cost_i,finalans);
        }
        System.out.println(finalans);
    }
}
