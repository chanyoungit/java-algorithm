import java.io.*;;
import java.util.*;

class Main {

    static int K;
    static ArrayList<Integer>[] al;
    static int[] value;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        al = new ArrayList[K + 1];
        for (int i = 1; i <= K; i++) {
            al[i] = new ArrayList<>();
        }

        int size = (int) Math.pow(2, K) - 1;
        value = new int[size + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= size; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        search(1, 1, size);

        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < al[i].size(); j++) {
                bw.write(al[i].get(j) + " ");
            }
            bw.write("\n");
        }

        bw.close();
    }

    public static void search(int depth, int start, int end) {
        int mid = (start + end) / 2;
        al[depth].add(value[mid]);

        if (depth == K) {
            return;
        }
        search(depth + 1, start, mid - 1);
        search(depth + 1, mid + 1, end);
    }
}