import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int k;
    int v;

    public Pair(int k, int v) {
        this.k = k;
        this.v = v;
    }

    @Override
    public int compareTo(Pair p) {
        if(p.v == v) return p.k - k;
        return p.v - v;
    }
}
public class Main {

    static int n, m;
    static final int MAX = 100000;
    static List<Pair> list = new ArrayList<>();
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

        for(int num : map.keySet()) {
            list.add(new Pair(num, map.get(num)));
        }

        Collections.sort(list);

        for(int i = 0; i < m; i++) {
            System.out.print(list.get(i).k + " ");
        }
    }
}