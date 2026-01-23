import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Member {
        int age;
        String name;
        int signUpOrder;

        public Member(int age, String name, int signUpOrder) {
            this.age = age;
            this.name = name;
            this.signUpOrder = signUpOrder;
        }
    }

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Member[] array = new Member[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            array[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken(), i);
        }

        Arrays.sort(array, (a, b) -> {
            if (a.age != b.age) {
                return Integer.compare(a.age, b.age);
            }
            return Integer.compare(a.signUpOrder, b.signUpOrder);
        });

        for(int i=0;i<n;i++){
            sb.append(array[i].age)
                    .append(' ')
                    .append(array[i].name)
                    .append('\n');
        }
        System.out.println(sb);
    }
}