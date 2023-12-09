import java.io.*;
import java.util.*;

public class Main {

    static Map<String, Integer> map = new TreeMap<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String s = sc.next();

            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for(String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }
    }
}