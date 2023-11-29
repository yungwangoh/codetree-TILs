import java.io.*;
import java.util.*;

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static final int MAX = 100;
    static int n, h, m;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static int[][] work = new int[MAX + 1][MAX + 1];
    static int[][] human = new int[MAX + 1][MAX + 1];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Pair> list = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();

                if(arr[i][j] == 2) list.add(new Pair(i, j));
            }
        }

        for(Pair p : list) {
            init();
            
            bfs(p.x, p.y);

            int cnt = count();
            human[p.x][p.y] = cnt;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(human[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static int count() {

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 3) {
                    min = Math.min(min, work[i][j]);
                }
            }
        }

        if(min == 0) return -1;
        else return min;
    }
    static void init() {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                work[i][j] = 0;
            }
        }
    }
    static void bfs(int x, int y) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(x, y));

        while(!q.isEmpty()) {

            Pair p = q.poll();
            x = p.x;
            y = p.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(canGo(nx, ny)) {
                    work[nx][ny] = work[x][y] + 1;
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }
    static boolean canGo(int x, int y) {
        if(isRange(x, y)) return false;
        if(work[x][y] > 0 || arr[x][y] == 1) return false;

        return true;
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}