import java.io.*;
import java.util.*;

public class Main {

    static final int MAX_N = 12, MAX_M = 100;
    static int n, m, k, max = Integer.MIN_VALUE;
    static int[] arr = new int[MAX_N + 1];
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        func(0);

        System.out.println(max);
    }
    static void func(int idx) {
        if(idx == n) {
            // for(int i = 0; i < list.size(); i++) {
            //     System.out.print(list.get(i));
            // }
            // System.out.println();
            max = Math.max(max, check());
            return;
        }

        for(int i = 1; i <= k; i++) {
            list.add(i);
            func(idx + 1);
            list.remove(list.size() - 1);
        }
    }
    static int check() {
        int[] accumulate = new int[k + 1];

        for(int i = 1; i <= k; i++) accumulate[i] = 1;
        
        int sum = 0;

        for(int i = 0; i < list.size(); i++) {
            accumulate[list.get(i)] += arr[i];
        }

        for(int i = 1; i <= k; i++) {
            if(accumulate[i] >= m) sum++;
        }

        return sum;
    }
}