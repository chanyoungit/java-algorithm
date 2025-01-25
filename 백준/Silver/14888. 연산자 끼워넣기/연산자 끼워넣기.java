import java.io.*;
import java.util.*;

// map.put(str, map.getOrDefault(str, 0) + 1);
// ArrayList<String> al = new ArrayList<>(map.keySet());
// ArrayList<Integer> al = new ArrayList<>(map.values());
// Collections.sort(al, new Comparator<String>() { ... return o1.compareTo(o2)};

public class Main {

    static int[] arr;
    static int[] cal;
    static int N, answerMax, answerMin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        cal = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }

        answerMax = -1100000000;
        answerMin = Integer.MAX_VALUE;

        dfs(arr[0], 0);

        bw.write(answerMax + "\n");
        bw.write(answerMin + "\n");

        bw.close();
    }

    public static void dfs(int num, int seq) {
        if (seq == N - 1) {
            if (answerMax < num) {
                answerMax = num;
            }
            if (answerMin > num) {
                answerMin = num;
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cal[i] != 0) {
                cal[i] -= 1;
                if (i == 0) {
                    dfs(num + arr[seq + 1], seq + 1);
                } else if (i == 1) {
                    dfs(num - arr[seq + 1], seq + 1);
                } else if (i == 2) {
                    dfs(num * arr[seq + 1], seq + 1);
                } else {
                    dfs(num / arr[seq + 1], seq + 1);
                }
                cal[i] += 1;
            }
        }
    }
}