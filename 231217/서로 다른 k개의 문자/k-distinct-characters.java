import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static final int MAX = 100000;
    static final int ASCII = 26;
    static int number = 0;
    static int[] ascii = new int[ASCII];
    static char[] chs = new char[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        k = sc.nextInt();

        n = s.length();
    
        for(int i = 1; i <= n; i++) {
            chs[i] = s.charAt(i - 1);
        }

        int j = 0;
        int max = 0;
        for(int i = 1; i <= n; i++) {

            while(canMove(j)) {
                ascii[(int) (chs[j + 1] - 'a')]++;

                if(ascii[(int) (chs[j + 1] - 'a')] == 1) {
                    number++;
                }

                j++;
            }

            max = Math.max(max, j - i + 1);

            ascii[(int) (chs[i] - 'a')]--;

            if(ascii[(int) (chs[i] - 'a')] == 0) number--;
        }

        System.out.println(max);
    }
    static boolean canMove(int j) {

        if(j + 1 > n) return false;

        if(number == k && ascii[(int) (chs[j + 1] - 'a')] == 0) return false;

        return true;
    }
}