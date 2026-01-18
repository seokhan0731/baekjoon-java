import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] array = new String[n];

        for (int i = 0; i < n; i++) {
            array[i] = br.readLine();
        }
        Arrays.sort(array, (a, b) -> {
            if (a.length() != b.length()) {
                return a.length() - b.length();
            }
            return a.compareTo(b);
        });

        sb.append(array[0]).append('\n');
        for (int i = 1; i < n; i++) {
            if (!array[i - 1].equals(array[i])) {
                sb.append(array[i]).append('\n');
            }
        }
        System.out.println(sb);
    }
}
