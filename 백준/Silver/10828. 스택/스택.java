import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 코드 3. 순수 배열 스택 직접 구현
 * int[] 배열을 사용하여 Integer객체가 아닌 int를 그대로 처리하도록 구현
 * 메모리 및 시간측면에서는 가장 효율적!
 *
 * +) size라는 별도의 커서 기반 구현 방법을 기억할 것!
 * 초창기 배열 구현 로직은 커서 없이 0이 아닌 정수의 입력 조건을 활용하여,
 * 0인 경우, 해당 공간은 비어있고, 배열의 총합이 0인 조건을 통해 stack.isEmpty()를 구현하고자함.
 * => 상당히 비효율적(배열 구현의 이점을 갖다 버리는 것과 여한가지)
 * (커서기반: O(1) vs 초기구현: O(n))
 */
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

/**
 * 코드 2. Deque 사용 버전
 * deque 자체가 stack이랑 queue 특성 동시에 갖고 있으니, 메소드는 크게 다르지 않음
 * stack.empty() 존재 X, isEmpty()로 통일했다정도
 */
//public class Main {
//    static StringBuilder sb = new StringBuilder();
//
//    static void controlStack(Deque<Integer> stack, String command) {
//        if (command.contains("push")) {
//            StringTokenizer st = new StringTokenizer(command);
//            st.nextToken();
//            Integer pushedNumber = Integer.parseInt(st.nextToken());
//            stack.push(pushedNumber);
//        }
//        if (command.equals("pop")) {
//            if (!stack.isEmpty()) {
//                Integer popedNumber = stack.pop();
//                sb.append(popedNumber);
//            } else {
//                sb.append(-1);
//            }
//            sb.append('\n');
//        }
//        if (command.equals("size")) {
//            sb.append(stack.size()).append('\n');
//        }
//        if (command.equals("empty")) {
//            if (!stack.isEmpty()) {
//                sb.append(0);
//            } else {
//                sb.append(1);
//            }
//            sb.append('\n');
//        }
//        if (command.equals("top")) {
//            if (!stack.isEmpty()) {
//                Integer topNumber = stack.peek();
//                sb.append(topNumber);
//            } else {
//                sb.append(-1);
//            }
//            sb.append('\n');
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//
//        Deque<Integer> stack = new ArrayDeque<>();
//
//        for (int i = 0; i < n; i++) {
//            String command = br.readLine();
//            controlStack(stack, command);
//        }
//
//        System.out.println(sb);
//    }
//}

/**
 * 기존 초기 코드(stack 라이브러리 이용)
 * stack은 현시점에서 거의 안 쓰는 라이브러리 중 하나
 * cuz 동기방식으로, 코딩테스트나 지역변수를 주로 사용하는 백엔드 개발에 적합하지 않음
 * (속도만 오래 걸리고, 비효율적) => ArrayDeque로 대체
 */
//public class Main {
//    static StringBuilder sb = new StringBuilder();
//
//    static void controlStack(Stack<Integer> stack, String command) {
//        if (command.contains("push")) {
//            StringTokenizer st = new StringTokenizer(command);
//            st.nextToken();
//            Integer pushedNumber = Integer.parseInt(st.nextToken());
//            stack.push(pushedNumber);
//        }
//        if (command.equals("pop")) {
//            if (!stack.empty()) {
//                Integer popedNumber = stack.pop();
//                sb.append(popedNumber);
//            } else {
//                sb.append(-1);
//            }
//            sb.append('\n');
//        }
//        if (command.equals("size")) {
//            sb.append(stack.size()).append('\n');
//        }
//        if (command.equals("empty")) {
//            if (!stack.empty()) {
//                sb.append(0);
//            } else {
//                sb.append(1);
//            }
//            sb.append('\n');
//        }
//        if (command.equals("top")) {
//            if (!stack.empty()) {
//                Integer topNumber = stack.peek();
//                sb.append(topNumber);
//            } else {
//                sb.append(-1);
//            }
//            sb.append('\n');
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//
//        Stack<Integer> stack = new Stack<>();
//
//        for (int i = 0; i < n; i++) {
//            String command = br.readLine();
//            controlStack(stack, command);
//        }
//
//        System.out.println(sb);
//    }
//}
