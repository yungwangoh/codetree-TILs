import java.io.*;
import java.util.*;

public class Main {

    static int n;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        String initStr = sc.next();
        String destStr = sc.next();

        int cnt = 0;
        boolean flag = false;
        for(int i = 0; i < n; i++) {
            if(initStr.charAt(i) != destStr.charAt(i)) {

                if(!flag) {
                    flag = true;
                    cnt++;
                }
            } else flag = false;
        }

        System.out.println(sum);
    }
}