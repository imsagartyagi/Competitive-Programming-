import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NestedDolls {
    static class node implements Comparator<node>{
        int a,b;
        @Override
        public int compare(node o1, node o2) {
            return o1.a-o2.a;
        }
    }


    // This is an O(n^2) algorithm which is Giving Tle at spoj. But remember there Exists an O(nlogn) algorithm to find Longest Increasing Subsequence!
    // See that PDF Which Has the Easiest Implementation of LIS in nlogn There is an video on Youtube too.
    public static void main(String[] args) {
        InputReader in=new InputReader(System.in);
        int test=in.nextInt();
        StringBuilder builder=new StringBuilder();
        while (test-- >0) {
            int n = in.nextInt();
            node[] arr=new node[n];
            for (int i=0;i<n;i++){
                arr[i]=new node();
                arr[i].a=in.nextInt();
                arr[i].b=in.nextInt();
            }
            Arrays.sort(arr,new node());
            int[][] dp=new int[n][n];
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    dp[i][j]=-1;
                }
            }
            builder.append((n-(Math.max(compute(arr,n-2,0,dp),1+ compute(arr,n-2,n-1,dp))))+1).append("\n");
        }
        System.out.println(builder);
    }

    private static int compute(node[] arr, int i, int prev, int[][] dp) {
        if (i<0){
            return 0;
        }
        if (dp[i][prev]!=-1){
            return dp[i][prev];
        }
        int op1=compute(arr,i-1,prev, dp);
        int op2=Integer.MIN_VALUE;
        if (prev==0||arr[prev].a>arr[i].a&&arr[prev].b>arr[i].b){
             op2=1+compute(arr, i-1, i, dp);
        }
        dp[i][prev]=Math.max(op2,op1);
        return dp[i][prev];
    }
}
class InputReader {
    private boolean finished = false;

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public int peek() {
        if (numChars == -1) {
            return -1;
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                return -1;
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar];
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String nextString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            if (Character.isValidCodePoint(c)) {
                res.appendCodePoint(c);
            }
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null) {
            return filter.isSpaceChar(c);
        }
        return isWhitespace(c);
    }

    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private String readLine0() {
        StringBuilder buf = new StringBuilder();
        int c = read();
        while (c != '\n' && c != -1) {
            if (c != '\r') {
                buf.appendCodePoint(c);
            }
            c = read();
        }
        return buf.toString();
    }

    public String readLine() {
        String s = readLine0();
        while (s.trim().length() == 0) {
            s = readLine0();
        }
        return s;
    }

    public String readLine(boolean ignoreEmptyLines) {
        if (ignoreEmptyLines) {
            return readLine();
        } else {
            return readLine0();
        }
    }

    public char nextCharacter() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        return (char) c;
    }

    public double nextDouble() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E') {
                return res * Math.pow(10, nextInt());
            }
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }

    public boolean isExhausted() {
        int value;
        while (isSpaceChar(value = peek()) && value != -1) {
            read();
        }
        return value == -1;
    }

    public String next() {
        return nextString();
    }

    public SpaceCharFilter getFilter() {
        return filter;
    }

    public void setFilter(SpaceCharFilter filter) {
        this.filter = filter;
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }

    public int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) array[i] = nextInt();
        return array;
    }

    public int[] nextSortedIntArray(int n) {
        int array[] = nextIntArray(n);
        Arrays.sort(array);
        return array;
    }

    public int[] nextSumIntArray(int n) {
        int[] array = new int[n];
        array[0] = nextInt();
        for (int i = 1; i < n; ++i) array[i] = array[i - 1] + nextInt();
        return array;
    }

    public long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; ++i) array[i] = nextLong();
        return array;
    }

    public long[] nextSumLongArray(int n) {
        long[] array = new long[n];
        array[0] = nextInt();
        for (int i = 1; i < n; ++i) array[i] = array[i - 1] + nextInt();
        return array;
    }

    public long[] nextSortedLongArray(int n) {
        long array[] = nextLongArray(n);
        Arrays.sort(array);
        return array;
    }
}

