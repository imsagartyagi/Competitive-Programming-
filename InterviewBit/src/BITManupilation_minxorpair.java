import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BITManupilation_minxorpair {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        ArrayList<Integer> integers=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            integers.add(in.nextInt());
        }
        System.out.println(findminPair(integers));
    }
    private static int findminPair(ArrayList<Integer> integers) {
        Collections.sort(integers);
        int n=integers.size();
        int xorVal=Integer.MAX_VALUE;
        for (int i=1;i<n;i++){
            if ((integers.get(i)^integers.get(i-1))<xorVal){
                xorVal=(integers.get(i)^integers.get(i-1));
            }
        }
        return xorVal;
    }
}
