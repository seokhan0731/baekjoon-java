import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 리팩토링 코드(정석) -> 스택 이용
 * <p>
 * 기존의 코드는 내부의 어떤 것이 들어오는지 모르는 상태로 +-1 진행(순서와 종류 구분 불가)
 * => 만약 여러 가지 문자가 들어오는 경우, 내용물을 모르기 때문에 정상적 로직 수행 불가
 * Ex. 반례: "([)]" -> 개수가 맞아서 통과시키지만, 실제로는 순서가 꼬여서 틀린 문자열
 * <p>
 * 스택 이용 -> 가장 최근에 push된 문자 확인 가능 -> 종류가 여러개여도 로직 수행 가능
 */
public class Main {

    static boolean isVps(String ps) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < ps.length(); i++) {
            if (ps.charAt(i) == '(') {
                stack.push('(');
                continue;
            }

            if (stack.empty()) {
                return false;
            }
            stack.pop();
        }

        return stack.empty();
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
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

/**
 * 기존 코드(엘리베이터 로직?)
 * 결국 해당 문제는 두 가지 조건을 만족 해야한다.
 * <p>
 * 1) '('와 ')'의 총 개수는 일치해야 한다. -> 문자열이 끝난 시점의 count==0 성립해야함
 * 2) 올바른 순서로 두 괄호가 위치해야 한다. -> 결국 ')'가 먼저 위치하는 것이 틀린 경우로, count>=0 성립해야함
 *
 */
//public class Main {
//
//    static boolean isVps(String ps) {
//        int count = 0;
//        for (int i = 0; i < ps.length(); i++) {
//            if (ps.charAt(i) == '(') {
//                count++;
//                continue;
//            }
//
//            count--;
//            if (count < 0) {
//                return false;
//            }
//        }
//        return count == 0;
//    }
//
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
//        StringBuilder sb = new StringBuilder();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        for (int i = 0; i < n; i++) {
//            String ps = br.readLine();
//            sb.append(isVps(ps) ? "YES\n" : "NO\n");
//        }
//
//        System.out.println(sb);
//    }
//}
