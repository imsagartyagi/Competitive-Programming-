import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringSort {
   public static int MainIndx;
    public static class node implements Comparator<node> {
        String string;
        int index;

        @Override
        public int compare(node o1, node o2) {
            if ((int)o1.string.charAt(MainIndx)-(int)o2.string.charAt(MainIndx)==0){
                return (int)o1.string.charAt(MainIndx+1)-(int)o2.string.charAt(MainIndx+1);
            }
           return (int)o1.string.charAt(MainIndx)-(int)o2.string.charAt(MainIndx);
        }
    }
    public static void main(String[] args)  throws NoSuchElementException{
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        node[] strings=new node[n];
        for (int i=0;i<n;i++){
            strings[i]=new node();
            strings[i].string=scanner.next();
            strings[i].index=i;
        }
        int test=scanner.nextInt();
        while(test-- >0){
            StringBuilder builder=new StringBuilder();
            int indx = scanner.nextInt();
            MainIndx=indx;
            Arrays.sort(strings,new node());
            for (int i=0;i<strings.length;i++){
                builder.append(strings[i].string).append("\n");
            }
            System.out.println(builder);
        }
    }
}
