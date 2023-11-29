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
    static int n, k, r1, c1, r2, c2, min = Integer.MAX_VALUE;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static boolean[][] visit = new boolean[MAX + 1][MAX + 1];
    static int[][] step = new int[MAX + 1][MAX + 1];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Pair> q = new LinkedList<>();
    static List<Integer> list = new ArrayList<>();
    static List<Pair> wall = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();

                if(arr[i][j] == 1) wall.add(new Pair(i, j));
            }
        }

        r1 = sc.nextInt() - 1;
        c1 = sc.nextInt() - 1;
        r2 = sc.nextInt() - 1;
        c2 = sc.nextInt() - 1;

        backtracking(0, 0);

        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
    static void controllWall(List<Integer> l) {

        boolean flag = false;
        visit = new boolean[MAX + 1][MAX + 1];
        step = new int[MAX + 1][MAX + 1];

        for(Integer num : l) {
            Pair p = wall.get(num);

            arr[p.x][p.y] = 0;
        }

        bfs(r1, c1);

        if(step[r2][c2] != 0) min = Math.min(min, step[r2][c2]);
        //print(step);

        for(Integer num : l) {
            Pair p = wall.get(num);

            arr[p.x][p.y] = 1;
        }
    }
    static void backtracking(int idx, int cnt) {
        if(cnt == k) {
            controllWall(list);
            return;
        }

        if(idx == wall.size()) return;

        list.add(idx);
        backtracking(idx + 1, cnt + 1);
        list.remove(list.size() - 1);

        backtracking(idx + 1, cnt);
    }
    static void bfs(int x, int y) {

        push(x, y, 0);

        while(!q.isEmpty()) {
            Pair p = q.poll();

            x = p.x;
            y = p.y;

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

        q.add(new Pair(x, y));
        visit[x][y] = true;
        step[x][y] = nextStep;
    }
    static boolean canGo(int x, int y) {
        if(isRange(x, y)) return false;
        if(visit[x][y] || step[x][y] > 0 || arr[x][y] == 1) return false;

        return true;
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}