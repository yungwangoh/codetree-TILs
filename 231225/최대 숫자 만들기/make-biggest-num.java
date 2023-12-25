import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static final int MAX = 50000;
    static Integer[] arr = new Integer[MAX + 1];
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, 0, n, new Comparator<Integer>() {

            @Override
            public int compare(Integer a, Integer b) {

                String s1 = String.valueOf(a);
                String s2 = String.valueOf(b);

                String s3 = new String(s1 + s2);
                String s4 = new String(s2 + s1);

                return s4.compareTo(s3);
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            sb.append(arr[i]);
        }

        System.out.println(sb.toString());
    }
}