import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static final int MAX = 1000;
    static int[] arr = new int[MAX + 1];
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            
            if(!map.containsKey(arr[i])) map.put(arr[i], 1);
            else map.put(arr[i], map.get(arr[i]) + 1);
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {

            if(!map.containsKey(arr[i])) map.put(arr[i], -1);
            else map.put(arr[i], map.get(arr[i]) - 1);
            
            for(int j = 0; j < i; j++) {

                int tmp = k - (arr[i] + arr[j]);

                if(map.containsKey(tmp)) {
                    ans += map.get(tmp);
                }
            }
        }

        System.out.println(ans);
    }
}