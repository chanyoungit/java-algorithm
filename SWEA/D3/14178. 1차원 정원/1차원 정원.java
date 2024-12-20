import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int range = M * 2 + 1;

			int result = N / range;
			if (N % range != 0)
				result += 1;

			int seq = i + 1;
			bw.write("#" + seq + " " + result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}