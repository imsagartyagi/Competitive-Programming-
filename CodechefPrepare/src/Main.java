import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        advancedFruits solver = new advancedFruits();
        solver.solve(1, in, out);
        out.close();
    }

    static class advancedFruits {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String a = scanner.next();
                String b = scanner.next();
                char[] arr1 = a.toCharArray();
                char[] arr2 = b.toCharArray();
                String[][] dp = new String[a.length() + 1][b.length() + 1];
                for (int i = 0; i < arr1.length; i++) {
                    for (int j = 0; j < arr2.length; j++) {
                        dp[i][j] = "";
                    }
                }
                String lcs = f(arr1, arr2, 0, 0, dp);
                String ans = f2(arr1, arr2, lcs.toCharArray());
                System.out.println(ans);
            }
        }

        private String f2(char[] arr1, char[] arr2, char[] lcs) {
            StringBuilder builder = new StringBuilder();
            int i = 0, j = 0, k = 0;
            int n = arr1.length;
            int m = arr2.length;
            int r = lcs.length;
            while (i < n && j < m && k < r) {
                while (i < n && j < m && k < r && arr1[i] == arr2[j] && arr2[j] == lcs[k]) {
                    builder.append(arr1[i]);
                    i++;
                    j++;
                    k++;
                }
                while (i < n && k < r && arr1[i] != lcs[k]) {
                    builder.append(arr1[i]);
                    i++;
                }
                while (j < m && k < r && arr2[j] != lcs[k]) {
                    builder.append(arr2[j]);
                    j++;
                }
            }
            while (i < n) {
                builder.append(arr1[i]);
                i++;
            }
            while (j < m) {
                builder.append(arr2[j]);
                j++;
            }
            return builder.toString();
        }

        private String f(char[] arr1, char[] arr2, int i, int j, String[][] dp) {
            if (i >= arr1.length || j >= arr2.length) {
                return "";
            }
            if (!dp[i][j].equals("")) {
                return dp[i][j];
            }
            if (arr1[i] == arr2[j]) {
                return arr1[i] + f(arr1, arr2, i + 1, j + 1, dp);
            } else {
                String op1 = f(arr1, arr2, i + 1, j, dp);
                String op2 = f(arr1, arr2, i, j + 1, dp);
                if (op2.length() > op1.length()) {
                    dp[i][j] = op2;
                    return op2;
                } else {
                    dp[i][j] = op1;
                    return op1;
                }
            }
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void close() {
            writer.close();
        }

    }

    static class InputReader {
        private InputStream stream;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

    }
}

