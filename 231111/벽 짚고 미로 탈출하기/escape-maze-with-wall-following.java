import java.io.*;
import java.util.*;

public class Main {

    static char[][] arr;
    static final int MAX = 100;
    static final int DIR = 4;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static boolean[][][] visited = new boolean[MAX + 1][MAX + 1][DIR];
    static int x;
    static int y;
    static int n;
    static int dir;
    static int cnt;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        x = sc.nextInt() - 1;
        y = sc.nextInt() - 1;

        arr = new char[n][n];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        dir = 0;
        cnt = 0;

        do {
            simulate();

        } while(!isRange(x, y));

        System.out.println(cnt);
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
    static boolean wallExist(int x, int y) {
        return !isRange(x, y) && arr[x][y] == '#';
    }
    static void simulate() {

        if(visited[x][y][dir]) {
            System.out.println(-1);
            System.exit(0);
        }

        visited[x][y][dir] = true;

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if(wallExist(nx, ny)) dir = (dir + 3) % 4;
        else if(isRange(nx, ny)) {
            x = nx;
            y = ny;
            cnt++;
        } else {
            int rx = nx + dx[(dir + 1) % 4];
            int ry = ny + dy[(dir + 1) % 4];

            if(wallExist(rx, ry)) {
                x = nx;
                y = ny;
                cnt++;
            } else {
                x = rx;
                y = ry;
                dir = (dir + 1) % 4;
                cnt += 2;
            }
        }
    }
}