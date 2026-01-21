import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 코드 2. 비교 연산에 compare 메소드 이용
 * 반환형의 경우는 부호값 변화는 동일
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        for (int i = 0; i < n; i++) {
            sb.append(array[i][0]).append(' ')
                    .append(array[i][1]).append('\n');
        }

        System.out.println(sb);
    }
}

/**
 * 기존 코드
 * 정수 오버플로우를 고려하지 않고 정렬 기준 람다식 작성시, 두 수의 차 이용
 * ->극단적으로 int 자료형의 범위가 차를 했을 때, 넘어간다면 의도하지 않는 결과 출력 가능성 존재
 * => compare 메소드 사용 습관화 필요
 */
//public class Main {
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
//        StringBuilder sb = new StringBuilder();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        int[][] array = new int[n][2];
//
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            array[i][0] = Integer.parseInt(st.nextToken());
//            array[i][1] = Integer.parseInt(st.nextToken());
//        }
//
//        Arrays.sort(array, (a, b) -> {
//            if (a[0] != b[0]) {
//                return a[0] - b[0];
//            }
//            return a[1] - b[1];
//        });
//
//        for(int i=0;i<n;i++){
//            sb.append(array[i][0]).append(' ')
//                    .append(array[i][1]).append('\n');
//        }
//
//        System.out.println(sb);
//    }
//}
