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

        int[] index = new int[N];
        index[0] = 0;
        for (int i = 1; i < N; i++) {
            if (sort_arr[i] == sort_arr[i - 1]) {
                index[i] = index[i - 1];
            } else {
                index[i] = index[i - 1] + 1;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (map.containsKey(sort_arr[i])) continue;
            map.put(sort_arr[i], index[i]);
        }

        for (int i = 0; i < N; i++) {
            bw.write(map.get(arr[i]) + " ");
        }

        bw.close();
    }
}