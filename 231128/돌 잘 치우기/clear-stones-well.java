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
    static int n, k, m;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static boolean[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Pair> list = new ArrayList<>();
    static List<Integer> idxList = new ArrayList<>();
    static List<Pair> start = new ArrayList<>();
    static boolean[] v = new boolean[MAX];
    static int max = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();

                if(arr[i][j] == 1) list.add(new Pair(i, j));
            }
        }

        
        for(int i = 0; i < k; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;

            start.add(new Pair(r, c));
        }

        combi(0, 0);

        System.out.println(max);
    }
    static int print() {

        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(visit[i][j]) sum++;
            }
        }

        return sum;
    }
    static void simulate(List<Integer> idxList) {

        for(int i = 0; i < idxList.size(); i++) {
            int num = idxList.get(i);
            Pair remove = list.get(num);
            arr[remove.x][remove.y] = 0;
        }

        for(Pair s : start) {
            visit[s.x][s.y] = true;
            bfs(s.x, s.y);
        }

        max = Math.max(max, print());

        for(int i = 0; i < idxList.size(); i++) {
            int num = idxList.get(i);
            Pair remove = list.get(num);
            arr[remove.x][remove.y] = 1;
        } 
    }
    static void combi(int idx, int cnt) {
        if(cnt == m) {
            visit = new boolean[MAX + 1][MAX + 1];
            simulate(idxList);
            return;
        }
        
        if(idx == list.size()) return;

        idxList.add(idx);
        combi(idx + 1, cnt + 1);
        idxList.remove(idxList.size() - 1);

        combi(idx + 1, cnt);
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
                    visit[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }
    static boolean canGo(int x, int y) {
        if(isRange(x, y) || visit[x][y] || arr[x][y] == 1) return false;

        return true;
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}