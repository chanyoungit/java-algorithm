import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sort_arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            sort_arr[i] = num;
        }

        Arrays.sort(sort_arr);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(sort_arr[i])) {
                map.put(sort_arr[i], rank++);
            }
        }

        for (int i = 0; i < N; i++) {
            bw.write(map.get(arr[i]) + " ");
        }

        bw.close();
    }
}