import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 기존 풀이. 바텀업 방식의 dp 사용
 * 결국 dp[n]으로 가는 방식은 두 가지가 존재한다.
 * n, n-1, n-3 or n, n-2(이 경우는 전 계단이 어디든 상관이 없음)
 * 이에 따라 계단의 점수 최댓값의 점화식은,
 *  dp[n]=max(score(i-1)+dp[i-3], dp[i-2])+score(n)과 같다.
 *
 *  0번째 계단은 계단으로 치지 않기 때문에,
 *  idx=3부터 해당 점화식은 유효하게 동작할 수 있다.
 *  전자의 경우에는 0칸 2칸 3칸/ 후자의 경우에는 0칸 1칸 3칸으로 점화식이 성립한다.
 *
 *  이에 따라, n<3인 경우를 dp.length<4로 예외 처리를 한 후, idx=1, 2값을 dp[]에 초기값으로 할당하여, 점화식을 돌렸다
 *
 *  +) 처음에는 score[]와 dp[] 두 개의 배열을 만들기 싫어, dp[] 하나만으로 누적연산자를 사용하여 동작시키고자 했지만,
 *  누적합이 진행 중, 중복으로 더해지는 문제가 생겨, score[]라는 별도의 점수만을 저장하는 배열을 생성할 수 밖에 없었다.
 *      또한, dp로 사용하는 값이 n-2, n-3이기 때문에, 굳이 배열을 만들지 않고, 변수 2개를 갱신하는 방식으로 접근해보고자 했지만,
 *      n-2, n-3을 통해 구한 값을 잠깐 저장해둘 공간이 없기 때문에, 변수 2개로는 불가능하다는 사실을 깨닫고, dp[]를 만들 수 밖에 없었다.
 *      => 변수 3개면 가능하다는 것을 깨달았고, 이것은 슬라이딩 윈도우 기법으로 불린다는 것을 깨달았음.
 */
public class Main {
    static int getMaxScore(int[] dp, int[] score) {
        if (dp.length < 4) {
            return Arrays.stream(score).sum();
        }

        dp[1] = score[1];
        dp[2] = dp[1] + score[2];

        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(score[i - 1] + dp[i - 3], dp[i - 2]) + score[i];
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i < score.length; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(getMaxScore(dp, score));
    }

}
