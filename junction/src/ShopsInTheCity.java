import java.util.Scanner;

public class ShopsInTheCity {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int test=scanner.nextInt();
        while(test-- >0){
            int n=scanner.nextInt();
            int m=scanner.nextInt();
            char[][] grid=new char[n][m];
            int x=-1;
            int y=-1;
            for (int i=0;i<n;i++){
                    grid[i]=scanner.next().toCharArray();
                }
            int[][] outputDP=new int[n][m];
            boolean[][] visited=new boolean[n][m];
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    outputDP[i][j]=-1;
                    visited[i][j]=false;
                    char val=grid[i][j];
                    if (grid[i][j]=='B'){
                        x=i;
                        y=j;
                    }
                }
            }

            int minans=Integer.MAX_VALUE;
            for (int i=x;i>=0;i--) {
                if (grid[i][y]=='G') break;
                int ans = minimum_Time(grid, i, y,n,m,outputDP,visited);
                minans=Integer.min(ans,minans);
            }
            for (int i=x;i<n;i++) {
                if (grid[i][y]=='G') break;
                int ans = minimum_Time(grid, i, y,n,m,outputDP,visited);
                minans=Integer.min(ans,minans);
            }
            for (int j=y;j<m;j++) {
                if (grid[x][j]=='G') break;
                int ans = minimum_Time(grid, x, j,n,m,outputDP,visited);
                minans=Integer.min(ans,minans);
            }
            for (int j=y;j>=0;j--) {
                if (grid[x][j]=='G') break;
                int ans = minimum_Time(grid, x, j,n,m,outputDP,visited);
                minans=Integer.min(ans,minans);
            }
            System.out.println(minans);
        }
    }

    private static int minimum_Time(char[][] grid,int i,int j,int n,int m,int[][] outputDP,boolean[][] visited) {
        if (i<0||j<0||i>n||j>m) {
            return 0;
        }
        if (outputDP[i][j]!=-1){
            return outputDP[i][j];
        }
        if (grid[i][j]=='X'){
            outputDP[i][j]=0;
            return 0;
        }

        int option1=Integer.MAX_VALUE;
        if (j+1<m&&visited[i][j+1]==false) {
            if (grid[i][j + 1] != 'G') {
                visited[i][j+1]=true;
                option1 = 1 + minimum_Time(grid, i, j + 1, n, m,outputDP,visited);
                outputDP[i][j+1]=option1;
            }
        }
        int option2=Integer.MAX_VALUE;
        if (i+1<n&&visited[i+1][j]==true) {
            if (grid[i + 1][j] != 'G') {
                visited[i+1][j]=true;
                option2 = 1 + minimum_Time(grid, i + 1, j, n, m,outputDP,visited);
                outputDP[i+1][j]=option2;
            }
        }
        int option3=Integer.MAX_VALUE;
        if (j-1>=0&&visited[i][j-1]==false) {
            if (grid[i][j - 1] != 'G') {
                visited[i][j-1]=true;
                option3 = 1 + minimum_Time(grid, i, j - 1, n, m,outputDP,visited);
                outputDP[i][j-1]=option3;
            }
        }
        int option4=Integer.MAX_VALUE;
        if (i-1>=0&&visited[i-1][j]==false) {
            if (grid[i - 1][j] != 'G') {
                visited[i-1][j]=true;
                option4 = 1 + minimum_Time(grid, i - 1, j, n, m,outputDP,visited);
                outputDP[i-1][j]=option4;
            }
        }
        outputDP[i][j]= Integer.min(option1,Integer.min(option2,Integer.min(option3,option4)));
        return outputDP[i][j];
    }
}
