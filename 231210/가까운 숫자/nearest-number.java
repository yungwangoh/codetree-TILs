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

        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        set.add(0);

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            
            if(set.higher(arr[i]) != null) {
                min = Math.min(min, set.higher(arr[i]) - arr[i]);
            }

            min = Math.min(min, arr[i] - set.lower(arr[i]));

            set.add(arr[i]);
            System.out.println(min);
        }
    }
}