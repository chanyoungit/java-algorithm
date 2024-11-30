import java.io.*;
import java.util.*;

class Solution {
	static char[][] ch;
	static int[][] arr;
	static int N;
	static int answer;
	static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	N = Integer.parseInt(br.readLine());
        	ch = new char[N][N];
        	arr = new int[N][N];
        	visited = new boolean[N][N];
        	
        	for (int i=0; i<N; i++) {
        		ch[i] = br.readLine().toCharArray();
        	}
        	
        	numberCheck();
        	
        	answer = 0;
        	for (int i=0; i<N; i++) {
        		for (int j=0; j<N; j++) {
        			if (!visited[i][j] && arr[i][j] == 0) {
        				answer++;
        				answerCheck(i, j);
        			}
        		}
        	}
        	
        	for (int i=0; i<N; i++) {
        		for (int j=0; j<N; j++) {
        			if (!visited[i][j] && arr[i][j] != -1) {
        				answer++;
        			}
        		}
        	}
        	
        	bw.write("#" + test_case + " " + answer + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void answerCheck(int a, int b) {
    	visited[a][b] = true;
    	
    	if (a-1 >= 0 && b-1 >= 0 && !visited[a-1][b-1]) {
			if (arr[a-1][b-1] != 0) {
				visited[a-1][b-1] = true;
			} else {
				answerCheck(a-1, b-1);
			}
		}
		
    	if (b-1 >= 0 && !visited[a][b-1]) {
			if (arr[a][b-1] != 0) {
				visited[a][b-1] = true;
			} else {
				answerCheck(a, b-1);
			}
		}
    	
    	if (a+1 < N && b-1 >= 0 && !visited[a+1][b-1]) {
			if (arr[a+1][b-1] != 0) {
				visited[a+1][b-1] = true;
			} else {
				answerCheck(a+1, b-1);
			}
		}
    	
    	if (a+1 < N && !visited[a+1][b]) {
			if (arr[a+1][b] != 0) {
				visited[a+1][b] = true;
			} else {
				answerCheck(a+1, b);
			}
		}
    	
    	if (a+1 < N && b+1 < N && !visited[a+1][b+1]) {
			if (arr[a+1][b+1] != 0) {
				visited[a+1][b+1] = true;
			} else {
				answerCheck(a+1, b+1);
			}
		}
    	
    	if (b+1 < N && !visited[a][b+1]) {
			if (arr[a][b+1] != 0) {
				visited[a][b+1] = true;
			} else {
				answerCheck(a, b+1);
			}
		}
    	
    	if (a-1 >= 0 && b+1 < N && !visited[a-1][b+1]) {
			if (arr[a-1][b+1] != 0) {
				visited[a-1][b+1] = true;
			} else {
				answerCheck(a-1, b+1);
			}
		}
    	
    	if (a-1 >= 0 && !visited[a-1][b]) {
			if (arr[a-1][b] != 0) {
				visited[a-1][b] = true;
			} else {
				answerCheck(a-1, b);
			}
		}
    }
    
    public static void numberCheck() {		// arr 초기화
    	for (int i=0; i<N; i++) {
    		for (int j=0; j<N; j++) {
    			if (ch[i][j] == '*') {
    				arr[i][j] = -1;
    			} else {
    				if (i-1 >= 0 && j-1 >= 0) {
    					if (ch[i-1][j-1] == '*') arr[i][j]++;
    				}
    				
    				if (j-1 >= 0) {
    					if (ch[i][j-1] == '*') arr[i][j]++;
    				}
    				
    				if (i+1 < N && j-1 >= 0) {
    					if (ch[i+1][j-1] == '*') arr[i][j]++;
    				}
    				
    				if (i+1 < N) {
    					if (ch[i+1][j] == '*') arr[i][j]++;
    				}
    				
    				if (i+1 < N && j+1 < N) {
    					if (ch[i+1][j+1] == '*') arr[i][j]++;
    				}
    				
    				if (j+1 < N) {
    					if (ch[i][j+1] == '*') arr[i][j]++;
    				}
    				
    				if (i-1 >= 0 && j+1 < N) {
    					if (ch[i-1][j+1] == '*') arr[i][j]++;
    				}
    				
    				if (i-1 >= 0) {
    					if (ch[i-1][j] == '*') arr[i][j]++;
    				}
    			}
    		}
    	}
    }
}