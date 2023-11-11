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
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;

        arr = new int[n][n];

        arr[r][c] = 1;

        for(int i = 0; i < m; i++) {

            List<Pair> list = check(n);
            for(int j = 0; j < list.size(); j++) {
                Pair p = list.get(j);

                bomb(p.x, p.y, i + 1, n);
            }
        }

        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 1) sum++;
            }
        }

        
        System.out.println(sum);
    }
    static List<Pair> check(int n) {
        List<Pair> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 1) list.add(new Pair(i, j));
            }
        }

        return list;
    }
    static void bomb(int x, int y, int t, int n) {

        int scale = calculate(t);
        for(int i = 0; i < 4; i++) {
            int nx = x + (scale * dx[i]);
            int ny = y + (scale * dy[i]);

            if(isRange(nx, ny, n) || arr[nx][ny] == 1) continue;

            arr[nx][ny] = 1;
        }
    }
    static boolean isRange(int x, int y, int n) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
    static int calculate(int t) {
        return (int) Math.pow(2, t - 1);
    }
}