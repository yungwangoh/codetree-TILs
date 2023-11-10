import java.io.*;
import java.util.*;

public class Main {

    static char[][] arr;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int x;
    static int y;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        x = sc.nextInt() - 1;
        y = sc.nextInt() - 1;

        arr = new char[n][n];
        int max = 0;
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);

                if(arr[i][j] == '.') max++;
            }
        }

        int cnt = 0;
        int dir = 0;
        boolean flag = false;
        boolean flag2 = false;
        while(true) {
            if(isRange(x, y, n)) {
                flag = true;
                break;
            }
            if(check(dir, '#', n) && check(dir + 1, '#', n)) dir = (dir + 3) % 4;
            else if(check((dir + 2) % 4, '@', n) && check((dir + 1) % 4, '.', n)) dir = (dir + 1) % 4;
            else if(check((dir + 2) % 4, '@', n) && check((dir + 1) % 4, '@', n)) {
                System.out.println(-1);
                System.exit(0);
            }

            move(dir);
            cnt++;

            //System.out.println(x + " " + y);
        }

        if(flag) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }
    static boolean isRange(int x, int y, int n) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
    static boolean check(int dir, char ch, int n) {

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if(isRange(nx, ny, n)) return false;

        if(arr[nx][ny] == ch) return true;
        
        return false;
    }
    static void move(int dir) {
        arr[x][y] = '@';
        x += dx[dir];
        y += dy[dir];
    }
}