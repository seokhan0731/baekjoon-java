import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void controlStack(Stack<Integer> stack, String command) {
        if (command.contains("push")) {
            StringTokenizer st = new StringTokenizer(command);
            st.nextToken();
            Integer pushedNumber = Integer.parseInt(st.nextToken());
            stack.push(pushedNumber);
        }
        if (command.equals("pop")) {
            if (!stack.empty()) {
                Integer popedNumber = stack.pop();
                sb.append(popedNumber);
            } else {
                sb.append(-1);
            }
            sb.append('\n');
        }
        if (command.equals("size")) {
            sb.append(stack.size()).append('\n');
        }
        if (command.equals("empty")) {
            if (!stack.empty()) {
                sb.append(0);
            } else {
                sb.append(1);
            }
            sb.append('\n');
        }
        if (command.equals("top")) {
            if (!stack.empty()) {
                Integer topNumber = stack.peek();
                sb.append(topNumber);
            } else {
                sb.append(-1);
            }
            sb.append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            controlStack(stack, command);
        }
        
        System.out.println(sb);
    }
}
