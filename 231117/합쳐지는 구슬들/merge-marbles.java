import java.io.*;
import java.util.*;

class Marble implements Comparable<Marble> {
    int x, y, d, w, num;

    public Marble(int x, int y, int d, int w, int num) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.w = w;
        this.num = num;
    }

    @Override
    public int compareTo(Marble m) {
        return m.num - num;
    }
}
public class Main {

    static int n, m, t;
    static final int MAX_N = 51;
    static ArrayList<Marble>[][] grid = new ArrayList[MAX_N][MAX_N];
    static ArrayList<Marble>[][] nextGrid = new ArrayList[MAX_N][MAX_N];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) 
                grid[i][j] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) 
                nextGrid[i][j] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int dir = dirMapper(sc.next().charAt(0));
            int w = sc.nextInt();

            Marble m = new Marble(r, c, dir, w, i + 1);

            grid[r][c].add(m);
        }

        while(t-- > 0) {
            simulate();
        }

        int sum = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                for(int k = 0; k < (int) grid[i][j].size(); k++) {
                    max = Math.max(max, grid[i][j].get(k).w);
                }
                sum += grid[i][j].size();
            }
        }

        System.out.println(sum + " " + max);
    }
    static void simulate() {

        for(int i = 0; i < n; i++) {
            for(int j =0 ; j < n; j++) {
                nextGrid[i][j] = new ArrayList<>();
            }
        }

        moveAll();

        addMarble();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = (ArrayList<Marble>) nextGrid[i][j].clone();
            }
        }
    }
    static Marble move(Marble marble) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int x = marble.x;
        int y = marble.y;
        int dir = marble.d;
        int w = marble.w;
        int num = marble.num;

        int nx = x + dx[dir], ny = y + dy[dir];

        if(isRange(nx,ny)) {
            dir = dirChange(dir);
            return new Marble(x, y, dir, w, num);
        } else {
            return new Marble(nx, ny, dir, w, num);
        }
    }
    static void moveAll() {
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < (int) grid[i][j].size(); k++) {
                    Marble marble = grid[i][j].get(k);

                    Marble newMarble = move(marble);

                    nextGrid[newMarble.x][newMarble.y].add(newMarble);
                }
            }
        }
    }
    static void addMarble() {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(nextGrid[i][j].size() == 0) continue;
                
                Collections.sort(nextGrid[i][j]);

                int sum = nextGrid[i][j].stream().mapToInt(marble -> marble.w).sum();

                nextGrid[i][j].get(0).w = sum;

                while((int) nextGrid[i][j].size() > 1) {
                    nextGrid[i][j].remove(nextGrid[i][j].size() - 1);
                }
            }
        }
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
    static int dirMapper(char dir) {
        if(dir == 'D') return 0;
        if(dir == 'U') return 1;
        if(dir == 'L') return 2;
        if(dir == 'R') return 3;

        return -1;
    }
    static int dirChange(int dir) {
        return dir ^ 1;
    }
}