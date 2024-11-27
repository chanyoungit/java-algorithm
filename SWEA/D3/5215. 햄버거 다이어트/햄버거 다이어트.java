import java.io.*;
import java.util.*;

class Solution {
	static int[][] arr;
	static int answer;
	static boolean[] visited;
	static int L;
	
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	L = Integer.parseInt(st.nextToken());
        	
        	arr = new int[N][2];
        	visited = new boolean[N];
        	for (int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		arr[i][0] = a;
        		arr[i][1] = b;
        	}
        	
        	answer = 0;
        	dfs(0,0,0);
        	
        	bw.write("#" + test_case + " " + answer + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static void dfs(int cal, int like, int depth) {
    	if (cal > L) {
    		return;
    	}
    	
    	if (depth == arr.length) {
    		answer = Math.max(answer, like);
    		return;
    	}
    	
    	dfs(cal+arr[depth][1], like+arr[depth][0], depth+1);
    	dfs(cal, like, depth+1);
    }
}