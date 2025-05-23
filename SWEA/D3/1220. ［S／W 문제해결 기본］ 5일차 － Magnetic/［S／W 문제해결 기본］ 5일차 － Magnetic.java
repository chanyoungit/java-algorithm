import java.io.*;
import java.util.*;

class Solution {
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = 10;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			int now = 0;
			
			for (int i = 0; i<N; i++) {
				for (int j=0; j<N; j++) {
					
					if (arr[j][i] == 1) {
						now = 1;
					}
					
					if (now == 1 && arr[j][i] == 2) {
						now = 0;
						answer++;
					}
				}
				now = 0;
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}