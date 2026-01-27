import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static final StringBuilder sb = new StringBuilder();
    static HashMap<Integer, Integer> myMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] myCard = new int[n];
        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(st.nextToken());
            if (myMap.containsKey(card)) {
                myMap.put(card, myMap.get(card) + 1);
                continue;
            }
            myMap.put(card, 1);
            myCard[i] = card;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (myMap.containsKey(target)) {
                sb.append(myMap.get(target)).append(' ');
                continue;
            }
            sb.append(0).append(' ');
        }

        System.out.println(sb);
    }
}