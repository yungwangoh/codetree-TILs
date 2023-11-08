import java.io.*;
import java.util.*;

public class Main {
    
    static int[][] arr;
    static int[][] temp;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        arr = new int[n][n];
        temp = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < k; i++) {
            bomb(n, m);
            drop(n);

            rotate(n);
            drop(n);

            bomb(n, m);
            drop(n);
            //print(n);
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] > 0) cnt++;
            }
        }

        System.out.println(cnt);
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
    static void bomb(int n, int m) {
        
        for(int col = 0; col < n; col++) {
            for(int row = 0; row < n; row++) {
                if(arr[row][col] == 0) continue;

                int num = arr[row][col];

                int end = idxSearch(row, num, col, n);

                if(end - row + 1 >= m) {
                    initZero(row, end, col);
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
    static void initZero(int start, int end, int col) {

        for(int i = start; i <= end; i++) {
            arr[i][col] = 0;
        }
    }
    static int idxSearch(int start, int curNum, int col, int n) {

        int end = start + 1;

        while(end < n) {
            if(arr[end][col] == curNum) {
                end++;
            } else break;
        }

        return end - 1;
    }
    static void rotate(int n) {
        temp = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                temp[i][j] = arr[n - j - 1][i];
            }
        }

        copy(n, temp);
    }
    static void print(int n) {
         for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}