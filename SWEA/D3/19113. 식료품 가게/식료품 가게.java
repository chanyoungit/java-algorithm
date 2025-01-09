import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int t = 0; t < TC; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[2 * N + 1];
			boolean[] visit = new boolean[2 * N + 1];

			int index = t + 1;
			sb.append("#").append(index).append(" ");

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= 2 * N; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= 2*N; i++) {
				if (!visit[i]) {
					visit[i] = true;
					int k = arr[i] + arr[i] / 3;
					for (int j = i + 1; j <= arr.length; j++) {
						if (k == arr[j] && !visit[j]) {
							visit[j] = true;
							sb.append(arr[i]).append(" ");
							break;
						}
					}
				}
			}
			
			bw.write(sb.toString() + "\n");
			sb.setLength(0);
		}

		bw.flush();
		bw.close();
		br.close();
	}
}