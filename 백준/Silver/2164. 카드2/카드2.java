import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * [기존 코드] deque를 통한 queue 자료 구조 구현
 * 기존 stack, queue 라이브러리 속 add, pop등을 사용하면 deque에 있는 first, last 개념과 헷갈림
 * -> deque 라이브러리 속 메소드 사용 숙달 핊요
 * <p>
 * -----------** deque **-----------
 * 앞이 first, 뒤가 last라고 생각하면 된다.
 * add/push -> offer()
 * pop/remove -> poll()
 * +) 앞/뒤 조회 -> peek()
 * <p>
 * => 스택에서는 Last In First Out -> offerLast(), pollLast()
 * => 큐에서는 First In First Out -> offerLast(), pollFirst()
 * ---------------------------------
 */
public class Main {
    static int popAndChange(Deque<Integer> queue) {
        while (true) {
            if (queue.size() == 1) {
                return queue.peekLast();
            }
            queue.pollFirst();
            queue.offerLast(queue.peekFirst());
            queue.pollFirst();
        }
    }

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.offerLast(i + 1);
        }

        System.out.println(popAndChange(queue));
    }
}

/**
 * [코드 2] 참고용 정도로 생각해둘 것
 * 해당 문제는 구현 외의 수학적 풀이법 존재
 * 귀납법 느낌으로 1부터 10정도까지 진행해보면, 2^k의 꼴에서는 해당 답이 2^k 그대로 도출되고,
 * 2^k+1에서 다시 2로 떨어진 후, 정수가 +1이 되면, 답은 *2씩 되는 경향성을 띈다.
 * 이러한 패턴을 통해, 자료구조를 구현하지 않고 문제에 대한 답 도출 가능
 * <p>
 * => 지금 단계에서는 왜 이런식으로 규칙성을 띄는지 깊게 생각할 필요 X,
 * 노가다 치다가 패턴이 보인다면, 믿고 가는 자세 정도 챙기면 될듯?
 */
//public class Main {
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
//
//        int n = Integer.parseInt(br.readLine());
//
//        int k = 0;
//
//        while (true) {
//            int powNumber = (int) Math.pow(2, k);
//
//            if (n == powNumber) {
//                System.out.println(n);
//                return;
//            }
//
//            if (powNumber > n) {
//                int a = powNumber - n;
//                System.out.println(powNumber-2*a);
//                return;
//            }
//            k++;
//        }
//    }
//}
