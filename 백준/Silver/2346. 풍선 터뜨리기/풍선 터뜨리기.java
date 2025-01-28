import java.io.*;
import java.util.*;

// map.put(str, map.getOrDefault(str, 0) + 1);
// ArrayList<String> al = new ArrayList<>(map.keySet());
// ArrayList<Integer> al = new ArrayList<>(map.values());
// Collections.sort(al, new Comparator<String>() { ... return o1.compareTo(o2)};

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean[] visit = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            map.put(i, Integer.parseInt(st.nextToken()));
        }

        int idx = 1;
        int cnt = 0;

        while (true) {
            visit[idx] = true;
            sb.append(idx + " ");
            cnt++;

            if (cnt == N) break;

            int value = map.get(idx);

            while (true) {
                if (value > 0) {
                    idx++;
                    if (idx > N) idx = 1;
                    if (!visit[idx]) value--;
                } else if (value < 0) {
                    idx--;
                    if (idx < 1) idx = N;
                    if (!visit[idx]) value++;
                } else {
                    break;
                }

            }
        }

        bw.write(sb.toString());
        bw.close();
    }
}