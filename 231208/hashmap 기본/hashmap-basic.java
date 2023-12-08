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
            String s = sc.next();
            int k = sc.nextInt();

            if(s.equals("add")) {
                int v = sc.nextInt();
                add(k ,v);
            } else if(s.equals("find")) {
                int v = map.getOrDefault(k, 0);

                if(v == 0) System.out.println("None");
                else System.out.println(v);

            } else if(s.equals("remove")) {
                remove(k);
            }
        }
    }
    static void add(int k, int v) {
        map.put(k ,v);
    }
    static void remove(int k) {
        map.remove(k);
    }
    static int find(int k) {
        return map.get(k);
    }
}