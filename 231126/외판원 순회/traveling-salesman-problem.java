import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 10;
    static int n, min = Integer.MAX_VALUE;
    static int[][] arr = new int[MAX + 1][MAX + 1];
    static boolean[] visit = new boolean[MAX + 1];
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

        func(0);

        System.out.println(min);
    }
    static void func(int row) {
        
        if(row == n) {

            boolean flag = true;
            for(int i = 0; i < n - 1; i++) {
                if(arr[list.get(i)][list.get(i + 1)] == 0 || 
                arr[list.get(n - 1)][list.get(0)] == 0) flag = false;
            }
            
            if(flag) {
                int sum = 0;
                for(int i = 0; i < n - 1; i++) {
                    sum += arr[list.get(i)][list.get(i + 1)];
                }
                sum += arr[list.get(n - 1)][list.get(0)];
                min = Math.min(min, sum);
                
                // for(int i = 0;  i < n; i++) {
                //     System.out.print(list.get(i) + " ");
                // }
                // System.out.println(sum);
            }
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            list.add(i);
            func(row + 1);
            visit[i] = false;
            list.remove(list.size() - 1);
        }
    }
}