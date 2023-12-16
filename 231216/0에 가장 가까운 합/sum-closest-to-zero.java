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

        int j = n;
        int sum = 0;
        for(int i = 1; i <= n; i++) {

            while(j != 1 && Math.abs(arr[i] + arr[j]) > 0) {
                set.add(Math.abs(arr[i] + arr[j]));
                j--;
            }

            if(j <= i) break;
        }

        System.out.println(set.higher(0));
    }
}