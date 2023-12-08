import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();

            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int i = 0; i < m; i++) {
            int num = sc.nextInt();

            System.out.print(map.getOrDefault(num, 0) + " ");
        }
    }
}