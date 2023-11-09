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
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;

        arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.print(arr[r][c] + " ");
        while(true) {

            Pair p = search(n, r, c);
            if(p.x == -1 && p.y == -1) {
                break;
            }

            System.out.print(arr[p.x][p.y] + " ");

            r = p.x;
            c = p.y;
        }
    }
    static Pair search(int n, int r, int c) {

        int max = arr[r][c];
        Pair p = new Pair(-1, -1);

        for(int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if(isRange(nx, ny, n)) continue;

            if(arr[nx][ny] > max) {
                max = arr[nx][ny];
                p = new Pair(nx, ny);
                break;
            }
        }

        r = p.x;
        c = p.y;
        
        return new Pair(r, c);
    }
    static boolean isRange(int x, int y, int n) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}