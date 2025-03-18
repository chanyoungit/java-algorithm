import java.io.*;
import java.util.*;

// map.put(str, map.getOrDefault(str, 0) + 1);
// ArrayList<String> al = new ArrayList<>(map.keySet());
// ArrayList<Integer> al = new ArrayList<>(map.values());
// Collections.sort(al, new Comparator<String>() { ... return o1.compareTo(o2)};
// String str = String.valueOf(ch).repeat(5);
// int[] alpha = new int[26];

//value = value.substring(0, value.length() - 1);
//value = new StringBuilder(value).reverse().toString();

// public int compare(Node o1, Node o2) {
//    return Double.compare(o1.weight, o2.weight);
// }

// Arrays.sort(a, Collections.reverseOrder())

// Lower Bound -> LIS
//while (s < e) {
//    int mid = (s + e) / 2;
//    if (al.get(mid) >= num) {
//        e = mid;
//    } else {
//        s = mid + 1;
//    }
//}
// al.set(e, num);

// Math.round(num1 * 100.0) / 100.0 -> 3.14
// bw.write(String.format("%02d:%02d\n", leadTime1 / 60, leadTime1 % 60));
// IFNULL(name, 'park') AS name, WHERE NAME IS NOT NULL, COUNT(DISTINCT NAME)


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        Integer[] box = new Integer[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(crane, Collections.reverseOrder());
        Arrays.sort(box, Collections.reverseOrder());

        ArrayList<Integer> boxList = new ArrayList<>(Arrays.asList(box));
        int answer = 0;

        if (crane[0] < boxList.get(0)) {
            bw.write("-1");
            bw.close();
            return ;
        }

        while (!boxList.isEmpty()) {
            int boxIndex = 0;

            for (int i = 0; i < N; i++) {
                while (boxIndex < boxList.size()) {
                    if (crane[i] >= boxList.get(boxIndex)) {
                        boxList.remove(boxIndex);
                        break;
                    }
                    boxIndex++;
                }
            }

            answer++;
        }

        bw.write(answer + "");

        bw.close();
    }
}