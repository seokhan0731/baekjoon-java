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
        int n = Integer.parseInt(st.nextToken());   //가로
        int m = Integer.parseInt(st.nextToken());   //세로

        boolean[][] board = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int k = 0; k < m; k++) {
                if (line.charAt(k) == 'B') {
                    board[i][k] = true;
                    continue;
                }
                board[i][k] = false;
            }
        }

        int min = 65;
        for (int i = 0; i <= n - 8; i++) {
            for (int k = 0; k <= m - 8; k++) {
                int count = 0;

                for (int x = i; x < i + 8; x++) {
                    for (int y = k; y < k + 8; y++) {
                        if ((x + y) % 2 == 0) {
                            if (!board[x][y]) {
                                count++;
                            }
                            continue;
                        }
                        if (board[x][y]) {
                            count++;
                        }
                    }

                }
                if (Math.min(count, 64 - count) < min) {
                    min = Math.min(count, 64 - count);
                }
            }

        }
        System.out.println(min);
    }

}