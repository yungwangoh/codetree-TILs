import java.io.*;
import java.util.*;

class Tuple implements Comparable<Tuple> {
    int x, y, z;

    public Tuple(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int compareTo(Tuple t) {
        if(x != t.x) return t.x - x;
        if(y != t.y) return t.y - y;
        return t.z - z;
    }
}
public class Main {

    static int n, m, t, k;
    static final int MAX_N = 50;
    static ArrayList<Tuple>[][] grid = new ArrayList[MAX_N][MAX_N];
    static ArrayList<Tuple>[][] nextGrid = new ArrayList[MAX_N][MAX_N];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) grid[i][j] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) nextGrid[i][j] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int d = dirMapper(sc.next().charAt(0));
            int v = sc.nextInt();

            Tuple tuple = new Tuple(v, i + 1, d);

            grid[r][c].add(tuple);
        }

        while(t-- > 0) {
            simulate();
        }

        int sum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sum += grid[i][j].size();
            }
        }

        System.out.println(sum);
    }
    static void simulate() {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                nextGrid[i][j] = new ArrayList<>();
            }
        }

        moveAll();

        selectMarbles();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = (ArrayList<Tuple>) nextGrid[i][j].clone();
            }
        }
    }
    static Tuple move(int x, int y, int v, int dir) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(v-- > 0) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(isRange(nx, ny)) {
                dir = dirChange(dir);
                nx = x + dx[dir]; ny = y + dy[dir];
            }
            x = nx; y = ny;
        }

        return new Tuple(x, y, dir);
    }
    static void moveAll() {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < grid[i][j].size(); k++) {
                    int v = grid[i][j].get(k).x;
                    int n = grid[i][j].get(k).y;
                    int d = grid[i][j].get(k).z;

                    int nx, ny, nDir;

                    Tuple tuple = move(i, j, v, d);

                    nx = tuple.x;
                    ny = tuple.y;
                    nDir = tuple.z;

                    nextGrid[nx][ny].add(new Tuple(v, n, d));
                }
            }
        }
    }
    static void selectMarbles() {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if((int) nextGrid[i][j].size() >= k) {

                    Collections.sort(nextGrid[i][j]);

                    while((int) nextGrid[i][j].size() > k) {
                        nextGrid[i][j].remove(nextGrid[i][j].size() - 1);
                    }
                }
            }
        }
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
    static int dirMapper(char ch) {
        if(ch == 'D') return 0;
        if(ch == 'U') return 1;
        if(ch == 'L') return 2;
        if(ch == 'R') return 3;

        return -1;
    }
    static int dirChange(int dir) {
        return dir ^ 1;
    }
}