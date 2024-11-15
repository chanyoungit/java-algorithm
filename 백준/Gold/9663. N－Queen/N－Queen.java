import java.io.*;

public class Main {

    static int[] arr;
    static int N;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        answer = 0;

        check(0);

        bw.write(answer + "");
        bw.close();
    }

    public static void check(int depth) {
        if (depth == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (isPossible(depth)) {
                check(depth + 1);
            }
        }
    }

    public static boolean isPossible(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[i] == arr[depth]) {
                return false;
            }

            if (Math.abs(i - depth) == Math.abs(arr[i] - arr[depth])) {
                return false;
            }
        }

        return true;
    }
}