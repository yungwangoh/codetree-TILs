import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static final int MAX = 100000;
    static int[] arr = new int[MAX + 1];
    static int[] count = new int[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int j = 0;
        int max = 0;
        for(int i = 1; i <= n; i++) {

            while(j + 1 <= n && count[arr[j + 1]] != 1) {
                count[arr[j + 1]]++;
                j++;
            }

            max = Math.max(max, j - i + 1);

            count[arr[i]]--;
        }

        System.out.println(max);
    }
}