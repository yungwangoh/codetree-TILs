import java.io.*;
import java.util.*;

public class Main {

    static int n, m, max = Integer.MIN_VALUE;
    static final int MX = 20;
    static int[] arr = new int[MX];
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        func(0, 0);

        System.out.println(max);
    }
    static void func(int idx, int cnt) {
        if(idx == n) {
            if(cnt == m) {
                max = Math.max(max, xor());
            }
            return;
        }

        list.add(arr[idx]);
        func(idx + 1, cnt + 1);
        list.remove(list.size() - 1);

        func(idx + 1, cnt);
    }
    static int xor() {

        int sum = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            sum ^= list.get(i);
        }

        return sum;
    }
}