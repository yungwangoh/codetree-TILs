import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static int n;
    static Map<String, Integer> m = new TreeMap<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            String s = sc.next();

            m.put(s, m.getOrDefault(s, 0) + 1);
        }

        Iterator<Entry<String, Integer>> it = m.entrySet().iterator();

        double ratio = (double) 100 / n;
        while(it.hasNext()) {
            Entry<String, Integer> entry = it.next();
            System.out.printf("%s %.4f\n", entry.getKey(), ratio * (double) entry.getValue());
        }
    }
}