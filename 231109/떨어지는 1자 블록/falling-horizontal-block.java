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

        for(int row = 0; row < n; row++) {
            boolean flag = false;
            for(int col = k; col <= k + m - 1; col++) {
                if(arr[row][col] == 1) flag = true;
            }

            if(flag) {
                continue;
            } else {
                for(int col = k; col <= k + m - 1; col++) {
                    arr[row][col] = 1;
                }

                if(row == 0) continue;
                else {
                    for(int col = k; col <= k + m - 1; col++) {
                        arr[row - 1][col] = 0;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}