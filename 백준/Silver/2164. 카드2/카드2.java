import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int n = Integer.parseInt(br.readLine());

        int k = 0;

        while (true) {
            int powNumber = (int) Math.pow(2, k);

            if (n == powNumber) {
                System.out.println(n);
                return;
            }

            if (powNumber > n) {
                int a = powNumber - n;
                System.out.println(powNumber-2*a);
                return;
            }
            k++;
        }
    }
}