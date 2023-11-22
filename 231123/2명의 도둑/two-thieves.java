import java.io.*;
import java.util.*;

public class Main {

    static final int MAX_N = 10;
    static int n, m, c, max = Integer.MIN_VALUE;
    static int[][] arr = new int[MAX_N + 1][MAX_N + 1];
    static int[] a = new int[MAX_N];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int m = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    for(int l = 0; l < n; l++) {
                        if(possible(i, j, k, l)) {
                            m = Math.max(m, func(i, j) + func(k, l));
                        }
                    }
                }
            } 
        }

        System.out.println(m);
    }
    static boolean intersact(int a, int b, int c, int d) {
        return !(b < c || d < a);
    }
    static boolean possible(int x1, int y1, int x2, int y2) {

        if(y1 + m - 1 >= n || y2 + m - 1 >= n) return false;

        if(x1 != x2) return true;

        if(intersact(y1, y1 + m - 1, y2, y2 + m - 1)) return false;

        return true;
    }
    static int func(int x, int y) {
        for(int i = y; i <= y + m - 1; i++) {
            a[i - y] = arr[x][i];
        }

        max = Integer.MIN_VALUE;
        findSum(0, 0, 0);
        return max;
    }
    static void findSum(int cIdx, int cWeight, int cValue) {
        if(cIdx == m) {
            if(cWeight <= c) {
                max = Math.max(max, cValue);
            }
            return;
        }

        findSum(cIdx + 1, cWeight, cValue);

        findSum(cIdx + 1, cWeight + a[cIdx], cValue + a[cIdx] * a[cIdx]);
    }
}