import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 풀이 2
 * StringBuilder의 reverse()사용
 * reverse()를 사용함으로써, 양옆 대칭을 각각 비교해주는 반복문 사용 필요 X
 * =>가독성 증가 but, 별도의 StringBuilder 생성 비용+toString()호출 비용 등 총 비용은 증가!
 * 
 * +) String은 불변 vs StringBuilder는 가변
 * =>reverse()를 사용하고자하면, StringBuilder 객체 생성 후, toString()을 통해, 뒤집고 String으로 변환 필요!
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }
            String reversed = new StringBuilder(input).reverse().toString();
            if (reversed.equals(input)) {
                sb.append("yes").append('\n');
                continue;
            }
            sb.append("no").append('\n');
        }

        System.out.println(sb);
    }
}


/**
 * 기존 코드
 * 문자열을 입력받아, 대칭의 중앙이 되는 문자를 기준으로 양옆을 비교하여, 하나라도 틀린 경우, false반환
 * false가 반환되지 않았다면, 그대로 true를 반환하게 하여, 팰린드롬수의 진위 여부를 판정
 * 팰린드롬수 알고리즘은 크게 손색이 없지만, 문자열이 길어진다면 .charAt()의 호출 비용까지 고려하여,
 * char[]을 사용하여 직접 접근하여 비교하는 방법이 속도적으로 더 유리
 */
//public class Main {
//    public static void main(String[] args) throws IOException {
/// /        System.setIn(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        while (true) {
//            String input = br.readLine();
//            if (input.equals("0")) {
//                break;
//            }
//
//            int length = input.length();
//            boolean isPalindrome = true;
//            for (int i = 0; i < length / 2; i++) {
//                if (input.charAt(i) != input.charAt(length - i - 1)) {
//                    isPalindrome = false;
//                    break;
//                }
//            }
//            if (!isPalindrome) {
//                sb.append("no").append('\n');
//                continue;
//            }
//            sb.append("yes").append('\n');
//        }
//
//        System.out.println(sb);
//    }
//}
