import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
         int n=scanner.nextInt();
         ArrayList<Pair<Character,Integer>> pairArrayList=new ArrayList<Pair<Character, Integer>>();
         for (int i=0;i<n;i++){
             char a= (char) scanner.nextInt();
             int val=scanner.nextInt();
             Pair<Character,Integer> pair=new Pair<Character, Integer>(a,val);
             pairArrayList.add(pair);
         }
         // bc yeh question copy maaara hai tune lodu dalle ! chor!

    }
}
