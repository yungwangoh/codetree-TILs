import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] arr = {5, 2};
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int cnt = 0;
        for(int i = 0; i < 2; i++) {
            cnt += (n / arr[i]);

            n %= arr[i];
        }

        if(n == 1) cnt = -1;
        System.out.println(cnt);
    }
}