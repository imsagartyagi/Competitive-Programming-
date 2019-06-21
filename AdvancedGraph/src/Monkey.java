import java.util.Scanner;

public class Monkey {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        while (test-- >0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < m; i++) {
                int v1 = scanner.nextInt() - 1;
                int v2 = scanner.nextInt() - 1;
                int v1Parent = findParent(v1, parent);
                int v2Parent = findParent(v2, parent);
                if (v1Parent < v2Parent) {
                    parent[v2Parent] = v1Parent;
                }
                else if (v1Parent > v2Parent){
                    parent[v1Parent]=v2Parent;
                }
            }
            for (int i=0;i<n;i++){
                int hp=findParent(i,parent);
                parent[i]=hp;
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int[] aans = new int[n];
            for (int i = 0; i < n; i++) {
                int indx = parent[i];
                aans[indx] += arr[i];
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (aans[i] > max) {
                    max = aans[i];
                }
            }
            System.out.println(max);
        }
    }

    private static int findParent(int v1, int[] parent) {
        if (parent[v1]==v1){
            return v1;
        }
        return findParent(parent[v1],parent);
    }
}
