import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static final int numberOfSize = 6;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[numberOfSize];
        for (int i = 0; i < numberOfSize; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i = 0; i < numberOfSize; i++) {
            int k = 0;
            while (true) {
                if (k * t >= array[i]) {
                    sum += k;
                    break;
                }
                k++;
            }
        }
        sb.append(sum).append('\n');
        sb.append(n / p).append(' ').append(n % p);

        System.out.println(sb);
    }
}