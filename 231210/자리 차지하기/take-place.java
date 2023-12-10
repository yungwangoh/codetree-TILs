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

       // for(int i = 0; i < m; i++) arr[i] = i + 1;

        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();

            set.add(num);
        }

        System.out.println(set.size());
    }
}