import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    // 아 위 왼 오
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int dirD = dirMapper('D');
            int dirL = dirMapper('L');
            int dirR = dirMapper('R');
            int dirU = dirMapper('U');

            int cntD = move(0, i, dirD);
            int cntR = move(i, 0, dirR);
            int cntL = move(i, n - 1, dirL);
            int cntU = move(n - 1, i, dirU);

            max = Math.max(Math.max(cntD, cntR), Math.max(cntL, cntU));
        }

        System.out.println(max);
    }
    static int move(int x, int y, int dir) {

        int cnt = 1;

        while(true) {
            cnt++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            //System.out.println(nx + " " + ny);
            if(isRange(nx, ny)) {
                break;
            }

            x += dx[dir];
            y += dy[dir];

            dir = vectorChange(x, y, dir);
        }

        return cnt;
    }
    static int vectorChange(int x, int y, int dir) {

        if(arr[x][y] == 1) {
            dir = dir ^ 2;
        } else if(arr[x][y] == 2) {
            dir = dir ^ 3;
        }

        return dir;
    }
    static int dirMapper(char dis) {
        if(dis == 'R') {
            return 3;
        } else if(dis == 'U') {
            return 1;
        } else if(dis == 'L') {
            return 2;
        } else {
            return 0;
        }
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}