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
    static int n, m;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static int[][] visit = new int[MAX + 1][MAX + 1];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        visit[0][0] = 1;
        bfs(0, 0);

        if(visit[n - 1][m - 1] == 1) System.out.println(1);
        else System.out.println(0);
    }
    static void bfs(int x, int y) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(x, y));

        while(!q.isEmpty()) {

            Pair newPair = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = newPair.x + dx[i];
                int ny = newPair.y + dy[i];

                if(isRange(nx, ny) || visit[nx][ny] == 1 || arr[nx][ny] == 0) continue;

                visit[nx][ny] = 1;
                q.add(new Pair(nx, ny));
            }
        }
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }
}