import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class AssignmentREcursion {
    public static void main(String[] args) {

    }
    public static ArrayList<ArrayList<Integer>> subset(int[] arr,int index,ArrayList<ArrayList<Integer>> arrayLists) {
        if (index==arr.length){
            arrayLists.add(new ArrayList<>());
            return arrayLists;
        }
        arrayLists=subset(arr,index+1,arrayLists);
        int item=arr[index];

        return arrayLists;
    }


















      public static  ArrayList<String> subsetOfArray(List<String> arr, ArrayList<String> stringArrayList){
        if (arr.isEmpty()){
            stringArrayList.add(" ");
            return stringArrayList;
        }
        stringArrayList=subsetOfArray(arr.subList(1,arr.size()),stringArrayList);
        int size=stringArrayList.size();
        for (int j=0;j<size;j++){
            stringArrayList.add(arr.get(0)+" "+stringArrayList.get(j));
        }
        return stringArrayList;
    }
      public static boolean checkAB(String str,boolean x) {
          if (str.length()==1) {
              if (str.equals("a"))
                  return true;
              return false;
          }

          if (str.length()==2) {
              if (str.equals("bb"))
                  return true;
              return false;
          }
          if (str.length()==3) {
              if (str.equals("abb")||str.equals("bba"))
              return true;
              return false;
          }

          x= checkAB(str.substring(1),x);
          if (x==false){
              return false;
          }
          if (str.charAt(0)=='a'){
              if (str.substring(1,2)=="") x=true;
              else if (str.substring(1,3).equals("bb")) x=true;
             else x=false;
          }
          if (str.substring(0,2).equals("bb")){
              if (str.substring(2,3).equals("")) x=true;
              else if (str.substring(2,3).equals("a")) x=true;
              else x=false;
          }
           return x;
      }


    public static  ArrayList<String> returnAllPermutation(String input,ArrayList<String> stringArrayList ){
        if (input.isEmpty()){
            stringArrayList.add("");
            return stringArrayList;
        }
      stringArrayList= returnAllPermutation(input.substring(1),stringArrayList);
        ArrayList<String> temp=new ArrayList<String>();
        for (int i=0;i<stringArrayList.size();i++){
            int l=stringArrayList.get(i).length();
            for (int j=0;j<=l;j++){
                temp.add(new StringBuilder(stringArrayList.get(i)).insert(j,input.charAt(0)).toString());
            }
        }
        stringArrayList=new ArrayList<String>();
        for (int k=0;k<temp.size();k++){
            stringArrayList.add(temp.get(k));
        }

       return stringArrayList;
    }
    public static void printAllCode(String input,String output){
        if (input.isEmpty()){
            System.out.println(output);
            return;
        }
        printAllCode(input.substring(1),output+codeOnes(input.substring(0,1)));
        if (input.length()>=2) {
            if (Integer.parseInt(input.substring(0,2))<=26) {
                printAllCode(input.substring(2),output+codeTENS(input.substring(0,2)));
            }
        }
    }
 public static ArrayList<String>  returnAllcodes(String str,ArrayList<String> output) {
     if (str.isEmpty()) {
         output.add("");
         return output;
     }
     returnAllcodes((str.substring(1)), output);
      for (int i=0;i<output.size();i++){
          output.set(i,codeOnes(str.substring(0,1))+output.get(i));
      }
      if (str.length()>=2&&Integer.parseInt(str.substring(0,2))<=26){
     ArrayList<String> temp=new ArrayList<String>();
     temp=returnAllcodes(str.substring(2),temp);
     for (int i=0;i<temp.size();i++){
         output.add(codeTENS(str.substring(0,2))+temp.get(i));
     }
     }
     return output;
    }
     public static String codeOnes(String str){

          if (str.charAt(0)=='1'){
             return "a";
         }
         else if (str.charAt(0)=='2'){
             return "b";
         }
         else if (str.charAt(0)=='3'){
             return "c";
         }
         else if (str.charAt(0)=='4'){
             return "d";
         }
         else if (str.charAt(0)=='5'){
             return "e";
         }
        else if (str.charAt(0)=='6'){
             return "f";
         }
        else if (str.charAt(0)=='7'){
             return "g";
         }
        else if (str.charAt(0)=='8'){
             return "h";
         }
         else if (str.charAt(0)=='9'){
             return "i";
         }
         return "";
     }
     public static String codeTENS(String string){
       if (string=="10"){
           return "j";
       }
       else  if (string.equals("11")){
           return "k";
       }
       else  if (string.equals("12")){
           return "l";
       }
       else  if (string.equals("13")){
           return "m";
       }
       else  if (string.equals("14")){
           return "n";
       }
       else  if (string.equals("15")){
           return "o";
       }
       else  if (string.equals("16")){
           return "p";
       }
       else  if (string.equals("17")){
           return "q";
       }
       else  if (string.equals("18")){
           return "r";
       }
       else  if (string.equals("19")){
           return "s";
       }
       else  if (string.equals("20")){
           return "t";
       }
       else  if (string.equals("21")){
           return "u";
       }
       else  if (string.equals("22")){
           return "v";
       }
       else  if (string.equals("23")){
           return "w";
       }
       else  if (string.equals("24")){
           return "x";
       }
       else  if (string.equals("25")){
           return "y";
       }
       else if (string.equals("26")){
           return "z";
       }
       return "";
     }

    public static int Staircase(int n){
      if (n==1){
          return 1;
      }
      if (n==2){
          return 2;
      }
      if (n==3){
          return 4;
      }
      return Staircase(n-1)+Staircase(n-2)+Staircase(n-3);
    }
   public int BinarySearch(int[] arr,int x,int sIndex,int eIndex){
        int mid=(sIndex+eIndex)/2;
        if (arr[mid]==x){
            return mid;
        }
        if (arr[mid]<x){
           return BinarySearch(arr,x,mid+1,eIndex);
        }
        else {
           return BinarySearch(arr,x,sIndex,mid-1);
        }

   }
}
