import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    static int popAndChange(Deque<Integer> queue) {
        while (true) {
            if (queue.size() == 1) {
                return queue.getLast();
            }
            queue.pop();
            queue.add(queue.getFirst());
            queue.pop();
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.add(i+1);
        }

        System.out.println(popAndChange(queue));
    }
}