import java.io.*;
import java.util.*;

class Main {

	static int[][] arr;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][0] = arr[0][0];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j == 0)
					dp[i][j] = arr[i][j];
				else {
					dp[i][j] = dp[i][j - 1] + arr[i][j];
				}
			}
		}

		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 4; j++) {
				if (j == 0)
					x1 = Integer.parseInt(st.nextToken());
				else if (j == 1)
					y1 = Integer.parseInt(st.nextToken());
				else if (j == 2)
					x2 = Integer.parseInt(st.nextToken());
				else
					y2 = Integer.parseInt(st.nextToken());

			}
			
			bw.write(check(x1-1,y1-1,x2-1,y2-1) + "\n");
		}

		bw.close();
	}
	
	public static int check(int x1, int y1, int x2, int y2) {
		int answer = 0;
		
		for (int i=x1; i<=x2; i++) {
			answer += dp[i][y2];
		}
		if (y2 == 0) return answer;
		if (y1 == 0) return answer;
		
		for (int i=x1; i<=x2; i++) {
			answer -= dp[i][y1-1];
		}
		
		return answer;
	}
}