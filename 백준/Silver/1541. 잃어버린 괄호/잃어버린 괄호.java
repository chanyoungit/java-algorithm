import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String example = br.readLine();
        String[] str = example.split("-");
        int answer = 0;
        for (int i = 0; i < str.length; i++) {
            int temp = mySum(str[i]);
            if (i == 0) answer += temp;
            else answer -= temp;
        }
        System.out.println(answer);
    }

    public static int mySum(String a) {
        int sum = 0;
        String[] str = a.split("[+]");
        for (int i = 0; i < str.length; i++) {
            sum += Integer.parseInt(str[i]);
        }
        return sum;
    }
}