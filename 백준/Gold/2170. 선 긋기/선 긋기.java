import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });

        int dy = arr[0][1];        // y축
        int dx = arr[0][0];        // x축
        int dist = dy - dx;

        for (int i = 1; i < arr.length; i++) {
            int x = arr[i][0];
            int y = arr[i][1];

            if (dy > x && dy < y) {
                dist += y - dy;
                dy = y;
            } else if (dy <= x) {
                dist += y - x;
                dx = x;
                dy = y;
            }
        }

        bw.write(dist + "");

        bw.flush();
        bw.close();
        br.close();
    }
}