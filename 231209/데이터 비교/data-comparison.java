import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static final int MAX = 100000;
    static int[] arr = new int[MAX + 1];
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i = 0; i < n; i++) set.add(sc.nextInt());
        m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < m; i++) {
            if(set.contains(arr[i])) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
        System.out.println();
    }
}