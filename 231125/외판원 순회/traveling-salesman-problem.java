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
            for(int i = 0; i < list.size(); i++) {
                if(arr[i][list.get(i)] == 0) flag = false;;
            }
            
            if(flag) {
                int sum = 0;
                for(int i = 0 ; i < list.size(); i++) {
                    sum += arr[i][list.get(i)];
                }

                min = Math.min(min, sum);
            }
            //System.out.println(sum);
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