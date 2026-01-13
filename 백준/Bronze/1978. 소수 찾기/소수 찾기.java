import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 리팩토링 코드
 * 1. 약수의 대칭성 이용 -> 소수가 아닌 경우, a*b(a<=b)꼴로 숫자가 표현되는데, 이때 a의 범위는 1<=a<=sqrt(number)
 * =>기존 처음부터 주어진 숫자까지 설정했던 범위를 sqrt(number)와 동일하게 설정
 * <p>
 * 2. 불필요한 배열 제거
 * => 각 요소에 대한 독립적인 판단을 통해 개수를 구하기 때문에, 입력과 동시에 로직을 수행하면 불필요한 배열 필요 X
 */
public class Main {
    static boolean isDecimal(int number) {
        int i = 2;
        while (i * i <= number) {
            if (number % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int decimalCount = 0;
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (number < 2) {
                continue;
            }
            if (isDecimal(number)) {
                decimalCount++;
            }
        }
        sb.append(decimalCount);
        System.out.println(sb);
    }
}


/**
 * 기존 코드
 * 소수 판단 로직
 * 2부터 자기 자신까지 while 루프를 통해, 약수 개수 판단
 * 모든 숫자를 끝까지 루프를 돌아야하므로, 입력이 큰 숫자가 들어오면 비효율적!
 *
 * @param number 입력받은 단일 숫자
 * @return 소수 여부
 */
//public class Main {
//    static boolean isDecimal(int number) {
//        int i = 2;
//        int count = 0;
//        while (i <= number) {
//            if (number % i == 0) {
//                count++;
//            }
//            i++;
//        }
//        if (count == 1) {
//            return true;
//        }
//        return false;
//    }
//
//    public static void main(String[] args) throws IOException {
/// /        System.setIn(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int n = Integer.parseInt(br.readLine());
//        int[] numArray = new int[n];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        for (int i = 0; i < n; i++) {
//            numArray[i] = Integer.parseInt(st.nextToken());
//        }
//
//        int decimalCount = 0;
//        for (int i = 0; i < n; i++) {
//            if (isDecimal(numArray[i])) {
//                decimalCount++;
//            }
//        }
//
//        sb.append(decimalCount);
//        System.out.println(sb);
//    }
//}
