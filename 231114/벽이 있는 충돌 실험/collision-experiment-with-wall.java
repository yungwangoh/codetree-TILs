import java.io.*;
import java.util.*;

class Marble {
    int x;
    int y;
    int d;

    public Marble(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
public class Main {

    static int[][] arr;

    // 아 위 좌 우
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Marble> list = new ArrayList<>();
    static int n, t, m;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            n = sc.nextInt();
            m = sc.nextInt();

            arr = new int[n][n];

            list = new ArrayList<>();

            for(int j = 0; j < m; j++) {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                char d = sc.next().charAt(0);

                list.add(new Marble(x, y, dirMapper(d)));
            }

            for(int j = 0; j <= 2 * n; j++) {
                moveAll();
                removeMarble();
            }

            System.out.println(list.size());
        }
    }
    static Marble move(Marble marble) {
        
        int x = marble.x;
        int y = marble.y;
        int d = marble.d;

        int nx = x + dx[d], ny = y + dy[d];

        if(isRange(nx, ny)) return new Marble(nx, ny, d);
        else return new Marble(x, y, dirChange(d));
    }
    static void moveAll() {

        for(int i = 0; i < list.size(); i++) {
            Marble nextMarble = move(list.get(i));
            list.set(i, nextMarble);
        }
    }
    static int dirChange(int dir) {
        return dir ^ 1;
    }
    static boolean duplicateMarbleExist(int idx) {
        int tx = list.get(idx).x;
        int ty = list.get(idx).y;

        return arr[tx][ty] >= 2;
    }
    static void removeMarble() {
        List<Marble> temp = new ArrayList<>();

        for(int i = 0; i < list.size(); i++) {
            int x = list.get(i).x;
            int y = list.get(i).y;
            arr[x][y]++;
        }

        for(int i = 0; i < list.size(); i++) {
            if(!duplicateMarbleExist(i)) temp.add(list.get(i));
        }

        for(int i = 0; i < list.size(); i++) {
            int x = list.get(i).x;
            int y = list.get(i).y;
            arr[x][y]--;
        }

        list = temp;
    }
    static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    static int dirMapper(char ch) {

        if(ch == 'D') return 0;
        if(ch == 'U') return 1;
        if(ch == 'L') return 2;
        if(ch == 'R') return 3;

        return -1;
    }
    static void print() {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}