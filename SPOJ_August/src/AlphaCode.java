import java.util.Scanner;

public class AlphaCode {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String n=scanner.next();
        char[] arr=n.toCharArray();
        while (!n.equals("0")) {
            arr = n.toCharArray();
            long[] ans = new long[arr.length];
            if (arr.length == 1) {
                System.out.println(1);
                n = scanner.next();
            }
            else {
                ans[0] = 1;
                int num = Integer.parseInt(String.valueOf(arr[0])) * 10 + Integer.parseInt(String.valueOf(arr[1]));
                if (Integer.parseInt(String.valueOf(arr[1]))==0){
                    if (Integer.parseInt(String.valueOf(arr[0]))>2||Integer.parseInt(String.valueOf(arr[0]))==0){
                        ans[1]=0;
                    }
                    else {
                        ans[1]=1;
                    }
                }
                else if (num<=26){
                    ans[1]=2;
                }
                else ans[1]=1;
                for (int i = 2; i < n.length(); i++) {
                    ans[i]=ans[i-1];
                    num = (num * 10 + Integer.parseInt(String.valueOf(arr[i]))) % 100;
                    if (Integer.parseInt(String.valueOf(arr[i]))==0){
                        if (Integer.parseInt(String.valueOf(arr[i-1]))>2||Integer.parseInt(String.valueOf(arr[i-1]))==0){
                            ans[i]=0;
                            break;
                        }
                        else {
                            ans[i]=ans[i-2];
                        }
                    }
                    else if (num<=26&&num>10){
                        ans[i]+=ans[i-2];
                    }

                }
                System.out.println(ans[ans.length - 1]);
                n = scanner.next();
            }
        }
    }

}
