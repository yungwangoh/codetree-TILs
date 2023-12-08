import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(map.containsKey(x)) {
                if(map.get(x) > y) {
                    map.put(x, y);
                }
            } else {
                map.put(x, y);
            }
        }

        long sum = 0;
        for(int x : map.keySet()) {
            sum += map.get(x);
        }

        System.out.println(sum);
    }
}