import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static final int MAX = 500;
    static String[] A = new String[MAX + 1];
    static String[] B = new String[MAX + 1];
    static Set<String> ASet = new HashSet<>();
    static Set<String> BSet = new HashSet<>();
    static Set<String> CSet = new HashSet<>();
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();


        for(int i = 0; i < n; i++) {
            A[i] = sc.next();
        }
        for(int i = 0; i < n; i++) {
            B[i] = sc.next();
        }

        int cnt = 0;

        for(int j = 0; j < m; j++) {
            for(int k = j + 1; k < m; k++) {
                for(int l = k + 1; l < m; l++) {
                    if(func(j, k, l)) cnt++;
                }
            }
        }


        System.out.println(cnt);
    }
    static boolean func(int j, int k, int l) {
         set.clear();

        for(int i = 0; i < n; i++) {
            String tmpA = String.valueOf(A[i].charAt(j)) + String.valueOf(A[i].charAt(k)) + String.valueOf(A[i].charAt(l));
            set.add(tmpA);
        }

        for(int i = 0; i < n; i++) {
            String tmpB = String.valueOf(B[i].charAt(j)) + String.valueOf(B[i].charAt(k)) + String.valueOf(B[i].charAt(l));
            if(set.contains(tmpB)) return false;
        }

        return true;
    }
}