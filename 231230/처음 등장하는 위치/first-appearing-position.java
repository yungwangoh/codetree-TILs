import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {

    static int n;
    static Map<Integer, Integer> m = new TreeMap<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int nn = sc.nextInt();

            if(!m.containsKey(nn)) m.put(nn, i + 1);
        }

        Iterator<Entry<Integer, Integer>> it = m.entrySet().iterator();

        while(it.hasNext()) {
            Entry<Integer, Integer> entry = it.next();

            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}