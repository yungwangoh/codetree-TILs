import java.io.*;
import java.util.*;

public class Main {

    static final int MX = 4;
    static int n, r, c, max = Integer.MIN_VALUE;
    static int[][] arr = new int[MX][MX];
    static int[][] brr = new int[MX][MX];
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                brr[i][j] = sc.nextInt() - 1; 
            }
        }

        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;

        func(r, c, 0);

        System.out.println(max);
    }
    static void func(int r, int c, int cnt) {

        max = Math.max(max, cnt);

        for(int i = 0; i < n; i++) {
            int nr = r + dx[brr[r][c]] * i;
            int nc = c + dy[brr[r][c]] * i;

            if(!isRange(nr, nc) && (arr[r][c] < arr[nr][nc])) {
                func(nr, nc, cnt + 1);
            }
        }  
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}