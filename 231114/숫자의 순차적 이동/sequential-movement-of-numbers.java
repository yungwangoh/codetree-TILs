import java.io.*;
import java.util.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int[][] arr;
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, -1, 1, 1, -1, -1, 1};
    static int n, m;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 1; j <= n * n; j++) {
                Pair newPair = search(j);
                Pair changePair = check(newPair.x, newPair.y);

                swap(arr, newPair.x, newPair.y, changePair.x, changePair.y);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    static Pair search(int num) {

        Pair p = new Pair(-1, -1);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == num) {
                    p = new Pair(i, j);
                    break;
                }
            }
        }

        return p;
    }
    static Pair check(int x, int y) {

        int max = 0;
        Pair p = new Pair(-1, -1);

        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isRange(nx, ny)) continue;

            if(max < arr[nx][ny]) {
                max = arr[nx][ny];
                p = new Pair(nx, ny);
            }
        }

        return p;
    }
    static void swap(int[][] arr, int x1, int y1, int x2, int y2) {
        int tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}