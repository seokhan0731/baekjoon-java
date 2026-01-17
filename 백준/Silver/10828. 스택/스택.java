import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int size = 0;

    static void controlStack(int[] stack, String command) {

        if (command.contains("push")) {
            StringTokenizer st = new StringTokenizer(command);
            st.nextToken();
            int pushedNumber = Integer.parseInt(st.nextToken());
            stack[size] = pushedNumber;
            size++;
        }
        if (command.equals("pop")) {
            if (size != 0) {
                Integer popedNumber = stack[size - 1];
                sb.append(popedNumber);
                size--;
            }
            else {
                sb.append(-1);
            }
            sb.append('\n');
        }
        if (command.equals("size")) {
            sb.append(size).append('\n');
        }
        if (command.equals("empty")) {
            if (size != 0) {
                sb.append(0);
            }
            else {
                sb.append(1);
            }
            sb.append('\n');
        }
        if (command.equals("top")) {
            if (size != 0) {
                Integer topNumber = stack[size - 1];
                sb.append(topNumber);
            }
            else {
                sb.append(-1);
            }
            sb.append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] stack = new int[n];
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            controlStack(stack, command);
        }
        System.out.println(sb);
    }
}
