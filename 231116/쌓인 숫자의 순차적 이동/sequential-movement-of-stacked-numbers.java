import java.io.*;
import java.util.*;

public class Main {
    
    static int[][] arr;
    static int n, m;
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, -1, 1, 1, -1, -1, 1};
    static List<Integer>[][] list;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][n];
        list = new List[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                list[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                list[i][j].add(sc.nextInt());
            }
        }

        for(int i = 0; i < m; i++) {
            int moving = sc.nextInt();

            check(moving);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(list[i][j].size() == 0) {
                    System.out.println("None");
                } else {
                    for(int k = list[i][j].size() - 1; k >= 0; k--) {
                        Integer element = list[i][j].get(k);
                        System.out.print(element + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
    static void check(int num) {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < list[i][j].size(); k++) {
                    if(list[i][j].get(k) == num) {
                        move(i, j, k);
                        return;
                    }
                }
            }
        }
    }
    static void print() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < list[i][j].size(); k++) {
                    System.out.print(list[i][j].get(k) + " ");
                }
                System.out.println();
            }
        }
        System.out.println();
    }
    static void move(int x, int y, int idx) {

        int max = 0;
        boolean flag = false;
        int rx = 0, ry = 0;
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isRange(nx, ny)) continue;

            for(int j = 0; j < list[nx][ny].size(); j++) {
                if(max < list[nx][ny].get(j)) {
                    flag = true;
                    max = list[nx][ny].get(j);
                    rx = nx;
                    ry = ny;
                }
            }
        }

        if(flag) {
            int size = list[x][y].size();

            List<Integer> subList = new ArrayList<>(list[x][y].subList(idx, size));

            for (Integer element : subList) {
                list[rx][ry].add(element);
            }

            list[x][y].removeAll(subList);
        }
    }
    static boolean isRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }
}