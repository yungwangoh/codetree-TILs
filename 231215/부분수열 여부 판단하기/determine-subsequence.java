import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static final int MAX = 100000;
    static int[] A = new int[MAX + 1];
    static int[] B = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i <= n; i++) A[i] = sc.nextInt();
        for(int i = 1; i <= m; i++) B[i] = sc.nextInt();

        if(check()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
    static boolean check() {

        int j = 1;
        for(int i = 1; i <= m; i++) {

            while(j <= n && A[j] != B[i]) {
                j++;
            }

            if(j == n + 1) return false;
            else j++;
        }

        return true;
    }
}