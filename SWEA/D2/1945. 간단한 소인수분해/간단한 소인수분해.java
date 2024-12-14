import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int a = 0, b = 0, c = 0, d = 0, e = 0;

            while (N % 2 == 0) {
                N /= 2;
                a++;
            }
            while (N % 3 == 0) {
                N /= 3;
                b++;
            }
            while (N % 5 == 0) {
                N /= 5;
                c++;
            }
            while (N % 7 == 0) {
                N /= 7;
                d++;
            }
            while (N % 11 == 0) {
                N /= 11;
                e++;
            }

            int index = i + 1;

            System.out.println("#" + index + " " + a + " " + b + " " + c + " " + d + " " + e);
        }
    }
}
