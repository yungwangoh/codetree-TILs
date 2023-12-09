import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static final int MAX_N = 100000;
    static final int MAX_K = 100000;
    static int[] a = new int[MAX_K + 1];
    static int[] b = new int[MAX_K + 1];
    static int[] arr = new int[MAX_N + 1];
    static int[] ans = new int[MAX_N + 1];
    static Set<Integer>[] set = new HashSet[MAX_N + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < k; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            set[i] = new HashSet<>();
        }

        for(int i = 1; i <= n; i++) {
            arr[i] = i;
            set[i].add(i);
            ans[i] = 1;
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < k; j++) {

                int tmp = arr[a[j]];
                arr[a[j]] = arr[b[j]];
                arr[b[j]] = tmp;

                if(!set[arr[a[j]]].contains(a[j])) {
                    set[arr[a[j]]].add(a[j]);
                    ans[arr[a[j]]]++;
                }

                if(!set[arr[b[j]]].contains(b[j])) {
                    set[arr[b[j]]].add(b[j]);
                    ans[arr[b[j]]]++;
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            System.out.println(ans[i]);
        }
    }
}