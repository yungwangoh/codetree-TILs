import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k;
    static final int MAX = 1000;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static int[][][] prefix = new int[4][MAX + 1][MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            String s = sc.next();

            for(int j = 1; j <= m; j++) {
                char c = s.charAt(j - 1);

                if(c == 'a') arr[i][j] = 1;
                else if(c == 'b') arr[i][j] = 2;
                else arr[i][j] = 3;
            }
        }

        for(int c = 1; c <= 3; c++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= m; j++) {
                    int addition = 0;

                    if(arr[i][j] == c) addition = 1;

                    prefix[c][i][j] = prefix[c][i - 1][j] + prefix[c][i][j - 1] - 
                                    prefix[c][i - 1][j - 1] + addition;
                }
            }
        }

        for(int i = 0; i < k; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            System.out.print(getSum(1, x1, y1, x2, y2) + " ");
            System.out.print(getSum(2, x1, y1, x2, y2) + " ");
            System.out.print(getSum(3, x1, y1, x2, y2) + " ");
            System.out.println();
        }
    }
    static int getSum(int c, int x1, int y1, int x2, int y2) {
        return prefix[c][x2][y2] - prefix[c][x1 - 1][y2] - 
            prefix[c][x2][y1 - 1] + prefix[c][x1 - 1][y1 - 1];
    }
}