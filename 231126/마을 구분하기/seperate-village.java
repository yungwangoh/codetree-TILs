import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 25;
    static int n, cnt = 0, ccnt = 0;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static boolean[][] visit = new boolean[MAX + 1][MAX + 1];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 0 || visit[i][j]) continue;

                ccnt = 1;
                dfs(i, j);
                list.add(ccnt);
                cnt++;
            }
        }

        Collections.sort(list);

        System.out.println(cnt);

        for(Integer n : list) {
            System.out.println(n);
        }
    }
    static void dfs(int x, int y) {

        visit[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isRange(nx, ny) || visit[nx][ny] || arr[nx][ny] == 0) continue;

            dfs(nx, ny);
            ccnt++;
        }
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}