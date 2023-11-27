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
    static int n, k;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static int[][] visit = new int[MAX + 1][MAX + 1];;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < k; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            visit[x][y] = 1;
            bfs(x, y);
        }

        System.out.println(count());
    }
    static int count() {
        
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visit[i][j] == 1) cnt++;
            }
        }

        return cnt;
    }
    static void bfs(int x, int y) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(x, y));

        while(!q.isEmpty()) {

            Pair np = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = np.x + dx[i];
                int ny = np.y + dy[i];

                if(isRange(nx, ny) || arr[nx][ny] == 1 || visit[nx][ny] == 1) continue;

                visit[nx][ny] = 1;
                q.add(new Pair(nx, ny));
            }
        }
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}