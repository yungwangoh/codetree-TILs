import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair>{
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p) {
        if(x == p.x) return y - p.y;
        return x - p.x;
    }
}
public class Main {

    static final int MAX = 100;
    static int n, k, r, c;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static int[][] visit;
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

        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;


        for(int i = 0; i < k; i++) {
            visit = new int[MAX + 1][MAX + 1];
            visit[r][c] = 1;
            Pair p = bfs(r, c);

            if(p.x == -1 && p.y == -1) {
                break;
            }

            r = p.x;
            c = p.y;

            //print();
        }

        System.out.println((r + 1) + " " + (c + 1));
    }
    // static void print() {
    //     for(int i = 0; i < n; i++) {
    //             for(int j = 0; j < n; j++) {
    //                 System.out.print(visit[i][j] + " ");
    //             }
    //             System.out.println();
    //         }
    //         System.out.println();
    // }
    static Pair bfs(int x, int y) {

        Queue<Pair> q = new LinkedList<>();
        List<Pair> list = new ArrayList<>();

        q.add(new Pair(x, y));

        int max = 0;
        while(!q.isEmpty()) {

            Pair np = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = np.x + dx[i];
                int ny = np.y + dy[i];

                if(canGo(x, y, nx, ny)) {
                    visit[nx][ny] = 1;
                    max = Math.max(max, arr[nx][ny]);
                    q.add(new Pair(nx, ny));
                }
            }
        }


        return check(max);  
    }
    static Pair check(int max) {
        
        List<Pair> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(max == arr[i][j] && visit[i][j] == 1) {
                    list.add(new Pair(i, j));
                }
            }
        }

        Collections.sort(list);

        if(list.isEmpty()) return new Pair(-1, -1);
        return list.get(0);
    }
    static boolean canGo(int x, int y, int nx, int ny) {
        if(isRange(nx, ny) || (arr[x][y] <= arr[nx][ny]) || visit[nx][ny] == 1) return false;

        return true;
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}