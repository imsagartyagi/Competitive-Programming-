import java.util.Scanner;
import java.util.TreeSet;

class KMP_String_Matching {
    TreeSet<Integer> KMPSearch(String pat, String txt)
    {
        TreeSet<Integer> set=new TreeSet<Integer>();
        int M = pat.length();
        int N = txt.length();
        int lps[] = new int[M];
        int j = 0;
        computeLPSArray(pat, M, lps);
        int i = 0;
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                set.add(i - j);
                j = lps[j - 1];
            }
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        return set;
    }

    void computeLPSArray(String pat, int M, int lps[])
    {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
    public static void main(String args[])
    {
       Scanner scanner=new Scanner(System.in);
       String a=scanner.next();
       String d=scanner.next();
       String e=scanner.next();
       String f=scanner.next();
       char[] A=a.toCharArray();
       char[] D=d.toCharArray();
       char[] E=e.toCharArray();
       char[] F=f.toCharArray();
        System.out.println(func(A,D,E,F));
    }
    public static int func(char[] A,char[] D,char[] E,char[] F){
      String a=new String(A);
      String d=new String(D);
      String e=new String(E);
      String f=new String(F);
      return (func2(a,d,e,f));
    }
    public static int func2(String a,String d,String e,String f){
        int min=a.length();
        if (a.contains(d)) {
            int op1 = func2(a.replace(d, ""), d, e, f);
            if (op1<min){
                min=op1;
            }
        }
        if (a.contains(e)) {
            int op2 = func2(a.replace(e, ""), d, e, f);
            if (op2<min){
                min=op2;
            }
        }
        if (a.contains(f)) {
            int op3 = func2(a.replace(f, ""), d, e, f);
            if (op3<min){
                min=op3;
            }
        }
            return min;
        }

    }


