import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CAM5_DisjointSet {
   // static int[] parent;
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        StringBuilder builder=new StringBuilder();
        while (test-- > 0) {
            int n = scanner.nextInt();
            int[] parent = new int[n];
            Arrays.fill(parent,-1);
            int e = scanner.nextInt();
            for (int i = 0; i < e; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int parentA = findParent(a,parent);
                int parentB = findParent(b,parent);
                if (parentA != parentB) {
                    unionRank(parentA, parentB,parent);
                }
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(findParent(i,parent));
            }
            builder.append(set.size()).append("\n");
        }
        System.out.println(builder);
    }

    private static void unionRank(int parentA, int parentB,int[] parent) {
        if (parent[parentA]<=parent[parentB]){
            parent[parentA]+=parent[parentB];
            parent[parentB]=parentA;
        }
        else {
            parent[parentB]+=parent[parentA];
            parent[parentA]=parentB;
        }
    }

    private static int findParent(int a,int[] parent) {
        if (parent[a]<0){
            return a;
        }
        return findParent(parent[a],parent);
    }
}


