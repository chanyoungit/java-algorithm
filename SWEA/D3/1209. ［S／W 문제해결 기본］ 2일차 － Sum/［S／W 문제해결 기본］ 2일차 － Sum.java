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
			int[][] arr = new int[100][100];
			
			for (int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				
				for (int j=0; j<100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			
			for (int i=0; i<100; i++) {		// 가로
				int sum = 0;
				
				for (int j=0; j<100; j++) {
					sum += arr[i][j];
				}
				
				answer = Math.max(answer, sum);
			}
			
			for (int i=0; i<100; i++) {
				int sum = 0;
				
				for (int j=0; j<100; j++) {
					sum += arr[j][i];
				}
				
				answer = Math.max(answer, sum);
			}
			
			int x = 0;
			int y = 0;
			int sum = 0;
			while (x < 100) {
				sum += arr[x][y];
				x++;
				y++;
			}
			answer = Math.max(answer, sum);
			
			x = 0;
			y = 99;
			sum = 0;
			while (x<100) {
				sum+= arr[x][y];
				x++;
				y--;
			}
			answer = Math.max(answer, sum);
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}