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

    static final int MAX = 8;
    static int n, k, u, d, max = 0;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static boolean[][] visit = new boolean[MAX + 1][MAX + 1];;
    static boolean[][] v = new boolean[MAX + 1][MAX + 1];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Pair> list = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        combi(0);

        System.out.println(max);
    }
    static void print() {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visit[i][j]) System.out.print(1 + " ");
                else System.out.print(0 + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void combi(int idx) {

        if(idx == k) {
            visit = new boolean[MAX + 1][MAX + 1];

            int sum = 0;
            for(Pair p : list) {
                visit[p.x][p.y] = true;
                bfs(p.x, p.y);
            }

            //print();

            max = Math.max(max, count());
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(v[i][j]) continue;

                v[i][j] = true;
                list.add(new Pair(i, j));
                combi(idx + 1);
                v[i][j] = false;
                list.remove(list.size() - 1);

            }
        }
    }
    static void bfs(int x, int y) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(x, y));

        while(!q.isEmpty()) {

            Pair np = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = np.x + dx[i];
                int ny = np.y + dy[i];

                if(canGo(nx, ny)) {

                    int num = Math.abs(arr[x][y] - arr[nx][ny]);

                    if(num >= u && num <= d) {
                        visit[nx][ny] = true;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }
    static int count() {

        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visit[i][j]) sum++;
            }
        }

        return sum;
    }
    static boolean canGo(int x, int y) {
        if(isRange(x, y) || visit[x][y]) return false;

        return true;
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}