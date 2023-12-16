import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static final int MAX = 100000;
    static int[] arr = new int[MAX + 1];
    static TreeSet<Integer> set = new TreeSet<>();
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 1; i <= n; i++) arr[i] = sc.nextInt();

        Arrays.sort(arr, 1, n + 1);

        int j = n;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {

            if(i < j) {
                min = Math.min(min, Math.abs(arr[i] + arr[j]));
            }

            while(i < j && arr[i] + arr[j] > 0) {
                j--;
                min = Math.min(min, Math.abs(arr[i] + arr[j]));
            }
        }

        System.out.println(min);
    }
}