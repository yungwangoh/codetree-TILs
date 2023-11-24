import java.io.*;
import java.util.*;

public class Main {
    
    static final int MAX = 10;
    static int n, min = Integer.MAX_VALUE;
    static int[] a = new int[MAX * 2 + 1];
    static List<Integer> list = new ArrayList<>();
    static int max_sum = 0;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < 2 * n; i++) {
            a[i] = sc.nextInt();
            max_sum += a[i];
        }

        func(0, 0);

        System.out.println(min);
    }
    static void func(int idx, int cnt) {
        if(idx == 2 * n) {
            if(cnt == n) {
                min = Math.min(min, calculate());
            }
            return;
        }

        list.add(a[idx]);
        func(idx + 1, cnt + 1);
        list.remove(list.size() - 1);

        func(idx + 1, cnt);
    }
    static int calculate() {

        int s1 = 0;
        int s2 = 0;
        for(int i = 0; i < list.size(); i++) {
            s1 += list.get(i);
        }

        s2 = max_sum - s1;

        return Math.abs(s1 - s2);
    }
}