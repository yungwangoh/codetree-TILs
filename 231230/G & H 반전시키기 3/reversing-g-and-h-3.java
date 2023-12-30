import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static char[] a;
    static char[] b;
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        a = new char[n];
        b = new char[n];
        char[] aa = sc.next().toCharArray();
        char[] bb = sc.next().toCharArray();

        for(int i = 0; i < n; i++) {
            a[i] = aa[i];
            b[i] = bb[i];
        }

        int cnt = 0;
        boolean flag = false;
        for(int i = 0; i < n; i++) {
            if(a[i] != b[i]) {
                
                if(!flag) {
                    reverse(i);
                    flag = true;
                    cnt++;
                }
            } else {
                flag = false;
            }
        }

        System.out.println(cnt);
    }
    static void reverse(int idx) {
        for(int i = idx; i < idx + 4 && i < n; i++) {
            if(a[i] == b[i]) {
                break;
            } else a[i] = (a[i] == 'G') ? 'H' : 'G';
        }

        // for(int j = 0; j < n; j++) {
        //                 System.out.print(a[j] + " ");
        //             }
        //             System.out.println();
    }
}