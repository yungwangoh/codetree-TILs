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
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] count;
    static int[][] nextCount;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();

        arr = new int[n][n];
        count = new int[n][n];
        nextCount = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;

            count[r][c]++;
        }

        for(int i = 0; i < t; i++) {

            nextCount = new int[n][n];

            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(count[j][k] == 1) move(j, k);
                }
            }

            copy();

            removeCollision();

            //print();
        }

        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(count[i][j] == 1) sum++;
            }
        }

        System.out.println(sum);
    }
    static void print() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(count[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void move(int x, int y) {

        Pair newPair = check(x, y);

        int nx = newPair.x, ny = newPair.y;

        if(nx == -1 && ny == -1) return;

        nextCount[nx][ny]++;
    }
    static Pair check(int x, int y) {

        int max = 0;
        Pair p = new Pair(-1, -1);

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isRange(nx, ny)) continue;

            if(max < arr[nx][ny]) {
                max = arr[nx][ny];
                p = new Pair(nx, ny);
            }
        }

        x = p.x;
        y = p.y;

        return new Pair(x, y);
    }
    static void removeCollision() {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(count[i][j] > 1) count[i][j] = 0;
            }
        }
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
    static void copy() {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                count[i][j] = nextCount[i][j];
            }
        }
    }
}