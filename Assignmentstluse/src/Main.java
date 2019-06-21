import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr={1,1,1,2,3,1 };
        int[] output={0,0,0,0,0,0};
        stockSpan(arr,output);
        for (int i=0;i<output.length;i++){
            System.out.println(output[i]);
        }
    }
    public static void stockSpan(int[] arr,int[] output){
     Stack<Integer> integerStack=new Stack<Integer>();
      integerStack.push(0);
      output[0]=1;
      for (int i=1;i<arr.length;i++){
          while(!integerStack.isEmpty()&&arr[integerStack.peek()]<arr[i]){
              integerStack.pop();
          }
          if (integerStack.isEmpty()){
              output[i]= i+1;
          }
          else output[i]= i-integerStack.peek();
          integerStack.push(i);
      }
    }







   public static ArrayList<Integer> longestConsecutiveSubsequence(int[] arr){
       HashSet<Integer> hashSet=new HashSet<Integer>();
       ArrayList<Integer> arrayList=new ArrayList<Integer>();
       int count=0;
       for (int i=0;i<arr.length;i++){
           hashSet.add(arr[i]);
       }
       for (int j=0;j<arr.length;j++){
           int temp=arr[j];
           int count1=0;
           ArrayList<Integer> arrayList1=new ArrayList<Integer>();
           while (hashSet.contains(temp+1)){
               count1++;
               arrayList1.add(temp);
               temp=temp+1;
           }
           if (count1>count){
               count=count1;
           }
         if (arrayList1.size()>arrayList.size()){
               arrayList=new ArrayList<Integer>();
               for (int k=0;k<arrayList1.size();k++){
                   arrayList.add(arrayList1.get(k));
               }
         }
       }

   return arrayList;

   }
    public int kthLargest(int[] arr,int k){
        Arrays.sort(arr);
        return arr[arr.length-k];
    }
    public  static String extractUniqueCharacter(String str){
        ArrayList<Character> characters=new ArrayList<Character>();
        String string=new String("");
        for (int i=0;i<str.length();i++){
            if (Collections.frequency(characters,str.charAt(i))<1)
            {
                characters.add(str.charAt(i));
                string=string.concat(Character.toString(str.charAt(i)));
            }
        }

        return string;
    }
}
