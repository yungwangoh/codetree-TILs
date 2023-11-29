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
    static boolean[][] visit = new boolean[MAX + 1][MAX + 1];
    static int[][] step = new int[MAX + 1][MAX + 1];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Pair> q = new LinkedList<>();
    static List<Pair> list = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();

                if(arr[i][j] == 2) list.add(new Pair(i, j)); 
            }
        }

        for(Pair p : list) {
            push(p.x, p.y, 0);
        }

        bfs();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 0) System.out.print(-1 + " ");
                else if(!visit[i][j] && step[i][j] == 0 && arr[i][j] == 1) 
                    System.out.print(-2 + " ");
                else {
                    System.out.print(step[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    static void bfs() {

        while(!q.isEmpty()) {

            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(canGo(nx, ny)) {
                    push(nx, ny, step[x][y] + 1);
                }
            }
        }
    }
    static void push(int x, int y, int nextStep) {
        visit[x][y] = true;
        q.add(new Pair(x, y));
        step[x][y] = nextStep;
    }
    static boolean canGo(int x, int y) {
        if(isRange(x, y)) return false;
        if(visit[x][y] || arr[x][y] == 0) return false;

        return true;
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}