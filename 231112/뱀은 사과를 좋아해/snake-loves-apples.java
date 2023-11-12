import java.io.*;
import java.util.*;

public class Main {

    static final int APPLE = 100;
    static char[] d;
    static int[] p;
    static int[] x;
    static int[] y;
    static int[][] arr;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};
    static boolean[][] visit;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        arr = new int[n][n];
        visit = new boolean[n][n];
        d = new char[k];
        p = new int[k];
        x = new int[m];
        y = new int[m];

        for(int i = 0; i < m; i++) {
            x[i] = sc.nextInt() - 1;
            y[i] = sc.nextInt() - 1;

            arr[x[i]][y[i]] = APPLE;
        }

        for(int i = 0; i < k; i++) {
            d[i] = sc.next().charAt(0);
            p[i] = sc.nextInt();
        }

        int cnt = move(0, 0, k, n);

        print(n);
        System.out.println(cnt);
    }
    static int move(int x, int y, int K, int n) {

        int cnt = 0;

        for(int i = 0; i < K; i++) {
            int dir = dirMapper(d[i]);
            int pp = p[i];

            for(int j = 0; j < pp; j++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                cnt++;
                if(isRange(nx, ny, n) || visit[nx][ny]) {
                    return cnt;
                }


                visit[nx][ny] = true;
                visit[x][y] = false;

                x += dx[dir];
                y += dy[dir];

                for(int k = 0; k < 4; k++) {
                    int rx = x + dx[k];
                    int ry = y + dy[k];

                    if(isRange(rx, ny, n) || visit[rx][ny]) continue;

                    if(search(rx, ny)) {
                        cnt++;
                        visit[rx][ny] = true;

                        x += dx[k];
                        y += dy[k];
                    }
                }
            }
        }

        return cnt;
    }
    static boolean search(int x, int y) {
        if(arr[x][y] == APPLE) return true;
        return false;
    }
    static int dirMapper(char dis) {
        if(dis == 'R') {
            return 0;
        } else if(dis == 'U') {
            return 1;
        } else if(dis == 'L') {
            return 2;
        } else {
            return 3;
        }
    }
    static boolean isRange(int x, int y, int n) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
    static void print(int n) {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}