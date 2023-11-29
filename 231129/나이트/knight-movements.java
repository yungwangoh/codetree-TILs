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
    static int n, r1, c1, r2, c2;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static int[][] visit = new int[MAX + 1][MAX + 1];
    static int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
    static int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        r1 = sc.nextInt() - 1;
        c1 = sc.nextInt() - 1;
        r2 = sc.nextInt() - 1;
        c2 = sc.nextInt() - 1;


        visit[r1][c1] = 0;
        System.out.println(bfs(r1, c1));
    }
    static int bfs(int x, int y) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(x, y));

        while(!q.isEmpty()) {

            Pair p = q.poll();
            x = p.x;
            y = p.y;

            for(int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(canGo(nx, ny)) {
                    visit[nx][ny] = visit[x][y] + 1;
                    q.add(new Pair(nx, ny));
                }
            }
        }

        if(visit[r2][c2] > 0) return visit[r2][c2];
        else return -1; 
    }
    static boolean canGo(int x, int y) {
        if(isRange(x, y) || visit[x][y] > 0) return false;

        return true;
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}