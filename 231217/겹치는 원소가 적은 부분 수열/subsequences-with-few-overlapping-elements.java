import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static final int MAX = 100000;
    static int[] arr = new int[MAX + 1];
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int j = 0;
        int max = 0;
        for(int i = 1; i <= n; i++) {
            
            while(canGo(j)) {
                int key = arr[j + 1];
                map.put(key, map.getOrDefault(key, 0) + 1);

                if(map.get(key) > k) break;

                j++;
            }

            max = Math.max(max, j - i + 1);

            if(map.getOrDefault(arr[i], 0) != 0) map.put(arr[i], map.get(arr[i]) - 1);
        }

        System.out.println(max);
    }
    static boolean canGo(int j) {
        if(j + 1 > n) return false;

        return true;
    }
}