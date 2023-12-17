import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100000;
    static final int ASCII = 127;
    static int[] ascii = new int[ASCII + 1];
    static char[] chs = new char[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        for(int i = 1; i <= s.length(); i++) {
            chs[i] = s.charAt(i - 1);
        }

        int j = 0;
        int max = 0;
        for(int i = 1; i <= s.length(); i++) {

            while(j + 1 <= s.length() && ascii[(int) (chs[j + 1] - 'a')] != 1) {
                ascii[(int) (chs[j + 1] - 'a')]++;
                j++;
            }

            max = Math.max(max, j - i + 1);

            ascii[(int) chs[i] - 'a'] -= 1;
        }

        System.out.println(max);
    }
}