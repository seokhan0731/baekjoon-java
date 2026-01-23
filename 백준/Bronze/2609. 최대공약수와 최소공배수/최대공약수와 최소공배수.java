import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 코드 2. 유클리드 호제법 및 최소 공배수 공식 사용
 * 공식의 원리보다는 최대공약수, 최소 공배수 이용시, 공식 갖다 쓸 수 있으면 된다.
 *
 * 1. 유클리드 호제법
 * gcd(a,b)=gcd(b,a%b)
 * 이때, a%b==0인 경우 b가 최대 공약수
 *
 * 2. 최소 공배수 공식
 * a*b=gcd*lcm
 * =>lcm=a*b/gcd
 */
public class Main {
    static int getGcd(int bigNumber, int smallNumber) {
        if (bigNumber % smallNumber == 0) {
            return smallNumber;
        }
        return getGcd(smallNumber, bigNumber % smallNumber);
    }

    static int getLcm(int bigNumber, int smallNumber, int gcd) {
        return bigNumber / gcd * smallNumber;   //큰 수*작은 수에서 정수 오버플로우를 고려하여 나누기 먼저 수행
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int smallNumber;
        int bigNumber;

        if (Integer.compare(a, b) > 0) {
            bigNumber = a;
            smallNumber = b;
        }
        else {
            bigNumber = b;
            smallNumber = a;
        }
        int gcd = getGcd(bigNumber, smallNumber);
        int lcm = getLcm(bigNumber, smallNumber, gcd);

        sb.append(gcd).append('\n');
        sb.append(lcm);

        System.out.println(sb);
    }
}


/**
 * 기존 풀이
 * 최대 공약수: 결국 두 수(x, y)에 대해 최대 공약수 a가 존재할 때,
 * x=a*b, y=a*c (b와 c는 1을 제외한 약수 존재 X)
 * => 재귀를 통해 최대 공약수 a
 * <p>
 * 최소 공배수: 최대 약수에서의 a*k꼴에서 큰수의 k가 작은 수의 k로 나누어 떨어진다면,
 * 최소 공배수는 큰 수 그자체가 되고, 그것이 아니라면 최대 공약수*작은 k*큰 k 사실 이용
 * <p>
 * 이 풀이는, 최대 공약수를 구하는 과정에서 모든 경우의 수를 모두 들여다보는 브루트 포스적 성격을 띔
 * => 해당 문제에서는 불필요한 자원 낭비 존재
 */
//public class Main {
//    static int getGcd(int smallNumber, int bigNumber) {
//        int k = 2;
//        while (k <= smallNumber) {
//            if ((smallNumber % k == 0) && (bigNumber % k == 0)) {
//                return k * getGcd(smallNumber / k, bigNumber / k);
//            }
//            k++;
//        }
//        return 1;
//    }
//
//    static int getLcm(int smallNumber, int bigNumber, int gcd) {
//        int x = smallNumber / gcd;
//        int y = bigNumber / gcd;
//        if (y % x == 0) {
//            return bigNumber;
//        }
//        return gcd * x * y;
//    }
//
//    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
//        StringBuilder sb = new StringBuilder();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int a = Integer.parseInt(st.nextToken());
//        int b = Integer.parseInt(st.nextToken());
//
//        int smallNumber;
//        int bigNumber;
//
//        if (Integer.compare(a, b) > 0) {
//            bigNumber = a;
//            smallNumber = b;
//        }
//        else {
//            bigNumber = b;
//            smallNumber = a;
//        }
//        int gcd = getGcd(smallNumber, bigNumber);
//        int lcm = getLcm(smallNumber, bigNumber, gcd);
//
//        sb.append(gcd).append('\n');
//        sb.append(lcm);
//
//        System.out.println(sb);
//    }
//}
