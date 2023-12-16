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
        int min = Math.abs(arr[1] + arr[n]);
        for(int i = 1; i <= n; i++) {

            while(j != i && arr[i] + arr[j] > 0) {
                int sum = Math.abs(arr[i] + arr[j]);
                //System.out.println(sum);
                min = Math.min(min, sum);
                j--;
            }

            if(j <= i) break;

            if(arr[i] + arr[j] < 0) {
                int sum = Math.abs(arr[i] + arr[j]);
                min = Math.min(min, sum);
            } else if(arr[i] + arr[j] == 0){
                min = 0;
            }
        }

        System.out.println(min);
    }
}