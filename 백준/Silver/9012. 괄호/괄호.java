import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean isVps(String ps) {
        int count = 0;
        for (int i = 0; i < ps.length(); i++) {
            if (ps.charAt(i) == '(') {
                count++;
                continue;
            }

            count--;
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String ps = br.readLine();
            sb.append(isVps(ps) ? "YES\n" : "NO\n");
        }

        System.out.println(sb);
    }
}
