import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static Map<String, Integer> map = new HashMap<>();
    static Map<Integer, String> map2 = new HashMap<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String s = sc.next();

            map.put(s, i + 1);
            map2.put(i + 1, s);
        }

        for(int i = 0; i < m; i++) {
            String s = sc.next();

            try {
                int num = Integer.parseInt(s);
                System.out.println(map2.get(num));
            } catch(Exception e) {
                System.out.println(map.get(s));
            }
        }
    }
}