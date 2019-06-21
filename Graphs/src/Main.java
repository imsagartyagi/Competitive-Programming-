import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
    public static ArrayList<ArrayList<Integer>> AlConnectedComponent(boolean[][] adjacencyMatrix, int n, boolean[] visited){
        ArrayList<ArrayList<Integer>> totalAns=new ArrayList<ArrayList<Integer>>();
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<visited.length;i++){
            if (visited[i]==false){
                ArrayList<Integer> temp1=new ArrayList<Integer>();
                temp1=returnbreadthFirstSearch(adjacencyMatrix,n,i,visited);
                totalAns.add(temp1);
            }
        }
        return totalAns;
    }
    public static ArrayList<Integer> returnbreadthFirstSearch(boolean[][] adjacencyMatrix,int n,int sElement,boolean[] visited){
        ArrayList<Integer> temp=new ArrayList<Integer>();
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(sElement);
        visited[sElement]=true;
        while (!queue.isEmpty()) {
            for (int i = 0; i < n; i++) {
                if (adjacencyMatrix[queue.peek()][i] == true) {
                    if (visited[i]!=true) {
                        visited[i]=true;
                        queue.add(i);
                    }
                }
            }
           temp.add(queue.remove());
        }
        return temp;
    }
    public static void isConnected(boolean[][] adjacencyMatrix,int n,int sElement,boolean[] visited,ArrayList<Integer> temp){
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(sElement);
        visited[sElement]=true;
        while (!queue.isEmpty()) {
            for (int i = 0; i < n; i++) {
                if (adjacencyMatrix[queue.peek()][i] == true) {
                    if (visited[i]!=true) {
                        visited[i]=true;
                        queue.add(i);
                    }
                }
            }
            temp.add(queue.remove());
        }
        if (temp.size()==n){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
    public static void bfsReversePath(boolean[][] adjacencyMatrix,int n,int start,int end,boolean[] visited){
        Queue<Integer> queue=new LinkedList<Integer>();
        HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
        queue.add(start);
        visited[start]=true;
        while (!queue.isEmpty()) {
            for (int i = 0; i < n; i++) {
                if (adjacencyMatrix[queue.peek()][i] == true) {
                    if (visited[i]!=true) {
                        visited[i]=true;
                        queue.add(i);
                        map.put(i,queue.peek());
                        if (i==end){
                            break;
                        }
                    }
                }
            }
            queue.remove();
        }
        System.out.println(end);
        for (int i =end;i>=0;){
            if (map.get(i)==start){
                System.out.println(start);
                break;
            }
            System.out.println(map.get(i));
             i=map.get(i);
        }
    }
    public static void dfspath_reverse(boolean[][] adjacencyMatrix, int n, int start, int end, boolean[] visited,ArrayList<Integer> temp){
      if(start==end){
          temp.add(start);
          for (int i=0;i<temp.size();i++){
              System.out.println(temp.get(i));
          }
          return;
      }
      for (int i=0;i<n;i++){
          if (adjacencyMatrix[start][i]==true){
             // ArrayList<Integer> temp1=new ArrayList<Integer>();
              if (start==i){
                  continue;
              }
              if (visited[i]==false){
                  visited[i]=true;
                  ArrayList<Integer> temp2=new ArrayList<Integer>(temp);
                  temp2.add(start);
                  dfspath_reverse(adjacencyMatrix,n,i,end,visited,temp2);
                  return;
              }
          }
      }

    }
    public static void depthFirstSearchPrint(boolean[][] adjacencyMatrix,int n,int sPoint,boolean[] visited){
        System.out.println(sPoint);
        visited[sPoint]=true;
        for (int i=0;i<n;i++){
            if (sPoint==i){
                continue;
            }
            if (adjacencyMatrix[sPoint][i]==true){
                if (visited[i]!=true) {
                    depthFirstSearchPrint(adjacencyMatrix, n, i, visited);
                }
            }
        }
    }
    public static void breadthFirstSearch(boolean[][] adjacencyMatrix,int n,int sElement,boolean[] visited){
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(sElement);
        visited[sElement]=true;
        while (!queue.isEmpty()) {
            for (int i = 0; i < n; i++) {
                if (adjacencyMatrix[queue.peek()][i] == true) {
                    if (visited[i]!=true) {
                        visited[i]=true;
                        queue.add(i);
                    }
                }
            }
            System.out.println(queue.remove());
        }
    }
    public static boolean hasPathDfs(boolean[][] adjacencyMAtrix,int n,int start,int end, boolean[] visited){
        if (adjacencyMAtrix[start][end]==true){
            return true;
        }
        visited[start]=true;
        for (int i=0;i<n;i++){
            if (start==i){
                continue;
            }
            if (adjacencyMAtrix[start][i]==true){
                if (visited[i]!=true){
                    return hasPathDfs(adjacencyMAtrix,n,i,end,visited);
                }
            }
        }
        return false;
    }
    public static boolean hasPathBfs(boolean[][] adjacencyMAtrix,int n,int start,int end,boolean[] visited){
        if (adjacencyMAtrix[start][end]==true){
            return true;
        }
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(start);
        visited[start]=true;
        while (!queue.isEmpty()) {
            for (int i = 0; i < n; i++) {
                if (adjacencyMAtrix[queue.peek()][i] == true) {
                    if (visited[i]!=true) {
                        queue.add(i);
                        visited[i]=true;
                        if (i==end){
                            return true;
                        }
                    }
                }
            }
            queue.remove();
        }
        return false;
    }
}
