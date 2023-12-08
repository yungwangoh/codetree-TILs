import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String s = sc.next();

            String convertString = sort(s);
            map.put(convertString, map.getOrDefault(convertString, 0) + 1);
        }

        int max = 0;
        for(String s : map.keySet()) {
            max = Math.max(max, map.get(s));
        }

        System.out.println(max);
    }
    static String sort(String s) {

        char[] ch = new char[s.length()];

        ch = s.toCharArray();

        Arrays.sort(ch);

        return String.valueOf(ch);
    }
}