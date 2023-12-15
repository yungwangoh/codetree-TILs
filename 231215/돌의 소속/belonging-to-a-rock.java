import java.io.*;
import java.util.*;

public class Main {

    static int n, q;
    static final int ROCK = 3;
    static final int MAX_N = 100000;
    static final int MAX_Q = 100000;
    static int[] arr = new int[MAX_N + 1];
    static int[][] prefix = new int[ROCK + 1][MAX_N + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        q = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i <= ROCK; i++) {
            for(int j = 1; j <= n; j++) {

                int addition = 0;

                if(arr[j] == i) addition = 1;

                prefix[i][j] = prefix[i][j - 1] + addition;
            }
        }

        for(int i = 0; i < q; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            System.out.print(prefix[1][y] - prefix[1][x - 1] + " ");
            System.out.print(prefix[2][y] - prefix[2][x - 1] + " ");
            System.out.println(prefix[3][y] - prefix[3][x - 1] + " ");
        }
    }
}