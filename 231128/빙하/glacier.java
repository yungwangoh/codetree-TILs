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

    static final int MAX = 200;
    static int n, m;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static int[][] draw = new int[MAX + 1][MAX + 1];
    static boolean[][] visit = new boolean[MAX + 1][MAX + 1];
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


        int cnt = 0;
        int sum = 0;
        int i = 0;
        while(true) {
            sum = count();
            cnt++;

            Pair init = searchNotVisited();

            visit[init.x][init.y] = true;
            List<Pair> list = new ArrayList(bfs(init.x, init.y));

            for(Pair p : list) arr[p.x][p.y] = 0;

            if(check()) break;
        }

        System.out.println(cnt + " " + sum);
        //print();        
    }
    static void print() {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static Pair searchNotVisited() {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visit[i][j]) return new Pair(i, j);
            }
        }

        return null;
    }
    static int count() {
        
        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1) sum++;
            }
        }

        return sum;
    }
    static boolean check() {

        boolean flag = true;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1) flag = false;
            }
        }

        return flag;
    }
    static List<Pair> bfs(int x, int y) {

        Queue<Pair> q = new LinkedList<>();
        
        List<Pair> list = new ArrayList<>();

        q.add(new Pair(x, y));

        while(!q.isEmpty()) {
            Pair np = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = np.x + dx[i];
                int ny = np.y + dy[i];

                if(canGo(nx, ny)) {
                    if(arr[nx][ny] == 1) {
                        list.add(new Pair(nx, ny));
                        continue;
                    }
                    visit[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
        }

        return list;
    }
    static boolean canGo(int x, int y) {
        if(isRange(x, y) || visit[x][y]) return false;

        return true;
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }
}