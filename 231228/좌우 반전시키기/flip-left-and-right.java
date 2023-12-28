import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static final int MAX = 100;
    static boolean[] check = new boolean[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            int x = sc.nextInt();

            if(x == 0) {
                check[i] = false;
            } else {
                check[i] = true;
            }
        }

        int cnt = 0;
        for(int i = 1; i < n; i++) {
            if(check[i - 1] == false) {
                change(i - 1, i, i + 1);
                cnt++;
            }
        }

        if(check()) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }
    static void change(int pre, int mid, int post) {
        check[pre] = !check[pre];
        check[mid] = !check[mid];
        check[post] = !check[post];
    }
    static boolean check() {
        for(int i = 0; i < n; i++) {
            if(check[i] == false) return false;
        }

        return true;
    }
}