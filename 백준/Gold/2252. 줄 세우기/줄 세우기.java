import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] al = new ArrayList[N + 1];
        int[] sorted = new int[N + 1];
        for (int i = 1; i <= N; i++) al[i] = new ArrayList<Integer>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            al[a].add(b);
            sorted[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (sorted[i] == 0) queue.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int num = queue.poll();
            sb.append(num + " ");
            for (int i = 0; i < al[num].size(); i++) {
                sorted[al[num].get(i)]--;
                if (sorted[al[num].get(i)] == 0) queue.add(al[num].get(i));
            }
        }
        System.out.println(sb);
    }
}