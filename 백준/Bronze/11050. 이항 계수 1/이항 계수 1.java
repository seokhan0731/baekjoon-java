import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int productOfNumerator = 1;
        int productOfDenominator = 1;
        for (int i = k; i > 0; i--) {
            productOfNumerator *= n;
            productOfDenominator *= i;
            n--;
        }
        System.out.println(productOfNumerator / productOfDenominator);
    }
}