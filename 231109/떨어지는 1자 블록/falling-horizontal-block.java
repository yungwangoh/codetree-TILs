import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt() - 1;

        arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int row = rowCheck(n, m, k);

        for(int i = k; i <= k + m - 1; i++) {
            arr[row][i] = 1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int rowCheck(int n, int m, int k) {
        for(int i = 0; i < n - 1; i++) {
            if(!check(i + 1, m, k)) return i;
        }

        return n - 1;
    }
    static boolean check(int row, int m, int k) {

        for(int j = k; j <= k + m - 1; j++) {
            if(arr[row][j] == 1) return false; 
        }

        return true;
    }
}