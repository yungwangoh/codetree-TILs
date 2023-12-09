import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i = 0; i < n; i++) set.add(sc.nextInt());
        m = sc.nextInt();
        for(int i = 0; i < m; i++) {

            int num = sc.nextInt();

            if(set.contains(num)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}