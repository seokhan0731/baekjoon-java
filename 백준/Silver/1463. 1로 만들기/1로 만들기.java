import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 기존 최적화 풀이
 * dp 사용
 * 바텀업 방식으로 idx=1까지는 수동으로 채운 뒤, 해당 숫자까지의 최소값을 비교하며, 저장한다.
 * 최소값이 되는 경우는 조건적으로 총 3가지이다.
 * 1. d[i]=d[i-1]+1
 * 2. d[i]=d[i/3]+1     3으로 나누어 떨어지는 경우
 * 3. d[i]=d[i/2]+1     2로 나누어 떨어지는 경우
 * <p>
 * <p>
 * 최적화 전 풀이
 * idx=1~3까지 수동으로 채워줬음 -> 2와 3도 결국 1을 만들기 위해 동일한 작업을 수행, 이에 따른 최적화 진행
 * 최소값의 초기값을 n으로 설정 -> 가독성을 위해 array[i-1]+1로 최적화 진행
 * 
 * 
 * +) 처음 이 문제를 접했을 때, 그리디 알고리즘 사용하고자함
 *    cuz 큰 수로 무조건적으로 나누어주는게 가장 최소의 경우의 수를 도출할 줄 알았음
 *      but 큰 수로 나누면, 그 결과값이 /3, /2가 되지 않는 숫자인 경우가 존재하기에,
 *          해당 선택이 최선의 결과를 불러오지 않음(미래에 영향)
 */
public class Main {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n + 1];
        array[1] = 0;

        for (int i = 2; i < n + 1; i++) {
            array[i] = array[i - 1] + 1;
            if (i % 2 == 0) {
                array[i] = Math.min(array[i], array[i / 2] + 1);
            }
            if (i % 3 == 0) {
                array[i] = Math.min(array[i], array[i / 3] + 1);
            }
        }

        System.out.println(array[n]);

    }
}
/**
 * 코드 2
 * dp 사용
 * 탑다운 방식으로, n부터 메모이제이션 이용하여, 하위 요소들을 재귀로 먼저 구한 후, 최종적으로 답을 도출
 * 최소가 되는 경우의 수는 조건부 3가지로 바텀업 방식과 동일
 * <p>
 * 동작은 하지만, 재귀함수의 호출비용, Integer로서의 객체 생성 비용 등에 따라, 시간 초과 발생
 * ->int[]배열로 변환(null->0), 그래도 시간 초과
 */
//public class Main2 {
//    static int getMinByRecursion(int n, int[] array) {
//        if (n == 1) {
//            return 0;
//        }
//        if (array[n] != 0) {
//            return array[n];
//        }
//
//        array[n] = getMinByRecursion(n - 1, array) + 1;
//
//        if (n % 2 == 0) {
//            array[n] = Math.min(array[n], getMinByRecursion(n / 2, array) + 1);
//        }
//        if (n % 3 == 0) {
//            array[n] = Math.min(array[n], getMinByRecursion(n / 3, array) + 1);
//        }
//
//        return array[n];
//    }
//
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//
//        int[] array = new int[n + 1];
//
//
//        System.out.println(getMinByRecursion(n, array));
//    }
//}
