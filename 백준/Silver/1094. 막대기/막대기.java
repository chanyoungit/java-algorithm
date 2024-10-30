import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int X = Integer.parseInt(br.readLine());
        int stick = 64;

        int count = 0;
        while (X != 0) {
            if (stick > X) stick /= 2;
            else {
                X -= stick;
                count++;
            }
        }
        bw.write(count + "");

        bw.close();
        br.close();
    }
}