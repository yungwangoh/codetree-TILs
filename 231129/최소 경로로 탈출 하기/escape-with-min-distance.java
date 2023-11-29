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
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        visit[0][0] = 0;
        int nn = bfs(0, 0);

        if(nn == 0) System.out.println(-1);
        else System.out.println(nn);
    }
    static int bfs(int x, int y) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(x, y));

        while(!q.isEmpty()) {

            Pair np = q.poll();
            x = np.x;
            y = np.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(canGo(nx, ny)) {
                    visit[nx][ny] = visit[x][y] + 1;
                    q.add(new Pair(nx, ny));
                }
            }
        }

        return visit[n - 1][m - 1];
    }
    static boolean canGo(int x, int y) {
        if(isRange(x, y)) return false;
        if(visit[x][y] > 0 || arr[x][y] == 0) return false;

        return true;
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }
}