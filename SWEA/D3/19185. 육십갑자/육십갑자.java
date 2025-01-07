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
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			String[] strN = new String[N + 1];
			String[] strM = new String[M + 1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++)
				strN[i] = st.nextToken();

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++)
				strM[i] = st.nextToken();

			int index = t + 1;
			sb.append("#").append(index).append(" ");

			int Q = Integer.parseInt(br.readLine());
			for (int i = 0; i < Q; i++) {
				int a = Integer.parseInt(br.readLine());

				int modN = a % N;
				int modM = a % M;

				if (modN == 0)
					modN = N;
				if (modM == 0)
					modM = M;

				String result = strN[modN] + strM[modM];
				sb.append(result).append(" ");
			}
			
			bw.write(sb.toString() + "\n");
			sb.setLength(0);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}