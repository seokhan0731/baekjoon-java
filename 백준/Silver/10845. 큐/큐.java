import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 기존 코드
 * Deque를 사용하여, offer, poll, peek를 통한 큐 자료구조 구현
 * 큐이기 때문에, last 위치에 push, first 위치에서 pop 진행
 *
 * 지금 현재 코드에서는 push 명령어만 "push n"꼴로 push 명령어가 들어오는 경우 StringTokenizer 객체를
 * 매번 생성하지만, 굳이 그럴 필요 없이 첫 nextTOken()에서 명령어를 받고 push인 경우에만 nextToken()으로 한번만
 * 더 넘겨주는 방식으로 하면 최적화 가능
 * +) switch나 equals로 통일하는 것이 코드 개선 방향성에서 더 유리
 *      cuz push_back같은 명령어가 추가 되었을 때, .contains("push")는 이걸 걸러내지 못하기 때문
 */
public class Main {

    static final Deque<Integer> queue = new ArrayDeque<>();
    static final StringBuilder sb = new StringBuilder();

    static void controlQueue(String command) {
        if (command.contains("push")) {
            StringTokenizer st = new StringTokenizer(command);
            st.nextToken();
            int pushedNumber = Integer.parseInt(st.nextToken());
            queue.offerLast(pushedNumber);
        }
        if (command.equals("pop")) {
            if (queue.isEmpty()) {
                sb.append(-1).append('\n');
                return;
            }
            sb.append(queue.pollFirst()).append('\n');
        }
        if (command.equals("size")) {
            sb.append(queue.size()).append('\n');
        }
        if (command.equals("empty")) {
            if (queue.isEmpty()) {
                sb.append(1).append('\n');
                return;
            }
            sb.append(0).append('\n');
        }
        if (command.equals("front")) {
            if (queue.isEmpty()) {
                sb.append(-1).append('\n');
                return;
            }
            sb.append(queue.peekFirst()).append('\n');
        }
        if (command.equals("back")) {
            if (queue.isEmpty()) {
                sb.append(-1).append('\n');
                return;
            }
            sb.append(queue.peekLast()).append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            controlQueue(command);
        }
        System.out.println(sb);
    }


}
