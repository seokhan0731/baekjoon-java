import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Vector<Integer> makeSumVector(int[] arr) {
        Vector<Integer> sumVector = new Vector<>();
        int length = arr.length;
        for (int i = 0; i < length - 2; i++) {
            for (int k = i + 1; k < length - 1; k++) {
                for (int j = k + 1; j < length; j++) {
                    sumVector.add(arr[i] + arr[k] + arr[j]);
                }
            }
        }
        Collections.sort(sumVector);
        return sumVector;
    }

    static int findSumClosetToGoal(Vector<Integer> sumVector, int goal) {
        int i = sumVector.size();
        while (true) {
            if (goal >= sumVector.get(i - 1)) {
                break;
            }
            i--;
        }
        return sumVector.get(i - 1);
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Vector<Integer> sumVector = makeSumVector(arr);
        int sumClosetToGoal = findSumClosetToGoal(sumVector, m);
        sb.append(sumClosetToGoal);
        System.out.println(sb);
    }
}
