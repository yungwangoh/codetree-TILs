import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static TreeSet<Integer> set = new TreeSet<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < m; i++) {
            set.add(i + 1);
        }

        for(int i = 0; i < n; i++) {
            int num = sc.nextInt();

            set.remove(num);

            System.out.println(set.last());
        }
    }
}