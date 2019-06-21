import java.util.*;
public class HackerBlocks {
    public static int ans=0;
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[][] board=new int[n][n];
        int count=0;
        solveNqueen(board,n,0,count);
        System.out.println(ans);
    }
    public static boolean solveNqueen(int[][] board,int n,int row,int count){
        if (row==n){
            count++;
            ans+=count;
            return false;
        }
        for (int j=0;j<n;j++){
            if (isPositionSafe(board,row,j,n)){
                board[row][j]=1;

                boolean rakhPaaye=solveNqueen(board,n,row+1,count);
                if (rakhPaaye) return true;
                board[row][j]=0; //Backtracking
            }
        }
        return false;
    }
    public static boolean isPositionSafe(int[][] board,int i,int j,int n){
        for (int row=0;row<i;row++){
            if (board[row][j]==1){
                return false;
            }
        }
        int x=i,y=j;
        while (x>=0&&y>=0){
            if (board[x][y]==1){
                return false;
            }
            x--;
            y--;
        }
        x=i;y=j;
        while (x>=0&&y<n){
            if (board[x][y]==1){
                return false;
            }
            x--;
            y++;
        }

        return true;
    }
}