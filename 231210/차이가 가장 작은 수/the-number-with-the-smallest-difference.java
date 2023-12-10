import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static final int MAX = 100000;
    static int[] arr = new int[MAX + 1];
    static TreeSet<Integer> set = new TreeSet<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            set.add(arr[i]);
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int x = arr[i];

            if(set.ceiling(m + x) != null) {
                min = Math.min(min, set.ceiling(m + x) - x);
            } 

            if(set.floor(x - m) != null)
                min = Math.min(min, x - set.floor(x- m));
        }

        if(min == Integer.MAX_VALUE) min = -1;

        System.out.println(min);
    }
}