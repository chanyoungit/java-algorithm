import java.io.*;
import java.util.*;

// map.put(str, map.getOrDefault(str, 0) + 1);
// ArrayList<String> al = new ArrayList<>(map.keySet());
// ArrayList<Integer> al = new ArrayList<>(map.values());
// Collections.sort(al, new Comparator<String>() { ... return o1.compareTo(o2)};

public class Main {

    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] weight = new long[N];
        long[] len = new long[N - 1];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            len[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weight[i] = Long.parseLong(st.nextToken());
        }

        long answer = 0;
        for (int i = 0; i < N - 1; i++) {

            if (!visit[i]) {
                visit[i] = true;
                long sum = len[i];

                for (int j = i + 1; j < N - 1; j++) {
                    if (weight[i] < weight[j]) {
                        visit[j] = true;
                        sum += len[j];
                    } else {
                        break;
                    }
                }

                answer += weight[i] * sum;
            }
        }

        bw.write(answer + "");
        bw.close();
    }
}