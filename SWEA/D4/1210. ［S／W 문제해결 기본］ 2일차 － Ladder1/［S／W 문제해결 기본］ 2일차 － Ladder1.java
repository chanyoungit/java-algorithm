import java.io.*;
import java.util.*;

class Solution {
	static int[] dx = {0,0,1};
	static int[] dy = {1,-1,0};
	static int[][] arr;
	static boolean[][] visited;
	static int answer;
	static int result;
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = 10;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int t = Integer.parseInt(br.readLine());
			arr = new int[100][100];
			for (int i=0; i<100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = 0;
			result = -1;
			for (int i =0; i<100; i++) {
				if (arr[0][i] == 1) {
					visited = new boolean[100][100];
					visited[0][i] = true;
					dfs(0, i);
					
					if (result != -1) {
						answer = i;
						break;
					}
				}
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int a, int b) {
		
		if (a == 99) {
			if (arr[a][b] == 2) {
				result = 2;
			}
		}
		
		for (int i=0; i<3; i++) {
			
			int x = a + dx[i];
			int y = b + dy[i];
			
			if (x>= 0 && y>=0 && x<100 && y<100) {
				if (!visited[x][y] && arr[x][y] == 1 || arr[x][y] == 2) {
					visited[x][y] = true;
					dfs(x,y);
					break;
				}
			}
		}
	}
}