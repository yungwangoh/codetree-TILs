import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int[][] temp;
    static int[][] backup;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new int[n][n];
        backup = new int[n][n];
        temp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                backup[i][j] = arr[i][j];
            }
        }

        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                
                bomb(i, j, n, arr[i][j]);
                drop(n);
                max = Math.max(max, pair(n));

                copy(n, backup);
            }
        }

        System.out.println(max);
    }
    static int pair(int n) {

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 1; j++) {
                if((arr[i][j] > 0 && arr[i][j + 1] > 0) && (arr[i][j] == arr[i][j + 1])) {
                    cnt++;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 1; j++) {
                if((arr[j][i] > 0 && arr[j + 1][i] > 0) && (arr[j][i] == arr[j + 1][i])) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
    static void drop(int n) {
        temp = new int[n][n];

        for(int col = 0; col < n; col++) {
            int cnt = n - 1;
            for(int row = n - 1; row >= 0; row--) {
                if(arr[row][col] == 0) continue;

                temp[cnt--][col] = arr[row][col];
            }
        }

        copy(n, temp);
    }
    static void bomb(int row, int col, int n, int num) {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if((i == row || j == col) && Math.abs(i - row) + Math.abs(j - col) < num) {
                    arr[i][j] = 0;
                }
            }
        }
    }
    static void copy(int n, int[][] temp) {

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }
}