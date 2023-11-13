import java.io.*;
import java.util.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static char[] d;
    static int[] p;
    static int[] x;
    static int[] y;
    static boolean[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Deque<Pair> dq = new LinkedList<>();
    static int cnt = 0;
    static int n = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        arr = new boolean[n][n];
        d = new char[k];
        p = new int[k];
        x = new int[m];
        y = new int[m];

        for(int i = 0; i < m; i++) {
            x[i] = sc.nextInt() - 1;
            y[i] = sc.nextInt() - 1;

            arr[x[i]][y[i]] = true;
        }

        for(int i = 0; i < k; i++) {
            d[i] = sc.next().charAt(0);
            p[i] = sc.nextInt();
        }

        dq.addFirst(new Pair(0, 0));

        for(int i = 0; i < k; i++) {
            int dir = dirMapper(d[i]);
            int num = p[i];

            if(move(dir, num) == false) break;
        }

        System.out.println(cnt);
    }
    static boolean isTwisted(Pair newHead) {

        for(Pair p : dq) {
            if(p.x == newHead.x && p.y == newHead.y) {
                return true;
            }
        }

        return false;
    }
    static boolean pushFront(Pair newHead) {

        if(isTwisted(newHead)) return false; 

        dq.addFirst(newHead);

        return true;
    }
    static void popBack() {
        dq.pollLast();
    }
    static boolean moveSnake(int nx, int ny) {
        if(arr[nx][ny]) {
            arr[nx][ny] = false;

            if(pushFront(new Pair(nx, ny)) == false)
                return false;

        } else {
            popBack();

            if(pushFront(new Pair(nx, ny)) == false) 
                return false;
        }

        return true;
    }
    static boolean move(int dir, int num) {

        while(num-- > 0) {
            cnt++;

            Pair head = dq.peekFirst();

            int nx = head.x + dx[dir];
            int ny = head.y + dy[dir];

            if(isRange(nx, ny) == false) return false;

            if(moveSnake(nx, ny) == false) return false;
        }

        return true;
    }
    static int dirMapper(char dis) {
        if(dis == 'R') {
            return 2;
        } else if(dis == 'U') {
            return 1;
        } else if(dis == 'L') {
            return 3;
        } else {
            return 0;
        }
    }
    static boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}