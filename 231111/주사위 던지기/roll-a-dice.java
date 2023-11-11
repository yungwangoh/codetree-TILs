import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int r;
    static int c;
    static int n;
    static int[][] dice = {
        {0, 1, 0},
        {4, 5, 3},
        {0, 6, 0},
        {0, 2, 0},
    };
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static int[] ddx = {0, 0, 1, -1};
    static int[] ddy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;

        arr = new int[n][n];
        arr[r][c] = dice[2][1];
        int dir = 0;
        for(int i = 0; i < m; i++) {
            
            char ch = sc.next().charAt(0);

            if(ch == 'L') {
                dir = 0;
                int nx = r + ddx[dir];
                int ny = c + ddy[dir];

                if(isRange(nx, ny)) continue;

                LRrotate(dir);

                arr[nx][ny] = dice[2][1];

                r += ddx[dir];
                c += ddy[dir];

            } else if(ch == 'R') {
                dir = 1;

                int nx = r + ddx[dir];
                int ny = c + ddy[dir];

                if(isRange(nx, ny)) continue;

                LRrotate(dir);

                arr[nx][ny] = dice[2][1];

                r += ddx[dir];
                c += ddy[dir];
            } else if(ch == 'D') {
                dir = 2;

                int nx = r + ddx[dir];
                int ny = c + ddy[dir];

                if(isRange(nx, ny)) continue;

                UDrotate(dir);

                arr[nx][ny] = dice[2][1];

                r += ddx[dir];
                c += ddy[dir];
            } else {
                dir = 3;

                int nx = r + ddx[dir];
                int ny = c + ddy[dir];

                if(isRange(nx, ny)) continue;

                UDrotate(dir);

                arr[nx][ny] = dice[2][1];

                r += ddx[dir];
                c += ddy[dir];
            }
        }     

        //print();

        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] > 0) sum += arr[i][j];
            }
        }

        System.out.println(sum);
    }
    static void LRrotate(int dir) {
        int[] a = new int[4];

        for(int i = 0; i < 4; i++) {
            int nx = 1 + dx[i];
            int ny = 1 + dy[i];

            a[i] = dice[nx][ny];
        }

        if(dir == 1) {

            int tmp = a[4 - 1];
            for(int i = 4 - 1; i >= 1; i--) {
                a[i] = a[i - 1];
            }
            a[0] = tmp;

        } else if(dir == 0) {

            int tmp = a[0];
            for(int i = 0; i < 4 - 1; i++) {
                a[i] = a[i + 1];
            }
            a[4 - 1] = tmp;

        }

        for(int i = 0; i < 4; i++) {
            int nx = 1 + dx[i];
            int ny = 1 + dy[i];

            dice[nx][ny] = a[i];
        }
    }
    static void UDrotate(int dir) {
        int[] a = new int[4];

        for(int i = 0; i < 4; i++) {
            a[i] = dice[i][1];
        }

        if(dir == 2) {
            int tmp = a[0];
            for(int i = 0; i < 3; i++) {
                a[i] = a[i + 1];
            }
            a[4 - 1] = tmp;
        } else if(dir == 3) {
            int tmp = a[4 - 1];
            for(int i = 4 - 1; i >= 1; i--) {
                a[i] = a[i - 1];
            }
            a[0] = tmp;
        } 

        for(int i = 0; i < 4; i++) {
            dice[i][1] = a[i];
        }
    }
    static void print() {
        for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            } 
            System.out.println();
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}