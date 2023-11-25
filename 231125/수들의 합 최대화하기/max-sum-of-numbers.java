import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 10;
    static int n, max = 0;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static boolean[] visit = new boolean[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        func(0, 0);

        System.out.println(max);
    }
    static void func(int row, int sum) {

        if(row == n) {
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            func(row + 1, sum + arr[row][i]);
            visit[i] = false;
        }
    }
}