import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 코드 2. 나머지 이용
 * 기존 코드에서의 입력값의 범위가 커짐에 따른 불필요한 비용을 줄이기 위해, 제거 되는 인덱스만을 계산하여 제거하는 방식
 * 나머지를 통한 제거 인덱스 구현    (현재 idx+k-1)/현재 사이즈
 *
 * 순환의 개념이 들어온다면, 나머지수를 이용할 수 있는지를 한번쯤 풀이 구상 단계에서 생각해볼 것!
 * 공식을 구체화할 때는, 마찬가지로 수학적 귀납법 스타일로 직접 몇 개를 구해서 시도해봐야함
 */
public class Main {
    static final StringBuilder sb = new StringBuilder();
    static int n;
    static int k;

    static void makeJosephusPermutation(List<Integer> list) {
        int currentIndex = 0;
        int currentSize = n;
        while (!list.isEmpty()) {
            int removeIndex = (currentIndex + k - 1) % currentSize;

            sb.append(list.remove(removeIndex));
            if (!list.isEmpty()) {
                sb.append(", ");
            }
            currentSize -= 1;
            currentIndex = removeIndex;
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        sb.append('<');
        makeJosephusPermutation(list);
        sb.append('>');

        System.out.println(sb);
    }
}

/**
 * 기존 코드
 * 문제에서 주어진 k번째에 위치한 숫자를 지우면 됨으로, k-1까지는 삭제 후, 뒤에 다시 넣어주고,
 * k번째는 제거하는 방식으로 큐에 모든 원소가 제거될 때까지 행위를 반복하여, 요새푸스 순열을 구현
 * <p>
 * 주어진 k와 n에 대한 범위가 크지 않기 때문에, 문제는 없지만, 범위가 커진다면, k-1까지 제거 후,
 * 다시 넣어주는 과정에 대한 불필요한 비용이 많이 소모
 */
//public class Main2 {
//    static final StringBuilder sb = new StringBuilder();
//    static int k;
//
//    static void makeJosephusPermutation(Deque<Integer> queue) {
//        while (!queue.isEmpty()) {
//            for (int i = 0; i < k - 1; i++) {
//                queue.offerLast(queue.pollFirst());
//            }
//
//            sb.append(queue.pollFirst());
//            if (!queue.isEmpty()) {
//                sb.append(", ");
//                continue;
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        k = Integer.parseInt(st.nextToken());
//
//        Deque<Integer> circularQueue = new ArrayDeque<>();
//
//        for (int i = 0; i < n; i++) {
//            circularQueue.offerLast(i + 1);
//        }
//
//        sb.append('<');
//        makeJosephusPermutation(circularQueue);
//        sb.append('>');
//
//        System.out.println(sb);
//    }
//}