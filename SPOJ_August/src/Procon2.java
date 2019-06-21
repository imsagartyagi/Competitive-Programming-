import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Procon2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        while (test-- >0) {
            PriorityQueue<Double> pq = new PriorityQueue<Double>(Collections.reverseOrder());
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                pq.add((double) x);
            }
            double ans = 0;
            for (int i = 1; i <= n - 1; i++) {
                double x1 = pq.poll();
                double x2 = pq.poll();
                double p = (x1 / 2) + (x2 / 2);
                ans=p;
                pq.add(p);
            }
            System.out.println(String.format("%.8f", ans));
        }
    }
}
