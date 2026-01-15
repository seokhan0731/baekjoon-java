import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int findMax(int[] arr, int goal) {
        int length = arr.length;
        int sum = 0;
        int max = 0;
        for (int i = 0; i < length - 2; i++) {
            for (int k = i + 1; k < length - 1; k++) {
                for (int j = k + 1; j < length; j++) {
                    sum = arr[i] + arr[k] + arr[j];
                    if (max < sum && sum <= goal) {
                        max = sum;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = findMax(arr, m);
        sb.append(max);
        System.out.println(sb);
    }
}
